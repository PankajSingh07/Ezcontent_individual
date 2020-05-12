package ezcontent.qa.testcases;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleMediaPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleMediaTest extends TestBase {
	TestUtil util = new TestUtil();
	LoginPage loginpage;
	ArticleMediaPage article;

	ArticleMediaTest() {
		super(); // to call the super class(BaseClass) constructor to get prop value
	}

	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
		driver.manage().deleteAllCookies();
		loginpage = new LoginPage();
		article = new ArticleMediaPage();
	}

	@Test(priority = 1)
	public void login() {
		loginpage.validateLogin();
		Wait.pageLoad(4);
	}

	@Test(priority = 2)
	public void dashboard() throws InterruptedException {
		article.dashBoardPage();
	}

	@Test(priority = 15)
	public void createArticleTest() throws InterruptedException {
		article.createArticle();

	}

	@Test(priority = 3)
	public void validatePageTitle() {
		String title = article.validateArticlePageTitle();
		Assert.assertEquals(title, prop.getProperty("articlePageTitle"));
	}

	@Test(priority = 4)
	public void validageLogo() {
		boolean flag = article.validateLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void title() {
		boolean flag1 = article.validateTitle();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority = 6)
	public void menu() {
		boolean flag11 = article.menuSetting();
		Assert.assertTrue(flag11);
	}
	@Test(priority = 6)
	public void metaTags() {
		boolean flag12 = article.metaTags();
		Assert.assertTrue(flag12);
	}
	@Test(priority = 6)
	public void xml() {
		boolean flag13 = article.xmlSiteMap();
		Assert.assertTrue(flag13);
	}
	@Test(priority = 6)
	public void scheduling() {
		boolean flag14 = article.scheduling();
		Assert.assertTrue(flag14);
	}
	
	@Test(priority = 6)
	public void promotion() {
		boolean flag15 = article.promotion();
		Assert.assertTrue(flag15);
	}
	

	@Test(priority = 6)
	public void shortTitle() {
		boolean flag2 = article.validateShortTitle();
		Assert.assertTrue(flag2);
	}

	@Test(priority = 7)
	public void subHead() {
		boolean flag3 = article.validateSubHead();
		Assert.assertTrue(flag3);
	}

	@Test(priority = 8)
	public void author() {
		boolean flag4 = article.author();
		Assert.assertTrue(flag4);
	}

	@Test(priority = 9)
	public void summary() {
		boolean flag5 = article.summary();
		Assert.assertTrue(flag5);
	}

	@Test(priority = 10)
	public void selectImage() {
		boolean flag6 = article.selectImageField();
		Assert.assertTrue(flag6);
	}


	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}
	@Test(priority = 11)
	public void media() {
		boolean flag7 = article.media();
		Assert.assertTrue(flag7);
	}

	@Test(priority = 12)
	public void selectAsset() {
		boolean flag8 = article.selectAsset();
		Assert.assertTrue(flag8);
	}

	@Test(priority = 13)
	public void addParagraph() {
		boolean flag9 = article.addParagraph();
		Assert.assertTrue(flag9);
	}

	@Test(priority = 14)
	public void taxnomy() {
		boolean flag10 = article.taxnomy();
		Assert.assertTrue(flag10);
	}
//
//	 @AfterClass
//	 public void closeBrowser() {
//	 TestBase.browserQuit();
//	 }


}
