package com.cyranosystems.qa.web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration_Property_file {

	Properties property;

	public Configuration_Property_file() {

		File source = new File("./Configuration/config.properties");

		try {
			FileInputStream fileinputstream = new FileInputStream(source);

			property = new Properties();

			property.load(fileinputstream);
			
		} catch (Exception e) {

			System.out.println("Unable to find the property file" + e.getMessage());
		}

	}

	public String browser_value() {

		return property.getProperty("Browser");
	}

	public String staging_url() {

		return property.getProperty("staging_url");
	}

	public String production_url() {

		return property.getProperty("production_url");
	}

	public String mailinator_url() {

		return property.getProperty("mailinator_url");
	}

	public String username() {

		return property.getProperty("username");
	}

	public String username_forgotPassword() {

		return property.getProperty("username_frgt_pwd");
	}

	public String password() {

		return property.getProperty("password");
	}

	public String sso_userid() {

		return property.getProperty("SSO_user");

	}

	public String sso_gmail_password() {

		return property.getProperty("SSO_user_password");
	}

	public String superadmin_username() {

		return property.getProperty("super_admin");
	}
}
