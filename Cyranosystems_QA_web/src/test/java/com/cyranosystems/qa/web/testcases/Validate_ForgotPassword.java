package com.cyranosystems.qa.web.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.ForgotPassword_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_ForgotPassword extends Test_Baseclass {
	
	//Forgot Password page > With valid credentials (Clicking on Hyper link in email page in Username page)
	
	@Test(enabled = true)
	public void forgot_passoword_validcredential() {
		
		forgot_pwd.forgot_password_request(config.username_frgt_pwd());
		String error_msg = forgot_pwd.reset_reqest_msg.getText();
		Assert.assertEquals(error_msg,
				"Temporary password will be sent to the below mentioned email address");
		
		// Navigate to Mailinator
		browser_factory.navigate_to(driver, config.mailinator_url());
		ForgotPassword_page.registered_email.sendKeys(config.username_frgt_pwd());
		ForgotPassword_page.mailinator_go.click();
		
		
	
		
	}

	
}
