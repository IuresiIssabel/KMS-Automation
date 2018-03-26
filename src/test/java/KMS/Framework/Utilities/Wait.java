package KMS.Framework.Utilities;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public Wait() {

    }

    public static void waitForElementByLocator(WebDriver driver, final By locator) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(120, TimeUnit.SECONDS)
                .pollingEvery(800, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public static void waitAfterElementToBeDisplayed(WebDriver driver, final By locator, int timeWait, boolean... forceSleep) {
        WebDriverWait wait = new WebDriverWait(driver, timeWait);
        try {
            if (forceSleep != null && forceSleep.length > 0 && forceSleep[0]) {
                Thread.sleep(2000);
            }
            wait.until(new ExpectedCondition<WebElement>() {
                //            	int i = 0;
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(locator);
                    return element.isDisplayed() ? element : null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static <T> T until(Callable<T> fn) {
        return until(10, 100, fn);
    }

    public static <T> T until(int timeoutInSeconds, Callable<T> fn) {
        return until(timeoutInSeconds, 100, fn);
    }

    private static <T> T until(int timeoutInSeconds, int pollIntervalInMiliSeconds, Callable<T> fn) {
        T result = null;
        StopWatch watch = new StopWatch();
        watch.start();

        do {
            try {
                result = fn.call();
                if (result instanceof Boolean && (Boolean) result) {
                    return result;
                }

                if (!(result instanceof Boolean) && result != null) {
                    return result;
                }
            } catch (Exception var6) {
            }

//            COLTimeUtils.sleep((long)pollIntervalInMiliSeconds);
        } while (watch.getTime() <= (long) (timeoutInSeconds * 1000));

        return result;
    }

}
