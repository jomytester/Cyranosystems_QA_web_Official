package com.cyranosystems.qa.web.testcases;

import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.Home_Inbox_Page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_Home_Inbox extends Test_Baseclass {

	@Test
	public void inox_newProgram() {
		
		login.valid_login("ad1@mailinator.com", config.password());
		//Home_Inbox_Page.home.click();
		String inbox_check = Home_Inbox_Page.inbox_check.getText();
		
		String opened = Home_Inbox_Page.inbox_opened.getText();
		
		
	}
	
	
}
