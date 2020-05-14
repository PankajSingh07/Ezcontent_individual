package ezcontent.qa.pages;

import java.io.Serializable;

import org.jsoup.select.Evaluator.Tag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleTextPage extends TestBase {




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
	WebElement selectimagebutton;

	@FindBy(id="entity_browser_iframe_image_browser")
	WebElement clickimageframe;

	@FindBy(xpath="//div[@class='views-row'][1]")
	WebElement selectimage;

	@FindBy(id="edit-submit")
	WebElement upload;

	@FindBy(id = "edit-field-content-add-more-add-modal-form-area-add-more")
	WebElement addparagraph;

	@FindBy(xpath=("//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable']//li[1]"))
	WebElement selecttext;

	//@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	@FindBy(xpath="//iframe[@title='Rich Text Editor, Body field']")
	WebElement clicktextframe;

	@FindBy(xpath="//textarea[@name='field_content[0][subform][field_body][0][value]']")
	WebElement textarea;
	//@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p")
	WebElement bodytext;

	@FindBy(xpath= "//summary[contains(text(),'Taxonomy')]")
	WebElement taxonomy;

	@FindBy(xpath= "//input[@id = 'autocomplete-deluxe-input--2']")
	WebElement tags;

	//	FindBy(xpath="//label[contains(text(),'Save as')]")
	//	WebElement saveas;

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

	@FindBy(xpath="//div[@aria-label = 'Status message']")
	WebElement submitmessage;

	//@FindBy(xpath = "//p[contains(text(),'You can select up to 1 media items (0 left).')]")
	//	WebElement mediaMessage;

	//initialization
	public ArticleTextPage(){
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	//actions

	public boolean validateLogo() {
		return srijanlogo.isDisplayed();

	}
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
		selectimagebutton.click();
		Wait.Pause(1000);

		TestUtil.switchFrameByWebElement(clickimageframe);
		System.out.println("iframe inserted in imageframe");
		selectimage.click();
		Wait.Pause(2000);

		upload.click();
		System.out.println("image uploaded");
		Wait.Pause(3000);
		
		//		String imgMediamessage = mediaMessage.getText();
		//		System.out.println("message is :" + imgMediamessage);
	}

	//content paragraph text
	public void addparagraphtext() throws InterruptedException 
	{
		//page scroll
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", addparagraph);
		addparagraph.click();
		selecttext.click();

		Wait.Pause(3000);
		textarea.sendKeys("textarea content");
	}


	public void taxonomy ()  
	{
		TestUtil.scrollToEndOfPage();		
		taxonomy.click();
		//tags.sendKeys("Drupal", Keys.RETURN);
		tags.sendKeys("Drupal");
		tags.sendKeys(Keys.RETURN);
	}

	//saveas published
	public void saveasstatus() throws InterruptedException
	{
		saveas.click();
		TestUtil.selectByValue(saveas, "published");

	}

	//save content
	public boolean savecontent() throws InterruptedException
	{
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
	public boolean validatethumbnailfield() {
		return selectimagebutton.isDisplayed();
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
	public boolean validaterevisonlogsection() {
		return revisonlogmessage.isDisplayed();
	}
	public boolean validatesaveassection() {
		return saveas.isDisplayed();
	}

	public String validatemessage() {
		return submitmessage.getText();
	}

}


//{
//TestUtil.switchFrameByWebElement(clicktextframe);
//System.out.println("iframe inserted in bodyframe");
//bodytext.sendKeys("content body text");
//
//System.out.println("text");
//TestUtil.switchBackToWindow();
//System.out.println("exit from iframe");
//
//}












