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
	public static WebElement submit_btn;

	@FindBy(how = How.XPATH, using = "//iframe[@name='a-y9b1kr3w7hxy']")
	public static WebElement frame_list_join_now;

	@FindBy(how = How.XPATH, using = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']//div[@class='recaptcha-checkbox-checkmark']")
	public static WebElement check_box;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement f1;
	
	
	
	public Join_now(WebDriver driver) {
		
		
		this.driver = driver;
	}

	public void join_now(String username) {

		join_now.click();

		enter_workemail.sendKeys(username);

		re_enter_workemail.sendKeys(username);
		
		try {
			Thread.sleep(80000);
		} catch (Exception e) {
			System.out.println("Re-Captcha couldn't complete"+e.getMessage());
		}
		
		//submit_btn.click();
		
	}

	
}
