package ezcontent.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleEmbedPage;
import ezcontent.qa.pages.LoginPage;


public class ArticleEmbedPageTest extends TestBase {
		ArticleEmbedPage embed;
		LoginPage page;
		
		public Logger log = Logger.getLogger(ArticleEmbedPage.class);
		
		public ArticleEmbedPageTest() throws IOException {
			super();
			
		}
		
		@BeforeClass
		public void setupSuite() throws IOException
		{
			browserLaunch();
			embed = new ArticleEmbedPage();
			page = new LoginPage();
			page.validateLogin(); 
		}
		
		@Test(priority = 0)
		public void validateMenu() throws IOException
		{
			
			Boolean menuResult = embed.validateMenu();
			Assert.assertTrue(menuResult, "Content is not displayed");
		 	
		}
		
		@Test(priority = 1)
		public void validateAddContent()
		{
			Boolean contentResult = embed.validateAddContent();
			Assert.assertTrue(contentResult, "Add Content button is not displayed");
			
		}
		
		@Test(priority = 2)
		public void validateContentType()
		{
			Boolean contentType = embed.validateContentType();
			Assert.assertTrue(contentType, "Article content type is not displayed");
		}
		
		@Test(priority = 3)
		public void validateRedirectionToArticlePage()
		{
			String pageHeading = embed.verifyRedirectionToArticlePage();
			Assert.assertEquals(pageHeading, prop.getProperty("articleHeading"));
			
		}
		
		@Test(priority = 4)
		public void validateSubSections()
		{
			List<String> list = embed.verifySubSections();
			System.out.println(list);	
		}
		
		@Test(priority= 6)
		public void validateTitleField()
		{
			embed.verifyTitleField();
		}
		
		@Test(priority = 7)
		public void validateShortTitle()
		{
			Boolean shortTitle = embed.verifyShortTitle();
			Assert.assertTrue(shortTitle);
		}
		
		@Test(priority = 8)
		public void validateSubHead()
		{
			String labelsubHeadActual = embed.verifysubhead();
			Assert.assertEquals(labelsubHeadActual, prop.getProperty("labelsubHeadExpected"));
		}
		
		@Test(priority = 9)
		public void verifyAuthorField()
		{
			embed.verifyAuthorField();
		}
		
		@Test(priority = 10)
		public void validateSummaryField()
		{
			String labelSummaryActual = embed.verifySummaryField();
			Assert.assertEquals(labelSummaryActual, prop.getProperty("labelSummaryExpected"));
		}
		
		@Test(priority = 11)
		public void validateSelectImage()
		{
			String labelThumbnailActual = embed.selectImageFromThumbnail();
			Assert.assertEquals(labelThumbnailActual, prop.getProperty("labelThumbnailExpected"));
		}	
		
		@Test(priority = 12)
		public void selectParagraphFromContent()
		{
			embed.verifyAddParagraph();
		    embed.selectParagraph();
		    log.info("***************Gallery Type is selected************");
		}
		
		@Test(priority = 13)
		public void validateTaxonomy()
		{
			embed.verifyTaxonomyField();
		}
		
		@Test(priority = 14)
		public void validateFocusField()
		{
			String labelRealActual = embed.verifyFocusField();
			Assert.assertEquals(labelRealActual, prop.getProperty("labelRealExpected"));
		}
		
		@Test(priority =16 , dependsOnMethods = {"validateTitleField" ,"selectParagraphFromContent" })
		public void validatesaveasPublished()
		{
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
			Assert.assertTrue(embed.advancedMenuItem());
		}
		
		@AfterClass
		public void closeBrowser()
		{
			browserQuit();
		}
	}


