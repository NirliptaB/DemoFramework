package com.learnautomation.pages;

import java.io.File;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper help;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUp()
	{
		Reporter.log("Execution started",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		help = new Helper();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir"))+"/Reports/FreeCRM_"+ Helper.getCurrentDateTime() +".html");
		
		
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
	}
	
	@BeforeClass
	public void start()
	{
		Reporter.log("Browser launching", true);
		driver = BrowserFactory.launchApplication(driver,config.getValueFromConfig("Browser"),config.getValueFromConfig("QAUrl"));
	}
	
	@AfterClass
	public void end()
	{
		BrowserFactory.closeApplication(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		String status;
		if(result.getStatus()==ITestResult.FAILURE)
		{
			status = "Failed";
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver,status)).build());
			
		}
		else
		{
			status = "Passed";
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver,status)).build());
		}
		
		report.flush();
	}
}
