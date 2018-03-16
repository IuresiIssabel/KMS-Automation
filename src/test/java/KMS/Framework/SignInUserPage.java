package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInUserPage extends Pages {
    private WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement nextButtonForEmail;

    public SignInUserPage(WebDriver driver) {
        super(driver);

        Utilities.switchToSpecificTab(driver, 1);
        Utilities.waitForElementByLocator(driver, By.cssSelector("#identifierId"));
    }

    public void completeEmailField(WebDriver driver, String user) {
        typeInEmailField(driver, user);
        clickOnNextButtonForEmail(driver);
    }

    private void typeInEmailField(WebDriver driver, String emailValue) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.id("identifierId"), 10);

        emailField.clear();
        emailField.sendKeys(emailValue);
    }

    private void clickOnNextButtonForEmail(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.id("identifierNext"), 10);

        nextButtonForEmail.click();
    }
}
