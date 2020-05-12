package ezcontent.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.pages.LogoutPage;
import ezcontent.qa.util.TestUtil;

public class LogoutTest extends TestBase {
	LoginPage login;
	LogoutPage logout;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	public LogoutTest() {
		super();
		
	}
	
	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
		
		login = new LoginPage();
		logout = new LogoutPage();
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"ExtentReport"+TestUtil.timeStamp()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	
}
	
	
	@Test(priority = 1)
	public void login() {
	logger=extent.createTest("verify login");
	login.validateLogin();
		
	}
	@Test(priority = 2)
	public void logout() {
		logger=extent.createTest("verify logout");
		logout.logOutPage();
		
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
	    if (testResult.getStatus() == ITestResult.FAILURE) { 
	        String temp=TestUtil.captureScreenshot();
	        logger.fail(testResult.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    }else if(testResult.getStatus()==ITestResult.SKIP)
	    {
	    	String temp=TestUtil.captureScreenshot();
	    	logger.skip(testResult.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	        	
	        }
	       
	    }    
	    
	 @AfterClass
	    public void teardown() {
	    	extent.flush();
	    	driver.quit();
}
}
