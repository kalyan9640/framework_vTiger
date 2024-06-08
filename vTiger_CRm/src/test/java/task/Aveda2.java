package task;

import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Aveda2 {
	@Test
	public void fashionTest() throws Throwable {
//		Workbook wb = WorkbookFactory.create(new FileInputStream("./TestData/Book2.xlsx"));
//
//		Sheet sh = wb.createSheet("aveda6");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.aveda.de/");
		WebElement hair = driver.findElement(By.xpath("//DIV[contains(@class,'header-primary-menu js-header-primary-menu')]/DIV/DIV/DIV/DIV/UL/LI[3]/A[normalize-space(@href)='#']"));
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