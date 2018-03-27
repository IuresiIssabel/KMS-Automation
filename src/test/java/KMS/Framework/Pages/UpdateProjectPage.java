package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProjectPage extends Page {
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

    public UpdateProjectPage(WebDriver driver) {
        super(driver);
    }

    private void completeProjectNameField(String projectName) {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_name']"), 10);

        projectNameField.clear();
        projectNameField.sendKeys(projectName);
    }

    private void completeEMField(String EM) {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_em']"), 10);

        EMfield.clear();
        EMfield.sendKeys(EM);
    }

    private void completeDoEField(String DoE) {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_Doe']"), 10);

        DoEField.clear();
        DoEField.sendKeys(DoE);
    }

    private void completeClientField(String client) {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_client']"), 10);

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
        Wait.waitAfterElementToBeDisplayed(driver, By.xpath("//span[text()='Save']"), 10);

        saveButton.click();
    }

    private void clickOnSaveToHistoryButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(2)"), 10);

        saveToHistoryButton.click();
    }

    private void clickOnCancelButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(1)"), 10);

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

    public void updateAndSaveAProject(String newProjectName, String EM, String DoE, String client) {
        completeProjectNameField(newProjectName);
        clickOnSaveButton();
    }

    public void updateAndSaveToHistoryAProject(String newProjectName, String EM, String DoE, String client) {
        completeProjectNameField(newProjectName);
        clickOnSaveToHistoryButton();
    }
}
