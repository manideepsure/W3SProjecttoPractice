package utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import magentoBaseClass_TestCase.BaseClass;

public class Reporting implements ITestListener {
	
	public ExtentSparkReporter reporter; 
	public ExtentReports extent; 
	public ExtentTest test; 
	
	public void onStart(ITestContext context) {
		
		reporter=new ExtentSparkReporter("C:\\Users\\manid\\eclipse-workspace\\DataDrivenTesting_01\\DDTReport\\newone.html");
		
		
		
		reporter.config().setDocumentTitle("Magneto Login Document");
		reporter.config().setReportName("Login Functionlaity Report");
		reporter.config().setTheme(Theme.DARK);
		
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("user", "Manideep");
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "chrome");
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
		String screenshotPath=System.getProperty("user.dir")+"\\DDTScreenShot\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		

		try {
			String imgPath=new BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgPath);//add screenshot into extent report
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
	
		}
	
	
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
	

}
