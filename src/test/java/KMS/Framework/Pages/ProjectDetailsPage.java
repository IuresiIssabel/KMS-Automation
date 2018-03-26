package KMS.Framework.Pages;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailsPage extends Page {
    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".project-details-button")
    private WebElement projectDetailsButton;

    @FindBy(xpath = "//div[contains(text(),'Stability')]")
    private WebElement stabilityMetricLabel;


    public void clickOnProjectDetailsButton() {
        Wait.waitAfterElementToBeDisplayed(driver, By.cssSelector(".project-details-button"), 10);

        projectDetailsButton.click();
    }

    public boolean verifyIfStabilityMetricIsDisplayed() {
        Wait.waitAfterElementToBeDisplayed(driver, By.xpath("//div[contains(text(),'Stability')]"), 10);

        return stabilityMetricLabel.isDisplayed();
    }
}
