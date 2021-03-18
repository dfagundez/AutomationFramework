package ar.com.levis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class SingleProductPage extends TestBase {

	// Page Factory:
	@FindBy(xpath="//*[@id=\'attribute538\']")
	WebElement SizeSelection;
	
	@FindBy(xpath="//*[@id=\'input-quantity\']")
	WebElement QuantitySelection;
	
	@FindBy(xpath="//*[@id=\'opcionesproducto\']/div[1]/div/ul/li/a")
	WebElement ColorSelection;
	
	@FindBy(xpath="/html/body/main/form/article/div/section[2]/div[2]/div[3]/div[1]/select/option[2]")
	WebElement FirtSize;
	
	@FindBy(xpath="/html/body/main/form/article/div/section[2]/div[2]/div[3]/div[2]/select/option[1]")
	WebElement QuantityOne;
	
	// Actions
	public void SelectSize() {
		Actions action = new Actions(driver);	
		action.moveToElement(SizeSelection).build().perform();
		FirtSize.click();
	}
	
	public void SelectQuantity() {
		Actions action = new Actions(driver);		
		action.moveToElement(QuantitySelection).build().perform();
		QuantityOne.click();
	}
	
	public void SelectColor() {
		ColorSelection.click();
	}
}
