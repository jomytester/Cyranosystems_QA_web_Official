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

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator to open mail

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		helper.SwitchingTo_WindowHandles("Cyrano");

		forgotpassword.resetPasswordPage(config.password(), config.password());

		Thread.sleep(1000);

		ForgotPassword_page.finish_button.click();

		String VerfiyTitle = driver.getTitle();

		// System.out.println(VerfiyTitle);

	}

	@Test(enabled = false, priority = 2)

	public void forgotPassoword_passwrodPage_validCredential() throws InterruptedException {

		Login_page.username_txt.sendKeys(config.username_forgotPassword());

		Login_page.login_clickon_next_btn.click();

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		helper.SwitchingTo_WindowHandles("Cyrano");

		forgotpassword.resetPasswordPage(config.password(), config.password());

		Thread.sleep(1000);

		ForgotPassword_page.finish_button.click();

		String VerfiyTitle = driver.getTitle();

		// System.out.println(VerfiyTitle);

	}

	@Test(enabled = false, priority = 3)

	public void forgotPassword_currentPassword_Manual() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword	 = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		// Redirecting to Cyrano

		driver.navigate().to(config.staging_url());

		login.valid_login(config.username_forgotPassword(), temporaryPassword);

		ForgotPassword_page.currentpasswordText.sendKeys(temporaryPassword);

		forgotpassword.resetPasswordPage(config.password(), config.password());

		Thread.sleep(1000);

		ForgotPassword_page.finish_button.click();

		String tab = driver.getTitle();

		// System.out.println(tab);
	}

	@Test(enabled = false, priority = 4)

	public void forgotPassoword_invalidemail() {

		forgotpassword.forgot_password_request("auto123@gmail.com");

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "User does not exist!");
	}

	@Test(enabled = false, priority = 5)

	public void forgotPassword_invalidCurrentPassword_passwordPage() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		// Redirecting to Cyrano

		driver.navigate().to(config.staging_url());

		login.valid_login(config.username_forgotPassword(), "300100");

		String error_message = ForgotPassword_page.reset_reqest_error_message.getText();

		if (error_message.contains("Login Failed")) {

			// System.out.println("Condition Passed");
		}
	}

	@Test(enabled = false, priority = 6)

	public void forgotPassword_invalidCurrentPassword_resetPage() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		// Redirecting to Cyrano

		driver.navigate().to(config.staging_url());

		login.valid_login(config.username_forgotPassword(), temporaryPassword);

		ForgotPassword_page.currentpasswordText.sendKeys("300100");

		forgotpassword.resetPasswordPage(config.password(), config.password());

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "Invalid user credentials!");
	}

	@Test(enabled = false, priority = 7)

	public void forgotPassword_different_newPassword_confirmPassword() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		// Redirecting to Cyrano

		helper.SwitchingTo_WindowHandles("Cyrano");

		ForgotPassword_page.newpasswordText.sendKeys("Test@2222");

		ForgotPassword_page.confirmpasswordText.sendKeys("Test@7777");

		ForgotPassword_page.submit_reset_password_button.click();

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "Password mismatch!");
	}

	@Test(enabled = false, priority = 8)

	public void forgotPassword_invalid_newPassword_confirmPassword() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		// Redirecting to Cyrano

		helper.SwitchingTo_WindowHandles("Cyrano");

		ForgotPassword_page.newpasswordText.sendKeys("Test2345");

		ForgotPassword_page.confirmpasswordText.sendKeys("Test7777adssdf");

		ForgotPassword_page.submit_reset_password_button.click();

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "Invalid format!");

	}

	@Test(enabled = false, priority = 9)

	public void forgotPassword_invalid_newPassword() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		// Redirecting to Cyrano

		helper.SwitchingTo_WindowHandles("Cyrano");

		ForgotPassword_page.newpasswordText.sendKeys("Test2345test");

		ForgotPassword_page.confirmpasswordText.sendKeys(config.password());

		ForgotPassword_page.submit_reset_password_button.click();

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "Invalid format!");
	}

	@Test(enabled = false, priority = 10)

	public void forgotPassword_invalid_currentPassword() throws InterruptedException {

		forgotpassword.forgot_password_request(config.username_forgotPassword());

		String message = forgotpassword.reset_reqest_success_message.getText();

		Assert.assertEquals(message, "Temporary password will be sent to the below mentioned email address");

		// Navigate to Mailinator

		driver.navigate().to(config.mailinator_url());

		mailinator_handler.opendifferentEmail_mailinator(config.username_forgotPassword(), "Forget something");

		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);

		String temporaryPassword = mailinator_handler.mailinator_email_subject.getText();

		// System.out.println(str);

		mailinator_handler.Mailinator_forgotPassword_resetbutton.click();

		// Redirecting to Cyrano

		helper.SwitchingTo_WindowHandles("Cyrano");

		ForgotPassword_page.newpasswordText.sendKeys(config.password());

		ForgotPassword_page.confirmpasswordText.sendKeys("Test2345567");

		ForgotPassword_page.submit_reset_password_button.click();

		String error_message = forgotpassword.reset_reqest_error_message.getText();

		Assert.assertEquals(error_message, "Password mismatch!");

	}

}
