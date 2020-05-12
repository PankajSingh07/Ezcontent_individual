package ezcontent.qa.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ezcontent.qa.base.TestBase;

public class Wait extends TestBase {

	WebDriverWait Wait;

	public Wait() throws IOException {
		super();

	}

	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public static void Pause(long millis) throws InterruptedException {

		Thread.sleep(millis);
	}

	public static void elementClickable(long timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void visibiltyOfElement(long timeout, WebElement element) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	public static void pageLoad(long time) {

		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

	}

}
