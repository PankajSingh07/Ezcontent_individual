package ezcontent.qa.pages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;


public class ArticleMapPage extends TestBase {
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
  WebElement content;
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
  WebElement addContent;
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-node-add-article']")
  WebElement article;
  @FindBy(xpath="//h1[@class='js-quickedit-page-title page-title']")
  WebElement createArticle;
  @FindBy(xpath="//fieldset[@class='required-fields field-group-fieldset fieldset js-form-item form-item js-form-wrapper form-wrapper']//span[@class='fieldset__label']")
  List <WebElement> subSections;
  @FindBy(xpath="//label[@class='form-item__label js-form-required form-required']")
  WebElement titleFieldLabel;
  @FindBy(xpath="//input[@id='edit-title-0-value']")
  WebElement titleField;
  @FindBy(xpath="//label[@for='edit-field-short-title-0-value']")
  WebElement subTitleFieldLabel;
  @FindBy(xpath="//input[@id='edit-field-short-title-0-value']")
  WebElement subTitleField;
  @FindBy(xpath="//label[@for='edit-field-subhead-0-value']")
  WebElement subheadLabel;
  @FindBy(xpath="//input[@id='edit-field-subhead-0-value']")
  WebElement subheadField;
  @FindBy(xpath="//label[@for='edit-field-author-target-id']")
  WebElement authorLabel;
  @FindBy(xpath="//input[@id='autocomplete-deluxe-input']")
  WebElement authorField;
  @FindBy(className="ui-menu-item")
  WebElement selectFemaleUser;
  @FindBy(xpath="//label[@for='edit-field-summary-0-value']")
  WebElement summaryLabel;
  @FindBy(xpath="//textarea[@id='edit-field-summary-0-value']")
  WebElement summaryField;
  @FindBy(xpath="//summary[text()='Thumbnail']")
  WebElement thumbnailLabel;
  @FindBy(xpath="//input[@class='button js-form-submit form-submit entity-browser-processed']")
  WebElement selectImagesButton;
  @FindBy(xpath="//iframe[@class='entity-browser-modal-iframe']")
  WebElement iframeImage;
  @FindBy(xpath="//img[@class='image-style-media-entity-browser-thumbnail']")
  WebElement selectImage;
  @FindBy(xpath="//input[@class='is-entity-browser-submit button button--primary js-form-submit form-submit']")
  WebElement clickOnSelectImageButton;
  @FindBy(xpath="//input[@type='submit' and @name='button_add_modal']")
   WebElement addParagraph;
  @FindBy(xpath="//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li/input[@value='Map']")
  WebElement selectMap;
  @FindBy(xpath="//label[text()='Google Map']")
  WebElement googleMapLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_map][0][value]']")
  WebElement googleMapField;
  @FindBy(xpath="//details[@class='required-fields field-group-details js-form-wrapper form-wrapper claro-details']/summary")
   WebElement taxonomy;	
  @FindBy(xpath="//label[text() = 'Tags']")
  WebElement tagsLabel;
  @FindBy(xpath="//input[@id='autocomplete-deluxe-input--2']")
  WebElement tagsField;
  @FindBy(xpath="//span[@class='autocomplete-deluxe-highlight-char']")
  WebElement selectTrumpTag;
  @FindBy(xpath="//label[@for='edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
  WebElement focusKeywordLabel ;
  @FindBy(xpath="//input[@id='edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
  WebElement focusKeyword ;
  @FindBy(xpath="//select[@id='edit-moderation-state-0-state']")
  WebElement dropdown;
  @FindBy(xpath="//input[@id='edit-submit']")
  WebElement published;
  @FindBy(xpath="//span[@class='field field--name-title field--type-string field--label-hidden quickedit-field']")
  WebElement articleCreated;
  @FindBy(xpath="//summary[@class='claro-details__summary claro-details__summary--accordion-item']")
   List<WebElement> articleContentList;
  @FindBy(xpath="//summary[text()='Simple XML Sitemap']")
  WebElement simpleXMLSiteMapLabel;
  @FindBy(xpath="//summary[text()='URL alias']")
  WebElement urlAliasLabel;
  @FindBy(xpath="//summary[text()='Authoring information']")
  WebElement authoringInformationLabel;
  @FindBy(xpath="//summary[text()='Promotion options']")
  WebElement promotionOptionsLabel;
  @FindBy(xpath="//label[text()='Revision log message']")
  WebElement revisionLogMessageLabel;
  @FindBy(xpath="//label[@for='edit-meta-changed']")
  WebElement lastSavedLabel;
  @FindBy(xpath="//label[@for='edit-meta-author']")
  WebElement authorLabel1;
  @FindBy(xpath="//summary[text()='Menu settings']")
  WebElement menuSettingsLabel;
  @FindBy(xpath="//summary[text()='Meta Tags']")
  WebElement metaTagsLabel;
  @FindBy(xpath="//summary[text()='Scheduling options']")
  WebElement schedulingOptionsLabel;
  @FindBy(xpath="//label[text()='Info Title']")
  WebElement infoTitleLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_title][0][value]']")
  WebElement infoTitleField;
  @FindBy(xpath="//label[text()='Short title']")
  WebElement shortTitleLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_short_title][0][value]']")
  WebElement shortTitleField;
  @FindBy(xpath="//label[text()='Info Body']")
  WebElement infoBodyLabel;
  @FindBy(xpath="//div[@class='cke_contents cke_reset']//iframe")
  WebElement infoBodyFieldIframe;
  @FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
  WebElement infoBodyField;
  @FindBy(xpath="//label[text()='URL']")
  WebElement urlLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_link][0][uri]']")
  WebElement urlField;
  @FindBy(xpath="//label[text()='Link text']")
  WebElement linkTextLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_link][0][title]']")
  WebElement linkTextField;
  
  
  public ArticleMapPage() throws IOException {
  	PageFactory.initElements(driver, this); 
   }
  public String contentHeading() {
    TestUtil.mouseHover(content);
    return content.getText();
   }
  public String mousehoverOnContent() {
  	TestUtil.mouseHover(content);
    return addContent.getText();
   }
  public boolean mousehoverOnAddContent() {
  	TestUtil.mouseHover(addContent);
    return article.isDisplayed();
   }
  public String mousehoverOnArticle() {
  	TestUtil.mouseClick(article);
    return createArticle.getText();
   }
  public List<String> verifySubSections() { 
  	List<String> options = new ArrayList<String>();
  	{ 
  	for (WebElement webElement : subSections) 
  		 options.add(webElement.getText());
  	  }
      return options;
      }
  public boolean enterTitleFieldData() {
		titleField.sendKeys("This is the Title field");
    return titleFieldLabel.isDisplayed();
	}
	public boolean subTitleFieldLabel() {
		subTitleField.sendKeys("This is the sub title field");
    return subTitleFieldLabel.isDisplayed();
	}
  public boolean enterSubheadFieldData() {
  	subheadField.sendKeys("This is the sub head field");
  	JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,200)","");
    return subheadLabel.isDisplayed();
  }
  public boolean enterAuthorFieldData()  {
    authorField.sendKeys("Femal");
    Wait.visibiltyOfElement(10, selectFemaleUser);
    TestUtil.mouseClick(selectFemaleUser);
    return authorLabel.isDisplayed();
  }
  public String enterSummaryFieldData() {
  	summaryField.sendKeys("This is the Summary Field");
    return summaryLabel.getText();
  }
  public String thumbnailLabel() {
    return thumbnailLabel.getText();
  }
  public void selectImages() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,400)","");
    Wait.Pause(2000);
    TestUtil.mouseClick(selectImagesButton);
    Wait.visibiltyOfElement(20, iframeImage);
    TestUtil.switchFrameByWebElement(iframeImage);
    Wait.Pause(4000);
    TestUtil.mouseClick(selectImage); 
    clickOnSelectImageButton.click(); 
    TestUtil.switchBackToWindow();
  }
  public void addParagraph() throws InterruptedException {
   JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,300)","");
    Wait.Pause(1000);
    TestUtil.mouseClick(addParagraph);
    selectMap.click();
    }
  public String enterinfoTitleFieldData() {
	  Wait.visibiltyOfElement(10, infoTitleField);
	  infoTitleField.sendKeys("This is the info title field");
	  return infoTitleLabel.getText();
  }
  public String entershortTitleFieldData() {
	  shortTitleField.sendKeys("This is the short title field");
	  return shortTitleLabel.getText();
  }
  public String enterInfoBodyFieldData() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
	    js.executeScript("window.scrollBy(0,400)","");
	  TestUtil.switchFrameByWebElement(infoBodyFieldIframe);
	  Wait.visibiltyOfElement(10, infoBodyField);
	  infoBodyField.sendKeys("This is the info body field");
	  TestUtil.switchBackToWindow();
	  return infoBodyLabel.getText();	
  }
   public String entergoogleMapFieldData() {
	  Wait.visibiltyOfElement(10,googleMapField );
	  googleMapField.sendKeys("This is the google map field");
	  return googleMapLabel.getText();
  }
   public String enterUrlFieldData() {
	  urlField.sendKeys("/node");
	  return urlLabel.getText();
  }
  public String enterLinkTextFieldData() {
	  linkTextField.sendKeys("This is the link text field");
	  return linkTextLabel.getText();
  }
  public boolean enterTagsFieldData() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("window.scrollBy(0,200)","");
		 Wait.visibiltyOfElement(10, taxonomy);
	     TestUtil.mouseClick(taxonomy);
		 tagsField.sendKeys("trump");
	     tagsField.sendKeys(Keys.RETURN);
	     return tagsLabel.isDisplayed();
    }
  public String enterFocusKeyword() {
	focusKeyword.sendKeys("This is the focus keyword");
	return focusKeywordLabel.getText();
	}
 // Approach 1 for Advanced menu
  public boolean advancedMenuItem () throws InterruptedException {
		boolean result = false;
	    List<WebElement> menus = articleContentList;
	    	for(int i =0;i< menus.size() ; i++) {
	      
	       if(menus.get(i).isDisplayed()); {
	       	 Wait.Pause(5000);
         TestUtil.mouseClick(menus.get(i));
         System.out.println(menus.get(i).getText()); 
         result = true;  
	      }   	
	    }
	   if (result == false) {
	  	 System.out.println("Advanced Menu Item is not found");
	    }
	  return result;  
	  }
