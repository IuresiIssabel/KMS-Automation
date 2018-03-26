package KMS.Framework.Utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Base {

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

}
