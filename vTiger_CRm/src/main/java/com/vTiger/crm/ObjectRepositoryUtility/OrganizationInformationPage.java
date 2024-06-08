package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * contains Organization Information Page elements 
 * @author Pavan Kalyan
 * 
 * 
 */

public class OrganizationInformationPage {
	 
	
	WebDriver driver=null;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryName;
	
	@FindBy(id="dtlview_Type")
	private WebElement TypeName;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneField;

	public WebElement getphoneField() {
		return phoneField;
	}
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return TypeName;
	}
	
	
	
}
