package practice.testNg;



import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {
@Test
public void sampleTest() {
	WebDriver driver=new ChromeDriver();
	TakesScreenshot ts =new EventFiringWebDriver(driver);	
}
}
