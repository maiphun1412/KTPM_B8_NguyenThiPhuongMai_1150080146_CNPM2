package dtm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxWhiteBoxTest {

    WebDriver driver;
    TextBoxPage page;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        page = new TextBoxPage(driver);
    }

    @Test(description = "TC01 - Nhap du thong tin hop le")
    public void testValidInput() {
        page.fillAndSubmit(
                "Nguyen Van A",
                "test@gmail.com",
                "HCM City"
        );

        Assert.assertTrue(
                page.isOutputDisplayed(),
                "Ket qua phai hien thi voi du lieu hop le"
        );
    }

    @Test(description = "TC02 - Email sai dinh dang")
    public void testInvalidEmail() {
        page.fillAndSubmit(
                "Nguyen Van A",
                "abc123",
                "HCM City"
        );

        Assert.assertFalse(
                page.isOutputDisplayed(),
                "Email sai dinh dang thi khong duoc hien thi ket qua"
        );
    }

    @Test(description = "TC03 - Name rong van co the submit tren demoqa")
    public void testEmptyName() {
        page.fillAndSubmit(
                "",
                "test@gmail.com",
                "HCM City"
        );

        Assert.assertTrue(
                page.isOutputDisplayed(),
                "Trang demoqa van cho hien thi ket qua khi de trong name"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}