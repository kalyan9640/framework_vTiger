package practice.testNg;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.vTiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vTiger.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.vTiger.crm.ObjectRepositoryUtility.HomePage;
import com.vTiger.crm.baseTest.BaseClassTest;

public class Data_provider extends BaseClassTest {

	@Test(dataProvider = "getData")
	public void createContact(String lastName) throws Throwable {

		// step 2: navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// step 3:click on create new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();

		// step 4: enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		// step 5: verify header msg expected result
		ContactInformationPage cip = new ContactInformationPage(driver);

		String headerInfo = cip.getHeaderInfo().getText();
		boolean status = headerInfo.contains(lastName);

		Assert.assertEquals(status, true);
		System.out.println("Passed");

	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./Testdata/Book2.xlsx"));
		Sheet sh = wb.getSheet("flipkart1");
		int r = sh.getLastRowNum();

		Object[][] o = new Object[2][1];
		for (int i = 0; i < 2; i++) {
			o[i][0] = sh.getRow(i).getCell(0).getStringCellValue();
		}

		return o;

	}
}
