package com.cyranosystems.qa.web.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_page {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "username")
	public static WebElement username_txt;

	@FindBy(how = How.ID, using = "next")
	public static WebElement login_clickon_next_btn;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement password_txt;

	@FindBy(how = How.ID, using = "login")
	public static WebElement login_btn;

	@FindBy(how = How.CLASS_NAME, using = "errortxt-cls")
	public static WebElement userexist_error_msg;

	@FindBy(how = How.CLASS_NAME, using = "errortxt-cls")
	public static WebElement loginFailed_error_msg;

	@FindBy(how = How.XPATH, using = "//button[@class='ellipsis']")
	public static WebElement signout_ellipsis;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign out')]")
	public static WebElement sigout_btn2;

	@FindBy(how = How.XPATH, using = "//a[@class='backto']")
	public static WebElement backToSignin_btn;

	@FindBy(how = How.XPATH, using = "//button[@class='btn login-getintouch']")
	public static WebElement learnMore_btn;

	@FindBy(how = How.ID, using = "sso-login-button")
	public static WebElement sso_login_btn;

	@FindBy(how = How.ID, using = "identifierId")
	public static WebElement gmail_userid_txt;

	@FindBy(how = How.CLASS_NAME, using = "CwaK9")
	public static WebElement gmailNext_btn;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement gmailPassword_txt;

	@FindBy(how = How.ID, using = "passwordNext")
	public static WebElement gmailPasswordNext_btn;

	@FindBy(how = How.CLASS_NAME, using = "ng-fa-icon")
	public static WebElement moveToonepointO_btn;

	public Login_page(WebDriver driver) {

		this.driver = driver;
	}

	public void valid_login(String username, String password) {

		username_txt.sendKeys(username);

		login_clickon_next_btn.click();

		password_txt.sendKeys(password);

		login_btn.click();

	}

	public void navigationToHomeLandingScreen() throws Exception {

		Thread.sleep(2000);
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.cyranolab.io/#/campaign/Mycampaign")) {
			Login_page.moveToonepointO_btn.click();
		}
	}

	public void sso_login(String username, String password) throws InterruptedException {

		username_txt.sendKeys(username);

		login_clickon_next_btn.click();

		String parentwindow = driver.getWindowHandle();

		sso_login_btn.click();

		Set<String> allwindows = driver.getWindowHandles();

		if (allwindows.size() > 1) {

			for (String childWindows : allwindows) {

				if (!childWindows.equals(parentwindow)) {

					driver.switchTo().window(childWindows);

					String actualTitle = driver.getTitle();

					if (actualTitle.contains("Sign in")) {

						gmail_userid_txt.sendKeys(username);

						gmailNext_btn.click();

						gmailPassword_txt.sendKeys(password);

						Thread.sleep(3000);

						gmailPasswordNext_btn.click();

						driver.switchTo().window(parentwindow);

						Thread.sleep(5000);

					}

				}

			}

		}
	}

}
