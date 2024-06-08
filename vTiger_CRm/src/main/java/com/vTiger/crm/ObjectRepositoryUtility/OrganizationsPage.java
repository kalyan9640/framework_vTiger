package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * contains Organization Page elements 
 * @author Pavan Kalyan
 * 
 * 
 */
public class OrganizationsPage {

	
	
	WebDriver driver=null;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(className = "txtBox")
	private WebElement searchEdt;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDd;
	
	@FindBy(name ="submit")
	private WebElement searchBtn;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDd() {
		return searchDd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
}
