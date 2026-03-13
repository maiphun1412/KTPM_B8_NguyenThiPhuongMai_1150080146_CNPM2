package dtm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userName")
    private WebElement nameField;

    @FindBy(id="userEmail")
    private WebElement emailField;

    @FindBy(id="currentAddress")
    private WebElement currentAddressField;

    @FindBy(id="submit")
    private WebElement submitBtn;

    @FindBy(id="output")
    private WebElement outputSection;

    public void fillAndSubmit(String name, String email, String address){

        nameField.sendKeys(name);
        emailField.sendKeys(email);
        currentAddressField.sendKeys(address);
        submitBtn.click();

    }

    public boolean isOutputDisplayed(){

        return outputSection.isDisplayed();

    }

}