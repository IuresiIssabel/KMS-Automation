package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProjectPage extends WebDrivers {

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".search-button")
    protected static WebElement searchButton;

    @FindBy(css = "[name='search']")
    protected static WebElement searchField;

    @FindBy(xpath = "//div[@class='project-name']")
    protected static WebElement projectNameElement;

    @FindBy(xpath = "//span[text()='Projects']")
    private static WebElement projectsTabButton;

    @FindBy(xpath = "//span[text()='Reports']")
    private static WebElement reportsTabButton;

    @FindBy(xpath = "//button[text()='Download']")
    private static WebElement downloadPDFButton;

    @FindBy(xpath = "//img[contains(@src, 'data:image/png')]")
    private static WebElement threePillarGlobalLogo;

    @FindBy(xpath = "//div[text()='KMS']")
    private static WebElement titleOfTheWebPage;

    @FindBy(xpath = "//div[text()='Knowledge Management System']")
    private static WebElement subTitleOfTheWebPage;

    @FindBy(xpath = "//div[text()='KMS Automation']")
    private static WebElement usersName;

    @FindBy(className = "drop-down-list")
    private static WebElement soryByDropDown;

//    @FindBy(xpath = "//div[text()='%s']")
//    private static WebElement projectMetricTitle;

    @FindBy(xpath = "//div[text()='Uptime percentage']")
    private static WebElement uptimePercentageMetric;

    @FindBy(xpath = "//div[text()='Production Open / Closed Rate']")
    private static WebElement productionOpenCloseRateMetric;

    @FindBy(xpath = "//div[text()='Application Crash Rate']")
    private static WebElement applicationCrashRateMetric;

    @FindBy(xpath = "//div[text()='Maintainability index']")
    private static WebElement maintainabilityIndexMetric;

    @FindBy(xpath = "//div[text()='Automatic provisioning']")
    private static WebElement automaticProvisioningMetric;

    @FindBy(xpath = "//div[text()='Configurability']")
    private static WebElement configurabilityMetric;

    @FindBy(xpath = "//div[text()='Installation documentation']")
    private static WebElement installationDocumentationMetric;

    @FindBy(xpath = "//div[text()='Standard checklist for deployment']")
    private static WebElement standardChecklistForDeploymentMetric;

    @FindBy(xpath = "//div[text()='Needed downtime']")
    private static WebElement neededDowntimeMetric;

    @FindBy(xpath = "//div[text()='Deployment time']")
    private static WebElement deploymentTimeMetric;

    @FindBy(xpath = "//div[text()='Sprint commitment completion']")
    private static WebElement sprintCommitmentCompletionMetric;

    @FindBy(xpath = "//div[text()='Checklist']")
    private static WebElement checklistMetric;

    @FindBy(xpath = "//div[text()='Guidline available']")
    private static WebElement guildlineAvailableMetric;

    @FindBy(xpath = "//div[text()='Stability']/following-sibling::img[contains(@src, 'image/png')]")
    private static WebElement stabilityCommentsButton;

    @FindBy(xpath = "//div[text()='Maintenance']/following-sibling::img[contains(@src, 'image/png')]")
    private static WebElement maintenanceCommentsButton;

    @FindBy(xpath = "//div[text()='Delivery_efficiency']/following-sibling::img[contains(@src, 'image/png')]")
    private static WebElement deliveryEfficiencyCommentsButton;

    @FindBy(xpath = "//div[text()='Performance']/following-sibling::img[contains(@src, 'image/png')]")
    private static WebElement performanceCommentsButton;

    @FindBy(xpath = "//div[text()='Security']/following-sibling::img[contains(@src, 'image/png')]")
    private static WebElement securityCommentsButton;

    @FindBy(xpath = "//div[text()='Comments']")
    private static WebElement commentsTabTitle;

    @FindBy(xpath = "//button[text()='Close']")
    private static WebElement closteCommentsTab;

    @FindBy(xpath = "//a[text()='No results found !']")
    protected static WebElement noResultFoundMessage;

    @FindBy(xpath = "//div[text()='KMS-Automation']")
    protected static WebElement kmsAtProjectName;

    public void searchForAProject(String searchFor) {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) searchField));
        searchField.sendKeys(searchFor);
        searchButton.click();
        verifyThatIsOnlyOneProject(searchFor);
        searchField.clear();
    }

    public void verifyThatIsOnlyOneProject(String theNameOfTheProject) {
        List<WebElement> listOfProjects = driver.findElements(By.xpath("//div[@class='project-name']"));
        int numberOfProjects = listOfProjects.size();
        for (WebElement theProject : listOfProjects) {
            String projectTitle = theProject.getText();
            if (numberOfProjects == 1 && projectTitle.equals(theNameOfTheProject)) {
                Assert.assertEquals(projectTitle, theNameOfTheProject);
            } else {
                String noResultFound = driver.findElement(By.xpath(String.valueOf(noResultFoundMessage))).getText();
                Assert.assertEquals(noResultFound, "No results found !");
            }
        }
    }

    public void clickOnProjectsTab() {
        projectsTabButton.click();

        longWait().until(ExpectedConditions.visibilityOf((WebElement) searchButton));
    }

    public void clickOnReportsTab() {
        reportsTabButton.click();

        longWait().until(ExpectedConditions.visibilityOf((WebElement) downloadPDFButton));
    }

    public void verifyElementsOnHomePage() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) threePillarGlobalLogo));

        identifyElementsOnPage();
        clickOnReportsTab();
        clickOnProjectsTab();
    }

    private void identifyElementsOnPage() {
        assertTrue(threePillarGlobalLogo.isDisplayed());
        assertTrue(soryByDropDown.isDisplayed());
        assertTrue(titleOfTheWebPage.isDisplayed());
        assertTrue(subTitleOfTheWebPage.isDisplayed());
        assertTrue(usersName.isDisplayed());
    }

    public void verifyProjectsElements() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) projectNameElement));
        String projectTitle = projectNameElement.getText();

        Assert.assertEquals(projectTitle, "KMS-Automation");
        verifyMetricTitles();
    }

    public void verifyMetricTitles() {
        WebElement[] metricTitle = {
                uptimePercentageMetric, productionOpenCloseRateMetric, applicationCrashRateMetric, maintainabilityIndexMetric,
                automaticProvisioningMetric, configurabilityMetric, installationDocumentationMetric, standardChecklistForDeploymentMetric,
                neededDowntimeMetric, deploymentTimeMetric, sprintCommitmentCompletionMetric, checklistMetric, guildlineAvailableMetric
        };

        for (WebElement verifyTitles : metricTitle) {
            assertTrue(verifyTitles.isDisplayed());
        }

//        //Todo string.format pe elementul "projectMetricTitle" si array-ul "verifyTitles"
//        String[] metricTitle = {
//                "Uptime percentage", "Production Open / Closed Rate", "Application Crash Rate", "Maintainability index",
//                "Automatic provisioning", "Configurability", "Installation documentation", "Standard checklist for deployment",
//                "Needed downtime", "Deployment time", "Sprint commitment completion", "Checklist", "Guidline available"
//        };
//        for (String verifyTitles : metricTitle) {
//            Assert.assertEquals(projectMetricTitle, verifyTitles);
//        }
    }

    //Todo verify each comment inside the comment section tab

    public void verifyCommentsTab() {
        WebElement[] metricsCommentButton = {
                stabilityCommentsButton, maintenanceCommentsButton, deliveryEfficiencyCommentsButton,
                performanceCommentsButton, securityCommentsButton
        };

        for (WebElement commentsSection : metricsCommentButton) {
            commentsSection.click();
            longWait().until(ExpectedConditions.visibilityOf((WebElement) commentsTabTitle));
            assertTrue(commentsTabTitle.isDisplayed());
            closteCommentsTab.click();
        }
    }
}
