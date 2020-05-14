package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.pages.SmartArticlePage;

public class SmartArticlePageTest extends TestBase {



	LoginPage loginPage;									
	SmartArticlePage SmartArticle;

	@BeforeClass
	public void setup()
	{
		browserLaunch();  // launch browser with url
		loginPage = new LoginPage();
		SmartArticle = new SmartArticlePage();

	}

	@Test(priority = 1)
	public void login()
	{
		//loginPage.validateLogin(prop.getProperty("devusername"), prop.getProperty("devpassword"));
		loginPage.validateLogin();

	}

	@Test(priority = 2)
	public void srijanlogo() {
		Assert.assertTrue(true);

	}
	@Test(priority = 3)
	public void createsmartarticlecontent () throws InterruptedException
	{
		SmartArticlePage createsmartarticlecontent = new SmartArticlePage();
		createsmartarticlecontent.clicksmartarticle();

	}
	@Test(priority = 4)
	public void validatetitle() {
		//validate title
		boolean title = SmartArticle.validatetitlefield();
		Assert.assertTrue(title);
	}

	@Test(priority = 5)
	public void addvalues() throws InterruptedException
	{
		SmartArticlePage addvalues = new SmartArticlePage();
		addvalues.entertitle();

	}
	@Test(priority = 6)
	public void validateautogenratesection() {

		boolean genratearticlebutton = SmartArticle.validategenrateartcilesection();
		Assert.assertTrue(genratearticlebutton);
		System.out.println("validate genrate article button");

	}
	
	
	@Test(priority = 7)
	public void genratearticle() throws InterruptedException
	{
		SmartArticlePage genratearticle = new SmartArticlePage();
		genratearticle.autoarticlecontent();

	}
	

	@Test(priority = 8)
	public void validaterightsectionfields() {
		//validate revisonlogfield
		boolean revisonlogmessage = SmartArticle.validaterevisonlogsection();
		Assert.assertTrue(revisonlogmessage);
		System.out.println("validate revison log message field");

		//validate schedlingoption field
		boolean schedlingoption = SmartArticle.validateschedulingsection();
		Assert.assertTrue(schedlingoption);
		System.out.println("validate schedling option field");

		//validate auth info field
		boolean authoringinfo = SmartArticle.validateauthoringsection();
		Assert.assertTrue(authoringinfo);
		System.out.println("validate authoringinfo field");

		//validate promotion field
		boolean promotionoption = SmartArticle.validatepromotionsection();
		Assert.assertTrue(promotionoption);
		System.out.println("validate promotion option field");

	}
	@Test(priority = 9)
	public void validateimagesection() {
		boolean smartarticleimage =SmartArticle.validatesmartmediaimage();
		Assert.assertTrue(smartarticleimage);
		System.out.println("validate article image");
	}
	
	@Test(priority = 10)
	public void addimage() throws InterruptedException
	{
		SmartArticlePage addimage = new SmartArticlePage();
		addimage.mediaimage();

    }

	
	@Test(priority = 11)
	public void validateartcilebodylabel() {
		boolean articlebodylabel =SmartArticle.validatearticlebody();
		Assert.assertTrue(articlebodylabel);
		System.out.println("validate article body");
	}


	@Test(priority = 12)
	public void addarticle() throws InterruptedException
	{
		SmartArticlePage addarticle = new SmartArticlePage();
		addarticle.articlebody();

    }

	@Test(priority = 13)
	public void validategenratesummary() {

		boolean genratesummarylink = SmartArticle.validategeneratesummary();
		Assert.assertTrue(genratesummarylink);
		System.out.println("validate genrate summary link");
	}
	
	@Test(priority = 14)
	public void addsummary() throws InterruptedException
	{
		SmartArticlePage addsummary = new SmartArticlePage();
		addsummary.genratesummary();

	}
	
	@Test(priority = 15)
	public void validategenratesummarytextfield() {
	boolean genratesummary = SmartArticle.validategeneratesummaryfield();
	Assert.assertTrue(genratesummary);
	System.out.println("validate genratesummary textarea");
}

	@Test(priority = 16)
	public void validategenratetags() {

		boolean genratetaglink = SmartArticle.validategeneratetags();
		Assert.assertTrue(genratetaglink);
		System.out.println("validate genratesummarylink");

		
	}

	@Test(priority = 17)
	public void addtags() throws InterruptedException
	{
		SmartArticlePage addtags = new SmartArticlePage();
		addtags.genratetag();

	}

	@Test(priority = 18)
	public void validategenratetagsfield() {
	boolean tagfield = SmartArticle.validategeneratetagfield();
	Assert.assertTrue(tagfield);
	System.out.println("validate autocomplete tag field");
	}
	
	@Test(priority = 19)
	public void validatesavebutton() {

		boolean save = SmartArticle.validatesavebutton();
		Assert.assertTrue(save);
		System.out.println("validate save button");
	}

	@Test(priority = 20)
	public void save() throws InterruptedException
	{
		SmartArticlePage save = new SmartArticlePage();
		save.savecontent();
	}

 
		@AfterClass
		public void closeBrowser() {
			browserQuit();
		}

}
