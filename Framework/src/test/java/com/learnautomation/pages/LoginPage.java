package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
	   this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[@id='languageDropdownInvoker']") WebElement languagedro;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]") WebElement signinl;
	
	@FindBy(id="signinSrEmail") WebElement emailad;
	
	@FindBy(id="signinSrPassword") WebElement passw;
	
	@FindBy(xpath="//button[@type='button']") WebElement signinbu;
	
	public void loginToCRM(String username,String passwo) 
	{
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{


		}
		
		
		languagedro.click();
		signinl.click();
		emailad.sendKeys(username);
		passw.sendKeys(passwo);
		signinbu.click();
	}
		
}
