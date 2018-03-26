package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page {

    @FindBy(id = "googleSignIn")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);

        Wait.waitForElementByLocator(driver, By.cssSelector("#googleSignIn"));
    }

    public void clickOnSignInButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("#googleSignIn"), 10);

        signInButton.click();
    }
}
