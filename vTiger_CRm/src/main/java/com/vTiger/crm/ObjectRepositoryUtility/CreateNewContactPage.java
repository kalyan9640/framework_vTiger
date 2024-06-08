package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.crm.generic.webDriverUtility.WebDriverUtility;



/**
 * contains  Create New Contacts Page  elements
 * @author Pavan Kalyan
 * 
 * 
 */
public class CreateNewContactPage {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrg;
	
	@FindBy(id = "search_txt")
	private WebElement searchtextEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	public WebElement getSelectOrg() {
		return selectOrg;
	}
	public void createContact(String name) {
		lastNameEdt.sendKeys(name);
		saveBtn.click();
		}
	public void createContact(String name,String StartDate,String endDate) {
		lastNameEdt.sendKeys(name);
		startDateEdt.clear();
		startDateEdt.sendKeys(StartDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
		}
	
	
	
	public void createContact(String name,String orgName) {
		
		lastNameEdt.sendKeys(name);
		selectOrg.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToTabOnURL(driver, "module=Accounts");
		searchtextEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wLib.switchToTabOnURL(driver, "Contacts&action");
		saveBtn.click();
		
	}
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getStartDateEdt() {
		return startDateEdt;
	}
	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
