package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.ProjectPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProjectPageTest extends TestBase {

    @Test
    public void elementsOnPageLoad() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.verifyElementsOnHomePage();
    }

    @Test
    public void searchForAProject() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
    }

    @Test
    public void searchForAProjectAndVerifyItsElements() {
        ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);

        projectPage.searchForAProject("KMS-Automation");
        projectPage.verifyProjectsElements();
        projectPage.verifyCommentsTab();
    }
}
