package com.cyranosystems.qa.web.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper_factory {


	public static void captureScreenshot(WebDriver driver) {

		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			File source = screenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			FileHandler.copy(source, new File("./Screenshots/" + timeStamp + ".png"));

		} catch (Exception e) {

			System.out.println("Unable to capture screenshot" + e.getMessage());
		}

	}
		

}
