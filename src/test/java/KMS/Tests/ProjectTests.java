package KMS.Tests;

import KMS.Framework.Base;
import KMS.Framework.Pages;
import KMS.Framework.Utilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTests extends Base {
    private Pages pages;

    @Test
    public void searchForAProject() {
        pages = PageFactory.initElements(driver, Pages.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField(driver,"kms-auto");
        pages.SignInPasswordPage().completePasswordField(driver,"Leverpoint456!");

        pages.ProjectsPage().searchForAProject(driver,"Berkeley Fit");

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, "Berkeley Fit"), true);
    }

    @Test
    public void createAndSaveNewProject() {
        String projectName = Utilities.getRandomString();
        pages = PageFactory.initElements(driver, Pages.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField(driver,"kms-auto");
        pages.SignInPasswordPage().completePasswordField(driver,"Leverpoint456!");

        pages.ProjectsPage().createAndSaveNewProject(driver,projectName,"Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver, projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, projectName), true);
    }

    @Test
    public void createAndCancelNewProject() {
        String projectName = Utilities.getRandomString();
        pages = PageFactory.initElements(driver, Pages.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField(driver,"kms-auto");
        pages.SignInPasswordPage().completePasswordField(driver,"Leverpoint456!");

        pages.ProjectsPage().createAndCancelNewProject(driver, projectName,"Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver, projectName);

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, projectName), false);
    }
}
