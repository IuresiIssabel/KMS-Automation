package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Base;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInUserPage extends Page {
    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(id = "identifierNext")
    private WebElement nextButtonForEmail;

    public SignInUserPage(WebDriver driver) {
        super(driver);

        Base.switchToSpecificTab(driver, 1);
        Wait.waitForElementByLocator(driver, By.cssSelector("#identifierId"));
    }

    public void completeEmailField(String user) {
        typeInEmailField(user);
        clickOnNextButtonForEmail();
    }

    private void typeInEmailField(String emailValue) {
        Wait.waitAfterElementToBeDisplayed(driver, By.id("identifierId"), 10);

        emailField.clear();
        emailField.sendKeys(emailValue);
    }

    private void clickOnNextButtonForEmail() {
        Wait.waitAfterElementToBeDisplayed(driver, By.id("identifierNext"), 10);

        nextButtonForEmail.click();
    }
}
