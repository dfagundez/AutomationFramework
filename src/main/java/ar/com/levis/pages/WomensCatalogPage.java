package ar.com.levis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomensCatalogPage {
	
	// Page Factory:
	@FindBy(xpath="//*[@id=\'the-18638\']/div[1]/a/img")
	WebElement FirstProduct;
		
	// Actions
	public SingleProductPage GoToSingleProductPage() {
			
		FirstProduct.click();
		return new SingleProductPage();
	}

}
