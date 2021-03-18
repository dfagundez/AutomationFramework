package ar.com.levis.testcases.scenarios;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.levis.pages.HomePage;
import ar.com.levis.pages.SingleProductPage;
import ar.com.levis.pages.WomensCatalogPage;
import base.TestBase;

public class SuccessfulPurchaseTest extends TestBase {
	WomensCatalogPage womensCatalogPage;
	SingleProductPage singleProductPage;
	HomePage homePage;
	
	public SuccessfulPurchaseTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization("levisar");
		homePage = new HomePage();
		womensCatalogPage = homePage.GoToWomensCatalogPage();
		singleProductPage = womensCatalogPage.GoToSingleProductPage();
		singleProductPage.SelectColor();
		singleProductPage.SelectQuantity();
		singleProductPage.SelectSize();
	}
	
	@Test(priority=1)
	public void confirmationOfSuccessfulPurchaseTest() {
		String purchaseConfirmationMessage = "Acceso del cliente";
		Assert.assertEquals(purchaseConfirmationMessage, "Su compra fue realizada con exito", "The purchase could not be made");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
