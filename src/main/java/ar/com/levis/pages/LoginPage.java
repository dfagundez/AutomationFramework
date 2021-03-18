package ar.com.levis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory:
	@FindBy(name="login[username]")
	WebElement username;
	
	@FindBy(name="login[password]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\'send2\']")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[@id=\'login-form\']/div[1]/div[1]/div/div/button")
	WebElement signupbutton;
	
	@FindBy(xpath="//*[@id=\'logo\']/i")
	WebElement levislogo;
	
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Get Information
	public boolean GetLogo() {
		return levislogo.isDisplayed();
	}
	
	// Actions
	public HomePage Login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		
		return new HomePage();
	}
}
