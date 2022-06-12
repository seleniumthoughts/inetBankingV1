package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
//import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");// Log4j file kept in root directory of project
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getchromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.ie.driver",readConfig.getedgepath());
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void getScreenshot(WebDriver driver,String testCaseName) throws IOException
	{
		String destinationFile=System.getProperty("user.dir")+"/Screenshots/"+testCaseName+".png";
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scr, new File(destinationFile));
	   System.out.println("Screeshot taken");
	}
	public static String randomestring()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public static String randomeNumeric()
	{
		
		String generatedNum=RandomStringUtils.randomNumeric(4);
		return generatedNum;
	}
	
}
