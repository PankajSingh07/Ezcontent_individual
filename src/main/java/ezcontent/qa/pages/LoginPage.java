package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.Wait;

public class LoginPage extends TestBase {

	// Page Factory = Object Repository:

	@FindBy(id = "edit-name")
	WebElement username;

	@FindBy(id = "edit-pass")
	WebElement password;

	@FindBy(id = "edit-submit")
	WebElement loginButton;

	@FindBy(id = "edit-forgot-password-link")
	WebElement forgetPassword;

	@FindBy(xpath = "//div[@class='layout-container']//a//img")
	WebElement logo;
	
	@FindBy(xpath = "//input[@id='edit-name']/preceding-sibling::label")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//input[@id='edit-pass']/preceding-sibling::label")
	WebElement passwordLabel;
	
	@FindBy(id = "edit-name--description")
	WebElement usernameHelpText;
	
	@FindBy(id = "edit-pass--description")
	WebElement passwordHelpText;
	
	@FindBy(id = "toolbar-item-user")
	WebElement toolBarIcon;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
	
	@FindBy(xpath="//a[@id='toolbar-item-user']")
	WebElement userNameDashboard;

	// to initialize the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public void validateLogin() {
		username.sendKeys(prop.getProperty("adminUsername"));
		password.sendKeys(prop.getProperty("adminPassword"));
		loginButton.click();
		Wait.pageLoad(25);
	}


	public void forgetPassword() {
		forgetPassword.click();

	}
	public String validateUsernameLabel() {
		return usernameLabel.getText();
	}
	public String validatePasswordLabel() {
		return passwordLabel.getText();
	}
	public String validateuserNameHelpText() {
		return usernameHelpText.getText();
	}
	public String validatepasswordHelpText() {
		return passwordHelpText.getText();
	}
	
	public String validateDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public String getDashboardUserName(){
        return userNameDashboard.getText();
    }
	
	public void logOut() {
		toolBarIcon.click();
		if (logout.isDisplayed())
		{
			logout.click();
		}	
		else {
			System.out.println("Failed");
			
			
		}
		
		
}}
