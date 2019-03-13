package com.cyranosystems.qa.web.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.utilities.Browser_factory;
import com.cyranosystems.qa.web.utilities.Configuration_Property_file;

public class TestBaseclass {
	
	public WebDriver driver;
	
	public Login_page login;
	
	public Configuration_Property_file config;
	
	
	
	@BeforeSuite
	public  void object_creation() {
		
		config = new Configuration_Property_file();
		login = new Login_page(driver);
		
		
	}
	
	
	@BeforeMethod
	
	public void Starts_execution() {
		
		driver = Browser_factory.start_browser(config.browser_value(), config.staging_url());
		login = PageFactory.initElements(driver, Login_page.class);
		
		
	}
	
	
	
	
	

}
