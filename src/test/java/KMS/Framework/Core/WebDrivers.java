package KMS.Framework.Core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class WebDrivers {
    public WebDriver driver;
    public PropertiesReader data;
    public static final int FIND_WAIT = 15;
    public static final int LONG_WAIT = 30;
    protected static final ThreadLocal<RemoteWebDriver> THREAD_LOCAL_DRIVER = new InheritableThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> THREAD_LOCAL_FIND_WAIT = new InheritableThreadLocal<>();
    protected static final ThreadLocal<WebDriverWait> THREAD_LOCAL_LONG_WAIT = new InheritableThreadLocal<>();

    public WebDrivers() {
        data = new PropertiesReader();
    }

    protected void rootInit() {
        DesiredCapabilities capabilities;
        if (data.getPropertyValue("browser").equals("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        } else {
            capabilities = DesiredCapabilities.firefox();
        }
        try {
            driver = new RemoteWebDriver(
                    new URL(data.getPropertyValue("selServer")),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().setSize(new Dimension(1600,900));
        WebDriverWait findWait, longWait;
        findWait = new WebDriverWait(driver, FIND_WAIT);
        longWait = new WebDriverWait(driver, LONG_WAIT);
        THREAD_LOCAL_DRIVER.set((RemoteWebDriver) driver);
        THREAD_LOCAL_FIND_WAIT.set(findWait);
        THREAD_LOCAL_LONG_WAIT.set(longWait);
    }

    protected void rootTearDown() {
        try {
            RemoteWebDriver driver = getDriver();
            if (driver != null)
                driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver() {
        return THREAD_LOCAL_DRIVER.get();
    }

    public static void switchToSpecificTab(WebDriver driver, int windowNumber) {
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        if (handles.size() > 0) {
            switchToHandle(driver, handles.get(windowNumber));
        }
    }

    private static void switchToHandle(WebDriver driver, String handle) {
        try {
            driver.switchTo().window(handle);
        } catch (Exception e) {
            System.out.println("error when switching to a tab");
        }
    }

    public static String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return "TestAuto".concat(salt.toString());
    }

    public WebDriverWait longWait() {
        return THREAD_LOCAL_LONG_WAIT.get();
    }
}
