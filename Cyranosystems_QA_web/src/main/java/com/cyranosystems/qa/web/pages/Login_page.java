package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_page {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "username")
	public static WebElement username_txt;

	@FindBy(how = How.ID, using = "next")
	public static WebElement clickon_next;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement password_txt;

	@FindBy(how = How.ID, using = "login")
	public static WebElement login_btn;
	
	@FindBy(how=How.CLASS_NAME, using= "errortxt-cls")
	public static WebElement userexist_error_msg;
	
	public Login_page(WebDriver driver) {
		
		this.driver = driver;
	}

	public void valid_login(String username, String password) {

		username_txt.sendKeys(username);

		clickon_next.click();

		password_txt.sendKeys(password);

		login_btn.click();

	}

}
