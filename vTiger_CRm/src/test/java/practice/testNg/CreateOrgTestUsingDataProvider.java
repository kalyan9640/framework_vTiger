package practice.testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.fileUtility.FileUtility;
import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgTestUsingDataProvider {
@Test(dataProvider = "getData")
	public void createOrg(String orgName) throws Throwable {
		WebDriver driver=null;
		try {
			// create an object for FileUtility class and ExcelUtility class
			FileUtility fLib=new FileUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			String browser = fLib.getDataFromPropertiesFile("browser");
			String url = fLib.getDataFromPropertiesFile("url");
			String username =fLib.getDataFromPropertiesFile("username");
			String password = fLib.getDataFromPropertiesFile("password");
	
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
		}
		finally {
			driver.quit();
		}
	}
	@DataProvider
	public void getData() throws Throwable{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("orgName");
		Object[][] objArr=new Object[3][1];
		for (int i = 0; i <rowCount-1 ; i++) {
			
			objArr[i][0]=eLib.getDataFromExcel("orgName", i+1, 0);
		}
		
	}																																														
}

