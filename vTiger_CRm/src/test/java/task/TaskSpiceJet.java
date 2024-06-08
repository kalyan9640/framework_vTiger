package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class TaskSpiceJet {
public static void main(String[] args) throws Throwable {
	WebDriverUtility wlib=new WebDriverUtility();
	FileInputStream fis=new FileInputStream("./TestData/vTigerTestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opt);
	wlib.waitPageToLoad(driver);
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("spicejet",Keys.ENTER);
	driver.findElement(By.xpath("//h3[contains(text(),'SpiceJet - Flight')]")).click();
	driver.findElement(By.xpath("//div[text()='round trip']")).click();
	driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[1]")).sendKeys("mum");
	driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]")).sendKeys("del");
	driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='20'])[1]")).click();
	driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='20'])[2]")).click();
	driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).click();
	driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
	driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	Thread.sleep(2000);
	List<WebElement> flights = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-b5h31w r-1ah4tor r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-1i10wst r-1kfrs79']"));
	System.out.println(flights.size());
	Sheet sh = wb.createSheet("flightss1");
		int j=0;
	for (WebElement e : flights) {
		Row r = sh.createRow(j);
		for (int i = 0; i <2; i++) {
			r.createCell(i).setCellValue(e.getText());
		}
		j++;
	}
	wb.write(new FileOutputStream("./TestData/vTigerTestData.xlsx"));
	driver.quit();
	
}
}
