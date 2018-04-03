package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.ProjectPage;
import KMS.Framework.Pages.ProjectDetailsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectDetailsTest extends TestBase {

    @Test
    public void searchForAProjectAndGoToDetails() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyIfStabilityMetricIsDisplayed();
        projectPage.verifyMetricTitles();
    }

    @Test
    public void goToDetailsPageAndAccessCommentsSection() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyIfStabilityMetricIsDisplayed();
        projectPage.verifyCommentsTab();
    }

}
