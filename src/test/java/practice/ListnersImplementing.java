package practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ninzaCRM.genericUtilities.BaseClass;
import ninzaCRM.genricUtilities.JavaUtility;
import ninzaCRM.genricUtilities.WebdriverUtility;

public class ListnersImplementing implements ITestListener{

    ExtentReports report;
     ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		 String methodName= result.getMethod().getMethodName();
		 System.out.println("======Suite Execution is Started=======");
		 
		 //Intimate extent reports for @Test Start
		   test=report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 String methodName= result.getMethod().getMethodName();
		 System.out.println("======Suite Execution is Started Sucessful=======");
		 
		 //log the status of @Test as PASS in extent report
		 test.log(Status.PASS,methodName+"==== Execution is passed====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	     String methodName= result.getMethod().getMethodName();
		 System.out.println("====== Test Exceution is failed=======");
		 
		 
		 //log the status as fail in Extent Reports
		 test.log(Status.FAIL,methodName+"----Test Execution Fail");
		 
		 //Capture the exception
		 System.out.println(result.getThrowable());
		 
		 //log the exception in extents reports
		 test.log(Status.WARNING,result.getThrowable());
		 
		 JavaUtility j= new JavaUtility();
		 WebdriverUtility w=new WebdriverUtility();
		 //Capture the screenshot
		 System.out.println(result.getThrowable());
		 
		 //ScreenShotName- method name _ date n time
	     String  screenshotname= methodName+j.getsystemDate();
			
	   try {
		   w.captureScreenShot(BaseClass.sdriver, screenshotname);
		   
		   //Attach screenshot to report
		    test.addScreenCaptureFromPath(screenshotname);
	   }catch (Exception e) {
		 e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	 
	   String methodName= result.getMethod().getMethodName();
		System.out.println("======Exceution is Skipped=======");
		
		//log the Skip Status
		test.log(Status.SKIP,methodName +"====== Exceution is Skipped=====");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
				
	     //log the exception
		test.log(Status.WARNING, result.getThrowable());
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
		System.out.println("======Exceution is failed=======");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
		System.out.println("======Exceution is failed=======");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("======Test suite is started=======");
		
		//Extend Report Configuration
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\Extent-Report"+ new JavaUtility().getsystemDate()+".html");
        esr.config().setDocumentTitle("Nonza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Report");
		
	ExtentReports report= new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Base Browser"," Microsoft edge");
	report.setSystemInfo("Base Platform"," Windows");
	report.setSystemInfo("Base URL","Test Env");
	report.setSystemInfo("Reporter Name","Gaurav");
		                 
	}

	@Override
	public void onFinish(ITestContext context) {
		 System.out.println("=====Suite execution finished======");
		 
		 //Report generation
		  report.flush();
	}

	
}
