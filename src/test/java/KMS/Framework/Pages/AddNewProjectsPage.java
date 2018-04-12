package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class AddNewProjectsPage extends WebDrivers {

    public AddNewProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "a.new-project-button")
    private static WebElement addNewProjectButton;

    @FindBy(css = "[name='project_name']")
    protected WebElement projectNameField;

    @FindBy(css = "[name='project_em']")
    private WebElement EMfield;

    @FindBy(css = "[name='project_Doe']")
    private WebElement DoEField;

    @FindBy(css = "[name='project_client']")
    private WebElement clientField;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(css = "main > div > div > div > div > button:nth-child(1)")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@class='commentField']")
    private WebElement commentFieldElement;

    @FindBy(xpath = "//input[@type='number' and following-sibling::div/text()='%']")
    private WebElement metricValueGoalInputForPercentage;

    @FindBy(xpath = "//input[@type='number' and following-sibling::div/text()='min.']")
    private WebElement metricValueGoalInputForMinutes;

    protected void completeProjectNameField(String projectName) {
        projectNameField.clear();
        projectNameField.sendKeys(projectName);
    }

    private void completeEMField(String EM) {
        EMfield.clear();
        EMfield.sendKeys(EM);
    }

    private void completeDoEField(String DoE) {
        DoEField.clear();
        DoEField.sendKeys(DoE);
    }

    private void completeClientField(String client) {
        clientField.clear();
        clientField.sendKeys(client);
    }

    private void completeMandatoryFieldsForNewProject(String projectName, String EM, String DoE, String client) {
        completeProjectNameField(projectName);
        completeEMField(EM);
        completeDoEField(DoE);
        completeClientField(client);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void createAndCancelNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        prefillAllProjectFields();
        clickOnCancelButton();
    }

    protected void clickOnCancelButton() {
        cancelButton.click();
    }

    public void verifyTheCreatedProjectsData(String EM, String DoE, String client) {
        Assert.assertEquals(EM, data.getEMField());
        Assert.assertEquals(DoE, data.getDoEField());
        Assert.assertEquals(client, data.getClientField());
    }

    public void clickOnAddNewProjectButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) addNewProjectButton));
        addNewProjectButton.click();
    }

    public void createAndSaveNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        prefillAllProjectFields();
        clickOnSaveButton();
    }

    public void prefillAllProjectFields() {
        prefillCommentFields();
        prefillMetricInput(
                "//input[@type='number' and following-sibling::div/text()='%']",
                data.getMetricValueGoalMinutesAndPercentageNr());
        prefillMetricInput(
                "//input[@type='number' and following-sibling::div/text()='min.']",
                data.getMetricValueGoalMinutesAndPercentageNr());
        changeOptionsInMetricDropdowns(
                "//select[contains(@name, 'score_')]",
                "score",
                data.getMetricScoreDropdownMaxNr());
        changeOptionsInMetricDropdowns(
                "//select[contains(@name, 'value_')]",
                "value",
                data.getMetricValueDropdownMaxNr());
        changeOptionsInMetricDropdowns(
                "//select[contains(@name, 'goal_')]",
                "goal",
                data.getMetricGoalDropdownMaxNr());
    }

    private void prefillCommentFields() {
        List<WebElement> commentField = driver.findElements(By.xpath("//input[@class='commentField']"));
        int n = 1;
        for (WebElement prefillCommentField : commentField) {
            int number = n++;
            prefillCommentField.sendKeys(data.getCommentField() + number);
        }
    }

    private void prefillMetricInput(String elementInput, int maxNumber) {
        List<WebElement> metricInputElement = driver.findElements(By.xpath(elementInput));
        for (WebElement prefillInput : metricInputElement) {
            prefillInput.clear();
            Random rand = new Random();
            int number = rand.nextInt(maxNumber);
            prefillInput.sendKeys("" + number);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeOptionsInMetricDropdowns(String elementInput, String metricColumn, int maxNumber) {
        List<WebElement> metricInputElement = driver.findElements(By.xpath(elementInput));
        for (WebElement prefillInput : metricInputElement) {
            Random rand = new Random();
            int number = rand.nextInt(maxNumber);
            prefillInput.sendKeys(
                    "//select[contains(@name, '" + metricColumn + "_')]/option[@value='" + number + "']");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createKMSAutomationProject() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        WebElement noResultFoundMsg = driver.findElement(By.xpath("//a[text()='No results found !']"));

        if (noResultFoundMsg != null && noResultFoundMsg.isDisplayed()) {
            clickOnAddNewProjectButton();
            createAndSaveNewProject(data.getKmsAutoProjectName(), data.getEMField(), data.getDoEField(), data.getClientField());
            projectPage.searchForAProject(data.getKmsAutoProjectName());
        }
    }
}
