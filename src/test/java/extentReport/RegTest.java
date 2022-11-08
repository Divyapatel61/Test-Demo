package extentReport;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.ExtendManager;

public class RegTest
{
	ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod
	public void init()
	{
		report = ExtendManager.getReport();
		
		test = report.createTest("Register Test");
	}
	
	@AfterMethod
	public void quit()
	{
		report.flush();
	}

	@Test
	public void doRegister() 
	{
		test.log(Status.INFO, "RegisterTest started");
		test.log(Status.PASS, "RegisterTest Pass");
	}
}
