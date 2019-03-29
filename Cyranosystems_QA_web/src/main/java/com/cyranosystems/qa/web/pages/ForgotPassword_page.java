package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassword_page {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public static WebElement click_here;

	@FindBy(how = How.XPATH, using = "//input[@name='forgotpasswordtxt']")
	public static WebElement forgotpasswordText;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement request_reset_link_button;

	@FindBy(how = How.XPATH, using = "//span[@class='errortxt-cls']")
	public static WebElement reset_reqest_error_message;

	@FindBy(how = How.XPATH, using = "//span[@class='succtxt-cls']")
	public static WebElement reset_reqest_success_message;

	@FindBy(how = How.XPATH, using = "//input[@name='currentpasswordtxt']")
	public static WebElement currentpasswordText;

	@FindBy(how = How.XPATH, using = "//input[@name='newpasswordtxt']")
	public static WebElement newpasswordText;

	@FindBy(how = How.XPATH, using = "//input[@name='confirmpasswordtxt']")
	public static WebElement confirmpasswordText;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement submit_reset_password_button;

	@FindBy(how = How.XPATH, using = "//div[@class='d-inline-block']//button")
	public static WebElement finish_button;

	public ForgotPassword_page(WebDriver idriver) {

		this.driver = idriver;
	}

	public void forgot_password_request(String username) {

		click_here.click();

		forgotpasswordText.sendKeys(username);

		request_reset_link_button.click();

	}

	public void resetPasswordPage(String Enter_newpassword, String confirm_newpassword) {

		ForgotPassword_page.newpasswordText.sendKeys(Enter_newpassword); // config.password()

		ForgotPassword_page.confirmpasswordText.sendKeys(confirm_newpassword); // config.password()

		ForgotPassword_page.submit_reset_password_button.click();
	}

}
