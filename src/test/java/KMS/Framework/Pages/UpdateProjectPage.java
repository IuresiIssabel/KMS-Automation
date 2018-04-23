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

    @FindBy(xpath = "//span[text()='Publish']")
    private static WebElement publishButton;

    @FindBy(xpath = "//span[text()='Save Draft']")
    private WebElement saveDraftButton;

    @FindBy(className = "update-project-button")
    private WebElement updateProjectButton;

    public void clickOnUpdateProjectButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) updateProjectButton));
        updateProjectButton.click();
    }

    public void clickOnPublishProjectButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) publishButton));
        publishButton.click();
    }

    public void clickOnSaveDraftButton() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) saveDraftButton));
        saveDraftButton.click();
        publishButton.click();
    }

    public void updateAProject(String newProjectName, String EM, String DoE, String client) {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);

        addNewProjectsPage.completeProjectNameField(newProjectName);
        addNewProjectsPage.prefillAllProjectFields();
        clickOnPublishProjectButton();
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
