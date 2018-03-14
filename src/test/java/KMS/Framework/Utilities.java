package KMS.Framework;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public static void waitForElementByLocator(WebDriver driver, final By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
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
            if (forceSleep != null && forceSleep.length > 0 && forceSleep[0] == true){
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

    public static void switchToSpecificTab(WebDriver driver, int windowNumber){
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        if (handles.size() > 0){
            switchToHandle(driver, handles.get(windowNumber));
        }
    }

    private static void switchToHandle(WebDriver driver, String handle){
        try{
            driver.switchTo().window(handle);
        }catch(Exception e){
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

        String saltStr = "TestAuto".concat(salt.toString());
        return saltStr;
    }

}
