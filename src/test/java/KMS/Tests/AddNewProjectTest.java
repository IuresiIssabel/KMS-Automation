package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Core.WebDrivers;
import KMS.Framework.Pages.AddNewProjectsPage;
import KMS.Framework.Pages.ProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddNewProjectTest extends TestBase {

    @Test
    public void createAndSaveNewProject() {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        String projectName = WebDrivers.getRandomString();

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, data.getEMField(), data.getDoEField(), data.getClientField());
        projectPage.searchForAProject(projectName);
        projectPage.verifyMainMetricTitles();
        projectPage.verifyMetricNames();
        projectPage.verifyCommentsTab();
    }

    @Test
    public void createAndCancelNewProject() {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        String projectName = WebDrivers.getRandomString();

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndCancelNewProject(
                projectName, data.getEMField(), data.getDoEField(), data.getClientField());
        projectPage.searchForAProject(projectName);
    }
}
