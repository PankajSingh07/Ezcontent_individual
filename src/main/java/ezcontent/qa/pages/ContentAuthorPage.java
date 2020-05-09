package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;

public class ContentAuthorPage extends TestBase{
	
//	
//	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-menu trigger toolbar-item is-active']")
//	WebElement Manage;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	WebElement Content;

	@FindBy(linkText = "Add content")
	WebElement AddContent;

	@FindBy(linkText = "Author")
	WebElement Author;
	
	@FindBy(xpath = "//h1[@class='js-quickedit-page-title page-title']")
	WebElement header;
		
	@FindBy(id = "edit-title-0-value")
	WebElement FullName;
	
	@FindBy(xpath = "//summary[contains(text(),'Avatar')]")
	WebElement Avatar;
	
	@FindBy(xpath = "//input[@name='field_thumbnail_entity_browser_entity_browser']")
	WebElement selectimagebutton;
	
	@FindBy(xpath= "//iframe[@id='entity_browser_iframe_image_browser']")
	WebElement authorAvatarFrame;
	
	
	@FindBy(xpath = "(//div[@class='views-row'])[1]")
	WebElement imageSelect;
	
	
	@FindBy(xpath = "//input[@id='edit-submit']")
	WebElement imageSelectbutton;
	

	@FindBy(xpath = "//*[contains(text(),'Edit summary')]")  
	WebElement summary;
	
	
	@FindBy(xpath = "//*[@id='edit-body-0-summary']") 
	WebElement entersummary;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")  
	WebElement bioframe;
	
	@FindBy(xpath = "//body//p")
	WebElement enterbiobody;
	
	@FindBy(xpath = "//*[@id='edit-status-value']")  
	WebElement publish;
	
	@FindBy(xpath = "//input[@name='op']")
	WebElement save;
	
	public ContentAuthorPage() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public void reachToAuthorPage() throws InterruptedException {
		

		Wait.Pause(2000);
		TestUtil.mouseHover(Content);
		TestUtil.mouseHover(AddContent);
		Author.click();
 		
	}
	
	public String validateWindowTabTitle() {
		return driver.getTitle();
	}
	
	public String validateHeaderTitle() {
		return header.getText();
	}
	
	
	public void enterFullName(String fn) {
		FullName.sendKeys(fn);
	}
	
	public void uploadImage() throws InterruptedException {
	
		Avatar.click();
		selectimagebutton.click();
		Wait.Pause(5000);
		TestUtil.switchFrameByWebElement(authorAvatarFrame);
		System.out.println("In frame");
		
		
		imageSelect.click();	
		Wait.Pause(2000);
		imageSelectbutton.click();
		TestUtil.switchBackToWindow();
		System.out.println("On default page");
		Wait.Pause(2000);
	}
	
	public void summaryEntry(String sum) throws InterruptedException {
		
		summary.click();
		entersummary.sendKeys(sum);	
	}
	
	public void bioEntry(String bio) {
		TestUtil.switchFrameByWebElement(bioframe);
		System.out.println("In frame BIO");
		enterbiobody.sendKeys(bio);	
		TestUtil.switchBackToWindow();
		System.out.println("On default page");
	}
	
	public void unpublish() {
		publish.click();
	}
	
	public void saveContent() {
		save.click();
	}
	
		
	
	
}
