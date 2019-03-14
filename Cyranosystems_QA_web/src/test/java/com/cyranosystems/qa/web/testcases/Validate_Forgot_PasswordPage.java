package com.cyranosystems.qa.web.testcases;

import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_Forgot_PasswordPage extends Test_Baseclass {
	
	//Forgot Password page > With valid credentials (Tapping on Hyper link in email page in Username page)
	
	@Test(enabled = true)
	public void forgot_passoword_validcredential() {
		
		forgot_pwd.forgot_password_request(config.username_frgt_pwd());
		
	}

}
