    package com.cyranosystems.qa.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cyranosystems.qa.web.utilities.Configuration_Property_file;

public class Mailinator_page {

    WebDriver driver;
    public Configuration_Property_file config = new Configuration_Property_file();
    
    
    @FindBy(how = How.XPATH, using = "//input[@id='inboxfield']")
    public static WebElement mailinator_registered_email;

    @FindBy(how = How.XPATH, using = "//div[@class='hidden-sm hidden-xs']//button[@type='button'][contains(text(),'Go!')]")
    public static WebElement mailinator_go;

    @FindBy(how = How.XPATH, using = "//div[@class='table-responsive']//table//tbody//tr")
    public static List<WebElement> MailinatorEmail_table_list;

    @FindBy(how = How.XPATH, using = "//table[@class='main']//table[2]//tr//td//a")
    public static WebElement mailinator_email_subject;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Reset')]")
    public static WebElement Mailinator_forgotPassword_resetbutton;
    
    @FindBy(how = How.XPATH, using = "//iframe[@id='msg_body']")
    public static WebElement MailFrame_mailinator;
    
    @FindBy(how = How.XPATH, using = "//td[@align='left']")
    public static WebElement joinnow_verificationcode;
    
    public Mailinator_page(WebDriver driver) {

        this.driver = driver;
    }

    public void opendifferentEmail_mailinator(String emailID , String email_Subject) {

        
        mailinator_registered_email.sendKeys(emailID);
        mailinator_go.click();

        for (int i = 0; i < MailinatorEmail_table_list.size(); i++) {

            if (MailinatorEmail_table_list.get(i).getText().contains(email_Subject)) {
                // System.out.println(ForgotPassword_page.table_list.get(i).getText());
                MailinatorEmail_table_list.get(i).click();
                break;

            } else {
               // System.out.println("nothing");
            }
        }
    }
}
