package com.cyranosystems.qa.web.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.utilities.Browser_factory;
import com.cyranosystems.qa.web.utilities.Configuration_Property_file;
import com.cyranosystems.qa.web.utilities.Helper_factory;

public class TestBaseclass {

	public WebDriver driver;
	public Login_page login;
	public Configuration_Property_file config;
	public Helper_factory helper;

	@BeforeSuite
	public void object_creation() {

		config = new Configuration_Property_file();
		login = new Login_page(driver);

	}

	@BeforeMethod

	public void Starts_execution() {

		driver = Browser_factory.start_browser(config.browser_value(), config.staging_url());
		login = PageFactory.initElements(driver, Login_page.class);

	}

	@AfterMethod
	public void browser_close(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			Helper_factory.captureScreenshot(driver);
		}
	}
	
	
	@AfterClass
	public void browser_close() {
		
		driver.quit();
	}
	

}
