package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.DashboardPage;
import ezcontent.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	DashboardPage dashboardPage;
	LoginPage loginPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
		loginPage = new LoginPage();			
		loginPage.validateLogin();
		dashboardPage = new DashboardPage();
	}

	@Test(priority = 0)
	public void DashboardPageTitleTest() {

		String titleDash = dashboardPage.validateDashboardTitle();
		Assert.assertEquals(titleDash, "Moderation Dashboard | EZContent");
		System.out.println("Dashboard Page title is :" + titleDash);
	}

	@Test(priority = 1)
	public void DashboardPageLogoTest() {
		boolean flag = dashboardPage.validateDashboardLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void clickOnArticleLinkTest() {
		dashboardPage.clickArticleLink();
	}

	@Test(priority = 3)
	public void logoutTest() {
		dashboardPage.logout();
	}

}
