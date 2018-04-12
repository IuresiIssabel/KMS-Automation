package KMS.Framework.Core;

import KMS.Framework.Pages.AddNewProjectsPage;
import KMS.Framework.Pages.LoginInUserPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends WebDrivers {
    @BeforeMethod()
    public void setUp() {
        try {
            rootInit();
            getDriver().get(data.getBaseUrl());
            Thread.sleep(1000);
            LoginInUserPage logIn = PageFactory.initElements(driver, LoginInUserPage.class);
            String winHandleBefore = driver.getWindowHandle();
            logIn.clickOnSignInButton();
            WebDrivers.switchToSpecificTab(driver, 1);
            logIn.typeInEmailField();
            logIn.typeInPasswordField();
            driver.switchTo().window(winHandleBefore);
            Thread.sleep(1000);
            driver.navigate().refresh();
            logIn.clickOnSignInButton();
            AddNewProjectsPage addNewProjectsPage = PageFactory.initElements(driver, AddNewProjectsPage.class);
            addNewProjectsPage.createKMSAutomationProject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod()
    public void tearDown() {
        rootTearDown();
    }
}
