package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProjectDetailsPage extends WebDrivers {

    public ProjectDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    @FindBy(xpath = "//div[contains(text(),'Stability')]")
    private WebElement stabilityMetricLabel;


    public void clickOnProjectDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) projectDetailsButton));
        projectDetailsButton.click();
    }

    public void verifyIfStabilityMetricIsDisplayed() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) stabilityMetricLabel));
        String stabilityText = stabilityMetricLabel.getText();
        Assert.assertEquals(stabilityText, "STABILITY");
        stabilityMetricLabel.isDisplayed();
    }
}
