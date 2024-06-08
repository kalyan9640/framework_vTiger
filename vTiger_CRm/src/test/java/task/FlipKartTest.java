package task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

import practice.testNg.ExcelUtility2;

public class FlipKartTest {
	@Test
	public void fashionTest() throws Throwable {
		ExcelUtility2 eLib = new ExcelUtility2();

		WebDriver driver = new ChromeDriver();
		new WebDriverUtility().waitPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
		Actions act = new Actions(driver);
		act.moveToElement(fashion).perform();
		int j = 0;
		for (int i = 1; i <= 11; i++) {
			WebElement category = driver.findElement(By.xpath("//div[@class='_16rZTH']/descendant::a[" + i + "]"));
			act.moveToElement(category).perform();
			List<WebElement> total = driver.findElements(By.xpath("//div[@class='_31z7R_']/descendant::a"));
			for (WebElement e : total) {
				System.out.println(e.getText());
				String data = e.getText();
				eLib.setDataIntoExcel("flipkart", j++, 0, data);

			}

		}
	}
}