package ezcontent.qa.base;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import ezcontent.qa.pages.ArticleEmbedPage;
import ezcontent.qa.pages.ArticleGalleryPage;
import ezcontent.qa.pages.ArticleMapPage;
import ezcontent.qa.pages.ContentLiveBlogPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
    public static ArticleEmbedPage embed;
	public static LoginPage loginpage;
    public static ArticleMapPage articlemapPage;
	public static ContentLiveBlogPage contentliveblogPage;
	public static ArticleGalleryPage Gallery;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;

	public Logger log = Logger.getLogger(TestBase.class);

	

	static String currentDir = System.getProperty("user.dir");
	String configFilePath = currentDir + File.separator + "src" + File.separator + "main" + File.separator + "java"
			+ File.separator + "ezcontent" + File.separator + "qa" + File.separator + "config" + File.separator
			+ "config.properties";

	static String chromeDriverPath = currentDir + File.separator + "driver" + File.separator + "chromedriver.exe";
	static String fireFoxDriverPath = currentDir + File.separator + "driver" + File.separator + "geckodriver.exe";

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void browserLaunch() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			}         

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
       //driver = new ChromeDriver(chromeOptions);

			//ChromeOptions chromeOptions = new ChromeOptions();
			//System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			
           //WebDriverManager.chromedriver().version("81.0.4044.69").setup();
           //ChromeOptions chromeOptions = new ChromeOptions();
		   //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		  //driver = new ChromeDriver(chromeOptions);
		 //chromeOptions.addArguments("headless");
		//driver = new ChromeDriver(chromeOptions);

		 else if (browserName.equals("FF")) {		
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//
			// ChromeOptions chromeOptions = new ChromeOptions();
			// //chromeOptions.addArguments("headless");
			// driver = new ChromeDriver(chromeOptions);

			// ChromeOptions chromeOptions = new ChromeOptions();
			// System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			// WebDriverManager.chromedriver().version("81.0.4044.69").setup();
			// ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			// driver = new ChromeDriver(chromeOptions);
			// chromeOptions.addArguments("headless");
			// driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equals("FF")) {


			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",chromeDriverPath);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();			

			System.setProperty("webdriver.ie.driver", chromeDriverPath);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("devurl"));
		
	}
	
	
	public static void browserQuit() {	
		driver.quit();

	}

	@BeforeClass
	public void setup() throws IOException {
		browserLaunch();
		log.info("******** Invoking Browser ************");
		loginpage = new LoginPage();
		articlemapPage = new ArticleMapPage();
		contentliveblogPage = new ContentLiveBlogPage();
		embed = new ArticleEmbedPage();
		Gallery = new ArticleGalleryPage();
		reporter =  new ExtentHtmlReporter(currentDir+File.separator+"Reports"+File.separator+TestUtil.timeStamp()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	@AfterClass
    public void closeBrowser()
		{
			browserQuit();
			extent.flush();
		}
	
//	@AfterMethod
//	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {   
//	    String path = TestUtil.captureScreenshot();
//	 		if(ITestResult.FAILURE == testResult.getStatus())
//	 		{
//	 			logger.fail(testResult.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());	
//	 	    }
//	 		else if(ITestResult.SUCCESS == testResult.getStatus())
//	 		{
//	 			logger.pass(testResult.getName());
//	 		}
//	 		else if(testResult.getStatus() == ITestResult.SKIP){
//	 		logger.skip(testResult.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//	 		// logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//	 		}
//	}

	
	

	
}
