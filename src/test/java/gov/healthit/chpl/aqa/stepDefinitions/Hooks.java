package gov.healthit.chpl.aqa.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Class Hooks definition.
 */
public class Hooks {

    private static WebDriver driver;
    private static final int DELAY = 30;

    /**
     * Launch ChromeDriver.
     */
    @Before
    public void openBrowser() {
        /* To run chrome with the developer tools window automatically opened re-able these lines.
         *
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--auto-open-devtools-for-tabs");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // does not work on CI machine, sometimes useful locally
        */
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }

    /**
     * Close browser windows and terminate WebDriver session.
     */
    @After
    public void afterMethod() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
