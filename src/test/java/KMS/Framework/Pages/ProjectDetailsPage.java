package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class ProjectDetailsPage extends WebDrivers {

    public ProjectDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    @FindBy(xpath = "//span[text()='Detail']")
    private WebElement dataHistoryDetails;

    @FindBy(xpath = "//p[contains(text(), 'Day')]")
    private WebElement dataHistoryDayColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Overall Score')]")
    private WebElement dataHistoryOverallScoreColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Stability')]")
    private WebElement dataHistoryStabilityColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Maintenance')]")
    private WebElement dataHistoryMaintenanceColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Delivery_efficiency')]")
    private WebElement dataHistoryDeliveryEfficiencyColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Performance')]")
    private WebElement dataHistoryPerformanceColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Security')]")
    private WebElement dataHistorySecurityColumnHeader;

    @FindBy(xpath = "//p[contains(text(), 'Options')]")
    private WebElement dataHistoryOptionsColumn;

    @FindBy(xpath = "//div[./div/div/div/p/text()='Day']/following-sibling::div//p")
    private WebElement dataHistoryDayColumn;

    @FindBy(xpath = "//span[contains(./img/@src, 'image/png')]")
    private WebElement uploadProjectLogoButton;

    public void clickOnProjectDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) projectDetailsButton));
        projectDetailsButton.click();
    }

    public void verifyDataHistoryColumnHeader() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDayColumn));
        HashMap<WebElement, String> dataHistoryColumnHeaders = new HashMap<>();

        dataHistoryColumnHeaders.put
                (dataHistoryDayColumnHeader, data.getColumn1());
        dataHistoryColumnHeaders.put
                (dataHistoryOverallScoreColumnHeader, data.getColumn2());
        dataHistoryColumnHeaders.put
                (dataHistoryStabilityColumnHeader, data.getColumn3());
        dataHistoryColumnHeaders.put
                (dataHistoryMaintenanceColumnHeader, data.getColumn4());
        dataHistoryColumnHeaders.put
                (dataHistoryDeliveryEfficiencyColumnHeader, data.getColumn5());
        dataHistoryColumnHeaders.put
                (dataHistoryPerformanceColumnHeader, data.getColumn6());
        dataHistoryColumnHeaders.put
                (dataHistorySecurityColumnHeader, data.getColumn7());
        dataHistoryColumnHeaders.put
                (dataHistoryOptionsColumn, data.getColumn8());

        for (Map.Entry<WebElement, String> entry : dataHistoryColumnHeaders.entrySet()) {
            assertTrue(entry.getKey().isDisplayed());
            String columnTitlesVerify = entry.getKey().getText();
            Assert.assertEquals(columnTitlesVerify, entry.getValue());
        }
    }

    public void verifyDataHistoryColumnInfo() {
        List<WebElement> dataHistoryColumnInfo = driver.findElements(By.xpath(
                "//div[./div/div/div/p/text()='Day']/following-sibling::div//p"));

        for (WebElement columnInformation : dataHistoryColumnInfo){
            assertTrue(columnInformation.isDisplayed());
        }
    }
}
