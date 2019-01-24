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
     * Returns button id of CHPL Resources Dropdown.
     * @param driver WebDriver
     * @return id element
     */
    public static WebElement chplResourcesDropdown(final WebDriver driver) {
        return driver.findElement(By.id("resource-toggle"));
    }

    /**
     * Returns URL of Contact Us Link.
     * @param driver WebDriver
     * @return URL element
     * */
    public static WebElement contactUsURL(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]"));
    }

    public static WebElement tableContentElement(final WebDriver driver) {
        return driver.findElement(By.xpath("//table[@class='table search-table table-striped table-responsive']"));
    }
}
