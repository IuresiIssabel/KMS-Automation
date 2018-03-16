package KMS.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    private WebDriver driver;

    private SignInUserPage signInUserPage;
    private ProjectsPage projectsPage;
    private SignInPage signInPage;
    private SignInPasswordPage signInPasswordPage;
    private UpdateProjectPage updateProjectPage;
    private ProjectDetailsPage projectDetailsPage;

    public Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage SignInPage(){
        signInPage = PageFactory.initElements(driver, SignInPage.class);

        return signInPage;
    }

    public SignInUserPage SignInUserPage(){
        signInUserPage = PageFactory.initElements(driver, SignInUserPage.class);

        return signInUserPage;
    }

    public SignInPasswordPage SignInPasswordPage() {
        signInPasswordPage = PageFactory.initElements(driver, SignInPasswordPage.class);

        return signInPasswordPage;
    }

    public ProjectsPage ProjectsPage(){
        projectsPage = PageFactory.initElements(driver, ProjectsPage.class);

        return projectsPage;
    }

    public UpdateProjectPage UpdateProjectPage(){
        updateProjectPage = PageFactory.initElements(driver, UpdateProjectPage.class);

        return updateProjectPage;
    }

    public ProjectDetailsPage DetailsProjectPage(){
        projectDetailsPage = PageFactory.initElements(driver, ProjectDetailsPage.class);

        return projectDetailsPage;
    }

}
