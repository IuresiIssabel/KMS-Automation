package KMS.Tests;

import KMS.Framework.Page;
import KMS.Framework.Utilities.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTests extends BaseTests {
    private Page pages;

    @Test
    public void searchForAProject() {
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().searchForAProject("Berkeley Fit");

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists("Berkeley Fit"), true);
    }

    @Test
    public void createAndSaveNewProject() {
        String projectName = Base.getRandomString();
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndSaveNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(projectName), true);
    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = Base.getRandomString();
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndCancelNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(projectName), false);
    }

    @Test
    public void createSearchAndUpdateAProject() {
        String projectName = Base.getRandomString();
        String newProjectName = Base.getRandomString();

        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndSaveNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        pages.ProjectsPage().clickOnUpdateProjectButton();
        pages.UpdateProjectPage().updateAProject(newProjectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(newProjectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(newProjectName), true);
    }

    @Test
    public void searchForAProjectAnGoToDetails() {
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().searchForAProject("Berkeley Fit");
        pages.DetailsProjectPage().clickOnProjectDetailsButton();

        Assert.assertEquals(pages.DetailsProjectPage().verifyIfStabilityMetricIsDisplayed(), true);
    }

}
