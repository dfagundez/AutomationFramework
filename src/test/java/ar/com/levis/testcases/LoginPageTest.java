package ar.com.levis.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.levis.pages.HomePage;
import ar.com.levis.pages.LoginPage;
import base.TestBase;
import util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization("levisar");
		homePage = new HomePage();
		testUtil = new TestUtil();
		loginPage = homePage.GoToLoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = testUtil.GetTitle();
		Assert.assertEquals(title, "Acceso del cliente", "Login page title not matched");
	}
	
	@Test(priority=2)
	public void levisLogoTest() {
		boolean flag = loginPage.GetLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		// Assert is missing
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
