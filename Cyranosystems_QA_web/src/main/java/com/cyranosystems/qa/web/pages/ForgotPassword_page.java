package com.cyranosystems.qa.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassword_page {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public static WebElement click_here;

	@FindBy(how = How.NAME, using = "forgotpasswordtxt")
	public static WebElement forgotpasswordtxt;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement request_reset_link_btn;

	@FindBy(how = How.XPATH, using = "//span[@class='errortxt-cls']")
	public static WebElement reset_reqest_error_msg; 

	@FindBy(how = How.XPATH, using = "//span[@class='succtxt-cls']")
	public static WebElement reset_reqest_success_msg;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Check Any Inbox!']")
	public static WebElement registered_email;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Go!')]")
	public static WebElement mailinator_go;

	@FindBy(how = How.XPATH, using = "//div[@class='table-responsive']//table//tbody//tr")
	public static List<WebElement> table_list;

	@FindBy(how = How.XPATH, using = "//iframe[@id='msg_body']")
	public static WebElement frame_list;

	@FindBy(how = How.XPATH, using = "//table[@class='main']//table[2]//tr//td//a")
	public static WebElement subject;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reset')]")
	public static WebElement mail_reset;

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

}
