package com.cyranosystems.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Produce_yourclips_page {

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'PRODUCE')]")
	public static WebElement clickOnProduce_btn;

	@FindBy(how = How.XPATH, using = "//li[@id='cust-admin-clips']")
	public static WebElement clickOnYourClips_btn;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Clip')]")
	public static WebElement clickOnAddClip_btn;

	public void create_clip() {

		clickOnProduce_btn.click();
		clickOnYourClips_btn.click();
		clickOnAddClip_btn.click();

	}

}
