package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProjectsPage extends WebDrivers {

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "[name='search']")
    private static WebElement searchField;

    @FindBy(css = ".search-button")
    protected static WebElement searchButton;

    @FindBy(css = "a.new-project-button")
    private static WebElement addNewProjectButton;

    @FindBy(css = ".update-project-button")
    private static WebElement updateProjectButton;

    @FindBy(xpath = "//div[@class='project-name']")
    protected static WebElement projectNameElement;

    public void searchForAProject(String searchFor) {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) searchField));
        searchField.sendKeys(searchFor);
        searchButton.click();
    }

    public void verifyThatIsOnlyOneProject() {
        longWait().until(ExpectedConditions.visibilityOf((WebElement) By.xpath(String.valueOf(projectNameElement))));
        List<WebElement> listOfProjects = driver.findElements(By.xpath(String.valueOf(projectNameElement)));
        for (WebElement projectName : listOfProjects) {
            String kmsAutomationProject = projectName.getText();
            Assert.assertEquals(kmsAutomationProject, "KMS-Automation");
        }
    }

    public void clickOnAddNewProjectButton() {

        addNewProjectButton.click();
    }

    public void clickOnUpdateProjectButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) updateProjectButton));
        updateProjectButton.click();
    }
}
