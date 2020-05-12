package ezcontent.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.TestUtil;
import ezcontent.qa.util.Wait;


public class BasicPage extends TestBase{
	
	
	// Page Factory = Object Repository:
	
	@FindBy(xpath = "//li[@class='menu-item menu-item--expanded']/a[@href='/admin/content']")
	WebElement content;

	@FindBy(xpath = "//li[@class='local-actions__item']/a[@href='/node/add']")
	WebElement addContent;
	
	@FindBy(xpath = "//dt/a[@href='/node/add/page']")
	WebElement basicPage;
	
	@FindBy(xpath = "//*[@class=\"page-logo-with-title\"]/a/img")
	WebElement logo;
	
	@FindBy(id = "edit-title-0-value")
	WebElement title;
	
	@FindBy(xpath = "//*[@title='Rich Text Editor, Body field']")
	WebElement bodyFrame;
	
	@FindBy(xpath = "//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement body;
	
	@FindBy(id = "edit-revision-log-0-value")
	WebElement RivisionMessage;
	
	@FindBy(xpath = "//*[@id='edit-menu']//summary[text()='Menu settings']")
	WebElement menuSetting;
	
	@FindBy(xpath = "//*[@id='edit-field-meta-tags-0']//summary[text()='Meta Tags']")
	WebElement metaTags;
	
	@FindBy(xpath = "//*[@id='edit-simple-sitemap']//summary[text()='Simple XML Sitemap']")
	WebElement xmlSiteMap;
	
	@FindBy(xpath = "//*[@id='edit-path-0']//summary[text()='URL alias']")
	WebElement urlAlias;
	
	@FindBy(xpath = "//*[@id='edit-author']//summary[text()='Authoring information']")
	WebElement authoringinfo;
	
	@FindBy(xpath = "//*[@id='edit-options']//summary[text()='Promotion options']")
	WebElement promotionOption;
	
	@FindBy(xpath= "//*[@class='js-quickedit-page-title title']")
	WebElement success;
	
	@FindBy(id = "edit-submit")
	WebElement save;
	
	
	// To initialize the page objects
	
	public BasicPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void dashboard() throws InterruptedException {
		content.click();
		WebElement element = addContent;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		basicPage.click();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public boolean title() {
		if(title.isDisplayed());{	
			title.sendKeys("Test");
			return true;
		}
		
		
		
	}
	public void body() throws InterruptedException {
		Wait.Pause(5000);
		driver.switchTo().frame(bodyFrame);
		body.sendKeys("Test");
		TestUtil.switchBackToWindow();
		save.click();
		
	}
	
	public boolean menus() {
		if(RivisionMessage.isDisplayed())
		{
	    RivisionMessage.sendKeys("test");
		}
	    TestUtil.scroll(0, 300);
		menuSetting.isDisplayed();
		metaTags.isDisplayed();
		xmlSiteMap.isDisplayed();
		promotionOption.isDisplayed();
		
		return true;
		}
		
		
		
		
	public String successfully() {
		return success.getText();
		
	}
		
		
	}


