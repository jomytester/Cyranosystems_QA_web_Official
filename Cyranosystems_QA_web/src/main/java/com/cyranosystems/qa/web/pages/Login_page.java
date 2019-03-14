package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_page {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "username")
	public static WebElement username_txt;

	@FindBy(how = How.ID, using = "next")
	public static WebElement clickon_next;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement password_txt;

	@FindBy(how = How.ID, using = "login")
	public static WebElement login_btn;
	
	@FindBy(how=How.CLASS_NAME, using= "errortxt-cls")
	public static WebElement userexist_error_msg;
	
	@FindBy(how=How.CLASS_NAME, using= "errortxt-cls")
	public static WebElement loginFailed_error_msg;
	
	@FindBy(how=How.XPATH, using="//button[@class='ellipsis']")
	public static WebElement signout_ellipsis;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Sign out')]")
	public static WebElement sigout_btn2;
	
	@FindBy(how=How.XPATH, using="//a[@class='backto']")
	public static WebElement backToSignin_btn;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn login-getintouch']")
	public static WebElement learnMore_btn;
	
	@FindBy(how=How.ID, using="sso-login-button")
	public static WebElement sso_login_btn;
	
	public Login_page(WebDriver driver) {
		
		this.driver = driver;
	}

	public void valid_login(String username, String password) {

		username_txt.sendKeys(username);

		clickon_next.click();

		password_txt.sendKeys(password);

		login_btn.click();

	}
	
	public void sso_login(String username) {
		
		username_txt.sendKeys(username);

		clickon_next.click();
		
		sso_login_btn.click();
		
		
	}

}
