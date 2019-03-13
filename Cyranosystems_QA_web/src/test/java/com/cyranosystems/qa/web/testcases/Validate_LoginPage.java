package com.cyranosystems.qa.web.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.TestBaseclass;

public class Validate_LoginPage extends TestBaseclass {
	
	
	@Test
	public void valid_Logincheck()  {
		
		login.valid_login(config.username(), config.password());
			
	
	}
	
	@Test
	public void invalidUsername_Logincheck() {
		
		Login_page.username_txt.sendKeys("jasdaszfdcad@gmail.com");
		Login_page.clickon_next.click();
		
		String error_msg =Login_page.userexist_error_msg.getText();
		
		Assert.assertEquals(error_msg, "User does not exist. If you have not signed in to Cyrano before, click 'Join Your Team' to get started. Otherwise, check the spelling of your email address.");
	}
	
	
	

}
