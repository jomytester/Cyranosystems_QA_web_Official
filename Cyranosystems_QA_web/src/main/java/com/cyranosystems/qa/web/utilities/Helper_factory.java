package com.cyranosystems.qa.web.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class Helper_factory /* extends Test_Baseclass */ {

    WebDriver driver;

    public Helper_factory(WebDriver driver) {

        this.driver = driver;
    }

    public static void aftermethodcaptureScreenshot(WebDriver driver, ITestResult result) {

        String method = result.getName();

        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            FileHandler.copy(source, new File("./Screenshots/" + method + timeStamp + ".png"));

        } catch (Exception e) {

            System.out.println("Unable to capture screenshot" + e.getMessage());
        }
    }

    public static void captureScreenshot(WebDriver driver, String methodname) {

        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            FileHandler.copy(source, new File("./Screenshots/" + methodname + timeStamp + ".png"));

        } catch (Exception e) {

            System.out.println("Unable to capture screenshot" + e.getMessage());
        }
    }

    public void SwitchingTo_WindowHandles(String pageToSwitch) {

        String parentWindow = driver.getWindowHandle();

        Set<String> allwinodws = driver.getWindowHandles();

        for (String childWindows : allwinodws) {

            if (!childWindows.equals(parentWindow)) {

                driver.switchTo().window(childWindows);

                String actualTitle = driver.getTitle();

                System.out.println(driver.getTitle());

                if (actualTitle.equalsIgnoreCase(pageToSwitch)) {
                    break;

                } else {

                    System.out.println("error in handling window");

                }

            }

        }
    }

    public void Handle_allowBlock_popup(String operation_To_be_Performed) {

        if (operation_To_be_Performed.equalsIgnoreCase("Allow")) {
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception e) {

                System.out.println("Unable to click on allow button " + e.getMessage());
            }
        } else if (operation_To_be_Performed.equalsIgnoreCase("Block")) {

            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception e) {

                System.out.println("Unable to click on allow button " + e.getMessage());
            }

        }
    }

    public String milliseconds_To_Minutes_Format(long milliseconds) {

        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);

        // long minutes = (milliseconds / 1000) / 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);

        // long seconds = (milliseconds / 1000);
        long seconds2 = TimeUnit.MILLISECONDS.toSeconds(milliseconds);

        return String.format("0%d:0%d:0%d", hours, minutes, seconds2);
    }

}
