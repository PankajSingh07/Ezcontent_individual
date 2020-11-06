package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;

import ezcontent.qa.pages.ContentAuthorPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ContentAuthorTest extends TestBase {
	
	public ContentAuthorTest() {
		super();
	}

	ContentAuthorPage author;
	LoginPage loginpage;
	

	@BeforeClass
	public void setup() throws IOException {
		browserLaunch();
		author = new ContentAuthorPage();
		loginpage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	public void loginFunctionality() {

		loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));
		System.out.println("Login to website successfully");
	}
	
	
	@Test(priority = 2)
	public void navigateToAuthorPage() {
		try {
			
			author.reachToAuthorPage();}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test(priority = 3)
	public void validateTabTitle() {

		String title = author.validateWindowTabTitle();
		Assert.assertEquals(title, "Create Author | EZContent");
		System.out.println("Author page tab title is :" + title);
	}

	@Test(priority = 4)
	public void validateHeaderTitle() {

		String title = author.validateHeaderTitle();
		Assert.assertEquals(title, "Create Author");
		System.out.println("Author web page title is :" + title);
	}

	@Test(priority = 5)
	public void enterName() {
		author.enterFullName(prop.getProperty("fullName"));
	}

	@Test(priority =6)
	public void enterAvatar() throws InterruptedException {
		author.uploadImage();
	}

	@Test(priority =7)
	public void entersummaryField() throws InterruptedException {
		TestUtil.scrollToPixel();
		author.summaryEntry(prop.getProperty("summary"));
	}

	@Test(priority = 8)
	public void enterbioField() throws InterruptedException {
		Wait.Pause(2000);
//		TestUtil.scrollToPixel();
		author.bioEntry(prop.getProperty("bio"));
	}

	@Test(priority = 9)
	public void UnPublishTheContent() throws InterruptedException {
		Wait.Pause(2000);
		author.unpublish();
		Wait.Pause(2000);
	}
	
	@Test(priority = 10)
	public void saveTheContent() throws Exception {
		author.saveContent();
		Wait.Pause(5000);
		TestUtil.deleteContent();

	}

	@AfterClass
	public void closeBrowser() {
		browserQuit();
	}

}
