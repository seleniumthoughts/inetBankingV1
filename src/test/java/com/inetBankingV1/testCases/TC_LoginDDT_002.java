package com.inetBankingV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pwd); 
		logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert box
			driver.switchTo().defaultContent();
			getScreenshot(driver,"loginDDT");
			Assert.assertTrue(false);
			logger.info("LoginFailed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.Logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert box
			driver.switchTo().defaultContent();
		}
	}
	
	//method to check alert is present or not
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	 String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/LoginData1.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)// i=0 will  point to header row so start with i=1
		{
			for(int j=0;j<colcount;j++)
			{
				//here [i-1] below  bcz need to store 0th index 
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); 
				
				
			}
		}
		return logindata;
	}
}
