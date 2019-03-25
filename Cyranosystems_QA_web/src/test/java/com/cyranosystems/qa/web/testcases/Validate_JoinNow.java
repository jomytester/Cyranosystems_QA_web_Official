package com.cyranosystems.qa.web.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.Test_Baseclass;
import com.cyranosystems.qa.web.utilities.Helper_factory;
import com.sun.glass.events.KeyEvent;

public class Validate_JoinNow extends Test_Baseclass{
	
	@Test
	public void new_team_creation() throws InterruptedException, AWTException {

		join_now.join_now("auto40@mailinator.com");
		Thread.sleep(150000);
		join_now.submit_btn.click();
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		
		 Set<String> allwinodws = driver.getWindowHandles();

	        for (String childWindow : allwinodws) {

	            if (!childWindow.equals(parentWindow)) {

	                driver.switchTo().window(childWindow);
	                driver.get("https://www.mailinator.com/");
	                
	                Thread.sleep(5000);

	                String actualTitle = driver.getTitle();
	                String child  = driver.getWindowHandle();

	                System.out.println(driver.getTitle());

	                if (actualTitle.equalsIgnoreCase("Mailinator")) {

	                }  else {

	                    System.out.println("error in handling window");

	                }

	            }
	    
	        }
		
	        String child  = driver.getWindowHandle();
	        robot.keyRelease(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			mailinator_handler.opendifferentEmail_mailinator("auto40@mailinator.com","Cyrano Verification Code!");

			WebElement  frame = mailinator_handler.MailFrame_mailinator;
	        driver.switchTo().frame(frame);
	        
	        String verificationCode = mailinator_handler.joinnow_verificationcode.getText();
	        System.out.println(verificationCode);
	        
	        driver.switchTo().window(parentWindow);
			
	        join_now.joinTeam_VerificationCode.sendKeys(verificationCode);
	        Thread.sleep(1000);
	        join_now.verify_your_code_button.click();
	        
	        join_now.detailsPage("First", "Last", "9988998899");
	        Thread.sleep(1000);
	        //join_now.DetailsPage_submitButton.click();
	        
	        driver.switchTo().window(child);
	        
	        mailinator_handler.homePage_goButton.click();
	        
	        Thread.sleep(3000);
	        
	        for (int i = 0; i < mailinator_handler.MailinatorEmail_table_list.size(); i++) {

	            if (mailinator_handler.MailinatorEmail_table_list.get(i).getText().contains("Welcome to Cyrano!")) {
	                System.out.println(mailinator_handler.MailinatorEmail_table_list.get(i).getText());
	                mailinator_handler.MailinatorEmail_table_list.get(i).click();
	                break;

	            } else {
	               // System.out.println("nothing");
	            }
	        }
	        
	        Thread.sleep(3000);
	        
	        WebElement  welcomeFrame = mailinator_handler.MailFrame_mailinator;
	        driver.switchTo().frame(welcomeFrame);
	        
	        mailinator_handler.joinTeam_button.click();
	        
	        helper.SwitchingTo_WindowHandles("Cyrano");
	        
	        /*Set<String> allwinodws1 = driver.getWindowHandles();
	        
	        for (String childWindows : allwinodws1) {
	        	
	        	if (!childWindows.equals(parentWindow)) {

	                driver.switchTo().window(childWindows);

	                String actualTitle = driver.getTitle();

	                System.out.println(driver.getTitle());

	                if (actualTitle.equalsIgnoreCase("Cyrano")) {

	                } else {

	                    System.out.println("error in handling window");

	                }

	            }

	        }*/
	        
	        Thread.sleep(1000);
	        
	        forgotpassword.changeNewPassword(config.password(), config.password());
	        
	        Thread.sleep(1000);
	        
	        forgotpassword.finish.click();
	        
}
}
