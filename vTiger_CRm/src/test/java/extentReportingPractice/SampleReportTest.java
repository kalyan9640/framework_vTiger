package extentReportingPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;



public class SampleReportTest {

	ExtentReports report;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test Suite Result");
		spark.config().setReportName("Contact Report");
		spark.config().setTheme(Theme.DARK);

		// Add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-123");

	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {

		// Spark report config

		ExtentTest test = report.createTest("CreateContactTest");

		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "Create contact");
		org.testng.Assert.assertEquals("pavan", "pavann");
		test.log(Status.INFO, "logout from app");

	}

	@Test
	public void createContactWithOrgTest() {

		// Spark report config

		ExtentTest test = report.createTest("createContactWithOrgTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created ");
		} else {
			test.log(Status.FAIL, "Contact is not Created ");
		}

		test.log(Status.INFO, "logout from app");

	}

	@Test
	public void createContactWithPhoneTest() {

		// Spark report config

		ExtentTest test = report.createTest("createContactWithPhoneTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "Create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created ");
		} else {
			test.log(Status.FAIL, "Contact is not Created ");
		}

		test.log(Status.INFO, "logout from app");

	}

}
