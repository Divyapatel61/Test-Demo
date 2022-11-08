package extentReport;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tests.ExtendManager;


public class LoginTest
{
	ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod
	public void init()
	{
		report = ExtendManager.getReport();
		
		test = report.createTest("Login Test");
	}
	
	@AfterMethod
	public void quit()
	{
		report.flush();
	}

	@Test
	public void Login() 
	{
		test.log(Status.INFO, "Starting test case Login");
		test.log(Status.FAIL, "404 error");
		Assert.fail();
		test.log(Status.INFO, "Opening Browser");
		test.log(Status.INFO, "Loggin In");
		test.log(Status.INFO,"Test Passed");
		
	}
}
