package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Pages {

    @FindBy(id = "googleSignIn")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);

        Utilities.waitForElementByLocator(driver, By.cssSelector("#googleSignIn"));
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
}
