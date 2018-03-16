package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProjectPage extends Pages {
    @FindBy(css = "[name='project_name']")
    private WebElement projectNameField;

    @FindBy(css = "[name='project_em']")
    private WebElement EMfield;

    @FindBy(css = "[name='project_Doe']")
    private WebElement DoEField;

    @FindBy(css = "[name='project_client']")
    private WebElement clientField;

    @FindBy(css = "main > div > div > div > div > button:nth-child(2)")
    private  WebElement saveButton;

    @FindBy(css = "main > div > div > div > div > button:nth-child(1)")
    private  WebElement cancelButton;

    public UpdateProjectPage(WebDriver driver) {
        super(driver);
    }

    private void completeProjectNameField(WebDriver driver, String projectName) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_name']"), 10);

        projectNameField.clear();
        projectNameField.sendKeys(projectName);
    }

    private void completeEMField(WebDriver driver, String EM) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_em']"), 10);

        EMfield.clear();
        EMfield.sendKeys(EM);
    }

    private void completeDoEField(WebDriver driver, String DoE) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_Doe']"), 10);

        DoEField.clear();
        DoEField.sendKeys(DoE);
    }

    private void completeClientField(WebDriver driver, String client) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_client']"), 10);

        clientField.clear();
        clientField.sendKeys(client);
    }

    private void completeMandatoryFieldsForNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        completeProjectNameField(driver,projectName);
        completeEMField(driver, EM);
        completeDoEField(driver, DoE);
        completeClientField(driver, client);
    }

    private void clickOnSaveButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(2)"), 10);

        saveButton.click();
    }

    private void clickOnCancelButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(1)"), 10);

        cancelButton.click();
    }

    public void createAndSaveNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        ProjectsPage.clickOnAddNewProjectButton(driver);
        completeMandatoryFieldsForNewProject(driver, projectName, EM, DoE, client);
        clickOnSaveButton(driver);
    }

    public void createAndCancelNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        ProjectsPage.clickOnAddNewProjectButton(driver);
        completeMandatoryFieldsForNewProject(driver, projectName, EM, DoE, client);
        clickOnCancelButton(driver);
    }

    public void searchAndUpdateAProject(WebDriver driver, String projectName, String newProjectName, String EM, String DoE, String client){
        ProjectsPage.searchForAProject(driver, projectName);

        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector(".update-project-button"), 10);
        ProjectsPage.clickOnUpdateProjectButton(driver);

        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_em']"), 20, true);
        completeProjectNameField(driver, newProjectName);

        saveButton.click();
    }


}
