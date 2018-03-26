package KMS.Framework.Utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        if (driver == null) {
            webDriver.remove();
        }
        webDriver.set(driver);
    }
}
