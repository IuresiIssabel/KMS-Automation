package KMS.Tests;

import KMS.Framework.Base;
import KMS.Framework.Pages;
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
        pages = PageFactory.initElements(driver, Pages.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField(driver,"kms-auto");
        pages.SignInPasswordPage().completePasswordField(driver,"Leverpoint456!");

        pages.ProjectsPage().createAndSaveNewProject(driver,"TestAutomationProject","Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver,"TestAutomationProject");

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, "TestAutomationProject"), true);
    }

    @Test
    public void createAndCancelNewProject() {
        pages = PageFactory.initElements(driver, Pages.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField(driver,"kms-auto");
        pages.SignInPasswordPage().completePasswordField(driver,"Leverpoint456!");

        pages.ProjectsPage().createAndCancelNewProject(driver,"TestAutomationProject","Test", "Test", "Test");
        pages.ProjectsPage().searchForAProject(driver,"TestAutomationProject");

        Assert.assertEquals(pages.ProjectsPage().returnIfAProjectExists(driver, "TestAutomationProject"), false);
    }
}
