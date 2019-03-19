package com.cyranosystems.qa.web.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_JoinNow extends Test_Baseclass{
	
	@Test(enabled = true, priority = 1)
	public void new_team_creation() throws InterruptedException {

		join_now.join_now("ad20@mailinator.com");
		
		Thread.sleep(2000);
		
		WebElement ele = join_now.frame_list_join_now;

		driver.switchTo().frame(ele);

		join_now.check_box.click();
		
		join_now.submit_btn.click();
		
	}
}
