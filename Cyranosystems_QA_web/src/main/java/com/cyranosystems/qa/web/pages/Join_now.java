package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Join_now {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Join Now')]")
	public static WebElement join_now;

	@FindBy(how = How.XPATH, using = "//input[@name='workemail']")
	public static WebElement enter_workemail;

	@FindBy(how = How.XPATH, using = "//input[@name='reenterworkmail']")
	public static WebElement re_enter_workemail;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement submit_button;

	@FindBy(how = How.XPATH, using = "//iframe[@name='a-y9b1kr3w7hxy']")
	public static WebElement frame_list_join_now;

	@FindBy(how = How.XPATH, using = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']//div[@class='recaptcha-checkbox-checkmark']")
	public static WebElement check_box;

	@FindBy(how = How.XPATH, using = "//input[@name='verification']")
	public static WebElement joinTeam_VerificationCode;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement verify_your_code_button;

	@FindBy(how = How.XPATH, using = "//input[@name='firstname']")
	public static WebElement DetailsPage_firstName;

	@FindBy(how = How.XPATH, using = "//input[@name='lastname']")
	public static WebElement DetailsPage_lastName;

	@FindBy(how = How.XPATH, using = "//input[@name='phoneno']")
	public static WebElement DetailsPage_phoneNo;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement DetailsPage_submitButton;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement f;

	public Join_now(WebDriver driver) {

		this.driver = driver;
	}

	public void join_now_page(String username) {

		join_now.click();

		enter_workemail.sendKeys(username);

		re_enter_workemail.sendKeys(username);

		try {

		} catch (Exception e) {

			System.out.println("Re-Captcha couldn't complete" + e.getMessage());
		}

	}

	public void joinNow_detailsPage(String first, String last, String phone) throws InterruptedException {

		DetailsPage_firstName.sendKeys(first);

		DetailsPage_lastName.sendKeys(last);

		DetailsPage_phoneNo.sendKeys(phone);

		DetailsPage_submitButton.click();

		Thread.sleep(1000);

		DetailsPage_submitButton.click();

	}

}
