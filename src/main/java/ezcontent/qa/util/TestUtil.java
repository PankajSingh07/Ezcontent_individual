package ezcontent.qa.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ezcontent.qa.base.TestBase;

public class TestUtil extends TestBase {
	

//	public static long PageLoadTimeout = 20;
//	public static long ImplicitWait = 10;
	
	public static Select select;
	public static Actions action;

	//Navigate to any url
	public void navigateToURL(String url) 
	{
		driver.navigate().to(url);

	}	
	
	// Switch by Index
	public static void switchFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}

    //Switch by frame name
	public static void switchFrameByName(String name)
	{
		driver.switchTo().frame(name);
	}

	// Switch by frame ID

public static void switchFrameById(String frameId)
{
	driver.switchTo().frame(frameId);
}

//Switch by frame WebElement
public static void switchFrameByWebElement(WebElement frameElement)
{
	driver.switchTo().frame(frameElement);
}

    //Switch back to the main window from frame
	public static void switchBackToWindow()
	{ 
		driver.switchTo().defaultContent();
	}

	// switch to simple alert
	public static void switchToSimpleAlert() {
	Alert simpleAlert = driver.switchTo().alert();
	 String alertText = simpleAlert.getText();
	 System.out.println("Alert text is " + alertText);
	 simpleAlert.accept();
	 }
	 
	 // Clear any field
     public static void clearField(WebElement element)
     {
         try {
             element.clear();
         } catch (Exception e) {
             System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
         }
        }
         
     public static void scrollToEndOfPage() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     }

     public static void scrollToPixel() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("window.scrollTo(0, 150)");
     }
     
     //To tackle click intercepted issue
     public static void scrollToClickElement(WebElement elementName) {
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
 		jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", elementName);
     }
     
     
     // Click any element
     public static void onClick(WebElement element)
 	 {
 		element.click();
 	 }
 	
     //select value from drop-down by index
 	 public static void selectByIndex(WebElement element , int index)
 	 {
 		 new Select(element).selectByIndex(index);	
 	 }
 	
 	//select value from drop-down by value
 	 public static void selectByValue(WebElement element , String value)
 	 {
 		new Select(element).selectByValue(value);
 	}
 	
 	//select value from drop-down by visible text
 	 public static void selectByText(WebElement element,String Text) 
 	{
 		new Select(element).selectByVisibleText(Text);
 	}
 	
 	//Mouse Hover
 	 public static void mouseHover(WebElement element)
	 {
		new Actions(driver).moveToElement(element).perform();
		
	 }
	
 	//mouseClick
	public static void mouseClick(WebElement element)
    {
		
		new Actions(driver).click(element).perform();
	}
	
	//below element locators are common and not content dependent
	public static void deleteContent() throws Exception
	{
		driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Delete')]")).click();
		Wait.Pause(5000);
		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
		
	}
	
}
	




