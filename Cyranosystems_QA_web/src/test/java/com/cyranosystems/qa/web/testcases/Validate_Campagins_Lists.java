package com.cyranosystems.qa.web.testcases;

import org.testng.annotations.Test;

import com.cyranosystems.qa.web.testbase.Test_Baseclass;

public class Validate_Campagins_Lists extends Test_Baseclass{
	
	@Test(enabled = true, priority = 1)
    public void login_validcredential() throws InterruptedException {

        login.valid_login(config.username(), config.password());
        
        list.go_to_lists.click();
        
        list.AddList.click();
        
        list.contact_listName.sendKeys("Ibot list 1");;

        

    }

}
