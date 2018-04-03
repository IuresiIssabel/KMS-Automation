package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Core.WebDrivers;
import KMS.Framework.Pages.AddNewProjectsPage;
import KMS.Framework.Pages.ProjectPage;
import KMS.Framework.Pages.UpdateProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UpdateProjectTest extends TestBase {

    @Test
    public void createSearchAndUpdateAProject() {
        String projectName = WebDrivers.getRandomString();
        String newProjectName = WebDrivers.getRandomString();

        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, "Test EM", "Test DoE", "Test client");
        projectPage.searchForAProject(projectName);

        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.updateAProject(
                newProjectName, "Test2 EM", "Test2 DoE", "Test2 client");
        projectPage.searchForAProject(newProjectName);
        updateProjectPage.verifyTheUpdatedProjectsData(
                "Test2 EM", "Test2 DoE", "Test2 client");
    }

    @Test
    public void createSearchAndUpdateAProjectAndCancelIt() {
        String projectName = WebDrivers.getRandomString();
        String newProjectName = WebDrivers.getRandomString();

        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, "Test EM", "Test DoE", "Test client");
        projectPage.searchForAProject(projectName);

        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.updateAProjectAndCancelIt(
                newProjectName, "Test2 EM", "Test2 DoE", "Test2 client");
        projectPage.searchForAProject(newProjectName);
        addNewProjectsPage.verifyTheCreatedProjectsData("Test EM", "Test DoE", "Test client");
    }
}
