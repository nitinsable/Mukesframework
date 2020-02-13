package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.apache.commons.io.FileUtils
public class Helper 
{

	//screenshots,alerts,frames,windows,sync issue,javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
	  File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM"+getCurrentDateTime() +".png";
	  
	  //FileHandler.copy(src,new File("./Screenshots/Login.png"));
	  //FileUtils.copyFile(src, new File("./Screenshots/Login.png"));
      try 
    {
		org.openqa.selenium.io.FileHandler.copy(src, new File("./Screenshots/Whizstorm"+getCurrentDateTime()+".png"));
	     
		System.out.println("screenshot captured");
    
    } 
      
     catch (IOException e) 
    {

       System.out.println("Unable to capture screenshot"+e.getMessage());
	}
     
      return screenshotPath;
      
	}
	
	public static String getCurrentDateTime() 
	{
		DateFormat custFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate= new Date();
		
		return custFormat.format(currentdate);
		
	}
	
}


