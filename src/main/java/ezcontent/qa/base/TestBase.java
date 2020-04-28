package ezcontent.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import ezcontent.qa.util.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/ezcontent/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("IE")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Wait.pageLoad(10);
		Wait.implicitWait(10);
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("devURL"));
		return driver;
	}

	public static void browserQuit() {

		driver.quit();

	}
	

}
