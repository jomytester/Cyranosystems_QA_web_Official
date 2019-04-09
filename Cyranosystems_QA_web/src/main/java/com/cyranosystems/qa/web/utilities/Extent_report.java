package com.cyranosystems.qa.web.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_report {
    
    public ExtentReports report;
    public ExtentTest logger;
    
    public Extent_report()
    
    {
        
       String name = new Object() {}.getClass().getName().toUpperCase();
        
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss ").format(Calendar.getInstance().getTime());

        ExtentHtmlReporter html_report = new ExtentHtmlReporter("./Reports/"+timeStamp+name+".html");

        report = new ExtentReports();

        report.attachReporter(html_report);
    }
        
    
    public void flush_extentReport() {
        
        report.flush();
    }

 
}
