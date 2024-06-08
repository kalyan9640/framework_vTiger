package com.vTiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * contains Login page elements and business library like login
 * @author Pavan Kalyan
 * 
 * 
 */
public class LoginPage {

	WebDriver driver=null;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="user_name")
	private WebElement username;

	
	@FindBy(name="user_password")
	private WebElement password;
	
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//div[@class='button']/input")})
	private WebElement loginBtn;
	
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String url,String un,String pwd) {
		driver.manage().window().maximize();
		driver.get(url);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
			}
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
}
