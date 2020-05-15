package ezcontent.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import ezcontent.qa.pages.ArticleEmbedPage;



public class ArticleEmbedPageTest extends ArticleEmbedPage {
		
		
		public Logger log = Logger.getLogger(ArticleEmbedPage.class);
		
		@Test(priority = 0)
		public void verifyMenu() throws IOException
		{
			logger = extent.createTest("validateMenu");
			loginpage.validateLogin();
			Boolean menuResult = embed.validateMenu();
			Assert.assertTrue(menuResult, "Content is not displayed");
		 	
		}
		
		@Test(priority = 1)
		public void verifyAddContent()
		{
			logger = extent.createTest("validateAddContent");
			Boolean contentResult = embed.validateAddContent();
			Assert.assertTrue(contentResult, "Add Content button is not displayed");
			
		}
		
		@Test(priority = 2)
		public void verifyContentType()
		{
			logger = extent.createTest("validateContentType");
			Boolean contentType = embed.validateContentType();
			Assert.assertTrue(contentType, "Article content type is not displayed");
		}
		
		@Test(priority = 3)
		public void validateRedirectionToArticlePage()
		{
			logger = extent.createTest("validateRedirectionToArticlePage");
			log.info("***************Navigating to the Artcile Page************");
			String pageHeading = embed.verifyRedirectionToArticlePage();
			Assert.assertEquals(pageHeading, prop.getProperty("articleHeading"));
			
		}
		
		@Test(priority = 4)
		public void validateSubSections()
		{
			logger = extent.createTest("validateSubSections");
			List<String> list = embed.verifySubSections();
			System.out.println(list);	
		}
		
		@Test(priority= 6)
		public void validateTitleField()
		{
			logger = extent.createTest("validateTitleField");
			embed.verifyTitleField();
		}
		
		@Test(priority = 7)
		public void validateShortTitle()
		{
			logger = extent.createTest("validateShortTitle");
			Boolean shortTitle = embed.verifyShortTitle();
			Assert.assertTrue(shortTitle);
		}
		
		@Test(priority = 8)
		public void validateSubHead()
		{
			logger = extent.createTest("validateSubHead");
			String labelsubHeadActual = embed.verifysubhead();
			Assert.assertEquals(labelsubHeadActual, prop.getProperty("labelsubHeadExpected"));
		}
		
		@Test(priority = 9)
		public void verifyAuthorField()
		{
			logger = extent.createTest("verifyAuthorField");
			embed.verifyAuthorField();
		}
		
		@Test(priority = 10)
		public void validateSummaryField()
		{
			logger = extent.createTest("validateSummaryField");
			String labelSummaryActual = embed.verifySummaryField();
			Assert.assertEquals(labelSummaryActual, prop.getProperty("labelSummaryExpected"));
		}
		
		@Test(priority = 11)
		public void validateSelectImage()
		{
			logger = extent.createTest("validateSelectImage");
			String labelThumbnailActual = embed.selectImageFromThumbnail();
			Assert.assertEquals(labelThumbnailActual, prop.getProperty("labelThumbnailExpected"));
		}	
		
		@Test(priority = 12)
		public void selectParagraphFromContent()
		{
			logger = extent.createTest("selectParagraphFromContent");
			embed.verifyAddParagraph();
		    embed.selectParagraph();
		    log.info("***************Gallery Type is selected************");
		}
		
		@Test(priority = 13)
		public void validateTaxonomy()
		{
			logger = extent.createTest("validateTaxonomy");
			embed.verifyTaxonomyField();
		}
		
		@Test(priority = 14)
		public void validateFocusField()
		{
			logger = extent.createTest("validateFocusField");
			String labelRealActual = embed.verifyFocusField();
			Assert.assertEquals(labelRealActual, prop.getProperty("labelRealExpected"));
		}
		
		@Test(priority =16 , dependsOnMethods = {"validateTitleField" ,"selectParagraphFromContent" })
		public void validatesaveasPublished()
		{
			logger = extent.createTest("validatesaveasPublished");
			Boolean statusMessage = embed.saveasPublished();
			log.info("***************Article is saved************");
			Assert.assertTrue(statusMessage);
		}
				
//		@Test(priority = 15) 
//		public void validateRightMenus() {
//			Boolean Flag = embed.verifyMenuSettings();
//			Assert.assertTrue(Flag , "Menu Settings is not displayed");
//			Boolean Flag1 = embed.verifymetaTags();
//			Assert.assertTrue(Flag1 , "Meta Tags is not displayed" );
//			Boolean Flag2 = embed.verifysitemap();
//			Assert.assertTrue(Flag2 , "Simple XML SiteMap is not displayed");
//			Boolean Flag3 =  embed.verifyschedulingOptions();
//			Assert.assertTrue(Flag3 , "Scheduling Options is not displayed");
//			Boolean Flag4 = embed.verifyalias();
//			Assert.assertTrue(Flag4 , "URL alias is not displayed");
//			Boolean Flag5 = embed.verifyauthoringInformation();
//			Assert.assertTrue(Flag5 , "Authoring Information is not displayed");
//		    Boolean Flag6 = embed.verifypromotionOption();
//			Assert.assertTrue(Flag6 , "Promotion Options is not displayed");
//					
//		}
		
		@Test(priority = 15)
		public void verifyAdvancedMenuItems() {
			logger = extent.createTest("verifyAdvancedMenuItems");
			Assert.assertTrue(embed.advancedMenuItem());
		}
		
	}


