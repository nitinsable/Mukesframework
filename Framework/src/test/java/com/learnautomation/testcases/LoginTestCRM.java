package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass{
	
	
	@Test(priority=0)
	public void loginApp() 
	{
		
	logger=reports.createTest("Login to whizstorm");
		//excel.getStringData("Login",0,0);
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("starting application");
		
		loginpage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
		//loginpage.loginToCRM(excel.getStringData(0, 0, 0),excel.getStringData(0, 0, 1));

		Helper.captureScreenshot(driver);
		logger.pass("login done successfully");
	
   }
	
	@Test(priority=2)
	public void loginApp1() 
	{
		
	    logger=reports.createTest("Logout");
		
		logger.fail("Logout failed");
	
   } 	
	
	
}
