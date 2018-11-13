package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class BasePage definition.
 */
public class BasePage {
    protected BasePage() {}

    private static WebElement element;

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("main-content"));
        return element;
    }

    /**
     * Return CQM Accordion on listing details page or edit CP page.
     * @param driver WebDriver
     * @return CQM Accordion element
     */
    public static WebElement cqmAccordion(final WebDriver driver) {
       return driver.findElement(By.id("details-cqm"));
    }
}
