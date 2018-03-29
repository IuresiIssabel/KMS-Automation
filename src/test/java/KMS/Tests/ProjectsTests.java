package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Core.WebDrivers;
import KMS.Framework.Pages.ProjectDetailsPage;
import KMS.Framework.Pages.ProjectsPage;
import KMS.Framework.Pages.UpdateProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectsTests extends TestBase {

    @Test
    public void searchForAProject() {
        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        projectsPage.searchForAProject("Berkeley Fit");
//        projectsPage.verifyThatIsOnlyOneProject();
    }

    @Test
    public void createAndSaveNewProject() {
        String projectName = WebDrivers.getRandomString();

        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        projectsPage.clickOnAddNewProjectButton();
        updateProjectPage.createAndSaveNewProject(projectName, "Test", "Test", "Test");
        projectsPage.searchForAProject(projectName);

//        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(projectName), true);
    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = WebDrivers.getRandomString();

        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        projectsPage.clickOnAddNewProjectButton();
        updateProjectPage.createAndCancelNewProject(projectName, "Test", "Test", "Test");
        projectsPage.searchForAProject(projectName);

//        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(projectName), false);
    }

    @Test
    public void createSearchAndUpdateAProject() {
        String projectName = WebDrivers.getRandomString();
        String newProjectName = WebDrivers.getRandomString();

        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        projectsPage.clickOnAddNewProjectButton();
        updateProjectPage.createAndSaveNewProject(projectName, "Test", "Test", "Test");
        projectsPage.searchForAProject(projectName);

        projectsPage.clickOnUpdateProjectButton();
        updateProjectPage.updateAProject(newProjectName, "Test", "Test", "Test");
        projectsPage.searchForAProject(newProjectName);

//        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(newProjectName), true);
    }

    @Test
    public void searchForAProjectAnGoToDetails() {
        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        ProjectDetailsPage detailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);

        projectsPage.searchForAProject("Berkeley Fit");
        detailsPage.clickOnProjectDetailsButton();

//        Assert.assertEquals(pages.DetailsProjectPage().verifyIfStabilityMetricIsDisplayed(), true);
    }

}
