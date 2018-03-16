package KMS.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailsPage extends Pages {
    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    public void clickOnProjectDetailsButton(WebDriver driver) {
        Utilities.waitAfterElementToBeDisplayed(driver, By.cssSelector(".project-details-button"), 10);

        projectDetailsButton.click();
    }
}
