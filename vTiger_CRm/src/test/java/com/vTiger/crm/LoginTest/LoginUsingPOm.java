package com.vTiger.crm.LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class LoginUsingPOm {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	try {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// create an object for FileUtility class and ExcelUtility class
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String username =fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
			//launching the browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		//creating organization
		//step 1: login  to application
		wLib.waitPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url,username, password);
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	finally {
		driver.quit();
	}
	}
}
