package dtm;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public void testLoginPageTitle() {
        String title = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}