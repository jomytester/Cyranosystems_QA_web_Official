package com.cyranosystems.qa.web.testcases;

import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;
import com.cyranosystems.qa.web.utilities.Browser_factory;

public class Validate_ForgotPassword extends Test_Baseclass {
    
    // Forgot Password page > With valid credentials (Clicking on Hyper link in
    // email page in Username page)
    
    @Test(enabled = true, priority = 1)
    
    public void forgotPassoword_usernamePage_validCredential() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator to open mail
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        forgotpassword.changeNewPassword(config.password(), config.password());
        
        Thread.sleep(1000);
        
        ForgotPassword_page.finish.click();
        
        String VerfiyTitle = driver.getTitle();
        
        System.out.println(VerfiyTitle);
        
    }

    @Test(enabled = true, priority = 2)
    
    public void forgotPassoword_passwrodPage_validCredential() throws InterruptedException {
        
        Login_page.username_txt.sendKeys(config.username_frgt_pwd());
        
        Login_page.login_clickon_next_btn.click();
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        forgotpassword.changeNewPassword(config.password(), config.password());
        
        Thread.sleep(1000);
        
        ForgotPassword_page.finish.click();
        
        String VerfiyTitle = driver.getTitle();
        
        System.out.println(VerfiyTitle);
        
    }

    @Test(enabled = true, priority = 3)
    
    public void forgotPassword_currentPassword_Manual() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        // Redirecting to Cyrano
        
        driver.navigate().to(config.staging_url());
        
        login.valid_login(config.username_frgt_pwd(), str);
        
        ForgotPassword_page.currentpasswordtxt.sendKeys(str);
        
        forgotpassword.changeNewPassword(config.password(), config.password());
        
        Thread.sleep(1000);
        
        ForgotPassword_page.finish.click();
        
        String tab = driver.getTitle();
        
        System.out.println(tab);
    }

    @Test(enabled = true, priority = 4)
    
    public void forgotPassoword_invalidemail() {
        
        forgotpassword.forgot_password_request("auto123@gmail.com");
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "User does not exist!");
    }

    @Test(enabled = true, priority = 5)
    public void forgotPassword_invalidCurrentPassword_passwordPage() throws InterruptedException {
       
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
       
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
       
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
       
        System.out.println(str);
       
        // Redirecting to Cyrano
       
        driver.navigate().to(config.staging_url());
       
        login.valid_login(config.username_frgt_pwd(), "300100");
        
        String error_msg = ForgotPassword_page.reset_reqest_error_msg.getText();
        
        if (error_msg.contains("Login Failed")) {
           
            System.out.println("Condition Passed");
        }
    }

    @Test(enabled = true, priority = 6)
    public void forgotPassword_invalidCurrentPassword_resetPage() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        // Redirecting to Cyrano
                
        driver.navigate().to(config.staging_url());
        
        login.valid_login(config.username_frgt_pwd(), str);
        
        ForgotPassword_page.currentpasswordtxt.sendKeys("300100");
        
        forgotpassword.changeNewPassword(config.password(), config.password());
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "Invalid user credentials!");
    }

    @Test(enabled = true, priority = 7)
    public void forgotPassword_different_newPassword_confirmPassword() throws InterruptedException {
       
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        // Redirecting to Cyrano
        
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        ForgotPassword_page.newpasswordtxt.sendKeys("Test@2222");
        
        ForgotPassword_page.confirmpasswordtxt.sendKeys("Test@7777");
        
        ForgotPassword_page.submit_reset_password.click();
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "Password mismatch!");
    }

    @Test(enabled = true, priority = 8)
    public void forgotPassword_invalid_newPassword_confirmPassword() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        // Redirecting to Cyrano
              
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        ForgotPassword_page.newpasswordtxt.sendKeys("Test2345");
        
        ForgotPassword_page.confirmpasswordtxt.sendKeys("Test7777adssdf");
        
        ForgotPassword_page.submit_reset_password.click();
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "Invalid format!");
        
    }
    

    @Test(enabled = true, priority = 9)
    public void forgotPassword_invalid_newPassword() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        // Redirecting to Cyrano
        
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        ForgotPassword_page.newpasswordtxt.sendKeys("Test2345test");
        
        ForgotPassword_page.confirmpasswordtxt.sendKeys(config.password());
        
        ForgotPassword_page.submit_reset_password.click();
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "Invalid format!");
    }
    
    @Test(enabled = true, priority = 10)
    public void forgotPassword_invalid_currentPassword() throws InterruptedException {
        
        forgotpassword.forgot_password_request(config.username_frgt_pwd());
        
        String msg = forgotpassword.reset_reqest_success_msg.getText();
        
        Assert.assertEquals(msg, "Temporary password will be sent to the below mentioned email address");
        
        // Navigate to Mailinator
        
        driver.navigate().to(config.mailinator_url());
        
        mailinator_handler.opendifferentEmail_mailinator(config.username_frgt_pwd(), "Forget something");
        
        driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
        
        String str = mailinator_handler.mailinator_email_subject.getText();
        
        System.out.println(str);
        
        mailinator_handler.Mailinator_forgotPassword_resetbutton.click();
        
        // Redirecting to Cyrano
        
        helper.SwitchingTo_WindowHandles("Cyrano");
        
        ForgotPassword_page.newpasswordtxt.sendKeys(config.password());
        
        ForgotPassword_page.confirmpasswordtxt.sendKeys("Test2345567");
        
        ForgotPassword_page.submit_reset_password.click();
        
        String error_msg = forgotpassword.reset_reqest_error_msg.getText();
        
        Assert.assertEquals(error_msg, "Password mismatch!");
    }

}
