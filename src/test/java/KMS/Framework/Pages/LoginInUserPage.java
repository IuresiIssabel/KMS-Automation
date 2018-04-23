package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public void typeInEmailField() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) emailField));
        emailField.sendKeys(data.getUsername());
        nextButton.click();

        longWait().until(ExpectedConditions.visibilityOf(passwordField));
    }

    public void typeInPasswordField() {
        passwordField.sendKeys(data.getPassword());
        try {
            Thread.sleep(1000);
            nextButton.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
