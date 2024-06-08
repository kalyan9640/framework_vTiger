package task;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class NoonTest {
@Test
public void appleTest() throws Throwable{
	WebDriver driver=null;
	Workbook wb=WorkbookFactory.create(new FileInputStream("./TestData/Book2.xlsx"));
	try {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// create an object for FileUtility class and ExcelUtility class
		String browser = fLib.getDataFromPropertiesFile("browser");
		//launching the browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		wLib.waitPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		Thread.sleep(3000);
		
		List<WebElement> apple = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
		int i=0,j=1;
		while(j<=7) {
		for (WebElement w : apple) {
			if (w.getText().contains("Apple")) {
				System.out.println(w.getText());
				wb.getSheet("Apple").createRow(i).createCell(0).setCellValue(w.getText());
				i++;
			}
		}
		 WebElement e = driver.findElement(By.xpath("(//div[contains(@class,'swiper-button-next')])[5]"));
		Select s=new Select(e);
		
		 Thread.sleep(1500);
		apple = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
		j++;
		}	
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}finally {
		wb.write(new FileOutputStream("./TestData/Book2.xlsx"));
		wb.close();
		driver.quit();
	}
		
}
}
