package ezcontent.qa.pages;

import java.io.Serializable;

import org.jsoup.select.Evaluator.Tag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleSocialMediaPage extends TestBase {


	@FindBy(xpath= "//a[@href='/admin/content']")
	WebElement admincontent;

	@FindBy(xpath="//ul[@class='local-actions']//a[@href='/node/add']")
	WebElement addcontent;

	@FindBy(xpath="//div[@id='block-ezcontent-admin-content']//a[@href='/node/add/article']")
	WebElement article;

	@FindBy(xpath= "//a[@class='admin-logo']")
	WebElement srijanlogo;
	
	@FindBy(id="edit-title-0-value")
	WebElement title;

	@FindBy(id="edit-field-short-title-0-value")
	WebElement subtitle;

	@FindBy(id="edit-field-subhead-0-value")
	WebElement subhead;

	@FindBy(xpath="//input[@id='autocomplete-deluxe-input']")
	WebElement author;

	@FindBy(xpath= "//textarea[@id='edit-field-summary-0-value']")
	WebElement summary;

	@FindBy(xpath="//input[@id='edit-field-thumbnail-entity-browser-entity-browser-open-modal']")
	WebElement selectimagebutn;

	@FindBy(id="entity_browser_iframe_image_browser")
	WebElement clickimageframe;

	@FindBy(xpath="//div[@class='views-row'][1]")
	WebElement selectimage;

	@FindBy(id="edit-submit")
	WebElement upload;
	
	@FindBy(xpath="//input[@name='button_add_modal']")
	WebElement addparagraph;

	@FindBy(xpath="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable']//li[6]")
	WebElement selectsocialmedia;
	
	@FindBy(xpath="(//input[@value='Add new media item'])[1]")
	WebElement addnewmedia1;
	
	//@FindBy(xpath="(//input[@value='Add new media item'])[2]")
	@FindBy(xpath="//input[@value='Add new media item']")
	WebElement addnewmedia2;

	@FindBy(xpath="//textarea[@name='field_content[0][subform][field_social_media][form][inline_entity_form][embed_code][0][value]']")
	WebElement instagrampost;
	
	@FindBy(xpath="//textarea[@name='field_content[1][subform][field_social_media][form][inline_entity_form][embed_code][0][value]']")
	WebElement tweetfield;
	
	@FindBy(xpath="(//input[@value='Create media item'])[1]")
	WebElement createmediaitem1;
	
	@FindBy(xpath="(//input[@value='Create media item'])[2]")
	WebElement createmediaitem2;

	@FindBy(xpath="input[@name='button_add_modal']")
	WebElement addparagraph2;
	
    @FindBy(xpath="//select[@name='field_content[1][subform][field_social_media][actions][bundle]']")
	WebElement clickinstafield;	

	@FindBy(xpath= "//summary[contains(text(),'Taxonomy')]")
	WebElement taxonomy;
	
	@FindBy(xpath= "//input[@id = 'autocomplete-deluxe-input--2']")
	WebElement tags;
	
	@FindBy(xpath="//select[@id='edit-moderation-state-0-state']")
	WebElement saveas;

	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement save;

	@FindBy(xpath="//textarea[@name='revision_log[0][value]']")
	WebElement revisonlogmessage;
	
	@FindBy(xpath="//summary[contains(text(),'Meta Tags')]")
	WebElement metatags;

	@FindBy(xpath="//summary[contains(text(),'Scheduling options')]")
	WebElement schedlingoption;

	@FindBy(xpath="//summary[contains(text(),'Authoring information')]")
	WebElement authoringinfo;
	
	@FindBy(xpath="//summary[contains(text(),'Promotion options')]")
	WebElement promotionoption;
    
	@FindBy(xpath="//div[@class='alert alert-dismissible fade show col-12 alert-success']")
	WebElement submitmessage;
	
	
	//initialization
	public ArticleSocialMediaPage(){
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	//actions

	public String verifyarticletitle() {
		return  driver.getTitle();

	}
	//article text content
	public void clickarticle()
	{
		admincontent.click();
		addcontent.click();
		article.click();
	}
	//add values in fields	
	public void entervalues() {

		title.sendKeys(prop.getProperty("articletexttitle"));
		subtitle.sendKeys(prop.getProperty("articletextsubtitle"));
		subhead.sendKeys(prop.getProperty("articletextsubhead"));
		
	}

    //add summary
	public void entersummary() {
		summary.sendKeys(prop.getProperty("summarytext"));
	}

	//select author
	public void selectauthor()
	{
		author.sendKeys("Female User", Keys.TAB);

	}
	//click on image
	public void addimage() throws InterruptedException 
	{
		selectimagebutn.click();
		Wait.Pause(2000);
		TestUtil.switchFrameByWebElement(clickimageframe);
		System.out.println("iframe inserted");
		selectimage.click();
		
		upload.click();
		Wait.Pause(2000);
		System.out.println("image uploaded:");
	
		//		String imgMediamessage = mediaMessage.getText();
		//		System.out.println("message is :" + imgMediamessage);
	}
	
	//content paragraph
		public void socialmedia() throws InterruptedException 
		{

			//page scroll
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", addparagraph);
			addparagraph.click();
			selectsocialmedia.click();
			Wait.Pause(3000);
		}
		public void instagramsocialmedia() throws InterruptedException 
		{
			addnewmedia1.click();
			Wait.Pause(2000);
		    instagrampost.sendKeys("www.google.com");
		    Wait.Pause(2000);
		    createmediaitem1.click();
		}
        
		public void tweetsocialmedia() throws InterruptedException 
		{
			Wait.Pause(2000);
			//page scroll
			TestUtil.scrollToEndOfPage();
			addparagraph.click();;
			selectsocialmedia.click();
			Wait.Pause(2000);
			clickinstafield.click();
		
			TestUtil.selectByText(clickinstafield, "Tweet");
			
			addnewmedia2.click();
			Wait.Pause(2000);
			tweetfield.sendKeys("https://help.twitter.com/en/using-twitter#tweetss");
	
			createmediaitem2.click();
			
		
		}
		
		public void taxonomy ()  
		{
		TestUtil.scrollToEndOfPage();		
		taxonomy.click();
		
		tags.sendKeys("Drupal");
		tags.sendKeys(Keys.RETURN);
		}
		
		//save content
		public boolean savecontent() throws InterruptedException
		{
			saveas.click();
			TestUtil.selectByValue(saveas, "published");
			Wait.Pause(2000);
			save.click();
			return submitmessage.isDisplayed();
		}
		
		
		// methods to verify labels
		public boolean validatelogo() {
			return srijanlogo.isDisplayed();
		}
		
		public boolean validatetitlefield() {
			return title.isDisplayed();
		}

		public boolean validatesubtitlefield() {
			return subtitle.isDisplayed();
		}

		public boolean validatesubheadfield() 
		{
			return subhead.isDisplayed();
		}
		public boolean validateauthorfield() {
			return author.isDisplayed();

		}

		public boolean validatesummaryfield() {
			return summary.isDisplayed();
		}

		public boolean validateaddparagraphfield() {
			return addparagraph.isDisplayed();
		}
		public boolean validatetaxonomyfield() {
			return taxonomy.isDisplayed();
		}
		public boolean validatesavebutton() {
			return save.isDisplayed();
		}
		
		public boolean validaterevisonlogsection() {
			return revisonlogmessage.isDisplayed();
		}
		public boolean validatesaveassection() {
			return saveas.isDisplayed();
		}
		public boolean validatemetatagsection() {
			return metatags.isDisplayed();
		}
		public boolean validateschedulingsection() {
			return schedlingoption.isDisplayed();
		}
		public boolean validateauthoringsection() {
			return authoringinfo.isDisplayed();
		}
		
		public boolean validatepromotionsection() {
			return promotionoption.isDisplayed();
		}	
		
		public String validatemessage() {
			return submitmessage.getText();
		}

	
		
}
	