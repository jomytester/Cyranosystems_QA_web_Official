package com.cyranosystems.qa.web.testcases;

import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;
import com.cyranosystems.qa.web.utilities.Browser_factory;

public class Validate_ForgotPassword extends Test_Baseclass {

	// Forgot Password page > With valid credentials (Clicking on Hyper link in
	// email page in Username page)

	@Test(enabled = false, priority = 1)
	public void forgotPassoword_usernamePage_validCredential() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		forgot_pwd.redirect_to_cyrano();
		
		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password.click();

		Thread.sleep(1000);

		ForgotPassword_page.finish.click();

		String tab = driver.getTitle();

		System.out.println(tab);

	}

	@Test(enabled = false, priority = 2)
	public void forgotPassoword_passwrodPage_validCredential() throws InterruptedException {

		Login_page.username_txt.sendKeys(config.username_frgt_pwd());

		Login_page.clickon_next.click();

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();

		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password.click();

		Thread.sleep(1000);

		ForgotPassword_page.finish.click();

		String tab = driver.getTitle();

		System.out.println(tab);

	}

	@Test(enabled = false, priority = 3)
	public void forgotPassword_currentPassword_Manual() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		// Redirecting to Cyrano

		Browser_factory.navigate_to(config.staging_url());

		login.valid_login(config.username_frgt_pwd(), str);

		ForgotPassword_page.currentpasswordtxt.sendKeys(str);

		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password.click();

		Thread.sleep(1000);

		ForgotPassword_page.finish.click();

	}

	@Test(enabled = false, priority = 4)
	public void forgotPassoword_invalidemail() {

		forgot_pwd.forgot_password_request("auto123@gmail.com");

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "User does not exist!");

	}

	@Test(enabled = false, priority = 5)
	public void forgotPassword_invalidCurrentPassword_passwordPage() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();

		Browser_factory.navigate_to(config.staging_url());

		login.valid_login(config.username_frgt_pwd(), "300100");

		String error_msg = ForgotPassword_page.reset_reqest_error_msg.getText();

		if (error_msg.contains("Login Failed")) {

			System.out.println("Condition Passed");
		}
	}

	@Test(enabled = false, priority = 6)
	public void forgotPassword_invalidCurrentPassword_resetPage() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();

		Browser_factory.navigate_to(config.staging_url());

		login.valid_login(config.username_frgt_pwd(), str);

		ForgotPassword_page.currentpasswordtxt.sendKeys("300100");

		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password.click();

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "Invalid user credentials!");

	}

	@Test(enabled = false, priority = 7)
	public void forgotPassword_different_newPassword_confirmPassword() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();
		
		ForgotPassword_page.newpasswordtxt.sendKeys("Test@2222");

		ForgotPassword_page.confirmpasswordtxt.sendKeys("Test@7777");

		ForgotPassword_page.submit_reset_password.click();

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "Password mismatch!");

	}

	@Test(enabled = false, priority = 8)
	public void forgotPassword_invalid_newPassword_confirmPassword() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();

		ForgotPassword_page.newpasswordtxt.sendKeys("Test2345");

		ForgotPassword_page.confirmpasswordtxt.sendKeys("Test7777adssdf");

		ForgotPassword_page.submit_reset_password.click();

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "Invalid format!");

	}

	@Test(enabled = false, priority = 9)
	public void forgotPassword_invalid_newPassword() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();

		ForgotPassword_page.newpasswordtxt.sendKeys("Test2345test");

		ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password.click();

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "Invalid format!");

	}

	@Test(enabled = false, priority = 10)
	public void forgotPassword_invalid_currentPassword() throws InterruptedException {

		forgot_pwd.forgot_password_request(config.username_frgt_pwd());

		String msg = forgot_pwd.reset_reqest_success_msg.getText();

		Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		helper.redirecting_to_mailinator();

		WebElement ele = ForgotPassword_page.frame_list;

		driver.switchTo().frame(ele);

		String str = ForgotPassword_page.subject.getText();

		System.out.println(str);

		ForgotPassword_page.mail_reset.click();

		// Redirecting to Cyrano

		forgot_pwd.redirect_to_cyrano();
		
		ForgotPassword_page.newpasswordtxt.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordtxt.sendKeys("Test2345567");

		ForgotPassword_page.submit_reset_password.click();

		String error_msg = forgot_pwd.reset_reqest_error_msg.getText();

		Assert.assertEquals(error_msg, "Password mismatch!");

	}

}
