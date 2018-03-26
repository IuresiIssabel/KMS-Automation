package KMS.Framework;

import KMS.Framework.Pages.*;
import KMS.Framework.Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page extends Base{
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage SignInPage() {
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public SignInUserPage SignInUserPage() {
        return PageFactory.initElements(driver, SignInUserPage.class);
    }

    public SignInPasswordPage SignInPasswordPage() {
        return PageFactory.initElements(driver, SignInPasswordPage.class);
    }

    public ProjectsPage ProjectsPage() {
        return PageFactory.initElements(driver, ProjectsPage.class);
    }

    public UpdateProjectPage UpdateProjectPage() {
        return PageFactory.initElements(driver, UpdateProjectPage.class);
    }

    public ProjectDetailsPage DetailsProjectPage() {
        return PageFactory.initElements(driver, ProjectDetailsPage.class);
    }

}
