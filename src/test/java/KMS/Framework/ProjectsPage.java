package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends Pages{
    @FindBy(css = "[name='search']")
    private static WebElement searchField;

    @FindBy(css = ".search-button")
    private static WebElement searchButton;

    @FindBy(css = "a.new-project-button")
    private static WebElement addNewProjectButton;

    @FindBy(css = ".update-project-button")
    private static WebElement updateProjectButton;

    public ProjectsPage(WebDriver driver){
        super(driver);

        Utilities.waitForElementByLocator(driver, By.cssSelector("[name='search']"));
    }

    private static void clickOnSearchButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector(".search-button"), 10);

        searchButton.click();
    }

    private static void typeInSearchField(WebDriver driver, String searchFor) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("[name='search']"), 10);

        searchField.sendKeys(searchFor);
    }

    public static void searchForAProject(WebDriver driver, String projectName){
        typeInSearchField(driver, projectName);
        clickOnSearchButton(driver);
    }

    public static void clickOnAddNewProjectButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector("a.new-project-button"), 10);

        addNewProjectButton.click();
    }

    public static void clickOnUpdateProjectButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector(".update-project-button"), 10);

        updateProjectButton.click();
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
