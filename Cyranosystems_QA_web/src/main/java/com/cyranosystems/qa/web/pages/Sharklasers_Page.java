package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Sharklasers_Page {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//span[@id='inbox-id']")
	public static WebElement enter_email;
	
	@FindBy(how = How.XPATH, using = "//button[@class='save button small']")
	public static WebElement enter_email_setButton;
	
	@FindBy(how = How.XPATH, using = "//span//input[@type='text']")
	public static WebElement enter_email_textBox;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m3;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m5;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m6;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m7;
	
	@FindBy(how = How.XPATH, using = "")
	public static WebElement m8;
	
	public Sharklasers_Page(WebDriver driver) {

		this.driver = driver;
	}
	
	
}