//     Approach 2 for Advanced menu
//    public boolean simpleXMLSiteField() {
//	 	  TestUtil.mouseClick(simpleXMLSiteMapLabel);
//	 	  return simpleXMLSiteMapLabel.isDisplayed();
//	   }
//	   public boolean urlAliasField() {
//	 	  TestUtil.mouseClick(urlAliasLabel);
//	 	  return urlAliasLabel.isDisplayed();
//	   }
//	   public boolean authoringInformationField() {
//	 	  TestUtil.mouseClick(authoringInformationLabel);
//	 	  return authoringInformationLabel.isDisplayed();
//	   }
//	   public boolean promotionOptionsField() {
//	 	  TestUtil.mouseClick(promotionOptionsLabel);
//	 	  return promotionOptionsLabel.isDisplayed();
//	   }
//	   public boolean revisionLogMessageField() {
//	 	  return revisionLogMessageLabel.isDisplayed();
//	   }
//	   public boolean lastSavedField() {
//	 	  return lastSavedLabel.isDisplayed();
//	   }
//	   public boolean authorField1() {
//	 	  return authorLabel1.isDisplayed();
//	   }
//	   public boolean metaTagsField() {
//		   TestUtil.mouseClick(metaTagsLabel);
//		   return metaTagsLabel.isDisplayed();
//	   }
//	   public boolean schedulingOptionsField() {
//		   TestUtil.mouseClick(schedulingOptionsLabel);
//		   return schedulingOptionsLabel.isDisplayed();
//	   }
//	   public boolean menuSettingsField() {
//		   TestUtil.mouseClick(menuSettingsLabel);
//		   return menuSettingsLabel.isDisplayed();
//	   }
//   
   public boolean saveArticleContent() {
	TestUtil.selectByValue(dropdown, "published");
	TestUtil.onClick(published);
	try {
		Wait.Pause(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return articleCreated.isDisplayed();
	    }
   }
   
       

