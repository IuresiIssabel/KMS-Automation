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
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        String projectName = WebDrivers.getRandomString();
        String newProjectName = WebDrivers.getRandomString();

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, data.getEMField(), data.getDoEField(), data.getClientField());
        projectPage.searchForAProject(projectName);

        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.updateAProject(
                newProjectName, data.getEMField2(), data.getDoEField2(), data.getClientField2());
        projectPage.searchForAProject(newProjectName);
        updateProjectPage.verifyTheUpdatedProjectsData(
                data.getEMField2(), data.getDoEField2(), data.getClientField2());
    }

    @Test
    public void createSearchAndUpdateAProjectAndCancelIt() {
        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
        UpdateProjectPage updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        String projectName = WebDrivers.getRandomString();
        String newProjectName = WebDrivers.getRandomString();

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, data.getEMField(), data.getDoEField(), data.getClientField());
        projectPage.searchForAProject(projectName);

        updateProjectPage.clickOnUpdateProjectButton();
        updateProjectPage.updateAProjectAndCancelIt(
                newProjectName, data.getEMField2(), data.getDoEField2(), data.getClientField2());
        projectPage.searchForAProject(newProjectName);
        addNewProjectsPage.verifyTheCreatedProjectsData(data.getEMField(), data.getDoEField(), data.getClientField());
    }
}
