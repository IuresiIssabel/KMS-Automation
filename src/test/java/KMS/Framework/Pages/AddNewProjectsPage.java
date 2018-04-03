package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    protected void clickOnSaveButton() {
        saveButton.click();
    }

    public void verifyTheCreatedProjectsData(String EM, String DoE, String client) {
        Assert.assertEquals(EM, "Test EM");
        Assert.assertEquals(DoE, "Test DoE");
        Assert.assertEquals(client, "Test client");
    }

    public void clickOnAddNewProjectButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) addNewProjectButton));
        addNewProjectButton.click();
    }

    public void createAndSaveNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        clickOnSaveButton();
    }

    public void createAndCancelNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        clickOnCancelButton();
    }

    protected void clickOnCancelButton() {
        cancelButton.click();
    }
}
