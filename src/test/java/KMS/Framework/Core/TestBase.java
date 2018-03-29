package KMS.Framework.Core;

import KMS.Framework.Pages.LoginInUserPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends WebDrivers {
    @BeforeMethod()
    public void setUp() {
        try {
            rootInit();
            getDriver().get("http://dev.kms.3pillar.corp:8000");
            Thread.sleep(1000);
            LoginInUserPage logIn = PageFactory.initElements(driver, LoginInUserPage.class);
            String winHandleBefore = driver.getWindowHandle();
            logIn.clickOnSignInButton();
            WebDrivers.switchToSpecificTab(driver, 1);
            logIn.typeInEmailField("kms-auto");
            logIn.typeInPasswordField("Leverpoint456!");
            driver.switchTo().window(winHandleBefore);
            Thread.sleep(1000);
            driver.navigate().refresh();
            logIn.clickOnSignInButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod()
    public void tearDown() {
        rootTearDown();
    }
}
