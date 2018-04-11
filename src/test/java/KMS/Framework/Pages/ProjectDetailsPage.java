package KMS.Framework.Pages;

import KMS.Framework.Core.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectDetailsPage extends WebDrivers {

    public ProjectDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    public void clickOnProjectDetailsButton() {
        longWait().until(ExpectedConditions.elementToBeClickable((WebElement) projectDetailsButton));
        projectDetailsButton.click();
    }
}
