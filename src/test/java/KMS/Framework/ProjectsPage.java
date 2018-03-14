package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends Pages{
    @FindBy(css = "[name='search']")
    private WebElement searchField;

    @FindBy(css = ".search-button")
    private WebElement searchButton;

    @FindBy(css = "a.new-project-button")
    private WebElement addNewProjectButton;

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

    public ProjectsPage(WebDriver driver){
        super(driver);

        Utilities.waitForElementByLocator(driver, By.cssSelector("[name='search']"));
    }

    private void clickOnSearchButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector(".search-button"), 10);

        searchButton.click();
    }

    private void typeInSearchField(WebDriver driver, String searchFor) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='search']"), 10);

        searchField.sendKeys(searchFor);
    }

    public void searchForAProject(WebDriver driver, String projectName){
        typeInSearchField(driver, projectName);
        clickOnSearchButton(driver);
    }

    private void clickOnAddNewProjectButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("a.new-project-button"), 10);

        addNewProjectButton.click();
    }

    private void completeProjectNameFieldForANewProject(WebDriver driver, String projectName) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_name']"), 10);

        projectNameField.clear();
        projectNameField.sendKeys(projectName);
    }

    private void completeEMFieldForANewProject(WebDriver driver, String EM) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_em']"), 10);

        EMfield.clear();
        EMfield.sendKeys(EM);
    }

    private void completeDoEFieldForANewProject(WebDriver driver, String DoE) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_Doe']"), 10);

        DoEField.clear();
        DoEField.sendKeys(DoE);
    }

    private void completeClientFieldForANewProject(WebDriver driver, String client) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='project_client']"), 10);

        clientField.clear();
        clientField.sendKeys(client);
    }

    private void completeMandatoryFieldsForNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        completeProjectNameFieldForANewProject(driver,projectName);
        completeEMFieldForANewProject(driver, EM);
        completeDoEFieldForANewProject(driver, DoE);
        completeClientFieldForANewProject(driver, client);
    }

    private void clickOnSaveButtonForANewProject(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(2)"), 10);

        saveButton.click();
    }

    private void clickOnCancelButtonForANewProject(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("main > div > div > div > div > button:nth-child(1)"), 10);

        cancelButton.click();
    }

    public void createAndSaveNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        clickOnAddNewProjectButton(driver);
        completeMandatoryFieldsForNewProject(driver, projectName, EM, DoE, client);
        clickOnSaveButtonForANewProject(driver);
    }

    public void createAndCancelNewProject(WebDriver driver, String projectName, String EM, String DoE, String client) {
        clickOnAddNewProjectButton(driver);
        completeMandatoryFieldsForNewProject(driver, projectName, EM, DoE, client);
        clickOnCancelButtonForANewProject(driver);
    }

    public boolean returnIfAProjectExists(WebDriver driver, String projectName) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.xpath("//div[@class='project-name']"), 5, true);

        List<WebElement> listOfProjects = driver.findElements(By.xpath("//div[@class='project-name']"));

        if (listOfProjects.size() != 0) {
            for (int i = 0; i <= listOfProjects.size(); i++) {
                return (listOfProjects.get(i).getText().contains(projectName) && listOfProjects.size() == 1);
            }
        }

        return false;
    }

}
