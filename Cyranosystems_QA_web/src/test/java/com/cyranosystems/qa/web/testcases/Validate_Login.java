package com.cyranosystems.qa.web.testcases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_Login extends Test_Baseclass {

	// Scenario: Log-in With valid username and password

	@Test(enabled = false)
	public void login_validcredential() {

		login.valid_login(config.username(), config.password());

	}

	// Scenario: Log-in with incorrect username and click next

	@Test(enabled = false)
	public void login_invalidUsername() {

		Login_page.username_txt.sendKeys("jasdaszfdcad@gmail.com");
		Login_page.clickon_next.click();
		String error_msg = Login_page.userexist_error_msg.getText();
		Assert.assertEquals(error_msg,
				"User does not exist. If you have not signed in to Cyrano before, click 'Join Your Team' to get started. Otherwise, check the spelling of your email address.");

	}

	// Scenario: Log-in with correct username and incorrect password

	@Test(enabled = false)
	public void login_invalidPassword() {

		login.valid_login(config.username(), "sdfv");
		String error_msg = Login_page.loginFailed_error_msg.getText();

		if (error_msg.contains("Login failed!")) {

			System.out.println(" condition passed ");

		}

	}

	// Scenario: Log-in with correct username and incorrect password (lock the account)

	@Test(enabled = false)
	public void login_lockaccount() throws InterruptedException {

		login.valid_login(config.username(), "sdfv");

		String error_msg = Login_page.loginFailed_error_msg.getText();

		for (int i = 0; i < 5; i++) {
			if (error_msg.contains("Login failed!")) {

				Login_page.login_btn.click();

			}

		}

		Thread.sleep(2000);

		String account_locked_error_msg = Login_page.loginFailed_error_msg.getText();

		Assert.assertEquals(account_locked_error_msg,
				"Your account has been locked for your security. Please use forgot password to re-set your account password");

	}

	// Scenario : Login-handles case sensitive

	@Test(enabled = false)
	public void login_caseSensitive_() {

		login.valid_login(config.username().toUpperCase(), config.password().toUpperCase());

		String error_msg = Login_page.loginFailed_error_msg.getText();

		if (error_msg.contains("Login failed!")) {

			System.out.println(" condition passed ");

		}

	}

	// Scenario: Login - Authentication (Press-backbutton after signout)
	@Test(enabled = false)
	public void login_Authentication() {

		login.valid_login(config.username(), config.password());

		String title_signin = driver.getTitle();

		Login_page.signout_ellipsis.click();

		Login_page.sigout_btn2.click();

		String title_signout = driver.getTitle();

		driver.navigate().back();

		if (title_signin.equals(title_signout)) {

			System.out.println("Condition Failed");
		} else {

			System.out.println("Condition Passed");
		}
	}

	// Scenario: Login - Backtosignin

	@Test(enabled = false)
	public void login_backtosignin() {

		Login_page.username_txt.sendKeys(config.username());
		Login_page.clickon_next.click();
		Login_page.backToSignin_btn.click();
		login.valid_login(config.username(), config.password());

	}
	
	// Scenario: Login - Learnmore

	@Test(enabled = false)
	public void login_Learnmore() throws InterruptedException {

		String parentWindow = driver.getWindowHandle();

		Login_page.learnMore_btn.click();

		Set<String> allwinodws = driver.getWindowHandles();

		for (String childWindows : allwinodws) {
			if (!childWindows.equals(parentWindow)) {
				driver.switchTo().window(childWindows);
				String actualTitle = driver.getTitle();

				if (actualTitle.equalsIgnoreCase("CYRANO - Home")) {

					System.out.println(driver.getTitle());

				}

			}

		}
	}
	
	
	
	@Test
	public void login_ssologin() throws InterruptedException {
		
		login.sso_login(config.sso_userid(), config.sso_gmail_password());
	}

}
