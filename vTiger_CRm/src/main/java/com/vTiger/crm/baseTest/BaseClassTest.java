package com.vTiger.crm.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;
import com.vTiger.crm.generic.webDriverUtility.UtilityClassObject;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;


@Listeners(com.vTiger.crm.ListenerUtility.ListenerImple.class) 


public class BaseClassTest {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuite() {
		System.out.println("Before Suite");
	}


//	@Parameters("browser")
//	when we are performing cross browser testing parameter are
//	passed from xml file to read that data we have to use 
//	@Parameters annotation and method should be parameterised
//	

	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void launchBrowser() throws Throwable {
		String browser = fLib.getDataFromPropertiesFile("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(sdriver);
		System.out.println("Launch browser");
	}

	
	
	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void login() throws Throwable {
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");

		wLib.waitPageToLoad(driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void logout() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.logoutFromApp();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void closeBrowser() {
		driver.quit();
		System.out.println("Close Browser");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
