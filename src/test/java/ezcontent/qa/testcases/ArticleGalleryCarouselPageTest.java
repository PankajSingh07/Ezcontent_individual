package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleGalleryCarouselPage;
import ezcontent.qa.pages.ArticleQuotePage;
import ezcontent.qa.pages.DashboardPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.Wait;

public class ArticleGalleryCarouselPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ArticleGalleryCarouselPage articleGalleryCarouselPage;
	ArticleQuotePage articleQuotePage;

	public ArticleGalleryCarouselPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		TestBase.browserLaunch();
		loginPage = new LoginPage();
		Wait.implicitWait(3000);
		loginPage.validateLogin();
		articleGalleryCarouselPage = new ArticleGalleryCarouselPage();
		articleQuotePage = new ArticleQuotePage();
	}

	@Test(priority = 0)
	public void clickOnArticleLink() {
		dashboardPage = new DashboardPage();
		dashboardPage.clickArticleLink();
	}

	@Test(priority = 1)
	public void validateBasicSection() {
		boolean flag0 = articleQuotePage.validateTitleField();
		Assert.assertTrue(flag0);
		System.out.println("Validated Title Field");
		boolean flag1 = articleQuotePage.validateShortTitleField();
		Assert.assertTrue(flag1);
		System.out.println("Validated Short Title Field");
		boolean flag2 = articleQuotePage.validateSubheadField();
		Assert.assertTrue(flag2);
		System.out.println("Validated Subhead Field");
		boolean flag3 = articleQuotePage.validateAuthorField();
		Assert.assertTrue(flag3);
		System.out.println("Validated Author Field");
	}

	@Test(priority = 2)
	public void validateTeaserSection() {
		boolean flag0 = articleQuotePage.validateSummaryField();
		Assert.assertTrue(flag0);
		System.out.println("Validated Summary Field");
		boolean flag1 = articleQuotePage.validateThumbnailTitle();
		Assert.assertTrue(flag1);
		System.out.println("Validated Thumbnail Title");
		boolean flag2 = articleQuotePage.validateSelectThumbnailImage();
		Assert.assertTrue(flag2);
		System.out.println("Validated Select ThumbnailImage Field");
	}

	@Test(priority = 3)
	public void validateContentSection() {
		boolean flag0 = articleQuotePage.validateContentSectionTitle();
		Assert.assertTrue(flag0);
		System.out.println("Validated ContentSection Title");
		boolean flag1 = articleQuotePage.validateAddParagraphLink();
		Assert.assertTrue(flag1);
		System.out.println("Validated AddParagraph Link");
		boolean flag2 = articleGalleryCarouselPage.validateGalleryCarouselFromList();
		Assert.assertTrue(flag2);
		System.out.println("Validated GalleryCarousel From Paragraph List");
		boolean flag3 = articleGalleryCarouselPage.validateGalleryCarouselNameField();
		Assert.assertTrue(flag3);
		System.out.println("Validated GalleryCarousel Name field");
		boolean flag4 = articleGalleryCarouselPage.validateSlideshowSelectImage();
		Assert.assertTrue(flag4);
		System.out.println("Validated GalleryCarousel Slideshow select image field");
	}

	@Test(priority = 4)
	public void validateContentCollapseAndEdit() {
		articleGalleryCarouselPage.collapseThenEditGC();
		System.out.println("Validated Collapse and edit actions");
	}

	@Test(priority = 5)
	public void validateContentRowWeights() {
		articleQuotePage.showAndHideRowWeights();
		System.out.println("Validated Show and hide Row weights");
	}

	@Test(priority = 6)
	public void validateContentToggleButtonActions()  {
		articleGalleryCarouselPage.toggleButtonActions();
		System.out.println("Validated toggle button's remove and duplicate function");
	}

	@Test(priority = 7)
	public void validateTaxonomySection() {
		boolean flag0 = articleQuotePage.validateTaxonomyTitle();
		Assert.assertTrue(flag0);
		System.out.println("Validated Taxonomy Title");
		boolean flag1 = articleQuotePage.validateTaxonomyTags();
		Assert.assertTrue(flag1);
		System.out.println("Validated TaxonomyTags input field");
	}

	@Test(priority = 8)
	public void validateSEOSection() {
		boolean flag0 = articleQuotePage.validateRealTimeSEOforDrupalTitle();
		Assert.assertTrue(flag0);
		System.out.println("Validated RealTime SEO for Drupal Title");
		boolean flag1 = articleQuotePage.validateFocusKeywordField();
		Assert.assertTrue(flag1);
		System.out.println("Validated Seo Focus Keyword Field");
		boolean flag2 = articleQuotePage.validateSaveButton();
		Assert.assertTrue(flag2);
		System.out.println("Validated Save Button");
	}

	@Test(priority = 9)
	public void validateRHSfields() {
		boolean logo = articleQuotePage.validatesrijanLogo();
		Assert.assertTrue(logo);
		System.out.println("Validated srijan logo at top RHS");	
		boolean flag0 = articleQuotePage.validateRevisionlogMessageLabel();
		Assert.assertTrue(flag0);
		System.out.println("Validated RevisionlogMessage Label");
		boolean flag1 = articleQuotePage.validateRevisionlogMessageField();
		Assert.assertTrue(flag1);
		System.out.println("Validated RevisionlogMessage Field");
		boolean flag2 = articleQuotePage.validateMenuSettings();
		Assert.assertTrue(flag2);
		System.out.println("Validated Menu Settings");
		boolean flag3 = articleQuotePage.validateMetaTags();
		Assert.assertTrue(flag3);
		System.out.println("Validated Meta Tags");
		boolean flag4 = articleQuotePage.validateSimpleXmlSitemap();
		Assert.assertTrue(flag4);
		System.out.println("Validated Simple Xml Sitemap");
		boolean flag5 = articleQuotePage.validateSchedulingOptions();
		Assert.assertTrue(flag5);
		System.out.println("Validated Scheduling Options");
		boolean flag6 = articleQuotePage.validateUrlAlias();
		Assert.assertTrue(flag6);
		System.out.println("Validated Url Alias");
		boolean flag7 = articleQuotePage.validateAuthoringInformation();
		Assert.assertTrue(flag7);
		System.out.println("Validated Authoring Information");
		boolean flag8 = articleQuotePage.validatePromotionOptions();
		Assert.assertTrue(flag8);
		System.out.println("Validated Promotion Options");
		boolean flag9 = articleQuotePage.validateSaveAsField();
		Assert.assertTrue(flag9);
		System.out.println("Validated SaveAs Field");
	}

	@Test(priority = 10)
	public void createArticleGalleryCarousel() throws InterruptedException {
		articleGalleryCarouselPage.createArticleGalleryCarousel();
	}

	@Test(priority = 11)
	public void validateNewArticleTitle() {
		String newArticleTitle = articleQuotePage.NewArticleTitle();
		Assert.assertEquals(newArticleTitle, prop.getProperty("articleTitleGalleryCarousel"));
		System.out.println("New article title is :" + newArticleTitle);
	}

	@AfterClass
	public void closeBrowser() {
		TestBase.browserQuit();
	}
}
