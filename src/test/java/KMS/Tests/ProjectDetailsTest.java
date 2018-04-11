package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.ProjectDetailsPage;
import KMS.Framework.Pages.ProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectDetailsTest extends TestBase {

    @Test
    public void goToProjectDetailsAndVerifyMetricTitles() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyMainMetricTitles();
    }

    @Test
    public void goToProjectDetailsAndVerifyMetricNames(){
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyMetricNames();
    }

    @Test
    public void goToProjectDetailsAndVerifyCommentsTab(){
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyCommentsTab();
    }
}
