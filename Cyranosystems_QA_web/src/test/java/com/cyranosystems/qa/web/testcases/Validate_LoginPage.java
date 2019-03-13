package com.cyranosystems.qa.web.testcases;

import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.TestBaseclass;

public class Validate_LoginPage extends TestBaseclass {
	
	
	@Test
	public void valid_Logincheck() {
		
		login.valid_login(config.username(), config.password());
		
	}

}
