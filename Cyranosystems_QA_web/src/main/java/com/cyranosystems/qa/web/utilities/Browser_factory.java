package com.cyranosystems.qa.web.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_factory {

	static WebDriver driver;
	
	

	public static WebDriver start_browser(String browser_name, String url) {

		try {
			if (browser_name.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

				driver = new ChromeDriver();

			}
			
			else if(browser_name.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");

				driver = new FirefoxDriver();
				
			}
		} catch (Exception e) {
			
			
			System.out.println("Unable to start browser" +e.getMessage());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
		return driver;

	}
	
	
		



	

}
