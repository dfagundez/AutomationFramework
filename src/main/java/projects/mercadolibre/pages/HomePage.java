package projects.mercadolibre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	// Page Factory:
	@FindBy(xpath="/html/body/header/div/form/input")
	WebElement SearchBox;
	
	@FindBy(xpath="/html/body/header/div/form/button")
	WebElement SearchButton;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public SearchResultsPage LookForSomething(String something) {
		SearchBox.sendKeys(something);
		SearchButton.click();
		return new SearchResultsPage();
	}
}
