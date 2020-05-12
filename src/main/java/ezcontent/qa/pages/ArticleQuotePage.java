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
import ezcontent.qa.base.TestBase;


public class ArticleQuotePage extends TestBase {

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

	@FindBy(xpath = "//iframe[@id='entity_browser_iframe_image_browser']")
	WebElement iframeElement;

	@FindBy(xpath = "//div[@class='view-content']/div[1]")
	WebElement checkImage1;

	@FindBy(xpath = "//input[@id='edit-submit']")
	WebElement uploadImages;

	@FindBy(xpath = "//p[contains(text(),'You can select up to 1 media items (0 left).')]")
	WebElement mediaMessage;

	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	WebElement uploadLink;
	@FindBy(xpath = "//a[@class='button']")
	WebElement selectImagePath;

// Content fields objects
	@FindBy(xpath = "//span[contains(text(),'Content')][@class='fieldset__label']")
	WebElement contentSection;

	@FindBy(xpath = "//input[@class='paragraph-type-add-modal-button js-show button js-form-submit form-submit']")
	WebElement addParagraph;
	
	@FindBys({
			@FindBy(xpath = "//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li/input") })
	List<WebElement> allParagraphType;
	@FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	WebElement closeList;

	@FindBy(xpath = "//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']//li[7]/input[1]")
	WebElement Quote;

	@FindBy(xpath = "//div[@class='field--type-string field--name-field-quote field--widget-string-textfield paragraphs-content js-form-wrapper form-wrapper']//input")
	WebElement quoteName;

	@FindBy(xpath = "//div[@class='field--type-string field--name-field-source field--widget-string-textfield paragraphs-content js-form-wrapper form-wrapper']//input")
	WebElement quoteSource;

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
	@FindBy(linkText = "Show row weights")
	WebElement showRowWeights;
	@FindBy(linkText = "Hide row weights")
	WebElement hideRowWeights;

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

	@FindBy(id = "edit-submit")
	WebElement saveButton;
	@FindBy(xpath = "//h1[@class='js-quickedit-page-title title']")
	WebElement newArticleTitle;

// RHS section fields objects
	
	@FindBy(xpath = "//a[@class='admin-logo']//img")
	WebElement srijanLogo;	
	@FindBy(xpath = "//label[contains(text(),'Revision log message')]")
	WebElement revisionlogMessageLabel;
	@FindBy(id = "edit-revision-log-0-value")
	WebElement revisionlogMessageField;
	@FindBy(id = "edit-menu")
	WebElement menuSettings;
	@FindBy(id = "edit-field-meta-tags-0")
	WebElement metaTags;
	@FindBy(id = "edit-simple-sitemap")
	WebElement simpleXmlSitemap;
	@FindBy(id = "edit-scheduler-settings")
	WebElement schedulingOptions;
	@FindBy(id = "edit-path-0")
	WebElement urlAlias;
	@FindBy(id = "edit-author")
	WebElement authoringInfo;
	@FindBy(id = "edit-options")
	WebElement promotionOptions;
	@FindBy(id = "edit-moderation-state-0-state")
	WebElement saveAs;

	public ArticleQuotePage() {
		PageFactory.initElements(driver, this);
	}

	public void createArticleQuote() {

// Base section: 
		title.sendKeys(prop.getProperty("articleTitleQuote"));
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
		quoteName.clear();
		quoteName.sendKeys(prop.getProperty("quotename"));
		quoteSource.sendKeys(prop.getProperty("quotesource"));

// Taxonomy section:
		TestUtil.viewportWebElement(addParagraph);
		tagsInput.sendKeys(prop.getProperty("tag1"));
		tagsInput.sendKeys(Keys.ENTER);
		tagsInput.sendKeys(prop.getProperty("tag2"));
		tagsInput.sendKeys(Keys.ENTER);

//Seo section
		seoFocusKeyword.sendKeys(prop.getProperty("focusKeyword"));

//select save as published:
		Select oSelect = new Select(saveAs);
		oSelect.selectByVisibleText("Published");
		saveButton.click();
	}

	public String NewArticleTitle() {
		Wait.visibiltyOfElement(10, newArticleTitle);
		return newArticleTitle.getText();
	}

// methods to validating the input fields on Create-Article page:
	public boolean validateTitleField() {
		return title.isDisplayed();
	}

