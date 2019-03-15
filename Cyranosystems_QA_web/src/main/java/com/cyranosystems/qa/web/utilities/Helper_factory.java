package com.cyranosystems.qa.web.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Helper_factory extends Test_Baseclass {

	public static void captureScreenshot(WebDriver driver) {

		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			FileHandler.copy(source, new File("./Screenshots/" + timeStamp + ".png"));

		} catch (Exception e) {

			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
	}

	public void redirecting_to_mailinator(WebDriver driver) {

		Browser_factory.navigate_to(driver, config.mailinator_url());
		ForgotPassword_page.registered_email.sendKeys(config.username_frgt_pwd());
		ForgotPassword_page.mailinator_go.click();

		for (int i = 0; i < ForgotPassword_page.table_list.size(); i++) {

			if (ForgotPassword_page.table_list.get(i).getText().contains("Forget something")) {
				// System.out.println(ForgotPassword_page.table_list.get(i).getText());
				ForgotPassword_page.table_list.get(i).click();

			} else {
				// System.out.println("nothing");
			}
		}
	}

	public void redirecting_to_cyrano() {

		String parentWindow = driver.getWindowHandle();

		ForgotPassword_page.mail_reset.click();

		Set<String> allwinodws = driver.getWindowHandles();

		for (String childWindows : allwinodws) {
			if (!childWindows.equals(parentWindow)) {
				driver.switchTo().window(childWindows);
				String actualTitle = driver.getTitle();

				if (actualTitle.equalsIgnoreCase("Mailinator")) {

					System.out.println(driver.getTitle());

				}
			}
		}
	}
}
