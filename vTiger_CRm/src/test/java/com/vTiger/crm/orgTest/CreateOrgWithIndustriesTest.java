package com.vTiger.crm.orgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgWithIndustriesTest {

	public static void main(String[] args) throws Throwable {
		
			WebDriver driver=null;
		try {	
			
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			WebDriverUtility wLib=new WebDriverUtility();
				Actions act=new Actions(driver);
				
			
			String browser = fLib.getDataFromPropertiesFile("browser");
			String url = fLib.getDataFromPropertiesFile("url");
			String username =fLib.getDataFromPropertiesFile("username");
			String password = fLib.getDataFromPropertiesFile("password");
			
			String orgName=eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
			String industryName=eLib.getDataFromExcel("org", 4, 3);
			String typeName=eLib.getDataFromExcel("org", 4, 4);
		
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
			cnop.createOrganization(orgName, industryName, typeName);
			
			// verify industry name
			OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			
			String actIndustry = oip.getIndustryName().getText();
			if (actIndustry.equals(industryName)) {
				System.out.println(industryName+" ---industry information is verified==PASS");
			} else {
				System.out.println(industryName+" ---industry information is not erified==FAIL");

			}
	
			//verify type name
			String actType = oip.getTypeName().getText();
			if (actType.equals(typeName)) {
				System.out.println(typeName+" ---type information is verified==PASS");
			} else {
				System.out.println(typeName+" ---type information is not erified==FAIL");

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			driver.quit();
		}
	}
		

}
