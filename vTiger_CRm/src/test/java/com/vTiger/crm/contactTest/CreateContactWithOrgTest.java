package com.vTiger.crm.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vTiger.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.vTiger.crm.generic.fileUtility.ExcelUtility;
import com.vTiger.crm.generic.javaUtility.JavaUtility;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();

		String lastName = eLib.getDataFromExcel("contact", 7, 2);
		String orgName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		WebDriver driver = new ChromeDriver();
		// step 2: navigate to organization module
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

		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is created ==pass");
		} else {
			System.out.println(orgName + " is not created ==fail");
		}

		hp.getContactsLink().click();
		;

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName, orgName);

		// verify last name
		ContactInformationPage cip = new ContactInformationPage(driver);
		String headerInfo = cip.getHeaderInfo().getText();

		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + " is created ==pass");
		} else {
			System.out.println(lastName + " is not created ==fail");
		}

		// verify org name

		String actOrgName1 = cip.getActOrgName().getText();
		if (actOrgName1.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + " information is not created==FAIL");

		}
	}
}
