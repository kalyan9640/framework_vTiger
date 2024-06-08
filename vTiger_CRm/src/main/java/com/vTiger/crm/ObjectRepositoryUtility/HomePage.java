package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * contains HomePage elements and business libraries like logout
 * @author Pavan Kalyan
 * 
 * 
 */

public class HomePage {
	WebDriver driver=null;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignsLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		CampaignsLink.click();
	}
	public void logoutFromApp() throws Throwable {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		Thread.sleep(500);
		signOut.click();
		
	}

	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	


	
}
