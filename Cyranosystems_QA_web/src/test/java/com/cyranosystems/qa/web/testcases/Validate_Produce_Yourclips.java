package com.cyranosystems.qa.web.testcases;

import org.testng.annotations.Test;

import com.cyranosystems.qa.web.pages.Login_page;
import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_Produce_Yourclips extends Test_Baseclass {

	@Test
	public void yourclips_video() throws Exception {

		login.valid_login(config.username(), config.password());

		login.navigationToHomeLandingScreen();

		Thread.sleep(3000);

		yourClips.create_clip("New Automation", "Video", 1000);

	}

}
