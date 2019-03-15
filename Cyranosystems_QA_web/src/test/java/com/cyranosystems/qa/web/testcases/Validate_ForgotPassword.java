package com.cyranosystems.qa.web.testcases;

import java.util.Set;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_ForgotPassword extends Test_Baseclass {

	// Forgot Password page > With valid credentials (Clicking on Hyper link in
	// email page in Username page)

	@Test(enabled = false)
	public void forgotPassoword_usernamePage_validCredential() {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());
		String error_msg = forgot_pwd.reset_reqest_success_msg.getText();
		Assert.assertEquals(error_msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator
		browser_factory.navigate_to(driver, config.mailinator_url());
		ForgotPassword_page.registered_email.sendKeys(config.username_frgt_pwd());
		ForgotPassword_page.mailinator_go.click();

		for (int i = 0; i < ForgotPassword_page.table_list.size(); i++) {

			if (ForgotPassword_page.table_list.get(i).getText().contains("Forget something")) {
				// System.out.println(ForgotPassword_page.table_list.get(i).getText());
				ForgotPassword_page.table_list.get(i).click();

			} else {
				System.out.println("nothing");
			}
		}

		WebElement ele = ForgotPassword_page.frame_list;
		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();
		System.out.println(str);

		String parentWindow = driver.getWindowHandle();

		ForgotPassword_page.mail_reset.click();

		Set<String> allwinodws = driver.getWindowHandles();

		for (String childWindows : allwinodws) {
			if (!childWindows.equals(parentWindow)) {
				driver.switchTo().window(childWindows);
				String actualTitle = driver.getTitle();

				if (actualTitle.equalsIgnoreCase("Mailinator")) {

					System.out.println(driver.getTitle());

				}
			}
		}

		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());
		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());
		ForgotPassword_page.submit_reset_password.click();
		

	}

	@Test(enabled = false)
	public void forgotPassoword_passwrodPage_validCredential() {

		Login_page.username_txt.sendKeys(config.username_frgt_pwd());
		Login_page.clickon_next.click();

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());
		String error_msg = forgot_pwd.reset_reqest_success_msg.getText();
		Assert.assertEquals(error_msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator
		browser_factory.navigate_to(driver, config.mailinator_url());
		ForgotPassword_page.registered_email.sendKeys(config.username_frgt_pwd());
		ForgotPassword_page.mailinator_go.click();

		for (int i = 0; i < ForgotPassword_page.table_list.size(); i++) {

			if (ForgotPassword_page.table_list.get(i).getText().contains("Forget something")) {
				// System.out.println(ForgotPassword_page.table_list.get(i).getText());
				ForgotPassword_page.table_list.get(i).click();

			} else {
				System.out.println("nothing");
			}
		}

		WebElement ele = ForgotPassword_page.frame_list;
		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();
		System.out.println(str);

		String parentWindow = driver.getWindowHandle();

		ForgotPassword_page.mail_reset.click();

		Set<String> allwinodws = driver.getWindowHandles();

		for (String childWindows : allwinodws) {
			if (!childWindows.equals(parentWindow)) {
				driver.switchTo().window(childWindows);
				String actualTitle = driver.getTitle();

				if (actualTitle.equalsIgnoreCase("Mailinator")) {

					System.out.println(driver.getTitle());

				}
			}
		}

		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());
		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());
		ForgotPassword_page.submit_reset_password.click();

	}

	@Test(enabled = false)
	public void forgotPassoword_invalidemail() {

		Login_page.username_txt.sendKeys(config.username_frgt_pwd());
		Login_page.clickon_next.click();
		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();
		Assert.assertEquals(error_msg, "User does not exist!");

	}
	@Test(enabled = true)
	public void forgotPassword_currentPassword_Manual() {
		
		forgot_pwd.forgot_password_request(config.username_frgt_pwd());
		String error_msg = forgot_pwd.reset_reqest_success_msg.getText();
		Assert.assertEquals(error_msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator
		browser_factory.navigate_to(driver, config.mailinator_url());
		ForgotPassword_page.registered_email.sendKeys(config.username_frgt_pwd());
		ForgotPassword_page.mailinator_go.click();

		for (int i = 0; i < ForgotPassword_page.table_list.size(); i++) {

			if (ForgotPassword_page.table_list.get(i).getText().contains("Forget something")) {
				// System.out.println(ForgotPassword_page.table_list.get(i).getText());
				ForgotPassword_page.table_list.get(i).click();

			} else {
				System.out.println("nothing");
			}
		}

		WebElement ele = ForgotPassword_page.frame_list;
		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();
		System.out.println(str);
		
		// Cyrano page 
		browser_factory.navigate_to(driver, config.staging_url());
		login.valid_login(config.username(), str);
		ForgotPassword_page.currentpasswordtxt.sendKeys(str);
		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());
		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());
		
		
		
		
		
		
		
	}
	
	
	
}
