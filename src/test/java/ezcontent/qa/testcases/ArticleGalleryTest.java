package ezcontent.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleGalleryPage;


public class ArticleGalleryTest extends TestBase {
     

	public Logger log = Logger.getLogger(ArticleGalleryPage.class);
	
	@Test(priority = 0)
	public void validateMenuItems() {
		logger = extent.createTest("validateMenuItems");
		loginpage.validateLogin();
		boolean flag = Gallery.validateMenu();
		Assert.assertTrue(flag);
		boolean flag1 = Gallery.validateAddContent();
		Assert.assertTrue(flag1);
		boolean flag2 = Gallery.validateContentType();
		Assert.assertTrue(flag2);
	}
	
	@Test(priority = 1)
    public void validateRedirectionToArticlePage() {
		logger = extent.createTest("validateRedirectionToArticlePage");
		log.info("***************Navigating to Article Page************");
		String pageHeading = Gallery.verifyRedirectionToArticlePage();
		Assert.assertEquals(pageHeading, prop.getProperty("articleHeading"));
	}
	
	@Test(priority = 2)
	public void validateTitleField() {
		logger = extent.createTest("validateTitleField");
		Gallery.verifyTitleField();
	}
	
	@Test(priority = 3)
	public void validateShortTitle() {
		logger = extent.createTest("validateShortTitle");
		boolean shortTitle = Gallery.verifyShortTitle();
		Assert.assertTrue(shortTitle);
	}
	
	@Test(priority = 4)
	public void validatesubhead() {
		logger = extent.createTest("validatesubhead");
		String subHead = Gallery.verifysubhead();
		Assert.assertEquals(subHead, prop.getProperty("labelsubHeadExpected"));
	}
	
	@Test(priority = 5)
	public void validateAuthorField() {
		logger = extent.createTest("validateAuthorField");
		Gallery.verifyAuthorField();
	}
	
	@Test(priority = 6)
	public void validateSummaryField( ) {
		logger = extent.createTest("validateSummaryField");
		String labelsubHeadActual =  Gallery.verifySummaryField();
		Assert.assertEquals(labelsubHeadActual, prop.getProperty("labelSummaryExpected"));
			
	}
	
	@Test(priority = 7)
	public void validateselectImageFromThumbnail() {
		logger = extent.createTest("validateselectImageFromThumbnail");
		 String labelThumbnailActual = Gallery.selectImageFromThumbnail();
	     Assert.assertEquals(labelThumbnailActual, prop.getProperty("labelThumbnailExpected"));
	     
	}
	
	@Test(priority = 8)
	public void selectParagraph() {		
		logger = extent.createTest("selectParagraph");
		Gallery.verifyaddparagraph();
		Gallery.selectParagraph();
		log.info("***************Gallery Type is selected************");
	}
	
	@Test(priority = 9)
	public void validateTaxonomyField() {
		logger = extent.createTest("validateTaxonomyField");
		Gallery.verifyTaxonomyField();
	}
	
	@Test(priority = 10)
	public void validateFocusField() {
		logger = extent.createTest("validateFocusField");
		String labelRealActual = Gallery.verifyFocusField();
		Assert.assertEquals(labelRealActual, prop.getProperty("labelRealExpected"));
	}
	
	@Test(priority = 12)
	public void validatesaveasPublished() {
		logger = extent.createTest("validatesaveasPublished");
		Boolean statusMessage = Gallery.saveasPublished();
		log.info("***************Article is saved************");
		Assert.assertTrue(statusMessage);
	}
	
	@Test(priority = 11) 
    public void validateAdvancedMenuItem() {
		logger = extent.createTest("validateAdvancedMenuItem");
		Assert.assertTrue(Gallery.advancedMenuItem());
	}
	
	
	}

	     
