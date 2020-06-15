package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	TestUtil util = new TestUtil();


	public LoginPageTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
		
	}

	@BeforeClass
	public void setup() {

		browserLaunch();     // launch browser with url
		loginpage = new LoginPage();  // create instance of LoginPage class			
	}

	@Test(priority = 1)
	public void loginPageTitle() {
		
	   String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginPageTitle"));
		System.out.println("Login Page title is :" + title);
	}

	@Test(priority = 2)
	public void logoImage() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		System.out.println("Login page logo is displayed");
}
	@Test(priority = 3)
	public void validateUsernameLabel() {
		String uLabel = loginpage.validateUsernameLabel();
		System.out.println("Username Text Field Label is :" +uLabel);
	}
	@Test(priority = 4)
	public void validatePasswordLabel() {
		String pLabel = loginpage.validatePasswordLabel();
		System.out.println("Password Text Field Label is :" +pLabel);	
	}
	@Test(priority = 5)
	public void validateuserNameHelpText() {
		String helpText = loginpage.validateuserNameHelpText();
		System.out.println("Username Help Text is :" +helpText);
	}
	@Test (priority = 6)
	public void validatepasswordHelpText() {
		String helpText1 = loginpage.validatepasswordHelpText();
		System.out.println("Password Help Text is :" +helpText1);
	}
	

	@Test(priority = 7)
	public void loginFunctionality() {

		loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));
		System.out.println("Login to website successfully");
	}

	@Test(priority = 10)
	public void clickOnForgetLink()  {

		loginpage.forgetPassword();
		System.out.println("click on forget password link");	
		
		}
	@Test(priority = 8)
	public void dashboardPageTitle() throws InterruptedException {
		
	   String title1 = loginpage.validateDashboardPageTitle();
	   Assert.assertEquals(title1,prop.getProperty("dashBoardTitle"));
	   System.out.println("Dashboard Page title is :" + title1);
	   Wait.Pause(3000);
	   
	}
	@Test(priority=9)
	public void logout() {
		loginpage.logOut();
		util.navigateToURL(prop.getProperty("devurl"));
		
	}
	

	@AfterClass
	public void closeBrowser() {
		browserQuit();
	}

}
