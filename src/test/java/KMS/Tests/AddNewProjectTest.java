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
        String projectName = WebDrivers.getRandomString();

        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndSaveNewProject(
                projectName, "Test EM", "Test DoE", "Test client");
        projectPage.searchForAProject(projectName);

    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = WebDrivers.getRandomString();

        AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        addNewProjectsPage.clickOnAddNewProjectButton();
        addNewProjectsPage.createAndCancelNewProject(
                projectName, "Test EM", "Test DoE", "Test client");
        projectPage.searchForAProject(projectName);
    }
}
