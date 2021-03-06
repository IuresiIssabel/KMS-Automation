package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.ProjectDetailsPage;
import KMS.Framework.Pages.ProjectPage;
import KMS.Framework.Pages.UpdateProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectDetailsTest extends TestBase {

    @Test
    public void goToProjectDetailsAndVerifyMetricTitles() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyMainMetricTitles();
    }

    @Test
    public void goToProjectDetailsAndVerifyMetricNames() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyMetricNames();
    }

    @Test
    public void goToProjectDetailsAndVerifyCommentsTab() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        projectPage.verifyCommentsTab();
    }

    @Test
    public void publishAProjectAndVerifyDataHistory() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyTheProjectWasPlublishedWithSuccesInDataHistory();
    }

    @Test
    public void goToProjectDetailsAndVerifyDataHistoryTableHeader() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.clickOnSaveDraftButton();
        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyDataHistoryColumnHeader();
    }

    @Test
    public void goToProjectDetailsAndVerifyDataHistoryInformation() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.clickOnSaveDraftButton();
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyDataHistoryColumnInfo();
    }

    @Test
    public void verifyMetricScorecardFromDataHistory() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.clickOnDataHistoryDetailsButton();
        detailsPage.verifyDataHistoryScoreCardMetricTitles();
        detailsPage.verifyDataHistoryMetricNames();
        detailsPage.verifyDataHistoryCommentsTab();
    }

    @Test
    public void verifyUploadProjectLogo() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyProjectLogo();
        detailsPage.clickOnProjectLogoButton();
        detailsPage.verifyProjectLogoPopupElements();
    }

    @Test
    public void addAProjectToDataHistoryThroughHistoricalData() {
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject(data.getKmsAutoProjectName());
        detailsPage.clickOnProjectDetailsButton();
        detailsPage.verifyHistoricalDataWasPublishedWithSuccess();
    }
}
