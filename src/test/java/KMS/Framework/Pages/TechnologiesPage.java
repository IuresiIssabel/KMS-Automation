package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class TechnologiesPage extends WebDrivers {

    public TechnologiesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Technologies']")
    protected static WebElement technologiesTabButton;

    //Adding this element just for now, until the tab is fully functional.
    @FindBy(xpath = "//h2[text()='AngularJS']")
    protected static WebElement technologiesTabContent;

    public void clickOnTechnologiesTabButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) technologiesTabButton));
        technologiesTabButton.click();
    }

    public void verifyTechnologiesTabContent() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        longWait().until(ExpectedConditions.visibilityOf((WebElement) technologiesTabContent));
        assertTrue(projectPage.searchButton.isDisplayed());
//        assertTrue(technologiesTabContent.isDisplayed());
    }
}
