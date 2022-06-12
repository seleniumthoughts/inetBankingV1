package com.inetBankingV1.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends TestListenerAdapter{

	public ExtentSparkReporter SparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyyMM.dd.HH.mm.ss").format(new Date());
		String repName="Test-report-"+timeStamp+".html";
		SparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			//SparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		extent.attachReporter(SparkReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Vinay");
		
		SparkReporter.config().setDocumentTitle("InetBanking Test Project");
		SparkReporter.config().setReportName("Functional Test Report");
		//SparkReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		SparkReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenShotPath);
		
		if(f.exists())
		{
			try
			{
				logger.fail("Screenshot is above "+logger.addScreenCaptureFromPath(screenShotPath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailedWithTimeout(tr);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	
	
}
