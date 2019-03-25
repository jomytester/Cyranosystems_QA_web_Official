package com.cyranosystems.qa.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cyranosystems.qa.web.utilities.Helper_factory;

public class Produce_yourclips_page {

    WebDriver driver;

    protected Helper_factory helper = new Helper_factory(driver);

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

    @FindBy(how = How.ID, using = "record")
    public static WebElement clickonStartrecording;

    @FindBy(how = How.ID, using = "circle")
    public static WebElement counter_321;

    @FindBy(how = How.ID, using = "time")
    public static WebElement recording_timer;

    public Produce_yourclips_page(WebDriver driver) {

        this.driver = driver;
    }

    public void create_clip(String Clipname, String recordingType, long millisecondsTorecord) throws Exception {

       WebDriverWait wait = new WebDriverWait(driver,30); 
       wait.until(ExpectedConditions.visibilityOf(clickOnProduce_btn));
        clickOnProduce_btn.click();
        clickOnYourClips_btn.click();
        clickOnAddClip_btn.click();
        clipname_txt.sendKeys(Clipname);

        if (recordingType.equalsIgnoreCase("Video")) {

            recordVideo_radiobtn.click();

            startRecording_btn.click();

            Thread.sleep(2000);

            helper.Handle_allowBlock_popup("allow");

            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            
            

            clickonStartrecording.click();

            if (counter_321.isDisplayed()) {

                System.out.println("Counter starts");
            }
           /* WebDriverWait wait = new WebDriverWait(driver , 30);
            wait.until(ExpectedConditions.invisibilityOf(counter_321));*/
            
            
            Thread.sleep(10000);
            String recordTime = helper.milliseconds_To_Minutes_Format(millisecondsTorecord);
            System.out.println(recordTime);
            
            System.out.println(recording_timer.getAttribute("innerHTML").toString());

            if (recording_timer.getAttribute("innerHTML").toString().equals(recordTime)) {

                System.out.println("Test stops");
                clickonStartrecording.click();

            }

        } else if (recordingType.equalsIgnoreCase("Audio")) {

            recordAudio_radiobtn.click();

            startRecording_btn.click();

            Thread.sleep(2000);

            helper.Handle_allowBlock_popup("allow");

            Thread.sleep(3000);

            driver.switchTo().defaultContent();

            Thread.sleep(3000);

            clickonStartrecording.click();

        } else if (recordingType.equalsIgnoreCase("URL")) {

            embedURl_radiobtn.click();
            selectURL_btn.click();

        } else if (recordingType.equalsIgnoreCase("Upload")) {

            upload_radiobtn.click();
            browserupload_btn.click();

        }

    }
}
