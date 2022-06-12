package com.inetBankingV1.testCases;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);//bseclass driver variable
		lp.setUserName(username);// baseclass variable
		logger.info("Username provided");
		lp.setPassword(password);// baseclass variable
		logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		Thread.sleep(2000);
		
		//addCust.alertClose();
		
		
		logger.info("Providing customer details..");
		addCust.custName("Vinay");
		addCust.gender("male");
		addCust.custDob("09", "06", "1990");
		Thread.sleep(3000);
		addCust.custAddress("India");
		addCust.custCity("Bangalore");
		addCust.custState("Karnataka");
		addCust.custPin("560076");
		
		String phoneNum=randomeNumeric();
		addCust.custTelephoneno(phoneNum);
		
		String email=randomestring()+"@gmail.com";
		addCust.custEmailid(email);
		addCust.custPassword("abcdef");
		addCust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started...");
	   boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
	    if(res==true)
	    {
	    	logger.info("Test case is passed");
	    	Assert.assertTrue(true);
	    }
	    else
	    {   
	    	logger.info("Test case is failed");
	    	getScreenshot(driver,"addNewCustomer");
	    	Assert.assertTrue(false);
	    }
	}
	
	
	
}
