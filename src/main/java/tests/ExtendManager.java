package tests;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendManager 
{

	static ExtentReports reports;
	
	public static ExtentReports getReport() 
	{
		
		if(reports == null) 
		{
			reports = new ExtentReports();
			//init report folder 
			Date d = new Date();
			System.out.println(d.toString().replaceAll(":", "-"));
			String reportFolder = d.toString().replaceAll(":", "-") + "//screenshots";
			
			String ScreenshotFolderPath = System.getProperty("user.dir")+"//reports//"+reportFolder;
			String ReportFolderPath = System.getProperty("user.dir")+"//reports//"+d.toString().replaceAll(":", "-");
			System.out.println("Path " +ScreenshotFolderPath);
			File f = new File(ScreenshotFolderPath);
			f.mkdirs(); //create a dynamic reports folder name + screenshots
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ReportFolderPath);
			
			sparkReporter.config().setReportName("Production Regression Testing");   	
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReporter);
		}
		return reports;
		

	}
}
