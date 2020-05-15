package ezcontent.qa.pages;


import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ArticleEmbedPage extends TestBase{
	
	
		
		@FindBy(xpath = "//a[@href='/admin/content']")
		WebElement Content;
		
		@FindBy(xpath = "//a[@href='/node/add']")
		WebElement addContent;
		
		@FindBy(xpath = "//a[@href='/node/add/article']")
		WebElement article;
		
		@FindBy(xpath = "//h1[@class='js-quickedit-page-title page-title']")
		WebElement articleHeading;
		
		@FindBy(className = "fieldset__label")
		List<WebElement> subSections;
		
		@FindBy(xpath = "//label[@class='form-item__label js-form-required form-required']")
		WebElement title;
		
		@FindBy(id = "edit-title-0-value")
		WebElement titleField;
		
		@FindBy(xpath = "//label[@for='edit-field-short-title-0-value']")
		WebElement shortTitle;
		
		@FindBy(id = "edit-field-short-title-0-value")
		WebElement shortTitleField;
		
		@FindBy(xpath = "//label[@for='edit-field-subhead-0-value']")
		WebElement subHead;
		
		@FindBy(id = "edit-field-subhead-0-value")
		WebElement subHeadField;
		
		@FindBy(xpath = "//label[@for='edit-field-author-target-id']")
		WebElement author;
		
		@FindBy(id= "autocomplete-deluxe-input")
		WebElement authorField;
		
		@FindBy(className = "ui-menu-item")
		WebElement authorAutoSuggestion;
		
		@FindBy(xpath = "//label[@for='edit-field-summary-0-value']")
		WebElement Summary;
		
		@FindBy(id= "edit-field-summary-0-value")
		WebElement summaryField;
		
		@FindBy(xpath = "//input[@id = 'edit-field-thumbnail-entity-browser-entity-browser-open-modal']")
		WebElement selectImageButton;
		
		@FindBy(id = "entity_browser_iframe_image_browser")
		WebElement iframeImage;
		
		@FindBy(xpath = "//div/div[@class = 'views-field views-field-thumbnail__target-id']")
		WebElement selectImage;
		
		@FindBy(xpath="//summary[text()='Thumbnail']")
		WebElement thumbnailLabel;
		
		@FindBy(xpath = "//div[@id = 'edit-actions']/input[@value='Select image(s)']")
		WebElement uploadImageButton;
		
		@FindBy(xpath = "//span[text() = 'Content']")
		WebElement content;
		
		@FindBy(xpath = "//input[@value='Add Paragraph']")
		WebElement paragraphButton;
		
		@FindBy(xpath = "//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li/input[@value='Embed']")
		WebElement selectEmbed;
		
		@FindBy(xpath = "//textarea[@required= 'required']")
		WebElement textBox;
		
		@FindBy(xpath = "//label[text() = 'Script']")
		WebElement Script;
		
		@FindBy(xpath = "//summary[text() = 'Taxonomy']")
		WebElement taxonomy;
		
		@FindBy(xpath = "//input[@id = 'autocomplete-deluxe-input--2']")
		WebElement tagTextField;
			
		@FindBy(xpath = "//input[@id = 'edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
		WebElement fieldKeyword;
		
		@FindBy(xpath = "//input[@value = 'Save']")
		WebElement saveButton;
		
		@FindBy(xpath = "//select[@id = 'edit-moderation-state-0-state']")
		WebElement saveAs;
		
		@FindBy(xpath = "//label[@for = 'edit-field-tags-target-id']")
		WebElement tag;
		
		@FindBy(xpath = "//div[@id = 'edit-field-yoast-seo-wrapper']/details/summary")
		WebElement realTime;
		
		@FindBy(xpath = "//label[@for = 'edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
		WebElement focusKeyword;
		
		@FindBy(xpath = "//div[@aria-label = 'Status message']")
		WebElement statusMessage;
		
//		@FindBy(xpath = "//details[@id = 'edit-menu']/summary")
//		WebElement menuSettings;
//		
//		@FindBy(xpath = "//details[@id = 'edit-field-meta-tags-0']/summary")
//		WebElement metaTags;
//		
//		@FindBy(xpath = "//details[@id = 'edit-simple-sitemap']/summary")
//		WebElement sitemap;
//		
//		@FindBy(xpath = "//details[@id = 'edit-scheduler-settings']/summary")
//		WebElement schedulingOptions;
//		
//		@FindBy(xpath = "//details[@id = 'edit-path-0']/summary")
//		WebElement alias;
//		
//		@FindBy(xpath = "//details[@id = 'edit-author']/summary")
//		WebElement authoringInformation;
//		
//		@FindBy(xpath = "//details[@id = 'edit-options']/summary")
//		WebElement promotionOption;
//		
//		@FindBy(xpath = "//div[@id = 'edit-advanced']/details/summary")
//		List<WebElement> menus;
		
		@FindBy(xpath="//summary[@class='claro-details__summary claro-details__summary--accordion-item']")
		List<WebElement> articleContentList;
		
		
		public ArticleEmbedPage(){
			
			PageFactory.initElements(driver, this);
		}

		public boolean validateMenu()
		{
			return Content.isDisplayed();
		}
		
		public boolean validateAddContent()
		{
			TestUtil.mouseHover(Content);
			return addContent.isDisplayed();
		}
		
		public boolean validateContentType() 
		{
			TestUtil.mouseHover(addContent);
			return article.isDisplayed();
		}
		
		public String verifyRedirectionToArticlePage()
		{
			TestUtil.mouseClick(article);
			return articleHeading.getText();
			
		}
		
		public List<String> verifySubSections()
		{ 
		  List<String> options = new ArrayList<String>();
		  for (WebElement webElement : subSections)
		  {
			 options.add(webElement.getText());
			  
		  }
		   return options;
		}
		
		public void verifyTitleField()
		{
			if (title.isDisplayed())
				titleField.sendKeys("Title Article ");
			else
				System.out.println("Title Field is not present");
			
		}
		
		public boolean verifyShortTitle()
		{
			shortTitleField.sendKeys("Article short title");
			return shortTitle.isDisplayed();
		}
		
		public String verifysubhead()
		{
			subHeadField.sendKeys("Article subhead");
			return subHead.getText();
			
		}
		
		public void verifyAuthorField()
		{
			if(author.isDisplayed())
			{
				authorField.sendKeys("fe");
				TestUtil.scroll(0, 200);
				Wait.visibiltyOfElement(2, authorAutoSuggestion);
				TestUtil.mouseClick(authorAutoSuggestion);
			}
			
			else
				System.out.println("Author Field is not present");
				
		}
		
		public String verifySummaryField()
		{
			summaryField.sendKeys("Article Summary");
			return Summary.getText();
		}
		
		public String selectImageFromThumbnail()
		{
			TestUtil.scroll(0, 500);
			TestUtil.mouseClick(selectImageButton);
            Wait.visibiltyOfElement(4, iframeImage);
			TestUtil.switchFrameByWebElement(iframeImage);
			TestUtil.mouseClick(selectImage);
			TestUtil.onClick(uploadImageButton);
			return thumbnailLabel.getText();
					
		}
        
		public void verifyAddParagraph()
		{
	
			TestUtil.scroll(0, 400);
			if(content.isDisplayed())
			{
			TestUtil.onClick(paragraphButton);
			 try {
				Wait.Pause(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			}
		}
		
		public void selectParagraph() {
			
			TestUtil.onClick(selectEmbed);
		   Wait.visibiltyOfElement(10, textBox);
		    if(Script.getText().equalsIgnoreCase("script"))
		    {
		      textBox.sendKeys("Article");
		    }
		    else 
		    	System.out.println("Script text area is not visible");
			
				
		}
		
		public void verifyTaxonomyField()
		{	

			TestUtil.scroll(0, 800);
			TestUtil.onClick(taxonomy);
			if(tag.isDisplayed())
			{
			  tagTextField.sendKeys("Drupal");
			  tagTextField.sendKeys(Keys.RETURN);	
			}
			else
				System.out.println("Tag Field is not appearing");
		}
		
		public String verifyFocusField()
		{
			if(focusKeyword.isDisplayed())
			{
			  fieldKeyword.sendKeys("This is focus");	
			}
			else
				System.out.println("Focus Field is not appearing");
			return realTime.getText();
		}
		
		public boolean saveasPublished()
		{
			TestUtil.selectByValue(saveAs, "published");
			TestUtil.onClick(saveButton);
			return statusMessage.isDisplayed();			
		}
		
//		public boolean verifyMenuSettings() {
//			 TestUtil.mouseClick(menuSettings);
//			 return menuSettings.isDisplayed();
//		}
//		
//		public boolean verifymetaTags() {
//			TestUtil.mouseClick(metaTags);
//			return metaTags.isDisplayed();
//		}
//		
//		public boolean verifysitemap() {
//			TestUtil.mouseClick(sitemap);
//			return sitemap.isDisplayed();
//		}
//		
//		public boolean verifyschedulingOptions() {
//			TestUtil.mouseClick(schedulingOptions);
//			return schedulingOptions.isDisplayed();
//		}
//		
//		public boolean verifyalias() {
//			TestUtil.mouseClick(alias);
//			return alias.isDisplayed();
//		}
//		
//		public boolean verifyauthoringInformation() { 
//			TestUtil.mouseClick(authoringInformation);
//			return authoringInformation.isDisplayed();
//		}
//		
//		public boolean verifypromotionOption() {
//			TestUtil.mouseClick(promotionOption);
//			return promotionOption.isDisplayed();
//		}
		
		  public boolean advancedMenuItem () {
				boolean result = false;
			    List<WebElement> menus = articleContentList;
			      for(int i =0;i< menus.size() ; i++) 
			      {
			          if(menus.get(i).isDisplayed())
			            {
		                     TestUtil.mouseClick(menus.get(i));
		                     System.out.println(menus.get(i).getText()); 
		                     result = true;  
			            }     	
			      }
			    if (result == false) 
			    {	
			       System.out.println("Advanced Menu Item is not found"); 
			    }
			 return result;    
			}
		
		
			
		
	}

