package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;

public class LogoutPage extends TestBase{
	
	@FindBy(id = "toolbar-item-user")
	WebElement toolBarIcon;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logOutPage() {
		toolBarIcon.click();
		if (logout.isDisplayed())
		{
			logout.click();
		}	
		else {
			System.out.println("Failed");
			
			
		}

}}
