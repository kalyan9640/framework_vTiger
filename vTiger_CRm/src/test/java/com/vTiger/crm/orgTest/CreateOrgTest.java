package com.vTiger.crm.orgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.baseTest.BaseClassTest;
import com.vTiger.crm.generic.webDriverUtility.UtilityClassObject;

public class CreateOrgTest extends BaseClassTest {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void createOrgTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		/* step 1:fetch data from excel*/
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		/* step 2: navigate to organization module*/
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		/* step 3: click on create organization*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organization page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		/* step 4: enter all the details and create new organization*/
		UtilityClassObject.getTest().log(Status.INFO, " create a organization");

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		/* step 5: verify header msg expected result*/
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		/* step 6: verify organization name*/
		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status, true);

		System.out.println("passed");

	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustries() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industryName = eLib.getDataFromExcel("org", 4, 3);
		String typeName = eLib.getDataFromExcel("org", 4, 4);

		/* step 3: click on create organization*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organization page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		/* step 4: enter all the details and create new organization*/
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, industryName, typeName);

		/* verify industry name*/
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		String actIndustry = oip.getIndustryName().getText();

		Assert.assertEquals(actIndustry, industryName);
		/* verify type name*/
		String actType = oip.getTypeName().getText();

		Assert.assertEquals(actType, typeName);
		System.out.println("passed");

	}

	@Test(groups = "regressionTest")
	public void createOrgwithPhoneNumber() throws Throwable {

		/* fetch orgname and phone number from excel*/
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

		/* navigate to organizations module*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organization page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, phoneNumber);

		/* verify phone number*/
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		String actPhoneNumber = oip.getphoneField().getText();

		Assert.assertEquals(actPhoneNumber, phoneNumber);

		System.out.println("passed");

	}
}
