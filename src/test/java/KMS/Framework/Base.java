package KMS.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/issabel.iuresi/Downloads/SimpleExample/src/test/resources/chromedriver");

        driver = new ChromeDriver();

//        driver.manage().window().maximize();
        driver.get("http://dev.kms.3pillar.corp:8000/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}