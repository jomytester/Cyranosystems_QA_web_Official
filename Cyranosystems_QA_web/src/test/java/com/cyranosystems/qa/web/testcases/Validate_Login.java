package com.cyranosystems.qa.web.testcases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;
import com.cyranosystems.qa.web.utilities.Helper_factory;

public class Validate_Login extends Test_Baseclass {

    // Scenario: Log-in With valid username and password

	@Test(enabled = true, priority = 1)
    public void login_validcredential() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.valid_login(config.username(), config.password());

        extentReport.logger.info("Done");

    }

    // Scenario: Log-in with incorrect username and click next

    @Test(enabled = true, priority = 2)
    public void login_invalidUsername() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        Login_page.username_txt.sendKeys("jasdaszfdcad@gmail.com");

        Login_page.login_clickon_next_btn.click();

        String error_msg = Login_page.userexist_error_msg.getText();

        Assert.assertEquals(error_msg,
                "User does not exist. If you have not signed in to Cyrano before, click 'Join Your Team' to get started. "
                        + "Otherwise, check the spelling of your email address.");

        extentReport.logger.info("Done");

    }

    // Scenario: Log-in with correct username and incorrect password

    @Test(enabled = true, priority = 3)
    public void login_invalidPassword() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.valid_login(config.username(), "sdfv");

        String error_msg = Login_page.loginFailed_error_msg.getText();

        if (error_msg.contains("Login failed!")) {

            System.out.println(" condition passed ");

        }
        extentReport.logger.info("Done");
    }

    // Scenario: Log-in with correct username and incorrect password (lock the
    // account)

    @Test(enabled = true, priority = 4)
    public void login_lockaccount() throws InterruptedException {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.valid_login(config.username(), "sdfv");

        String error_msg = Login_page.loginFailed_error_msg.getText();

        for (int i = 0; i < 5; i++) {

            if (error_msg.contains("Login failed!")) {

                Login_page.login_btn.click();

            }

        }

        Thread.sleep(2000);

        String account_locked_error_msg = Login_page.loginFailed_error_msg.getText();

        Assert.assertEquals(account_locked_error_msg,
                "We have locked your account, just in case something fishy is going on. You can reset your password by clicking next to forgot password below.");
        extentReport.logger.info("Done");

    }

    // Scenario : Login-handles case sensitive

    @Test(enabled = true, priority = 5)
    public void login_caseSensitive_() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.valid_login(config.username().toUpperCase(), config.password().toUpperCase());

        String error_msg = Login_page.loginFailed_error_msg.getText();

        if (error_msg.contains("Login failed!")) {

            System.out.println(" condition passed ");

        }
        extentReport.logger.info("Done");
    }

    // Scenario: Login - Authentication (Press-backbutton after signout)
    @Test(enabled = true, priority = 6)
    public void login_Authentication() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.valid_login(config.username(), config.password());

        String title_signin = driver.getTitle();

        Login_page.signout_ellipsis.click();

        Login_page.sigout_btn2.click();

        String title_signout = driver.getTitle();

        driver.navigate().back();

        if (!title_signin.equals(title_signout)) {

            System.out.println("Condition Passed");

        } else {

            System.out.println("Condition Failed ");
        }
    }

    // Scenario: Login - Backtosignin

    @Test(enabled = true, priority = 7)

    public void login_backtosignin() {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        Login_page.username_txt.sendKeys(config.username());

        Login_page.login_clickon_next_btn.click();

        Login_page.backToSignin_btn.click();

        login.valid_login(config.username(), config.password());

        extentReport.logger.info("Done");

    }

    // Scenario: Login - Learnmore

    @Test(enabled = true, priority = 8)
    public void login_Learnmore() throws InterruptedException {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        String parentWindow = driver.getWindowHandle();

        Login_page.learnMore_btn.click();

        Set<String> allwinodws = driver.getWindowHandles();

        for (String childWindows : allwinodws) {

            if (!childWindows.equals(parentWindow)) {

                driver.switchTo().window(childWindows);

                String actualTitle = driver.getTitle();

                if (actualTitle.equalsIgnoreCase("CYRANO - Home")) {

                    System.out.println(driver.getTitle());

                }

            }

        }
        extentReport.logger.info("Done");
    }

    @Test(priority = 9, enabled = true)
    public void login_ssologin() throws InterruptedException {

        String name = new Object() {
        }.getClass().getEnclosingMethod().getName();

        extentReport.report.createTest(name);

        login.sso_login(config.sso_userid(), config.sso_gmail_password());

        extentReport.logger.info("Done");

    }
    
}
