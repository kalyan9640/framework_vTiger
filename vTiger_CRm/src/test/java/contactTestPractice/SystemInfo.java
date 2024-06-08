package contactTestPractice;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SystemInfo {
@Test
public void info() {
	
	System.out.println(System.getProperty("os.name"));
	
	System.out.println(System.getProperty("os.version"));

	System.out.println(System.getProperty("os.arch"));

	 WebDriver driver=new ChromeDriver();
	 
	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    String os = cap.getPlatformName().toString();
	    System.out.println(os);
	    String v = cap.getBrowserVersion().toString();
	    System.out.println(v);
	    System.out.println(cap.asMap());
	    
	    driver.quit();
}
}
