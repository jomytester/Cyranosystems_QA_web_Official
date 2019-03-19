package com.cyranosystems.qa.web.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Produce_yourclips_page {

	WebDriver driver;

	public Alert alert;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'PRODUCE')]")
	public static WebElement clickOnProduce_btn;

	@FindBy(how = How.XPATH, using = "//li[@id='cust-admin-clips']")
	public static WebElement clickOnYourClips_btn;

	@FindBy(how = How.XPATH, using = "//button[@angularticsaction='AddClip']")
	public static WebElement clickOnAddClip_btn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Name']")
	public static WebElement clipname_txt;

	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	public static WebElement description_txt;

	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-5 col-md-5 col-xs-5'][2]//div//div//span")
	public static List<WebElement> recordingOptions_list;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'col-lg-5 col-md-5 col-xs-5')]//div[2]//div[1]//input[1]")
	public static WebElement recordVideo_radiobtn;

	@FindBy(how = How.XPATH, using = "//div[3]//div[1]//input[1]")
	public static WebElement recordAudio_radiobtn;

	@FindBy(how = How.XPATH, using = "//input[@angularticslabel='YourClips-AddClip-Embed-Url']")
	public static WebElement embedURl_radiobtn;

	@FindBy(how = How.XPATH, using = "embedURl_radiobtn")
	public static WebElement upload_radiobtn;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start Recording')]")
	public static WebElement startRecording_btn;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Select')]")
	public static WebElement selectURL_btn;

	@FindBy(how = How.XPATH, using = "//input[@id='uploadBtn']")
	public static WebElement browserupload_btn;

	@FindBy(how = How.XPATH, using = "//[@id=\"record\"]")
	public static WebElement start_recordingFrame_btn;

	public Produce_yourclips_page(WebDriver driver) {

		this.driver = driver;
	}

	public void create_clip(String Clipname, String recordingType) throws InterruptedException {

		clickOnProduce_btn.click();
		clickOnYourClips_btn.click();
		clickOnAddClip_btn.click();
		clipname_txt.sendKeys(Clipname);

		Thread.sleep(3000);

		if (recordingType.equalsIgnoreCase("Video")) {

			recordVideo_radiobtn.click();
			startRecording_btn.click();
			Thread.sleep(2000);
			start_recordingFrame_btn.click();
			

		} else if (recordingType.equalsIgnoreCase("Audio")) {

			recordAudio_radiobtn.click();
			startRecording_btn.click();
			start_recordingFrame_btn.click();

		} else if (recordingType.equalsIgnoreCase("URL")) {

			embedURl_radiobtn.click();
			selectURL_btn.click();

		} else if (recordingType.equalsIgnoreCase("Upload")) {

			upload_radiobtn.click();
			browserupload_btn.click();

		}

	}
}
