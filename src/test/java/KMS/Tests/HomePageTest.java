package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.HomePage;
import KMS.Framework.Pages.ProjectsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void elementsOnPageLoad() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.verifyElementsOnHomePage();
    }

    @Test
    public void searchForAProject() {
        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);

        projectsPage.searchForAProject("KMS-Automation");
//        projectsPage.verifyThatIsOnlyOneProject();
    }

    @Test
    public void searchForAProjectAndVerifyItsElements() {
        ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        projectsPage.searchForAProject("KMS-Automation");
        homePage.verifyProjectsElements();
        homePage.verifyCommentsTab();
    }
}
