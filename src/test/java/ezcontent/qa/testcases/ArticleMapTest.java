package ezcontent.qa.testcases;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleMapPage;
import ezcontent.qa.pages.LoginPage;


public class ArticleMapTest extends TestBase{

	LoginPage loginpage;
	ArticleMapPage articlemapPage;
	
	public ArticleMapTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
   @BeforeClass
	public void setup() throws IOException {
		browserLaunch();
		loginpage = new LoginPage();
		articlemapPage = new ArticleMapPage();
	}
	@Test(priority=1)
	public void loginTest() {
	loginpage.validateLogin();
    }
	@Test(priority=2)
	public void verifyContent() {
	String contentTitle= articlemapPage.contentHeading();
	Assert.assertEquals(contentTitle,prop.getProperty("labelContentExpected"));
	}
	@Test(priority=3)
	public void Content(){
		String content=articlemapPage.mousehoverOnContent();
	Assert.assertEquals(content, prop.getProperty("addContentHeading"));
	}
	@Test(priority=4)
	
	public void addContent() {
		boolean addContent = articlemapPage.mousehoverOnAddContent();
		Assert.assertTrue(addContent);
	}
    @Test(priority=5)
	public void article() {
		String article = articlemapPage.mousehoverOnArticle();
		Assert.assertEquals(article, prop.getProperty("articleHeading"));
		}
   @Test(priority = 6)
	public void verifySections() {
		List<String> expectedlist = articlemapPage.verifySubSections();
		System.out.println(expectedlist);	
		List<String> actualList = Arrays.asList("Basic","Teaser" ,"Content");
		Assert.assertEquals(actualList, expectedlist);
		}
	@Test(priority =7)
	public void titleField(){
	    boolean title = articlemapPage.enterTitleFieldData();
		Assert.assertTrue(title);
	}	
	@Test(priority = 8)
	public void subTitleField() {
		boolean subTitle = articlemapPage.subTitleFieldLabel();
		Assert.assertTrue(subTitle);
	}
	@Test(priority = 9)
	public void subHeadField() {
		boolean subhead = articlemapPage.enterSubheadFieldData();
		Assert.assertTrue(subhead);
	}
	@Test(priority = 10)
	public void authorField() throws InterruptedException{
		boolean author = articlemapPage.enterAuthorFieldData();
		Assert.assertTrue(author);
	}
	@Test(priority=11)
	public void summaryField() {
		String SummaryLabel = articlemapPage.enterSummaryFieldData();
		Assert.assertEquals(SummaryLabel, prop.getProperty("labelSummaryExpected"));
	}
	@Test(priority = 12)
	public void thumbnailFieldLabel() {
		String thumbnail = articlemapPage.thumbnailLabel();
		Assert.assertEquals(thumbnail, prop.getProperty("labelThumbnailExpected"));
	}
	@Test(priority=13)
	public void selectImages() throws InterruptedException {
		articlemapPage.selectImages();
	}
    @Test(priority=14)
	public void addParagraphField() throws InterruptedException {
		articlemapPage.addParagraph();
    }	
    @Test(priority=15)
	public void infoTitleField() {
	String infoTitle = articlemapPage.enterinfoTitleFieldData();
	Assert.assertEquals(infoTitle, prop.getProperty("labelInfoTitle"));
	}
    @Test(priority=16)
	public void shortTitleField() {
	String shortTitle = articlemapPage.entershortTitleFieldData();
	Assert.assertEquals(shortTitle, prop.getProperty("labelShortTitle"));
	}
	@Test(priority=17)
	public void infoBodyField() {
	String infoBody = articlemapPage.enterInfoBodyFieldData();
	Assert.assertEquals(infoBody, prop.getProperty("labelInfoBody"));
	}
    @Test(priority=18)
	public void googleMapField() {
		String googleMap = articlemapPage.entergoogleMapFieldData();
		Assert.assertEquals(googleMap, prop.getProperty("labelGoogleMap"));
	}
    @Test(priority=19)
	public void urlField() {
	String url = articlemapPage.enterUrlFieldData();
	Assert.assertEquals(url, prop.getProperty("labelUrl"));
	}
	@Test(priority=20)
	public void linkTextField() {
	String linkText = articlemapPage.enterLinkTextFieldData();
	Assert.assertEquals(linkText, prop.getProperty("labelLinkText"));
	}
	 @Test(priority=21 , dependsOnMethods = {"addParagraphField" ,"googleMapField" })
    public void tagsField() {
   boolean tagsLabel = articlemapPage.enterTagsFieldData();
   Assert.assertTrue(tagsLabel);
   }
   @Test(priority=22)
   public void focusKeywordField() {
    String focusKeyword = articlemapPage.enterFocusKeyword();
	Assert.assertEquals(focusKeyword, prop.getProperty("labelFocusKeyword"));
   }   
//    @Test(priority=23)
//    public void verifyRightSideLabels() {
//    boolean lastSavedLabel = articlemapPage.lastSavedField();
//    Assert.assertTrue(lastSavedLabel);
//    boolean authorLabel1 = articlemapPage.authorField1();
//    Assert.assertTrue(authorLabel1);
//    boolean revisionLabel = articlemapPage.revisionLogMessageField();
//    Assert.assertTrue(revisionLabel);
//    boolean menuSettingsLabel = articlemapPage.menuSettingsField();
//    Assert.assertTrue(menuSettingsLabel);
//    boolean metaTagsLabel = articlemapPage.metaTagsField();
//    Assert.assertTrue(metaTagsLabel);
//    boolean simpleXMLSiteLabel = articlemapPage.simpleXMLSiteField();
//    Assert.assertTrue(simpleXMLSiteLabel);
//    boolean schedulingOptionsLabel = articlemapPage.schedulingOptionsField();
//    Assert.assertTrue(schedulingOptionsLabel);
//    boolean urlAliasLabel = articlemapPage.urlAliasField();
//    Assert.assertTrue(urlAliasLabel);
//    boolean authoringInformationLabel = articlemapPage.authoringInformationField();
//    Assert.assertTrue(authoringInformationLabel);
//    boolean promotionsOptionsLabel = articlemapPage.promotionOptionsField();
//    Assert.assertTrue(promotionsOptionsLabel);
//      }
    @Test(priority = 23)
 	public void verifyRightSideLabels() throws InterruptedException {
 	boolean fields =articlemapPage.advancedMenuItem();
 	Assert.assertTrue(fields);
	}
    @Test(priority=24)
   public void saveArticleContent() {
    boolean articleCreated =articlemapPage.saveArticleContent();
	Assert.assertTrue(articleCreated);
    }
    @AfterClass
    public void closeBrowser()
	{
		browserQuit();
	}
	


}




 