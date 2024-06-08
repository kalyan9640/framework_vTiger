package extentReportingPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vTiger.crm.ListenerUtility.ListenerImple;
import com.vTiger.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.baseTest.BaseClassTest;

public class CreateContactReporter extends BaseClassTest {

	
	
	@Test()
	public void createContactTest() throws Throwable {
		
		
		// step 1: fetch contact name from excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2);

		// step 2: navigate to contacts module
		ListenerImple.test.log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step 3:click on create new contact
		ListenerImple.test.log(Status.INFO, "navigate to contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		// step 4: enter all the details and create new contact
		ListenerImple.test.log(Status.INFO, "navigate to create new contact page");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		// step 5: verify header msg expected result
		ListenerImple.test.log(Status.INFO, "verify the result");
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerInfo = cip.getHeaderInfo().getText();
		Assert.assertEquals(lastName, headerInfo);
		
	}
	
	@Test()
	public void createContactTest1() throws Throwable {
		
		
		// step 1: fetch contact name from excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2);

		// step 2: navigate to contacts module
		ListenerImple.test.log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step 3:click on create new contact
		ListenerImple.test.log(Status.INFO, "navigate to contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		// step 4: enter all the details and create new contact
		ListenerImple.test.log(Status.INFO, "navigate to create new contact page");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		// step 5: verify header msg expected result
		ListenerImple.test.log(Status.INFO, "verify the result");
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerInfo = cip.getHeaderInfo().getText();
		Assert.assertEquals(lastName, headerInfo);
		
	}
	
	
	
}
