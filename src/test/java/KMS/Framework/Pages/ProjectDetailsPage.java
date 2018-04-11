package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ProjectDetailsPage extends WebDrivers {

    public ProjectDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    @FindBy(xpath = "//div[contains(text(),'Stability')]")
    private WebElement stabilityMetricLabel;
    @FindBy(xpath = "//div[contains(text(),'Maintenance')]")
    private WebElement maintenanceMetricLabel;
    @FindBy(xpath = "//div[contains(text(),'Delivery_efficiency')]")
    private WebElement deliveryEfficiencyMetricLabel;
    @FindBy(xpath = "//div[contains(text(),'Performance')]")
    private WebElement perfomanceMetricLabel;
    @FindBy(xpath = "//div[contains(text(),'Security')]")
    private WebElement securityMetricLabel;


    public void clickOnProjectDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) projectDetailsButton));
        projectDetailsButton.click();
    }

    public void verifyIfMetricTitlesAreDisplayed() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) stabilityMetricLabel));

        HashMap<WebElement, String> metricTitles = new HashMap<>();
        metricTitles.put(stabilityMetricLabel, "STABILITY");
        metricTitles.put(maintenanceMetricLabel, "MAINTENANCE");
        metricTitles.put(deliveryEfficiencyMetricLabel, "DELIVERY_EFFICIENCY");
        metricTitles.put(perfomanceMetricLabel, "PERFORMANCE");
        metricTitles.put(securityMetricLabel, "SECURITY");

        for (Map.Entry<WebElement, String> entry : metricTitles.entrySet()) {
            String stabilityText = entry.getKey().getText();
            Assert.assertEquals(stabilityText, entry.getValue());
        }
    }
}
