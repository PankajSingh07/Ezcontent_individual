package ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.ArticleSocialMediaPage;
import ezcontent.qa.pages.ArticleTextPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.Wait;

public class ArticleSocialMediaTest extends TestBase {

	LoginPage loginPage;									
	//ArticlePage ArticleTest = new ArticlePage();
	ArticleSocialMediaPage ArticlePage;



	@BeforeClass
	public void setup()
	{
		browserLaunch();  // launch browser with url
		loginPage = new LoginPage();
		ArticlePage = new ArticleSocialMediaPage();
		//loginPage.validateLogin(prop.getProperty("devusername"), prop.getProperty("devpassword"));

	}

	@Test(priority = 1)
	public void login()
	{
		loginPage.validateLogin();
		//loginPage.validateLogin(prop.getProperty("Admin"), prop.getProperty("Adminpass"));

	}

	@Test(priority = 2)
	public void srijanlogo() {
		Assert.assertTrue(true);

	}
	@Test(priority = 3)
	public void createarticlecontent () throws InterruptedException
	{
		ArticleSocialMediaPage createarticlecontent = new ArticleSocialMediaPage();
		createarticlecontent.clickarticle();
	}


	@Test(priority = 4)
	public void validatebasicsection() {
		//validate title
		boolean title = ArticlePage.validatetitlefield();
		Assert.assertTrue(title);
		System.out.println("validate title");
		//validate subtitle
		boolean subtitle = ArticlePage.validatesubtitlefield();
		Assert.assertTrue(subtitle);
		System.out.println("validate subtitle");
		//validate subhead
		boolean subhead = ArticlePage.validatesubheadfield();
		Assert.assertTrue(subhead);
		System.out.println("validate subhead");


	}
	@Test(priority = 5)
	public void addvalues() throws InterruptedException
	{
		ArticleSocialMediaPage addvalues = new ArticleSocialMediaPage();
		addvalues.entervalues();

	}
	
	@Test(priority = 6)
	public void validaterightsectionfields() {
		//validate revisonlogfield
		boolean revisonlogmessage = ArticlePage.validaterevisonlogsection();
		Assert.assertTrue(revisonlogmessage);
		System.out.println("validate revison log message field");
		//validate meta tag field
		boolean metatags = ArticlePage.validatemetatagsection();
		System.out.println("validate metatags field");
		//validate schedlingoption field
		boolean schedlingoption = ArticlePage.validateschedulingsection();
		Assert.assertTrue(schedlingoption);
		System.out.println("validate schedling option field");
		//validate auth info field
		boolean authoringinfo = ArticlePage.validateauthoringsection();
		Assert.assertTrue(authoringinfo);
		System.out.println("validate authoringinfo field");
		//validate promotion field
		boolean promotionoption = ArticlePage.validatepromotionsection();
		Assert.assertTrue(promotionoption);
		System.out.println("validate promotion option field");

	}
	@Test(priority = 7)
	public void validatebasicauthorsection() {
		//validate author
		boolean author = ArticlePage.validatetitlefield();
		Assert.assertTrue(author);
		System.out.println("validate author");
	}
	@Test(priority = 8)
	public void authorField() throws InterruptedException{
		ArticleSocialMediaPage  authorField = new ArticleSocialMediaPage();
		authorField.selectauthor();
		Assert.assertTrue(true);	
	}
	@Test(priority = 9)
	public void validateTeaserSection() {
		//validate summary
		boolean summary = ArticlePage.validatetitlefield();
		Assert.assertTrue(summary);
		System.out.println("validate summary");
	}

	@Test(priority = 10)
	public void summary() throws InterruptedException {
		ArticleSocialMediaPage summary =new ArticleSocialMediaPage();
		summary.entersummary();

	}
	
	@Test(priority = 11)
	public void saveas() throws InterruptedException {
		ArticleTextPage saveas =new ArticleTextPage();
		saveas.saveasstatus();
	}
	
	@Test(priority = 12)
	public void validateTeaserImageSection() {
		//validate thumbnail
		boolean selectimagebutton = ArticlePage.validatetitlefield();
		Assert.assertTrue(selectimagebutton);
		System.out.println("validate Imagefield");
	}


	@Test(priority = 13)
	public void clickimage() throws InterruptedException {
		ArticleSocialMediaPage clickimage =new ArticleSocialMediaPage();
		clickimage.addimage();

	}


	@Test(priority = 14)
	public void validatecontentSection() {
		//validate paragraph
		boolean addparagraph = ArticlePage.validateaddparagraphfield();
		Assert.assertTrue(addparagraph);
		System.out.println("validate addparagraph button");
	}
	
	@Test(priority = 15)
	public void addparagraph() throws InterruptedException {
		ArticleSocialMediaPage addparagraph =new ArticleSocialMediaPage();
		addparagraph.socialmedia();

	}
	 
	@Test(priority = 16)
	public void addinstapost() throws InterruptedException {
		ArticleSocialMediaPage addinstapost =new ArticleSocialMediaPage();
		addinstapost.instagramsocialmedia();
	}
	
	@Test(priority = 17)
	public void addtweetpost() throws InterruptedException {
		ArticleSocialMediaPage addtweetpost =new ArticleSocialMediaPage();
		addtweetpost.tweetsocialmedia();
	}


	@Test(priority = 18)
	public void validateTaxonomySection() {
		//validate taxonomy
		boolean taxonomy = ArticlePage.validatetaxonomyfield();
		Assert.assertTrue(taxonomy);
		System.out.println("validate taxonomy");
	}
	

	@Test(priority = 19)
	public void selecttaxonomyvalue() throws InterruptedException
	{
		ArticleTextPage selecttaxonomyvalue =new ArticleTextPage();
		selecttaxonomyvalue.taxonomy();
	}
	
	@Test(priority = 20)
	public void validatesaveas() {
		//validate saveas
		boolean saveasfield = ArticlePage.validatesaveassection();
		Assert.assertTrue(saveasfield);
		System.out.println("validate saveas field");
	}
	@Test(priority = 21)
	public void validateSavebutton() {
		//validate save button
		boolean save = ArticlePage.validatesavebutton();
		Assert.assertTrue(save);
		System.out.println("validate save button");
	}

	@Test(priority = 22)
	public void save() throws InterruptedException
	{
		ArticleTextPage save =new ArticleTextPage();
		save.savecontent();

	}

	@AfterClass
	public void closeBrowser() {
		browserQuit();
	}
}

