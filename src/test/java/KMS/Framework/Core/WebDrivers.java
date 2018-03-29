package KMS.Framework.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WebDrivers {
    public static final int FIND_WAIT = 15;
    public static final int LONG_WAIT = 30;
    public WebDriver driver;
    protected static final ThreadLocal<RemoteWebDriver> THREAD_LOCAL_DRIVER = new InheritableThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> THREAD_LOCAL_FIND_WAIT = new InheritableThreadLocal<>();
    protected static final ThreadLocal<WebDriverWait> THREAD_LOCAL_LONG_WAIT = new InheritableThreadLocal<>();
    private static ChromeDriverService chromeService;
    protected String browser;
    private static final ThreadLocal<String> WINDOW_HANDLE = new InheritableThreadLocal<>();

    private void startChromeService() {
        if (chromeService == null) {
            chromeService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
                    .usingAnyFreePort()
                    .build();
            try {
                chromeService.start();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    protected void rootInit() {
        browser = System.getProperty("browser");
        initDriverPaths();
        startChromeService();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriverWait findWait, longWait;
        findWait = new WebDriverWait(driver, FIND_WAIT);
        longWait = new WebDriverWait(driver, LONG_WAIT);
        WINDOW_HANDLE.set(null);
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

    private void initDriverPaths() {
        String chromedriverPath = "src/test/resources/chromedriver.exe";
        String geckodriverPath = "src/test/resources/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", geckodriverPath);
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
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
