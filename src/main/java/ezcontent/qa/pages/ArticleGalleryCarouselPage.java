package ezcontent.qa.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleGalleryCarouselPage extends TestBase {

// Basic fields objects
	@FindBy(id = "edit-title-0-value")
	WebElement title;
	@FindBy(id = "edit-field-short-title-0-value")
	WebElement shortTitle;
	@FindBy(id = "edit-field-subhead-0-value")
	WebElement subhead;
	@FindBy(id = "autocomplete-deluxe-input")
	WebElement author;

// Teaser fields objects	
	@FindBy(id = "edit-field-summary-0-value")
	WebElement summary;
	@FindBy(xpath = "//summary[contains(text(),'Thumbnail')]")
	WebElement thumbnail;
	@FindBy(xpath = "//input[@id='edit-field-thumbnail-entity-browser-entity-browser-open-modal']")
	WebElement selectImageTeaser;
	@FindBy(xpath = "//div[@class='view-content']/div[1]")
	WebElement checkImage1;
	@FindBy(xpath = "//p[contains(text(),'You can select up to 1 media items (0 left).')]")
	WebElement mediaMessage;
	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	WebElement uploadLink;
	@FindBy(xpath = "//input[@type=‘file’]")
	WebElement selectImagePath;

// Content fields objects	
	@FindBy(xpath = "//span[contains(text(),'Content')][@class='fieldset__label']")
	WebElement contentSection;
	@FindBy(xpath = "//input[@class='paragraph-type-add-modal-button js-show button js-form-submit form-submit']")
	WebElement addParagraph;
	@FindBy(xpath = "//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']//li[4]/input[1]")
	WebElement galleryCarousel;
	@FindBys({
			@FindBy(xpath = "//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li/input") })
	List<WebElement> allParagraphType;

	@FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	WebElement closeList;
	@FindBy(xpath = "//span[@class='paragraph-type-label']")
	WebElement galleryCarouselTitle;
	@FindBy(xpath = "//div[@class='field--type-string field--name-name field--widget-string-textfield js-form-wrapper form-wrapper']//input")
	WebElement galleryCarouselName;
	@FindBy(name = "field_content_0_subform_field_media_0_inline_entity_form_field_media_slideshow_entity_browser_entity_browser")
	WebElement selectImageContent;
	@FindBy(id = "entity_browser_iframe_image_browser")
	WebElement iframeElement;
	@FindBy(xpath = "//div[@class='view-content']/div[6]")
	WebElement checkImage6;
	@FindBy(xpath = "//div[@class='view-content']/div[7]")
	WebElement checkImage7;
	@FindBy(xpath = "//div[@class='view-content']/div[8]")
	WebElement checkImage8;
	@FindBy(xpath = "//input[@id='edit-submit']")
	WebElement uploadImages;
	@FindBy(xpath = "//input[@title='Collapse']")
	WebElement collapse;
	@FindBy(xpath = "//input[@title='Edit']")
	WebElement edit;
	@FindBy(xpath = "(//button[@class='paragraphs-dropdown-toggle'])[1]")
	WebElement toggleButton1;
	@FindBy(xpath = "(//button[@class='paragraphs-dropdown-toggle'])[2]")
	WebElement toggleButton2;
	@FindBy(xpath = "//input[contains(@id, 'field-content-1-remove')]")
	WebElement remove2;	
	@FindBy(xpath = "//div[@class='paragraphs-dropdown-actions']/input[1]")
	WebElement remove;
	@FindBy(xpath = "//div[@class='paragraphs-dropdown-actions']/input[2]")
	WebElement duplicate;

// Taxanomy fields objects
	@FindBy(xpath = "//summary[contains(text(),'Taxonomy')]")
	WebElement taxonomy;
	@FindBy(id = "autocomplete-deluxe-input--2")
	WebElement tagsInput;

// Seo fields objects	
	@FindBy(xpath = "//summary[contains(text(),'Real-time SEO for drupal')]")
	WebElement realTimeSEOTitle;
	@FindBy(id = "edit-field-yoast-seo-0-yoast-seo-focus-keyword")
	WebElement seoFocusKeyword;

	@FindBy(id = "edit-moderation-state-0-state")
	WebElement saveAs;

	@FindBy(id = "edit-submit")
	WebElement saveButton;
	
	@FindBy(id = "edit-revision-log-0-value")
	WebElement revisionlogMessageField;

//for editor	@FindBy(xpath = "//h1[@class='title']") WebElement newArticleTitle;

	@FindBy(xpath = "//h1[@class='js-quickedit-page-title title']")
	WebElement newArticleTitle;

	public ArticleGalleryCarouselPage() {
		PageFactory.initElements(driver, this);
	}

	public void createArticleGalleryCarousel() throws InterruptedException {

// Base section: 
		title.sendKeys(prop.getProperty("articleTitleGalleryCarousel"));
		revisionlogMessageField.sendKeys(prop.getProperty("revisionLogMessage"));
		shortTitle.sendKeys(prop.getProperty("subtitle"));
		subhead.sendKeys(prop.getProperty("subhead"));
		author.sendKeys(prop.getProperty("author"));

// Teaser section:		
		summary.sendKeys(prop.getProperty("summary"));
		TestUtil.viewportWebElement(thumbnail);
		selectImageTeaser.click();
		TestUtil.switchFrameByWebElement(iframeElement);
		checkImage1.click();
		uploadImages.click();
		Wait.visibiltyOfElement(5, mediaMessage);
		String imgMediamessage = mediaMessage.getText();

// Content section:
		TestUtil.viewportWebElement(contentSection);
		galleryCarouselName.clear();
		galleryCarouselName.sendKeys(prop.getProperty("galleryCarouselname"));
		TestUtil.viewportWebElement(galleryCarouselName);
		Wait.elementClickable(5, selectImageContent);
		selectImageContent.click();
		Wait.visibiltyOfElement(5, iframeElement);
		TestUtil.switchFrameByWebElement(iframeElement);
		TestUtil.viewportWebElement(checkImage7);
		checkImage6.click();
		checkImage7.click();
		checkImage8.click();
		uploadImages.click();

// Taxonomy section:
		  TestUtil.viewportWebElement(addParagraph); //
		  tagsInput.sendKeys(prop.getProperty("tag1")); //
		  tagsInput.sendKeys(Keys.ENTER); //
		  tagsInput.sendKeys(prop.getProperty("tag2")); //
		  tagsInput.sendKeys(Keys.ENTER);
		 
// Seo section
		seoFocusKeyword.sendKeys(prop.getProperty("focusKeyword"));

//select save as published:
		Select oSelect = new Select(saveAs);
		oSelect.selectByVisibleText("Published");
		Wait.Pause(10000);
		Wait.elementClickable(5, saveButton);
		saveButton.click();
	}

// methods to validating the input fields on Create-Article page:	
	public boolean validateAddParagraphLink() {
		return addParagraph.isDisplayed();
	}

	public boolean validateGalleryCarouselFromList() {
		Boolean result = false;
		TestUtil.viewportWebElement(contentSection);
		addParagraph.click();
		List<WebElement> elementlist = allParagraphType;
		System.out.println(elementlist.size());
		for (WebElement element : elementlist) {
			System.out.println(element.getAttribute("value"));
			if (element.getAttribute("value").equalsIgnoreCase("Gallery Carousel")) {
				result = true;
				element.isDisplayed();
				element.click();
				break;
			}
		}
		if (result == false) {
			closeList.click();
			System.out.println("required element not found");
		}
		return result;
	}

	public boolean validateGalleryCarouselNameField() {
		Wait.visibiltyOfElement(8, galleryCarouselName);
		return galleryCarouselName.isDisplayed();
	}

	public boolean validateSlideshowSelectImage() {
		return selectImageContent.isDisplayed();
	}

	public void collapseThenEditGC() {
		galleryCarouselName.sendKeys("testing text 123");
		collapse.click();
		Wait.visibiltyOfElement(8, edit);
		if (edit.isDisplayed()) {
			edit.click();
	}	Wait.visibiltyOfElement(8, galleryCarouselName); 
		galleryCarouselName.sendKeys("testing text 321");
	}
	
	public void toggleButtonActions() {
		toggleButton1.isDisplayed();
		toggleButton1.click();
		remove.isDisplayed();
		duplicate.isDisplayed();		
		duplicate.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
        Wait.visibiltyOfElement(8, toggleButton2);
		toggleButton2.click();
		remove2.isDisplayed();
		remove2.click();			
	}
}
