package com.cyranosystems.qa.web.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cyranosystems.qa.web.pages.Forgot_password;
import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.utilities.Browser_factory;
import com.cyranosystems.qa.web.utilities.Configuration_Property_file;
import com.cyranosystems.qa.web.utilities.Helper_factory;

public class Test_Baseclass {

	public WebDriver driver;
	public Login_page login;
	public Configuration_Property_file config;
	public Helper_factory helper;
	public Forgot_password forgot_pwd;
	public Browser_factory browser_factory;

	@BeforeSuite
	public void object_creation() {

		config = new Configuration_Property_file();
		login = new Login_page(driver);
		forgot_pwd = new Forgot_password();
		browser_factory = new Browser_factory();
		
	}

	/*
	@BeforeClass
	public void Starts_execution() {
		
		driver = Browser_factory.start_browser(config.browser_value(), config.staging_url());
	}*/
	
	
	@BeforeMethod
	public void initialisation() {
		
		driver = Browser_factory.start_browser(config.browser_value(), config.staging_url());
		
		login = PageFactory.initElements(driver, Login_page.class);
		
		forgot_pwd = PageFactory.initElements(driver, Forgot_password.class);
		
	}

	@AfterMethod
	public void browser_close(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			Helper_factory.captureScreenshot(driver);
		}
		
		driver.quit();
	}
	
	
	
	
	

}
