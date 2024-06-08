package com.vTiger.crm.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vTiger.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactWithSupportDate {

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
			
			String lastName=eLib.getDataFromExcel("contact", 4, 2);
	
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
		
		//step 2: navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		//step 3: click on create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContact().click();
		//step 4: enter all the details and create new contact
		
		//select todays date
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.requiredDateYYYYMMDD(30);
	
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact(lastName, startDate, endDate);
		
		// step 5: verify header msg expected result
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String headerInfo=cip.getHeaderInfo().getText();
		
		if (headerInfo.contains(lastName)) {
			System.out.println(lastName+" is created ==pass");
		} else {
			System.out.println(lastName+" is not created ==fail");
		}
		
		//step 6: verify last name
		String actLastName = cip.getActLastName().getText();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName+" is created ==pass");

		} else {
			System.out.println(lastName+" is not created ==fail");

		}
		//step 6: verify start date
		String actStartDate = cip.getActStartDate().getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate+" is verified ==pass");

		} else {
			System.out.println(startDate+" is not verified ==fail");

		}
		//step 6: verify end date 
		String actEndDate = cip.getActEndDate().getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate+" is verified ==pass");

		} else {
			System.out.println(endDate+" is not verified ==fail");

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