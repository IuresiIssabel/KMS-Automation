package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProjectPage extends WebDrivers {

    public UpdateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[name='project_name']")
    private WebElement projectNameField;

    @FindBy(css = "[name='project_em']")
    private WebElement EMfield;

    @FindBy(css = "[name='project_Doe']")
    private WebElement DoEField;

    @FindBy(css = "[name='project_client']")
    private WebElement clientField;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(css = "main > div > div > div > div > button:nth-child(2)")
    private WebElement saveToHistoryButton;

    @FindBy(css = "main > div > div > div > div > button:nth-child(1)")
    private WebElement cancelButton;

    private void completeProjectNameField(String projectName) {
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

    private void clickOnSaveButton() {
        saveButton.click();
    }

    private void clickOnSaveToHistoryButton() {
        saveToHistoryButton.click();
    }

    private void clickOnCancelButton() {
        cancelButton.click();
    }

    public void createAndSaveNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        clickOnSaveButton();
    }

    public void createAndCancelNewProject(String projectName, String EM, String DoE, String client) {
        completeMandatoryFieldsForNewProject(projectName, EM, DoE, client);
        clickOnCancelButton();
    }

    public void updateAProject(String newProjectName, String EM, String DoE, String client) {
        completeProjectNameField(newProjectName);
        clickOnSaveButton();
    }

}
