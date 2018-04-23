package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private WebElement dataHistoryDetailsBtn;

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

    //TODO: try to make the xpaths more smarter and not that many

    @FindBy(xpath = "(//div[text()='Uptime percentage'])[2]")
    private static WebElement dataHistoryUptimePercentageMetric;

    @FindBy(xpath = "(//div[text()='Production Open / Closed Rate'])[2]")
    private static WebElement dataHistoryProductionOpenCloseRateMetric;

    @FindBy(xpath = "(//div[text()='Application Crash Rate'])[2]")
    private static WebElement dataHistoryApplicationCrashRateMetric;

    @FindBy(xpath = "(//div[text()='Maintainability index'])[2]")
    private static WebElement dataHistoryMaintainabilityIndexMetric;

    @FindBy(xpath = "(//div[text()='Automatic provisioning'])[2]")
    private static WebElement dataHistoryAutomaticProvisioningMetric;

    @FindBy(xpath = "(//div[text()='Configurability'])[2]")
    private static WebElement dataHistoryConfigurabilityMetric;

    @FindBy(xpath = "(//div[text()='Installation documentation'])[2]")
    private static WebElement dataHistoryInstallationDocumentationMetric;

    @FindBy(xpath = "(//div[text()='Standard checklist for deployment'])[2]")
    private static WebElement dataHistoryStandardChecklistForDeploymentMetric;

    @FindBy(xpath = "(//div[text()='Needed downtime'])[2]")
    private static WebElement dataHistoryNeededDowntimeMetric;

    @FindBy(xpath = "(//div[text()='Deployment time'])[2]")
    private static WebElement dataHistoryDeploymentTimeMetric;

    @FindBy(xpath = "(//div[text()='Sprint commitment completion'])[2]")
    private static WebElement dataHistorySprintCommitmentCompletionMetric;

    @FindBy(xpath = "(//div[text()='Checklist'])[2]")
    private static WebElement dataHistoryChecklistMetric;

    @FindBy(xpath = "(//div[text()='Guidline available'])[2]")
    private static WebElement dataHistoryGuildlineAvailableMetric;

    @FindBy(xpath = "(//div[text()='Stability']/following-sibling::img[contains(@src, 'image/png')])[2]")
    private static WebElement dataHistoryStabilityCommentsButton;

    @FindBy(xpath = "(//div[text()='Maintenance']/following-sibling::img[contains(@src, 'image/png')])[2]")
    private static WebElement dataHistoryMaintenanceCommentsButton;

    @FindBy(xpath = "(//div[text()='Delivery_efficiency']/following-sibling::img[contains(@src, 'image/png')])[2]")
    private static WebElement dataHistoryDeliveryEfficiencyCommentsButton;

    @FindBy(xpath = "(//div[text()='Performance']/following-sibling::img[contains(@src, 'image/png')])[2]")
    private static WebElement dataHistoryPerformanceCommentsButton;

    @FindBy(xpath = "(//div[text()='Security']/following-sibling::img[contains(@src, 'image/png')])[2]")
    private static WebElement dataHistorySecurityCommentsButton;

    @FindBy(xpath = "//div[contains(./img/@src,'data:image')]//button")
    protected static WebElement projectLogoButton;

    @FindBy(xpath = "//div[contains(./img/@src,'data:image') and ./button]")
    protected static WebElement projectLogoImage;

    @FindBy(xpath = "//span[text()='Edit Project Logo']")
    protected static WebElement projectLogoPopupTitle;

    @FindBy(xpath = "(//span[text()='Drop files here, paste or '])[2]")
    protected static WebElement projectLogoPopupDetails;

    @FindBy(xpath = "(//span[text()='Drop files here, paste or ']/button)[2]")
    protected static WebElement projectLogoPopupBrowseButton;

    @FindBy(xpath = "//span[text()='CANCEL']")
    protected static WebElement projectLogoPopupCancelButton;

    @FindBy(xpath = "//span[text()='SAVE']")
    protected static WebElement projectLogoPopupSaveButton;

    @FindBy(xpath = "//a[text()='Add Historical Data']")
    protected static WebElement addHistoricalDataButton;

    @FindBy(name = "historical-date")
    private static WebElement historicalDataInput;

    public void clickOnProjectDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) projectDetailsButton));
        projectDetailsButton.click();
    }

    public void clickOnDataHistoryDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) dataHistoryDetailsBtn));
        dataHistoryDetailsBtn.click();
    }

    public void clickOnProjectLogoButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) projectLogoButton));
        projectLogoButton.click();
    }

    public void clickOnAddHistoricalDataButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) addHistoricalDataButton));
        addHistoricalDataButton.click();
    }

    public void verifyDataHistoryColumnHeader() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDayColumn));
        HashMap<WebElement, String> dataHistoryColumnHeaders = new HashMap<>();

        dataHistoryColumnHeaders.put(dataHistoryDayColumnHeader, data.getColumn1());
        dataHistoryColumnHeaders.put(dataHistoryOverallScoreColumnHeader, data.getColumn2());
        dataHistoryColumnHeaders.put(dataHistoryStabilityColumnHeader, data.getMetricTitle1());
        dataHistoryColumnHeaders.put(dataHistoryMaintenanceColumnHeader, data.getMetricTitle2());
        dataHistoryColumnHeaders.put(dataHistoryDeliveryEfficiencyColumnHeader, data.getMetricTitle3());
        dataHistoryColumnHeaders.put(dataHistoryPerformanceColumnHeader, data.getMetricTitle4());
        dataHistoryColumnHeaders.put(dataHistorySecurityColumnHeader, data.getMetricTitle5());
        dataHistoryColumnHeaders.put(dataHistoryOptionsColumn, data.getColumn3());

        for (Map.Entry<WebElement, String> entry : dataHistoryColumnHeaders.entrySet()) {
            assertTrue(entry.getKey().isDisplayed());
            String columnTitlesVerify = entry.getKey().getText();
            Assert.assertEquals(columnTitlesVerify, entry.getValue());
        }
    }

    public void verifyDataHistoryColumnInfo() {
        List<WebElement> dataHistoryColumnInfo = driver.findElements(By.xpath(
                "//div[./div/div/div/p/text()='Day']/following-sibling::div//p"));

        for (WebElement columnInformation : dataHistoryColumnInfo) {
            assertTrue(columnInformation.isDisplayed());
        }
    }

    public void verifyDataHistoryScoreCardMetricTitles() {
        String[] metricTitles = {data.getMetricTitle1(), data.getMetricTitle2(), data.getMetricTitle3(),
                data.getMetricTitle4(), data.getMetricTitle5()};
        String[] metricLabels = {data.getMetricCategory1(), data.getMetricCategory2(), data.getMetricCategory3(),
                data.getMetricCategory4(), data.getMetricCategory5()};

        for (String titles : metricTitles) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement dataHistoryMetricTitles = driver.findElement(By.xpath("(//div[text()='" + titles + "'])[2]"));
            assertTrue(dataHistoryMetricTitles.isDisplayed());

            //TODO - verify the labels
//            String getMetricLabel = dataHistoryMetricTitles.getText();
//            Assert.assertEquals(getMetricLabel, metricLabels);
        }
    }

    public void verifyDataHistoryMetricNames() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryStabilityColumnHeader));

        WebElement[] metricTitle = {
                dataHistoryUptimePercentageMetric, dataHistoryProductionOpenCloseRateMetric,
                dataHistoryApplicationCrashRateMetric, dataHistoryMaintainabilityIndexMetric,
                dataHistoryAutomaticProvisioningMetric, dataHistoryConfigurabilityMetric,
                dataHistoryInstallationDocumentationMetric, dataHistoryStandardChecklistForDeploymentMetric,
                dataHistoryNeededDowntimeMetric, dataHistoryDeploymentTimeMetric,
                dataHistorySprintCommitmentCompletionMetric, dataHistoryChecklistMetric, dataHistoryGuildlineAvailableMetric
        };

        for (WebElement verifyTitles : metricTitle) {
            assertTrue(verifyTitles.isDisplayed());
        }
    }

    public void verifyDataHistoryCommentsTab() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryStabilityColumnHeader));

        WebElement[] dataHistoryMetricsCommentButton = {
                dataHistoryStabilityCommentsButton, dataHistoryMaintenanceCommentsButton, dataHistoryDeliveryEfficiencyCommentsButton,
                dataHistoryPerformanceCommentsButton, dataHistorySecurityCommentsButton
        };

        for (WebElement commentsSection : dataHistoryMetricsCommentButton) {
            commentsSection.click();
            longWait().until(ExpectedConditions.visibilityOf((WebElement) projectPage.commentsTabTitle));
            assertTrue(projectPage.commentsTabTitle.isDisplayed());
            projectPage.verifyMetricComments();
            projectPage.closteCommentsTab.click();
        }
    }

    public void verifyProjectLogo() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) projectLogoButton));
        assertTrue(projectLogoImage.isDisplayed());
        assertTrue(projectLogoButton.isDisplayed());
    }

    public void verifyProjectLogoPopupElements() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) projectLogoPopupBrowseButton));

        WebElement[] logoPopupElements = {projectLogoPopupTitle, projectLogoPopupDetails, projectLogoPopupBrowseButton,
                projectLogoPopupCancelButton, projectLogoPopupSaveButton};

        for (WebElement popupElements : logoPopupElements) {
            assertTrue(popupElements.isDisplayed());
        }
    }

    public void verifyTheProjectWasPlublishedWithSuccesInDataHistory() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDetailsBtn));
        int numberOfElementsFoundAfter = driver.findElements(By.xpath((("//span[text()='Detail']")))).size();
        projectPage.clickOnProjectsTab();
        projectPage.searchForAProject(data.getKmsAutoProjectName());
        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.clickOnPublishProjectButton();
        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDetailsBtn));
        int numberOfElementsFoundBefore = driver.findElements(By.xpath((("//span[text()='Detail']")))).size();
        assert numberOfElementsFoundBefore > numberOfElementsFoundAfter;
    }

    public void verifyHistoricalDataWasPublishedWithSuccess() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDetailsBtn));
        int numberOfElementsFoundAfter = driver.findElements(By.xpath((("//span[text()='Detail']")))).size();

        clickOnAddHistoricalDataButton();
        longWait().until(ExpectedConditions.visibilityOf((WebElement) historicalDataInput));
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String myPCDate = dateFormat.format(date);
        historicalDataInput.sendKeys(myPCDate);
        updateProjectPage.updateAProject(
                data.getKmsAutoProjectName(), data.getEMField2(), data.getDoEField2(), data.getClientField2());

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();

        longWait().until(ExpectedConditions.visibilityOf((WebElement) dataHistoryDetailsBtn));
        int numberOfElementsFoundBefore = driver.findElements(By.xpath((("//span[text()='Detail']")))).size();
        assert numberOfElementsFoundBefore > numberOfElementsFoundAfter;
    }
}
