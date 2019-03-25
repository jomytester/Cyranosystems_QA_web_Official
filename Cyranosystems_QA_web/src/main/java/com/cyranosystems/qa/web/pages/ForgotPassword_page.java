package com.cyranosystems.qa.web.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassword_page {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public static WebElement click_here;

	@FindBy(how = How.XPATH, using = "//input[@name='forgotpasswordtxt']")
	public static WebElement forgotpasswordtxt;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement request_reset_link_btn;

	@FindBy(how = How.XPATH, using = "//span[@class='errortxt-cls']")
	public static WebElement reset_reqest_error_msg;

	@FindBy(how = How.XPATH, using = "//span[@class='succtxt-cls']")
	public static WebElement reset_reqest_success_msg;
	
	@FindBy(how = How.XPATH, using = "//input[@name='currentpasswordtxt']")
	public static WebElement currentpasswordtxt;

	@FindBy(how = How.XPATH, using = "//input[@name='newpasswordtxt']")
	public static WebElement newpasswordtxt;

	@FindBy(how = How.XPATH, using = "//input[@name='confirmpasswordtxt']")
	public static WebElement confirmpasswordtxt;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement submit_reset_password;

	@FindBy(how = How.XPATH, using = "//div[@class='d-inline-block']//button")
	public static WebElement finish;

	public ForgotPassword_page(WebDriver idriver) {
		
		this.driver = idriver;
	}

	public void forgot_password_request(String username) {

		click_here.click();

		forgotpasswordtxt.sendKeys(username);

		request_reset_link_btn.click();

	}
	
	public void changeNewPassword(String Enter_newpassword , String confirm_newpassword) {
		
		ForgotPassword_page.newpasswordtxt.sendKeys(Enter_newpassword ); //config.password()

		ForgotPassword_page.confirmpasswordtxt.sendKeys(confirm_newpassword); //config.password()

		ForgotPassword_page.submit_reset_password.click();
	}

}
