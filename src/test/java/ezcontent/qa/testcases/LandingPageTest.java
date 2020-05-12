package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;

import ezcontent.qa.pages.LandingPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;


public class LandingPageTest extends TestBase {
	
	LoginPage loginpage;
	LandingPage landingpage;
	

	
	@BeforeClass
	public void setup() {
		TestBase.browserLaunch(); // to launch browser and get url

		loginpage = new LoginPage();
		
		landingpage = new LandingPage();
		 
		loginpage.validateLogin();
		
		
	}
	
	@Test(priority=0)
	public void redirectiontest() throws InterruptedException {
		
		Wait.pageLoad(10);
		landingpage.redirectiontolandingpage();
			
	}
	
	@Test(priority=1)
	public void landingPageTitleTest() {
		
		   String title = landingpage.getLoginPageTitle();
			Assert.assertEquals(title, prop.getProperty("Landingpagetitle"));
			
		}
	
	@Test(priority=2)
	public void validateTitleFieldTest() {
		landingpage.enterInTitleField(prop.getProperty("Landingpagetitlefield"));
		
	}
	
	@Test(priority=3)
	public void validateTitleFieldLabelTest() {
		String label = landingpage.getTitleFieldlabel();
		Assert.assertEquals(label, prop.getProperty("LandingPagetitlefieldlabel"));
		
	}
	
//	
	
//	@Test(priority=4)
//	public void validateBodyFieldLabelTest() {
//		String label = landingpage.getBodyFieldLabel();
//		Assert.assertEquals(label, prop.getProperty("LandingPagetitlefieldlabel"));
//		
//	}
	
	@Test(priority=5)
	public void validateLogFieldTest() {
		landingpage.enterRevisionLogMessage("Test log message summary");
		
	}
	
	@Test(priority=6)
	public void EnterBody() throws InterruptedException  {
		landingpage.enterInBodyField("Test body summary");
		
	
		
	}
	
	@Test(priority = 7)
	public void validateCreationStatusMessage() {
		String statusMessage = landingpage.clickOnSave();
		Assert.assertEquals(statusMessage, "×\n" + 
				"Status message\n" + 
				"Landing page Test Landing title 121 has been created.");
		
	}
	
	@Test(priority = 8)
	public void closeStatusMsg() {
		landingpage.closeStatusMsg();
		
	}
	
	@Test(priority = 9)
	public void validatelayoutStatusMsg() {
		String statusMessage= landingpage.clickOnLayout();
		Assert.assertEquals(statusMessage, "×\n" + 
				"Status message\n" + 
				"You are editing the layout for this Landing page content item.");
		landingpage.closeStatusMsg();
		
	}
	
	@Test(priority = 10)
	public void validateSectionCountInLayout() throws InterruptedException {
		
		 landingpage.getNumberOfSection("One Column","Test Section 1");
		//Assert.assertEquals(number, 4);	
	}

	@Test(priority = 11)
	public void chooseAndAddBlock() {
		landingpage.addFirstBlockInLayout();
		landingpage.goToCustomBlock("Cards");
	}
	
	@Test(priority = 12)
	public void blockConfiguration() throws InterruptedException {
		landingpage.configureBlock();
	}
	
	@Test(priority = 13)
	public void secondBlockConfiguration() throws InterruptedException {
		landingpage.secondSection();
	}
	
	@Test(priority = 14)
	public void thirdBlockConfiguration() throws InterruptedException {
		landingpage.thirdSection();
	}
	
	@Test(priority = 15)
	public void fourthBlockConfiguration() throws InterruptedException {
		landingpage.fourthSection();
	}
	
	@Test(priority = 15)
	public void fifthBlockConfiguration() throws InterruptedException {
		landingpage.fifthSection();
	}
	
	@Test(priority = 15)
	public void sixthBlockConfiguration() throws InterruptedException {
		landingpage.sixthSection();
	}
	

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
	    if (testResult.getStatus() == ITestResult.FAILURE) { 
	        TestUtil.captureScreenshot();
	    } 
	}
	
//	@AfterClass
//	public void closeBrowser() {
//		TestBase.browserQuit();
//	}
	
}
