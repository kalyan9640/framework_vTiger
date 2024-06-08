package task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class SpiceJetTest {
	
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	FileUtility fLib=new FileUtility();	
	String browser = fLib.getDataFromPropertiesFile("browser");
	WebDriverUtility wLib=new WebDriverUtility();
			
	if (browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		
		wLib.waitPageToLoad(driver);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("spicejet",Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(text(),'SpiceJet - Flight')]")).click();
		
		
	
	
	}
}
}