	public boolean validateShortTitleField() {
		return shortTitle.isDisplayed();
	}

	public boolean validateSubheadField() {
		return subhead.isDisplayed();
	}

	public boolean validateAuthorField() {
		return author.isDisplayed();
	}

	public boolean validateSummaryField() {
		return summary.isDisplayed();
	}

	public boolean validateThumbnailTitle() {
		return thumbnail.isDisplayed();
	}

	public boolean validateSelectThumbnailImage() {
		return selectImageTeaser.isDisplayed();
	}

	public boolean validateContentSectionTitle() {
		return contentSection.isDisplayed();
	}

	public boolean validateAddParagraphLink() {
		return addParagraph.isDisplayed();
	}

	public boolean validateQuoteFromList() {
		Boolean result = false;
		TestUtil.viewportWebElement(contentSection);
		addParagraph.click();
		List<WebElement> elementlist = allParagraphType;
		System.out.println(elementlist.size());
		for(WebElement element: elementlist) {
		System.out.println(element.getAttribute("value"));	
	 if(element.getAttribute("value").equalsIgnoreCase("Quote")) {
		 result = true;
		 element.isDisplayed();
		 element.click();
		 break;	 	 
	 } }
		 if(result == false) {
			 closeList.click();
			 System.out.println("required element not found");
		 } return result;
	 }     

	public boolean validateQuoteNameField() {		 
		 Wait.visibiltyOfElement(8, quoteName);
		 return quoteName.isDisplayed();	 
	}  

	public boolean validateQuoteSourceField() {
		return quoteSource.isDisplayed();
	}

	public void collapseThenEdit() {
		quoteName.sendKeys("testing text 123");
		collapse.click();
		Wait.visibiltyOfElement(8, edit);
		if (edit.isDisplayed()) {
			edit.click();			
		} Wait.visibiltyOfElement(8, collapse);
		  collapse.isDisplayed();
	}

	public void showAndHideRowWeights() {
		showRowWeights.click();
		if (hideRowWeights.isDisplayed()) {
			hideRowWeights.click();
		}
	}

	public void toggleButtonActions() {
		toggleButton1.isDisplayed();
		toggleButton1.click();
		remove.isDisplayed();
		duplicate.isDisplayed();	
		duplicate.click();
	    Wait.visibiltyOfElement(8, toggleButton2);
		toggleButton2.click();
		remove2.isDisplayed();
		remove2.click();			
	}

	public boolean validateTaxonomyTitle() {
		TestUtil.viewportWebElement(addParagraph);
		return taxonomy.isDisplayed();
	}

	public boolean validateTaxonomyTags() {
		taxonomy.click();
		return tagsInput.isDisplayed();
	}

	public boolean validateRealTimeSEOforDrupalTitle() {
		return realTimeSEOTitle.isDisplayed();
	}

	public boolean validateFocusKeywordField() {
		return seoFocusKeyword.isDisplayed();
	}

	public boolean validateSaveButton() {
		return saveButton.isDisplayed();
	}
	public boolean validatesrijanLogo() {
		return srijanLogo.isDisplayed();
	}
	
	public boolean validateRevisionlogMessageLabel() {
		return revisionlogMessageLabel.isDisplayed();
	}

	public boolean validateRevisionlogMessageField() {
		return revisionlogMessageField.isDisplayed();
	}

	public boolean validateMenuSettings() {
		return menuSettings.isDisplayed();
	}

	public boolean validateMetaTags() {
		return metaTags.isDisplayed();
	}

	public boolean validateSimpleXmlSitemap() {
		return simpleXmlSitemap.isDisplayed();
	}

	public boolean validateSchedulingOptions() {
		return schedulingOptions.isDisplayed();
	}

	public boolean validateUrlAlias() {
		return urlAlias.isDisplayed();
	}

	public boolean validateAuthoringInformation() {
		return authoringInfo.isDisplayed();
	}

	public boolean validatePromotionOptions() {
		return promotionOptions.isDisplayed();
	}

	public boolean validateSaveAsField() {
		return saveAs.isDisplayed();
	}

}
