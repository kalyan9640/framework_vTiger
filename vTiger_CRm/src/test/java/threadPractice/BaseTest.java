package threadPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	public void testSetup() {
		// Initialize the WebDriver instance
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Store the WebDriver instance in the ThreadLocal variable
		threadDriver.set(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void testTeardown() {
		// Fetch the WebDriver instance and close it
		threadDriver.get().quit();
		// Remove the WebDriver instance from the ThreadLocal variable
		threadDriver.remove();
	}

}