package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginInUserPage extends WebDrivers {

    public LoginInUserPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "googleSignIn")
    private WebElement signInButton;

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(css = "[name='password'")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@role='button']//span[text()='Next']")
    private WebElement nextButton;

    public void clickOnSignInButton() {
        signInButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void typeInEmailField(String emailValue) {
        emailField.sendKeys(emailValue);
        nextButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void typeInPasswordField(String passwordValue) {
        passwordField.sendKeys(passwordValue);
        nextButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
