package ar.com.levis.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.levis.pages.HomePage;
import base.TestBase;
import util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	// Test case should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser
	// I stayed at minute 1:21:01
	
	@BeforeMethod
	public void setUp() {
		initialization("levisar");
		homePage = new HomePage();
		testUtil = new TestUtil();
	}
	
	@Test(priority=1)
	public void MensCatalogLinkTest() {
		boolean flag = homePage.MensCatalogLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void WomensCatalogLinkTest() {
		boolean flag = homePage.WomensCatalogLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void KidsCatalogLinkTest() {
		boolean flag = homePage.KidsCatalogLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void KidsCatalogTitleTest() {
		homePage.GoToKidsCatalogPage();
		String title = testUtil.GetTitle();
		Assert.assertEquals(title, "Kids", "Login page title not matched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
