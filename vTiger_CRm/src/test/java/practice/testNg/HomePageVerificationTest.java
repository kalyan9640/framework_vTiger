package practice.testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerificationTest {

	
	@Test
	public void homePageTest() {
		String expData = "Home";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		String actData = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		System.out.println(driver.getTitle());
		if (actData.trim().equals(expData)) {
			System.out.println(expData+"  page is verified ==pass");
		}
		else {
				System.out.println(expData+"  page is not verified==fail");
		}
		SoftAssert sft=new SoftAssert();
		sft.assertEquals(actData.trim(), expData);
		System.out.println("pavan kalyan");
		sft.assertAll();
		
		System.out.println("This Should not be printed");
		Assert.assertEquals(actData.trim(), expData);

		
		driver.quit();
	}
	
}
