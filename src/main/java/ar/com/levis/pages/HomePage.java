package ar.com.levis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	// Page Factory:
	@FindBy(xpath="//*[@id=\'cat-hombre\']/a")
	WebElement MensCatalogButton;
	
	@FindBy(xpath="//*[@id='cat-mujer']/a")
	WebElement WomensCatalogButton;
	
	@FindBy(xpath="//*[@id=\'cat-kids\']/a")
	WebElement KidsCatalogButton;
	
	@FindBy(xpath="//*[@id=\'cat-sale\']/a")
	WebElement SaleCatalogButton;
	
	@FindBy(xpath="//*[@id=\'cat-stories\']/a")
	WebElement StoriesButton;
	
	@FindBy(xpath="//*[@id=\'lookbooks\']/a")
	WebElement LookbookButton;
	
	@FindBy(xpath="//*[@id=\'mi-cuenta\']/ul/li[1]/a")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[@id=\'mi-cuenta\']/a")
	WebElement MenuMyAccount;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Get Information
	public boolean MensCatalogLink() {
		return MensCatalogButton.isDisplayed();
	}
	
	public boolean WomensCatalogLink() {
		return WomensCatalogButton.isDisplayed();
	}
	
	public boolean KidsCatalogLink() {
		return KidsCatalogButton.isDisplayed();
	}
	
	// Actions
	public LoginPage GoToLoginPage() {
		Actions action = new Actions(driver);
		
		action.moveToElement(MenuMyAccount).moveToElement(LoginButton).click().build().perform();
		return new LoginPage();
	}
	
	public MensCatalogPage GoToMensCatalogPage() {
		MensCatalogButton.click();
		return new MensCatalogPage();
	}
	
	public WomensCatalogPage GoToWomensCatalogPage() {
		WomensCatalogButton.click();
		return new WomensCatalogPage();
	}
	
	public KidsCatalogPage GoToKidsCatalogPage() {
		KidsCatalogButton.click();
		return new KidsCatalogPage();
	}
	
	public SaleCatalogPage GoToSaleCatalogPage() {
		SaleCatalogButton.click();
		return new SaleCatalogPage();
	}
	
	public StoriesPage GoToStoriesCatalogPage() {
		StoriesButton.click();
		return new StoriesPage();
	}
	
	public LookBookPage GoToLookbookCatalogPage() {
		LookbookButton.click();
		return new LookBookPage();
	}
	
}
