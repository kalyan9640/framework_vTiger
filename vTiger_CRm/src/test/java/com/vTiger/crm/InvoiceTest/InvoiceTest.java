package com.vTiger.crm.InvoiceTest;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.crm.baseTest.BaseClassTest;
@Listeners()
public class InvoiceTest extends BaseClassTest {

	@Test(retryAnalyzer = com.vTiger.crm.ListenerUtility.RetryListnerImple.class)
	public void createInvoiceTest() {

		Reporter.log("Execute Create Invoice Test",true);
		Reporter.log("Step--1",true);
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		Reporter.log("Step--2",true);

	}

	@Test
	public void createInvoiceWithOrgTest() {

		WebDriver driver=new ChromeDriver();
		RemoteWebDriver r=(RemoteWebDriver) driver;
		TakesScreenshot ts=r;
		Actions a=new Actions(driver);
	
		System.out.println("create Invoice With Org Test");

		System.out.println("Step--1");
		System.out.println("Step--2");
		System.out.println("Step--3");
		System.out.println("Step--4");
		System.out.println("Step--5");

	}
	
	
	
}
