package com.vTiger.crm.orgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgWithPhoneNumber {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		try {
			
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
				
			String browser = fLib.getDataFromPropertiesFile("browser");
			String url = fLib.getDataFromPropertiesFile("url");
			String username =fLib.getDataFromPropertiesFile("username");
			String password = fLib.getDataFromPropertiesFile("password");
			
			String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
			String phoneNumber=eLib.getDataFromExcel("org", 7, 3);

		//launching the browser
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		//creating organization
		
		//step 1: login  to application
		wLib.waitPageToLoad(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url, username, password);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, phoneNumber);
		
		// verify phone number
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
		String actPhoneNumber = oip.getphoneField().getText();
		if (actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber+" is verified ==pass");

		} else {
			System.out.println(phoneNumber+" is not verified ==fail");

		}
		}
		catch(Exception e ) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			driver.quit();
		}

	}

}

