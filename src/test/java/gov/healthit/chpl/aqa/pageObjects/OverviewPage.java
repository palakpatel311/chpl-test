package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class OverviewPage definition.
 */
public class OverviewPage {

    private WebDriver driver;
    private static WebElement element = null;

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("mainContent"));
        return element;
    }

    /**
     * Returns element holding page title.
     * @param driver WebDriver
     * @return element holding page title
     */
    public static WebElement title(final WebDriver driver) {
        element = driver.findElement(By.id("pageTitle"));
        return element;
    }

    /**
     * Returns element holding ACB/ATL table.
     * @param driver WebDriver
     * @return element holding ACB/ATL table
     */
    public static WebElement acbAtlTable(final WebDriver driver) {
        element = driver.findElement(By.id("acbAtlTable"));
        return element;
    }
}
