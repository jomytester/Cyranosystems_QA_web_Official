package com.cyranosystems.qa.web.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.pages.Join_now;
import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.pages.Mailinator_page;
import com.cyranosystems.qa.web.pages.Produce_yourclips_page;
import com.cyranosystems.qa.web.utilities.Browser_factory;
import com.cyranosystems.qa.web.utilities.Configuration_Property_file;
import com.cyranosystems.qa.web.utilities.Helper_factory;

public class Test_Baseclass {

	public WebDriver driver;
	public Login_page login;
	public Configuration_Property_file config;
	public Helper_factory helper;
	public ForgotPassword_page forgetpassword;
	public Browser_factory browser_factory;
	public Produce_yourclips_page yourClips;
	public Join_now join_now;
	public Mailinator_page mailinator_handler;
	

	@BeforeSuite
	public void object_creation() {

		config = new Configuration_Property_file();
		login = new Login_page(driver);
		forgetpassword = new ForgotPassword_page(driver);
		browser_factory = new Browser_factory();
		yourClips = new Produce_yourclips_page(driver);
		helper = new Helper_factory(driver);
		join_now = new Join_now(driver);
		mailinator_handler = new Mailinator_page(driver);

	}

	@BeforeMethod
	public void initialisation() {

		driver = Browser_factory.start_browser(config.browser_value(), config.staging_url());
		login = PageFactory.initElements(driver, Login_page.class);
		forgetpassword = PageFactory.initElements(driver, ForgotPassword_page.class);
		yourClips = PageFactory.initElements(driver, Produce_yourclips_page.class);
		join_now = PageFactory.initElements(driver, Join_now.class);
		helper = PageFactory.initElements(driver, Helper_factory.class);
		mailinator_handler= PageFactory.initElements(driver, Mailinator_page.class);
	}

	@AfterMethod
	public void browser_close(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			Helper_factory.captureScreenshot(driver);
		}

		driver.quit();
	}

}
