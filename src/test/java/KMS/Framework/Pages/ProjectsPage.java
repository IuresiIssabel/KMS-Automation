package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends Page {

    @FindBy(css = "[name='search']")
    private static WebElement searchField;

    @FindBy(css = ".search-button")
    private static WebElement searchButton;

    @FindBy(css = "a.new-project-button")
    private static WebElement addNewProjectButton;

    @FindBy(css = ".update-project-button")
    private static WebElement updateProjectButton;

    public ProjectsPage(WebDriver driver) {
        super(driver);

        Wait.waitForElementByLocator(driver, By.cssSelector("[name='search']"));
    }

    private void clickOnSearchButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector(".search-button"), 10);

        searchButton.click();
    }

    private void typeInSearchField(String searchFor) {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='search']"), 10);

        searchField.sendKeys(searchFor);
    }

    public void searchForAProject(String projectName) {
        typeInSearchField(projectName);
        clickOnSearchButton();
    }

    public void clickOnAddNewProjectButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector("a.new-project-button"), 10);

        addNewProjectButton.click();
    }

    public void clickOnUpdateProjectButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector(".update-project-button"), 10);

        updateProjectButton.click();
    }

    public boolean returnIfAProjectExists(String projectName) {
        Wait.waitAfterElementToBeDisplayed(driver, By.xpath("//div[@class='project-name']"), 5, true);

        List<WebElement> listOfProjects = driver.findElements(By.xpath("//div[@class='project-name']"));

        if (listOfProjects.size() != 0) {
            for (int i = 0; i <= listOfProjects.size(); i++) {
                return (listOfProjects.get(i).getText().contains(projectName) && listOfProjects.size() == 1);
            }
        }

        return false;
    }

}
