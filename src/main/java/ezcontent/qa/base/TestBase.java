package ezcontent.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ezcontent.qa.util.Wait;
import java.io.File;
import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

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

	}
	
	
