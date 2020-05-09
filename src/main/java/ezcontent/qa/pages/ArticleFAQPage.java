package ezcontent.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleFAQPage extends TestBase{
	
	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	WebElement Content;

	@FindBy(linkText = "Add content")
	WebElement addContent;
	
	@FindBy(linkText = "Article")
	WebElement article;

	@FindBy(xpath = "//h1[@class='js-quickedit-page-title page-title']")
	WebElement header;
	
	@FindBy(xpath = "//input[@id='edit-title-0-value']")
	WebElement title;
	
	@FindBy(xpath = "//input[@id='edit-field-short-title-0-value']")
	WebElement shortTitle;
	
	@FindBy(xpath = "//input[@id='edit-field-subhead-0-value']")
	WebElement subHead;
	
	@FindBy(xpath = "//input[@id='autocomplete-deluxe-input']")
	WebElement author;
	
	@FindBy(xpath = "//textarea[@id='edit-field-summary-0-value']")
	WebElement summary;
	
	@FindBy(xpath ="//summary[contains(text(),'Thumbnail')]")
	WebElement thmbnaildropDown;
	
	@FindBy(xpath = "//div[@class='claro-details__wrapper details-wrapper']//div/input[@type='submit']")
	WebElement thumbnailSelectImage;
	
	@FindBy(xpath = "//iframe[@id='entity_browser_iframe_image_browser']")
	WebElement thumbnailImageFrame;
	
	@FindBy(xpath = "(//div[@class='views-row'])[1]")
	WebElement selectImage;
	
	@FindBy(xpath = "//input[@id='edit-submit']")
	WebElement imageSelectbutton;
	
	@FindBy(xpath = "//input[@id='edit-field-content-add-more-add-modal-form-area-add-more']")
	WebElement addParagraphButton;
	
	@FindBy(xpath = "(//input[@id='field-content-faq-add-more'])[2]")
	WebElement clickOnFAQ;
	
	@FindBy(xpath = "//input[contains(@id,'edit-field-content-0-subform-field-faq-items-0-subform-field-question-0-value')]")
	WebElement question;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement ansFrame;
	
	@FindBy(xpath = "//body//p")
	WebElement FAQAnswer;
	
	@FindBy(name = "field_content_0_subform_field_faq_items_0_previewer")
	WebElement preview;
	
	@FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	WebElement closePreview;
	
	@FindBy(xpath = "(//button[@class='paragraphs-dropdown-toggle'])[2]")
	WebElement threeDots;
	
	@FindBy(xpath= "//input[@name='field_content_0_subform_field_faq_items_0_duplicate']")
	WebElement duplicate;
	
	@FindBy(xpath="//input[@name='field_content_0_subform_field_faq_items_0_remove']")
	WebElement remove;
	
	@FindBy(xpath = "//input[@name='field_content_0_subform_field_faq_items_1_collapse']") 
	WebElement collapse; 
	
	@FindBy(xpath = "//summary[contains(text(),'Taxonomy')]")
	WebElement taxonomy	;

	@FindBy(xpath = "//input[@id='autocomplete-deluxe-input--2']")
	WebElement tags;
	
	@FindBy(xpath = "(//a[@class='ui-menu-item-wrapper'])[1]")
	WebElement architecture;
	
	@FindBy(id = "edit-submit")
	WebElement save;
	
	public ArticleFAQPage() {
		PageFactory.initElements(driver, this); 
	}
	
public void reachToArticlePage() throws InterruptedException {
		
		Wait.Pause(2000);
		TestUtil.mouseHover(Content);
		TestUtil.mouseHover(addContent);
		article.click();	
	}
	
	public String validateWindowTabTitle() {
		return driver.getTitle();
	}
	
	public String validateHeaderTitle() {
		return header.getText();
	}
	
	
	public void enterBasicsDetails(String ttl, String sttl, String shead, String atr) throws Exception {
		title.sendKeys(ttl);
		shortTitle.sendKeys(sttl);
		subHead.sendKeys(shead);
		author.sendKeys(atr);
		Wait.Pause(2000);
		author.sendKeys(Keys.ARROW_DOWN);
		author.sendKeys(Keys.ENTER);
	}
	
	public void enterTeaserDetails(String smry) {
		summary.sendKeys(smry);
		
	}
	
	public void uploadThumbnailImage() throws InterruptedException {
		
				
		System.out.println("entered in thumbnail method");
		Wait.Pause(5000);
			
		TestUtil.scrollToClickElement(thumbnailSelectImage);
		
//		thumbnailSelectImage.click();
		Wait.Pause(5000);
		TestUtil.switchFrameByWebElement(thumbnailImageFrame);
		System.out.println("In thubnail frame");
		
		
		selectImage.click();	
		Wait.Pause(2000);
		imageSelectbutton.click();
		TestUtil.switchBackToWindow();
		System.out.println("On default page");

	}
	
	public void enterContentDetails(String faqques, String faqans) throws InterruptedException {
		
//		addParagraphButton.click();
		
		TestUtil.scrollToClickElement(addParagraphButton);
		Wait.Pause(3000);
		clickOnFAQ.click();

		Wait.Pause(3000);
		question.sendKeys(faqques);
		System.out.println(" FAQ ques written");
		Wait.Pause(3000);
		TestUtil.switchFrameByWebElement(ansFrame);
		System.out.println("In FAQ answer frame");
		
		FAQAnswer.sendKeys(faqans);
		TestUtil.switchBackToWindow();
		System.out.println("On default page");
		preview.click();
		Wait.Pause(3000);
		closePreview.click();
			
	}
	
	public void contentFunctionalities() throws InterruptedException {
		
		System.out.println("to be execute 3-dots");
		threeDots.click();
		Wait.Pause(3000);
		duplicate.click();
		Wait.Pause(3000);
		threeDots.click();
		Wait.Pause(3000);
		remove.click();
		Wait.Pause(5000);
		collapse.click();
		Wait.Pause(5000);
	}
	
	public void enterTaxonomy(String tg) throws InterruptedException {
		
		TestUtil.scrollToClickElement(taxonomy);
		Wait.Pause(3000);
		tags.sendKeys(tg);
		Wait.Pause(2000);
		tags.sendKeys(Keys.ARROW_DOWN);
		tags.sendKeys(Keys.ENTER);
		Wait.Pause(2000);
		TestUtil.scrollToEndOfPage();
	}
	
	public void saveContent() {
		save.click();
	}
	
	
}
