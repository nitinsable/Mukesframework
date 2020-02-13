package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuit() 
	{
		
	     Reporter.log("setting up reports & Test is getting ready",true);
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		 reports=new ExtentReports();
		 reports.attachReporter(extent);
		 Reporter.log("setting done & Test can be started",true);
	
	}
	
	@BeforeClass
	public void setup()
	{	
		Reporter.log("trying to start browser & getting application ready",true);
		driver=BrowserFactory.startApplicatioin(driver,config.getBrowser(),config.getStagingURL());
		//driver=BrowserFactory.startApplicatioin(driver, "Firefox", "https://whizstorm.com/");
        //System.out.println(driver.getTitle());		
		Reporter.log("Browser and application is up & running",true);	
	}
	
	@AfterClass
	public void tearDown()
	{
	  BrowserFactory.quitBrowser(driver);	
	}
    
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end",true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		  Helper.captureScreenshot(driver);
		  logger.fail("Test fail",MediaEntityBuilder.createScreenCaptureFromPath("driver").build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath("driver").build());	
		}
		
		Reporter.log("Test Completed >> Reports genertaed",true);
		/*
		else if(result.getStatus()==ITestResult.SKIP)
			
		{
			logger.skip("Test skipped",MediaEntityBuilder.createScreenCaptureFromPath("driver").build());	

		}
		*/
		reports.flush();
	}
}
