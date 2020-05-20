package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleFAQPage;
import ezcontent.qa.pages.ArticleReferencedCardPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleReferencedCardTest extends TestBase
{
	public ArticleReferencedCardTest() {
		super();
	}
	
	ArticleReferencedCardPage article;
	LoginPage loginpage;
	
	@BeforeClass
	public void setup() throws IOException {
		browserLaunch();
		article = new ArticleReferencedCardPage();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginFunctionality() {

		loginpage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));
		System.out.println("Login to website successfully");
	}
	
	
	@Test(priority = 2)
	public void reachToArticlePageTest() throws InterruptedException {
		article.reachToArticlePage();
	}
	
	@Test(priority = 3)
	public void validateTabTitleTest() {

		String title = article.validateWindowTabTitle();
		Assert.assertEquals(title, "Create Article | EZContent");
		System.out.println("Article page tab title is :" + title);
	}

	@Test(priority = 4)
	public void validateHeaderTitleTest() {

		String title = article.validateHeaderTitle();
		Assert.assertEquals(title, "Create Article");
		System.out.println("Article web page title is :" +title);
	}
	
	@Test(priority = 5)
	public void enterBasicDetailsTest() throws Exception {
		article.enterBasicsDetails(prop.getProperty("RCTitle"), prop.getProperty("RCShortTitle"), prop.getProperty("RCSubHead"), prop.getProperty("RCAuthor"));
		System.out.println("Basic Details Entered");
	}
	
	
	@Test(priority = 6)
	public void enterTeaserDetailTest() {
		article.enterTeaserDetails(prop.getProperty("RCSummary"));	
		System.out.println("Teaser deatil entered");
	}
	
	@Test(priority = 7)
	public void uploadThumbnailImageTest() throws Exception {
		article.uploadThumbnailImage();		
	}
	

	@Test(priority = 8)
	public void enterContentDetailsTest() throws Exception {
		
		article.enterContentDetails(prop.getProperty("RCSearch1"), prop.getProperty("RCSearch2"));
	}
	
	@Test(dependsOnMethods = {"enterContentDetailsTest"})
	public void contentFunctionalitiesTest() throws Exception {
		article.contentFunctionalities();
	}
	
	@Test(dependsOnMethods = {"contentFunctionalitiesTest"})
	public void enterTaxonomyTest() throws Exception {
		article.enterTaxonomy(prop.getProperty("RCTagName"));
	}
	
	@Test(priority = 11)
	public void saveContentTest() throws Exception {
		article.saveContent();
	Wait.Pause(5000);
	TestUtil.deleteContent();
	}

	@AfterClass
	public void closeBrowser() {
		browserQuit();
	}	
	
	
}
