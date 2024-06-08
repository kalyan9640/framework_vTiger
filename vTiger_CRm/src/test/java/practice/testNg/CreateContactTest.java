package practice.testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactTest {
	
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
	@Test
public  void main() throws Throwable {
	driver=new ChromeDriver();
	wLib.waitPageToLoad(driver);
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(fLib.getDataFromPropertiesFile("url"), fLib.getDataFromPropertiesFile("username"),  fLib.getDataFromPropertiesFile("password"));
	
	HomePage hp=new HomePage(driver);
	hp.getContactsLink();
	
	hp.logoutFromApp();
		
	
}
}
