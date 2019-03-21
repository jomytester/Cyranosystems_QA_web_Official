package com.cyranosystems.qa.web.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.Test_Baseclass;
import com.cyranosystems.qa.web.utilities.Helper_factory;
import com.sun.glass.events.KeyEvent;

public class Validate_JoinNow extends Test_Baseclass{
	
	@Test
	public void new_team_creation() throws InterruptedException, AWTException {

		join_now.join_now("auto4@mailinator.com");
		Thread.sleep(20000);
		join_now.submit_btn.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		
		Thread.sleep(2000);
		/*String parentWindow = driver.getWindowHandle();
		
		 Set<String> allwinodws = driver.getWindowHandles();

	        for (String childWindows : allwinodws) {

	            if (!childWindows.equals(parentWindow)) {

	                driver.switchTo().window(childWindows);
	                driver.get(config.mailinator_url());
	                
	                Thread.sleep(5000);

	                String actualTitle = driver.getTitle();

	                System.out.println(driver.getTitle());

	                if (actualTitle.equalsIgnoreCase("Mailinator")) {

	                } else {

	                    System.out.println("error in handling window");

	                }

	            }
		
		mailinator_handler.opendifferentEmail_mailinator("auto4@mailinator.com", "Cyrano Verification Code!");
		driver.switchTo().frame(mailinator_handler.MailFrame_mailinator);
		String joinnow_verfication_code = mailinator_handler.joinnow_verificationcode.getText();
		driver.switchTo().window(parentWindow);
		
	        }*/
	}
}
