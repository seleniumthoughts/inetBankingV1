package com.inetBankingV1.testCases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	//private  static Logger logger=LogManager.getLogger(TC_LoginTest_001.class);
	
	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		logger.info("URL opened");
		
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("passed");
		}
		else
		{
			
			
			Assert.assertTrue(false);
			logger.info("Login test Failed");
		}
	}
	@Test
	public void validateHeaderText() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		WebElement headerText=lp.getHeaderText();
		if(headerText.getText().equals("Guru99 Bank"))
		{
			logger.info("Validate header text success..");
			Assert.assertTrue(true);
		}
		else
		{
			getScreenshot(driver,"validateHeaderText");//passing driver & methodName
			 logger.error("ValidateHeaderText failed");
			Assert.assertTrue(false);
		   
			
		}
		
	}
	
	
	
}
