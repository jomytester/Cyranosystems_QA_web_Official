package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Campaigns_Lists_Page {
	
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Lists')]")
	public static WebElement go_to_lists;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add List')]")
	public static WebElement AddList;
	 
	@FindBy(how = How.XPATH, using = "//input[@name='contactlistname']")
	public static WebElement contact_listName;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Create List')]")
	public static WebElement createLst_btn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Lists')]")
	public static WebElement go_to_lists4;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Lists')]")
	public static WebElement go_to_lists5;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Lists')]")
	public static WebElement go_to_lists6;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Lists')]")
	public static WebElement go_to_lists7;
	

}
