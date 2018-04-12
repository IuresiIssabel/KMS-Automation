package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UpdateProjectPage extends WebDrivers {

    public UpdateProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".update-project-button")
    private static WebElement updateProjectButton;

    @FindBy(css = "main > div > div > div > div > button:nth-child(2)")
    private WebElement saveToHistoryButton;

    public void clickOnUpdateProjectButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) updateProjectButton));
        updateProjectButton.click();
    }

    public void clickOnSaveToHistoryButton() {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);

        longWait().until(ExpectedConditions.visibilityOf((WebElement) saveToHistoryButton));
        saveToHistoryButton.click();
        addNewProjectsPage.clickOnSaveButton();
    }

    public void updateAProject(String newProjectName, String EM, String DoE, String client) {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);

        addNewProjectsPage.completeProjectNameField(newProjectName);
        addNewProjectsPage.prefillAllProjectFields();
        addNewProjectsPage.clickOnSaveButton();
    }

    public void updateAProjectAndCancelIt(String newProjectName, String EM, String DoE, String client) {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);

        addNewProjectsPage.completeProjectNameField(newProjectName);
        addNewProjectsPage.prefillAllProjectFields();
        addNewProjectsPage.clickOnCancelButton();
    }

    public void verifyTheUpdatedProjectsData(String EM, String DoE, String client) {
        Assert.assertEquals(EM, data.getEMField2());
        Assert.assertEquals(DoE, data.getDoEField2());
        Assert.assertEquals(client, data.getClientField2());
    }
}
