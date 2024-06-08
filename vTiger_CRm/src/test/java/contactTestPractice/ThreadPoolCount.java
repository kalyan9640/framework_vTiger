package contactTestPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolCount {
@Test(invocationCount = 10, threadPoolSize = 4)
public void m1() throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	Thread.sleep(2000);
	driver.quit();
	
}
}
