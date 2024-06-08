package contactTestPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vTiger.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.generic.webDriverUtility.UtilityClassObject;

public class ThrdPract2 extends BaseClassTest {

	@Test()
	public void createContactTest() throws Throwable {
		// step 1: fetch contact name from excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2);

		// step 2: navigate to contacts module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step 3:click on create new contact
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		// step 4: enter all the details and create new contact
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new contact page");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		// step 5: verify header msg expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify the result");
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerInfo = cip.getHeaderInfo().getText();
		Assert.assertEquals(lastName, headerInfo);

	}

	@Test()
	public void createContactWithOrg() throws Throwable {
		driver = UtilityClassObject.getDriver();
		String lastName = eLib.getDataFromExcel("contact", 7, 2);
		String orgName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		// step 3: click on create organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step 4: enter all the details and create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		// step 5: verify header msg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		// step 6: verify organization name
		boolean status = actOrgName.contains(orgName);

		Assert.assertEquals(status, true);

		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);

		cp.getCreateContact().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);

		cncp.createContact(lastName, orgName);

		// verify last name
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		boolean status1 = headerInfo.contains(lastName);
		Assert.assertEquals(status1, true);

		// verify org name
		String actOrgName1 = cip.getActOrgName().getText();

		Assert.assertEquals(actOrgName1.trim(), orgName + "abc");
		System.out.println("Passed");

	}

	@Test()
	public void createContactWithSupportDate() throws Throwable {
		driver = UtilityClassObject.getDriver();
		// step 1: fetch name from excel
		String lastName = eLib.getDataFromExcel("contact", 4, 2);

		// step 2: navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step 3: click on create contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		// step 4: enter all the details and create new contact

		// select todays date
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.requiredDateYYYYMMDD(30);

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName, startDate, endDate);

		// step 5: verify header msg expected result
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		boolean status = headerInfo.contains(lastName);
		Assert.assertEquals(status, true);

		// step 6: verify last name
		String actLastName = cip.getActLastName().getText();
		boolean status1 = actLastName.contains(lastName);
		Assert.assertEquals(status1, true);

		// step 6: verify start date
		String actStartDate = cip.getActStartDate().getText();
		boolean status2 = actStartDate.contains(startDate);
		Assert.assertEquals(status2, true);

		// step 7: verify end date
		String actEndDate = cip.getActEndDate().getText();
		boolean status3 = actEndDate.contains(endDate + " pav");
		Assert.assertEquals(status3, true);
		System.out.println("Passed");

	}

}
