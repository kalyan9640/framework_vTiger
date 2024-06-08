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

public class FlipKart2Test {
	@Test
	public void fashionTest() throws Throwable {
		ExcelUtility2 eLib = new ExcelUtility2();

		// Step 1:launch browser
		WebDriver driver = new ChromeDriver();
		new WebDriverUtility().waitPageToLoad(driver);
		driver.manage().window().maximize();

		// Step 2:navigate to flipkart 
		driver.get("https://www.flipkart.com/");

		// step 3: mouse over to fashion
		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
		Actions act = new Actions(driver);
		act.moveToElement(fashion).perform();
		int col = 0;
 
		// fetch all categories in fashion

		List<WebElement> all = driver.findElements(By.xpath("//div[@class='_16rZTH']/descendant::a"));
		for (WebElement e : all) {
			int row = 0;
			// mouse over to each Category
			act.moveToElement(e).perform();
			eLib.setDataIntoExcel("flipkart1", row++, col, e.getText());

			// fetch sub categories in each category
			List<WebElement> total = driver.findElements(By.xpath("//div[@class='_31z7R_']/descendant::a"));

			// store each sub category name in excel
			for (WebElement eAll : total) {
//				act.moveToElement(eAll);
				System.out.println(eAll.getText());
				String data = eAll.getText();
				eLib.setDataIntoExcel("flipkart1", row++, col, eAll.getText());
			}
			col++;
		}
	}
}