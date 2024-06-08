package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * contains Contact Information Page elements
 * @author Pavan Kalyan
 * 
 * 
 */


public class ContactInformationPage {
	WebDriver driver;
	
	public ContactInformationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName; 
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement actStartDate; 
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement actEndDate; 
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actOrgName;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getActStartDate() {
		return actStartDate;
	}

	public WebElement getActEndDate() {
		return actEndDate;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	} 

}
