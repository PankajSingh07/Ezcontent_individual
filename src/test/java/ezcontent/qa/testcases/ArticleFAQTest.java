package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleFAQPage;
import ezcontent.qa.pages.LoginPage;

public class ArticleFAQTest extends TestBase{
	
	public ArticleFAQTest() {
		super();
	}
	
	ArticleFAQPage article;
	LoginPage loginpage;
	
	@BeforeClass
	public void setup() throws IOException {
		browserLaunch();
		article = new ArticleFAQPage();
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
		article.enterBasicsDetails(prop.getProperty("FAQTitle"), prop.getProperty("FAQShortTitle"), prop.getProperty("FAQSubHead"), prop.getProperty("FAQAuthor"));
		System.out.println("Basic Details Entered");
	}
	
	
	@Test(priority = 6)
	public void enterTeaserDetailTest() {
		article.enterTeaserDetails(prop.getProperty("FAQSummary"));	
		System.out.println("Teaser deatil entered");
	}
	
	@Test(priority = 7)
	public void uploadThumbnailImageTest() throws Exception {
		article.uploadThumbnailImage();		
	}
	
	
	@Test(priority = 8)
	public void enterContentDetailsTest() throws Exception {
		
		article.enterContentDetails(prop.getProperty("FAQQues"), prop.getProperty("FAQAnswer"));
	}
	
	@Test(priority = 9)
	public void contentFunctionalitiesTest() throws Exception {
		article.contentFunctionalities();
	}
	
	@Test(priority = 10)
	public void enterTaxonomyTest() throws Exception {
		article.enterTaxonomy(prop.getProperty("FAQTagName"));
	}
	
//	@Test(priority = 11)
//	public void saveContentTest() {
//		article.saveContent();
//		
//	}
//
//	@AfterClass
//	public void closeBrowser() {
//		browserQuit();
//	}	
	
	
}
