package gov.healthit.chpl.aqa.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Class Hooks definition.
 */
public class Hooks {

    private static WebDriver driver;
    private static final int DELAY = 30;

    @Before
    public void openBrowser() {
        String exePath = "C:\\Users\\amore\\eclipse-workspace\\chpl-testautomation\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}