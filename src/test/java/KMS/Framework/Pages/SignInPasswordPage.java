package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Base;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage extends Page {

    @FindBy(css = "[name='password'")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement nextButton;

    public SignInPasswordPage(WebDriver driver) {
        super(driver);

        Base.switchToSpecificTab(driver, 1);
        Wait.waitForElementByLocator(driver, By.cssSelector("[name='password'"));
    }

    public void completePasswordField(String password) {
        typeInPasswordField(password);
        clickOnNextButtonForPassword();
    }

    private void typeInPasswordField(String password) {
        Wait.waitForElementByLocator(driver, By.cssSelector("[name='password'"));

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void clickOnNextButtonForPassword() {
        Wait.waitAfterElementToBeDisplayed(driver, By.id("passwordNext"), 10);

        nextButton.click();

        Base.switchToSpecificTab(driver, 0);
        PageFactory.initElements(driver, ProjectsPage.class);
    }

}
