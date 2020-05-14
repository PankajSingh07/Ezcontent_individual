package ezcontent.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class SmartArticlePage  extends TestBase {

	@FindBy(xpath= "//a[@href='/admin/content']")
	WebElement admincontent;

	@FindBy(xpath="//ul[@class='local-actions']//a[@href='/node/add']")
	WebElement addcontent;

	@FindBy(xpath="//div[@id='block-ezcontent-admin-content']//a[@href='/node/add/smart_article']")
	WebElement smartarticle;

	@FindBy(xpath= "//a[@class='admin-logo']")
	WebElement srijanlogo;

	@FindBy(id="edit-title-0-value")
	WebElement title;

	@FindBy(xpath="//input[@id='edit-generate-summary']")
	//xpath="//input[@name='generate_summary']")
	WebElement genratearticlecontent;

	@FindBy(xpath="//iframe[@title='Rich Text Editor, Auto Generated Article Content field']")
	WebElement autoarticleiframe;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p")
	WebElement autoarticleiframetext;

	@FindBy(xpath="//summary[contains(text(),'Smart Media Image')]")
	WebElement smartmediaimage;

	@FindBy(xpath="//input[@name='field_smart_media_image_entity_browser_entity_browser']")
	WebElement selectimagebutton;

	@FindBy(xpath="//iframe[@name='entity_browser_iframe_smart_image_browser']")
	WebElement imageiframe;

	@FindBy(xpath="//input[@name='entity_browser_select[media:206]']")
	WebElement selectimage;

	@FindBy(id="edit-submit")
	WebElement upload;

	@FindBy(xpath="//label[contains(text(),'Article Body')]")
	WebElement articlelabel;

	@FindBy(xpath="//iframe[@title='Rich Text Editor, Article Body field']")
	WebElement articlebodyiframe;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement articlebodytext;

	@FindBy(xpath="//summary[contains(text(),'Generate Summary')]")
	//"(//summary[@class='claro-details__summary'])[3]")
	WebElement clickgenratesummary;

	@FindBy(xpath="//textarea[@name='field_smart_text_summary[0][summary_container][summary_area]']")
	WebElement summarytext;

	@FindBy(xpath="//summary[contains(text(),'Generate Tags')]")
	WebElement genratetags;

	@FindBy(xpath="	//input[@name='field_smart_tags[target_id]']")
	WebElement articletags;

	@FindBy(xpath="	//input[@id='edit-submit']")
	WebElement save;

	@FindBy(xpath="//textarea[@name='revision_log[0][value]']")
	WebElement revisonlogmessage;

	@FindBy(xpath="//summary[contains(text(),'Scheduling options')]")
	WebElement schedlingoption;

	@FindBy(xpath="//summary[contains(text(),'Authoring information')]")
	WebElement authoringinfo;

	@FindBy(xpath="//summary[contains(text(),'Promotion options')]")
	WebElement promotionoption;

	@FindBy(xpath="//input[@name='status[value]']")
	WebElement checkbox;

	//initialization
	public SmartArticlePage(){
		PageFactory.initElements(driver, this); // this refer to current class objects
	}

	//actions

	public void clicksmartarticle()
	{
		admincontent.click();
		addcontent.click();
		smartarticle.click();
	}

	//add values in fields	
	public void entertitle() throws InterruptedException {

		title.sendKeys(prop.getProperty("smartarticletitle"));		
	}

	public void autoarticlecontent() throws InterruptedException  
	{

		genratearticlecontent.click();
		
		Wait.Pause(2000);
		TestUtil.scrollToPixel();//scroll

		TestUtil.switchFrameByWebElement(autoarticleiframe);
		System.out.println("iframe inserted in auto genertated field");

		Wait.Pause(2000);
		autoarticleiframetext.sendKeys("text");

		TestUtil.switchBackToWindow();
		System.out.println("exit from iframe");

		Wait.visibiltyOfElement(2, checkbox);
		checkbox.click();

	}

	public void mediaimage() throws InterruptedException  
	{
		TestUtil.scroll(0, 300);
		
		smartmediaimage.click();
		selectimagebutton.click();
		
		Wait.Pause(3000);
		TestUtil.switchFrameByWebElement(imageiframe);
		selectimage.click();
		TestUtil.scrollToEndOfPage();
		upload.click();

	}

	public void articlebody() throws InterruptedException  
	{

		//TestUtil.scroll(0, 900);//scroll
		Wait.Pause(3000);
		TestUtil.switchFrameByWebElement(articlebodyiframe);
		System.out.println("iframe inserted");

		articlebodytext.sendKeys("article text");

		TestUtil.switchBackToWindow();
		System.out.println("exit from iframe");


	}


	public void genratesummary() throws InterruptedException  
	{
		TestUtil.scroll(0, 300);//scroll
		Wait.Pause(3000);
		clickgenratesummary.click();
		Wait.Pause(2000);
		TestUtil.scrollToPixel();
		summarytext.sendKeys("summary");





	}
	public void genratetag() throws InterruptedException  
	{
		TestUtil.scroll(0, 300);
		genratetags.click();
		Wait.Pause(2000);
		articletags.click();
		articletags.sendKeys("Drupal", Keys.RETURN);

	}
	public void savecontent()  
	{
		save.click();

	}

	//methods to verify labels

	public boolean validatetitlefield() {
		return title.isDisplayed();
	}

	public boolean validategenrateartcilesection() {
		return genratearticlecontent.isDisplayed();
	}
	public boolean validateartcilesummay() {
		return autoarticleiframetext.isDisplayed();
	}

	public boolean validatesmartmediaimage() {
		return clickgenratesummary.isDisplayed();
	}
	public boolean validatearticlebody() {
		return articlelabel.isDisplayed();
	}
	public boolean validategeneratesummary() {
		return clickgenratesummary.isDisplayed();
	}

	public boolean validategeneratesummaryfield() {
		return summarytext.isDisplayed();
	}

	public boolean validategeneratetags() {
		return genratetags.isDisplayed();
	}

	public boolean validategeneratetagfield() {
		return articletags.isDisplayed();
	}
	public boolean validatesavebutton() {
		return save.isDisplayed();
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

}
