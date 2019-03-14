package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Forgot_password {

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public static WebElement click_here; 
	
	@FindBy(how = How.NAME, using = "forgotpasswordtxt" )
	public static WebElement forgotpasswordtxt;
	
	@FindBy(how = How.XPATH, using = "//div[@class='d-inline-block']")
	public static WebElement request_reset_link_btn;
}
