package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class CollectionsPages definition.
 */
public final class CollectionsPages {
    private CollectionsPages() {}
    private static WebElement element = null;

    /**
     * Returns ACB Filter button element.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement acbFilterButton(final WebDriver driver) {
        element = driver.findElement(By.id("filter-button"));
        return element;
    }

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("main-content"));
        return element;
    }
}
