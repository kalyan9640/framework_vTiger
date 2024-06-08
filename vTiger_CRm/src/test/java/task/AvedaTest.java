package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AvedaTest {
	@Test
	public void fashionTest() throws Throwable {
//		Workbook wb = WorkbookFactory.create(new FileInputStream("./TestData/Book2.xlsx"));
//
//		Sheet sh = wb.createSheet("aveda6");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.alertIsPresent());
		driver.manage().window().maximize();
		driver.get("https://www.aveda.de/");
		WebElement hair = driver.findElement(By.xpath("//div[@id='node-6656']/div/ul/li/a[text()='HAARE & KOPFHAUT']"));
		Actions act = new Actions(driver);
		act.moveToElement(hair).perform();
//		act.moveToElement(driver.findElement(By.xpath("//li[@class='menu__item menu__item--lvl-2 menu__item--category js-menu-item-category active']"))).perform();
//		Thread.sleep(2000);
//	
//		int i=0; 
		
//	List<WebElement> categories = driver.findElements(By.xpath("(//div[@id='node-6572'])[2]/descendant::a"));
		
		List<WebElement> all = driver.findElements(By.xpath("//li[@class='menu__item menu__item--lvl-2 menu__item--category js-menu-item-category active']/descendant::ul[@class='menu menu--lvl-3']/descendant::a/font/font"));
		for (WebElement e : all) {
			System.out.println(e.getText());
//			sh.createRow(i++).createCell(0).setCellValue(e.getText());
		}
//		 wb.write(new FileOutputStream("./TestData/Book2.xlsx"));
		 driver.quit();
//		 wb.close();
		 
	}
}