package ezcontent.qa.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleGalleryPage extends TestBase {

	@FindBy(xpath = "//div[@class = 'paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li[3]/input")
	WebElement Gallery;
	
	@FindBy(xpath  = "//div[@class='paragraphs-subform js-form-wrapper form-wrapper']/div/div/label")
	WebElement Title;
	
	@FindBy(xpath = "//div[@class= 'paragraphs-subform js-form-wrapper form-wrapper']/div/div/input")
	WebElement TitleField;
	
	@FindBy(xpath = "//details[@required = 'required']/summary")
	WebElement mediaItem;
	
	@FindBy(xpath = "//input[@name = 'field_content_0_subform_field_media_items_entity_browser_entity_browser']")
	WebElement selectImageButton;
	
	@FindBy(id = "entity_browser_iframe_image_browser")
	WebElement iframeImage;
	
	@FindBy(xpath = "//div/div[@class = 'views-field views-field-thumbnail__target-id']")
	WebElement selectImage;
	
	@FindBy(xpath = "//div[@id = 'edit-actions']/input[@value='Select image(s)']")
	WebElement uploadImageButton;
	
	@FindBy(xpath = "//div[@class ='cke_inner cke_reset']//iframe")
	WebElement iframeEditor;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    WebElement textBody;
	
	public ArticleGalleryPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMenu()
	{
		return embed.validateMenu();
	}
	
	public boolean validateAddContent()
	{
		return embed.validateAddContent();
	}
	
	public boolean validateContentType() {
		
		return embed.validateContentType();
	}
	
	public String verifyRedirectionToArticlePage() {
		
		return embed.verifyRedirectionToArticlePage();
	}
	
	public void verifyTitleField() {
		embed.verifyTitleField();
	}
	
	public boolean verifyShortTitle() {
		return embed.verifyShortTitle();
	}
	
	public String verifysubhead() {
		return embed.verifysubhead();
	}
	
	public void verifyAuthorField( ) {
		embed.verifyAuthorField();
	}
	
	public String verifySummaryField() {
		return embed.verifySummaryField();
	}
	
	public String selectImageFromThumbnail() {
		return embed.selectImageFromThumbnail();
	}
	
	public void verifyaddparagraph() {
		embed.verifyAddParagraph();
	}
	
	public boolean selectParagraph() {
		TestUtil.onClick(Gallery);
		Wait.visibiltyOfElement(5, Title);
        if(Title.isDisplayed())
	    {
	    	TitleField.sendKeys("Title Text");
	    }
	    if (mediaItem.isDisplayed()) {
	    	TestUtil.scroll(0, 200);
	    	TestUtil.onClick(selectImageButton);
	        Wait.visibiltyOfElement(3, iframeImage);
	    	TestUtil.switchFrameByWebElement(iframeImage);
	    	TestUtil.mouseClick(selectImage);
	    	TestUtil.onClick(uploadImageButton);
	    	TestUtil.switchBackToWindow();
	    
	    }
	   
	    TestUtil.switchFrameByWebElement(iframeEditor);
	    textBody.sendKeys("This is editor");
	    TestUtil.switchBackToWindow();
	    
	 return mediaItem.isDisplayed();
	}
	
	
	
	public void verifyTaxonomyField() {
		embed.verifyTaxonomyField();
	}
	
	public String verifyFocusField() {
		return embed.verifyFocusField();
	}
	
	public boolean saveasPublished() {

		return embed.saveasPublished();
	}
	
	public boolean advancedMenuItem() {
		return embed.advancedMenuItem();
	}


}
