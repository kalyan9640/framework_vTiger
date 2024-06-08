package com.vTiger.crm.orgTest;

import org.openqa.selenium.By;
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

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		try {
			// create an object for FileUtility class and ExcelUtility class
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			String browser = fLib.getDataFromPropertiesFile("browser");
			String url = fLib.getDataFromPropertiesFile("url");
			String username =fLib.getDataFromPropertiesFile("username");
			String password = fLib.getDataFromPropertiesFile("password");
			
			String orgName=eLib.getDataFromExcel("org", 10, 2)+jLib.getRandomNumber();
		
	
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
		
		//step 2: navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		
		//step 3: click on create organization
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		
		//step 4: enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);
		
		
		// step 5: verify header msg expected result
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgName =oip.getHeaderMsg().getText();
		
		//step 6: verify organization name
		
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName+" is created ==pass");
		} else {
			System.out.println(orgName+" is not created ==fail");
		}
		
		//go back to home page
		hp.getOrganizationLink().click();
		
		//search for organization
		op.getSearchEdt().sendKeys(orgName);
		wLib.select(op.getSearchDd(),"Organization Name");
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../following-sibling::td[5]/a[2]")).click();
		Thread.sleep(500);
		wLib.switchToAlertAndAccept(driver);
		
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