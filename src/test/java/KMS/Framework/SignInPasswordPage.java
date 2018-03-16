package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage extends Pages {
    private WebDriver driver;

    @FindBy(css = "[name='password'")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement nextButton;

    public SignInPasswordPage(WebDriver driver) {
        super(driver);

        Utilities.switchToSpecificTab(driver, 1);
        Utilities.waitForElementByLocator(driver, By.cssSelector("[name='password'"));
    }

    public void completePasswordField(WebDriver driver, String password) {
        typeInPasswordField(driver, password);
        clickOnNextButtonForPassword(driver);
    }

    private void typeInPasswordField(WebDriver driver, String password) {
        Utilities.waitForElementByLocator(driver, By.cssSelector("[name='password'"));

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private ProjectsPage clickOnNextButtonForPassword(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.id("passwordNext"), 10);

        nextButton.click();

        Utilities.switchToSpecificTab(driver, 0);
        return PageFactory.initElements(driver, ProjectsPage.class);

    }

}
