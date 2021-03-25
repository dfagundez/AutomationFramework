package projects.kavakar;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestUtil;

public class KavakHomePageTest extends TestBase {

    WebDriver driver;
    TestUtil testUtil;

    @BeforeMethod
    public void setUp() {
        testUtil = new TestUtil();
        initialization("kavak","chrome");
    }

    @Test
    public void validateLinksTest() {
        boolean flag = testUtil.checkingPageLinks();
        Assert.assertTrue(flag, "There are broken links");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
