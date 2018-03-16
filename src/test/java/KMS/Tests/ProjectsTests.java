package KMS.Tests;

import KMS.Framework.Base;
import KMS.Framework.Pages;
import KMS.Framework.Utilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTests extends Base {
    private Pages pages;

    @Test
    public void searchForAProject() {
        pages = PageFactory.initElements(driver, Pages.class);

        pages.ProjectsPage().searchForAProject(driver, "Berkeley Fit");

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, "Berkeley Fit"), true);
    }

    @Test
    public void createAndSaveNewProject() {
        String projectName = Utilities.getRandomString();
        pages = PageFactory.initElements(driver, Pages.class);

        pages.UpdateProjectPage().createAndSaveNewProject(driver, projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver, projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, projectName), true);
    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = Utilities.getRandomString();
        pages = PageFactory.initElements(driver, Pages.class);

        pages.UpdateProjectPage().createAndCancelNewProject(driver, projectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver, projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, projectName), false);
    }

    @Test
    public void createSearchAndUpdateAProject() {
        String projectName = Utilities.getRandomString();
        String newProjectName = Utilities.getRandomString();

        pages = PageFactory.initElements(driver, Pages.class);

        pages.UpdateProjectPage().createAndSaveNewProject(driver, projectName, "Test", "Test", "Test");
        pages.UpdateProjectPage().searchAndUpdateAProject(driver, projectName, newProjectName, "Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver, newProjectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, newProjectName), true);
    }

}
