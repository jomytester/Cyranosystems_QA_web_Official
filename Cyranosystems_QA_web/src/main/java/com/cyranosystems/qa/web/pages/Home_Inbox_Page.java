package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Inbox_Page {

	WebDriver driver;

	public Home_Inbox_Page(WebDriver driver) {
		
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'HOME')]")
	public static WebElement home;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Inbox')]")
	public static WebElement inbox_check;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'New')]")
	public static WebElement inbox_new;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Opened')]")
	public static WebElement inbox_opened;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Library')]")
	public static WebElement inbox_library;

	@FindBy(how = How.XPATH, using = "//img[@src='https://cdn.cyranolab.io/program/ee3ddb2e-4a24-11e9-93fb-0284445cea14.png']")
	public static WebElement tapping_on_program_thumnail;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish1;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish11;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish111;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish1111;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish2;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish22;

	@FindBy(how = How.XPATH, using = "")
	public static WebElement finish3;

}
