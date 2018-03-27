package KMS.Tests;

import KMS.Framework.Page;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    static WebDriver driver;

    @BeforeMethod
    public void setUp1() {
        String osName = System.getProperty("os.name").toLowerCase();
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        Platform desiredPlatform = Platform.ANY;

        if (osName.contains("windows")) {
            desiredPlatform = Platform.WINDOWS;
        } else if (osName.contains("mac")) {
            desiredPlatform = Platform.MAC;
        }
        capability.setPlatform(desiredPlatform);

        if (capability.getPlatform().is(Platform.WINDOWS)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/issabel.iuresi/IdeaProjects/KMS/src/test/resources/chromedriver");
        }

        driver = new ChromeDriver();
        driver.get("http://dev.kms.3pillar.corp:8000/login");
    }

    @BeforeMethod
    public void setUp2() {
        Page pages = PageFactory.initElements(driver, Page.class);

        pages.SignInPage().clickOnSignInButton();
        pages.SignInUserPage().completeEmailField("kms-auto");
        pages.SignInPasswordPage().completePasswordField("Leverpoint456!");
        driver.switchTo().window("");
        driver.navigate().refresh();
        pages.SignInPage().clickOnSignInButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}