package KMS.Tests;

import KMS.Framework.Page;
import KMS.Framework.Utilities.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTests extends BaseTest {
    private Page pages;
//            = new Page(driver);

    @Test
    public void searchForAProject() {
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().searchForAProject("Berkeley Fit");

        Assert.assertEquals(pages.ProjectsPage().returnIfProjectExists("Berkeley Fit"), true);
    }

    @Test
    public void createAndSaveNewProject() {
        String projectName = BasePage.getRandomString();
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndSaveNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfProjectExists(projectName), true);
    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = BasePage.getRandomString();
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndCancelNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfProjectExists(projectName), false);
    }

    @Test
    public void createSearchUpdateAndSaveAProject() {
        String projectName = BasePage.getRandomString();
        String newProjectName = BasePage.getRandomString();

        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndSaveNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        pages.ProjectsPage().clickOnUpdateProjectButton();
        pages.UpdateProjectPage().updateAndSaveAProject(newProjectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(newProjectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfProjectExists(newProjectName), true);
    }

    @Test
    public void createSearchUpdateAndSaveToHistoryAProject() {
        String projectName = BasePage.getRandomString();
        String newProjectName = BasePage.getRandomString();

        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().clickOnAddNewProjectButton();
        pages.UpdateProjectPage().createAndSaveNewProject(projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(projectName);

        pages.ProjectsPage().clickOnUpdateProjectButton();
        pages.UpdateProjectPage().updateAndSaveToHistoryAProject(newProjectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(newProjectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfProjectExists(newProjectName), true);
    }

    @Test
    public void searchForAProjectAnGoToDetails() {
        pages = PageFactory.initElements(driver, Page.class);

        pages.ProjectsPage().searchForAProject("Berkeley Fit");
        pages.DetailsProjectPage().clickOnProjectDetailsButton();

        Assert.assertEquals(pages.DetailsProjectPage().verifyIfStabilityMetricIsDisplayed(), true);
    }

}
