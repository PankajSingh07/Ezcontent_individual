package ezcontent.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ezcontent.qa.base.TestBase;
import ezcontent.qa.util.Wait;

public class DashboardPage extends TestBase {

	// Page Factory = Object Repository:

	@FindBy(id = "toolbar-item-user")
	WebElement editor;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;

	@FindBy(xpath = "//a[@id='toolbar-item-administration']")
	WebElement manage;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	WebElement content;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
	WebElement addContent;

	@FindBy(xpath = "//a[@class='toolbar-icon toolbar-icon-node-add-article']")
	WebElement article;

	@FindBy(xpath = "//img[@class='img-fluid d-inline-block align-top']")
	WebElement dashboardLogo;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateDashboardTitle() {
		return driver.getTitle();
	}

	public boolean validateDashboardLogo() {
		return dashboardLogo.isDisplayed();
	}

	public void clickArticleLink() {
		Actions actions = new Actions(driver);
		Wait.visibiltyOfElement(10, content);
		actions.moveToElement(content).perform();
		actions.moveToElement(addContent).perform();
		Wait.visibiltyOfElement(5, article);
		article.click();
	}

	public void logout() {
		editor.click();
		logout.click();
	}

}
