package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



/**
 * contains  Create New Organization Page  elements
 * @author Pavan Kalyan
 * 
 * 
 */



public class CreateNewOrganizationPage {
	WebDriver driver=null;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement indstryDd;

	@FindBy(name = "accounttype")
	private WebElement accounttypeDd;
	
	@FindBy(id = "phone")
	private WebElement phoneEdt;
	
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getAccounttypeDd() {
		return accounttypeDd;
	}

	public WebElement getIndstryDd() {
		return indstryDd;
	}

	public void createOrganization(String orgName) {
		
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrganization(String orgName,String industry,String type) {
		
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(indstryDd);
		sel.selectByVisibleText(industry);
		sel=new Select(accounttypeDd);
		sel.selectByVisibleText(type);
		
		saveBtn.click();
	}
	
	public void createOrganization(String orgName,String PhoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(PhoneNumber);
		saveBtn.click();
	}
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
