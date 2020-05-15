package ezcontent.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleEmbedPage;
import ezcontent.qa.pages.ArticleGalleryPage;
import ezcontent.qa.pages.LoginPage;


public class ArticleGalleryTest extends TestBase {
     
    LoginPage page;
	ArticleGalleryPage Gallery;
	ArticleEmbedPage em;
	
	public ArticleGalleryTest() throws IOException {
		super();
		
	}
	public Logger log = Logger.getLogger(ArticleGalleryPage.class);
	@BeforeClass
	public void setupSuite() throws IOException
	{
		browserLaunch();
		Gallery = new ArticleGalleryPage();
		page = new LoginPage();
		page.validateLogin();
		
	}
	
	@Test(priority = 0)
	public void validateMenuItems() {
		boolean flag = Gallery.validateMenu();
		Assert.assertTrue(flag);
		boolean flag1 = Gallery.validateAddContent();
		Assert.assertTrue(flag1);
		boolean flag2 = Gallery.validateContentType();
		Assert.assertTrue(flag2);
	}
	
	@Test(priority = 1)
    public void validateRedirectionToArticlePage() {
		log.info("***************Navigating to Article Page************");
		String pageHeading = Gallery.verifyRedirectionToArticlePage();
		Assert.assertEquals(pageHeading, prop.getProperty("articleHeading"));
	}
	
	@Test(priority = 2)
	public void validateTitleField() {
		Gallery.verifyTitleField();
	}
	
	@Test(priority = 3)
	public void validateShortTitle() {
		boolean shortTitle = Gallery.verifyShortTitle();
		Assert.assertTrue(shortTitle);
	}
	
	@Test(priority = 4)
	public void validatesubhead() {
		String subHead = Gallery.verifysubhead();
		Assert.assertEquals(subHead, prop.getProperty("labelsubHeadExpected"));
	}
	
	@Test(priority = 5)
	public void validateAuthorField() {
		Gallery.verifyAuthorField();
	}
	
	@Test(priority = 6)
	public void validateSummaryField( ) {
		String labelsubHeadActual =  Gallery.verifySummaryField();
		Assert.assertEquals(labelsubHeadActual, prop.getProperty("labelSummaryExpected"));
			
	}
	
	@Test(priority = 7)
	public void validateselectImageFromThumbnail() {
		 String labelThumbnailActual = Gallery.selectImageFromThumbnail();
	     Assert.assertEquals(labelThumbnailActual, prop.getProperty("labelThumbnailExpected"));
	     
	}
	
	@Test(priority = 8)
	public void selectParagraph() {		
		Gallery.verifyaddparagraph();
		Gallery.selectParagraph();
		log.info("***************Gallery Type is selected************");
	}
	
	@Test(priority = 9)
	public void validateTaxonomyField() {
		Gallery.verifyTaxonomyField();
	}
	
	@Test(priority = 10)
	public void validateFocusField() {
		String labelRealActual = Gallery.verifyFocusField();
		Assert.assertEquals(labelRealActual, prop.getProperty("labelRealExpected"));
	}
	
	@Test(priority = 12)
	public void validatesaveasPublished() {
		Boolean statusMessage = Gallery.saveasPublished();
		log.info("***************Article is saved************");
		Assert.assertTrue(statusMessage);
	}
	
	@Test(priority = 11) 
    public void validateAdvancedMenuItem() {
		Assert.assertTrue(Gallery.advancedMenuItem());
	}
	@AfterClass
	public void closeBrowser()
	{
		browserQuit();
	}
	
	
	
	}

	     
