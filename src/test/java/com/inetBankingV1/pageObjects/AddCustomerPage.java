package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME,using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	@FindBy(how=How.XPATH,using="//iframe[@name='ad_iframe'] //span[text()='close']")
	@CacheLookup
	WebElement alertClose;
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String name)
	{
		txtCustomerName.sendKeys(name);
	}
	
	public void gender(String cgender)
	{
		rdGender.click();
	}
	
	public void custDob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity)
	{
		txtcity.sendKeys(ccity);
		
	}
	
	public void custState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	public void custPin(String cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custTelephoneno(String ctelepgoneno)
	{
		txttelephoneno.sendKeys(ctelepgoneno);
	}
	
	public void custEmailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
	public void alertClose()
	{
		//alertClose.click();
	
	}

}
