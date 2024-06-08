package com.vTiger.crm.contactTest;

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
import com.vTiger.crm.baseTest.BaseClassTest;
import com.vTiger.crm.generic.webDriverUtility.UtilityClassObject;

/**
 * @author Pavan Kalyan
 */

public class CreateContactTest extends BaseClassTest {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		/* step 1: fetch contact name from excel */

		String lastName = eLib.getDataFromExcel("contact", 1, 2);

		/* step 2: navigate to contacts module */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contacts page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/* step 3:click on create new contact */
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		/* step 4: enter all the details and create new contact */
		UtilityClassObject.getTest().log(Status.INFO, "create new Contact");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		/* step 5: verify header msg expected result */
		UtilityClassObject.getTest().log(Status.INFO, "naviagate to contact information page");
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerInfo = cip.getHeaderInfo().getText();
		boolean status = headerInfo.contains(lastName);

		Assert.assertEquals(status, true);
		System.out.println("Passed");
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {
		String lastName = eLib.getDataFromExcel("contact", 7, 2);
		String orgName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		/* step 3: click on create organization */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organization page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		/* step 4: enter all the details and create new organization */
		UtilityClassObject.getTest().log(Status.INFO, "create an organization");

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		/* step 5: verify header msg expected result */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization information page");

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		/* step 6: verify organization name */
		Assert.assertEquals(actOrgName.contains(orgName), true);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contacts page");
		hp.getContactsLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact ");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);

		cncp.createContact(lastName, orgName);

		/* verify last name */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		Assert.assertEquals(headerInfo.contains(lastName), true);

		/* verify org name */
		String actOrgName1 = cip.getActOrgName().getText();

		Assert.assertEquals(actOrgName1.trim(), orgName);
		System.out.println("Passed");

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable {
		/* step 1: fetch name from excel */
		String lastName = eLib.getDataFromExcel("contact", 4, 2);

		/* step 2: navigate to contacts module */

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contacts page");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/* step 3: click on create contact */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		/* step 4: enter all the details and create new contact */

		/* select todays date */

		UtilityClassObject.getTest().log(Status.INFO, "Create contact ");
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.requiredDateYYYYMMDD(30);

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName, startDate, endDate);

		/* step 5: verify header msg expected result */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();
		Assert.assertEquals(headerInfo.contains(lastName), true);

		/* step 6: verify last name */
		String actLastName = cip.getActLastName().getText();
		Assert.assertEquals(actLastName.contains(lastName), true);

		/* step 6: verify start date */
		String actStartDate = cip.getActStartDate().getText();
		Assert.assertEquals(actStartDate.contains(startDate), true);

		/* step 7: verify end date */
		String actEndDate = cip.getActEndDate().getText();
		Assert.assertEquals(actEndDate.contains(endDate), true);
		System.out.println("Passed");

	}

}
