package gov.healthit.chpl.aqa.pageObjects;

import java.util.List;

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

    public static WebElement updateSuccessfulToastContainer(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));
    }

    public static WebElement showNavigationLink(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/header/nav/div[1]/button"));
    }

    public static WebElement headerNav(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/header/nav[1]"));
    }

    public static WebElement pageTitle(final WebDriver driver, final String pageTitle) {
        return driver.findElement(By.xpath("//h1[contains(text(),'" + pageTitle + "')]"));
    }

    public static WebElement loggedInRoleUsername(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='login-toggle']"));
    }

    public static List<WebElement> getRowElements(final WebElement elements) {
        List<WebElement> rows = elements.findElements(By.tagName("tr"));
        return rows;
    }

    public static List<WebElement> getColElements(final WebElement elements) {
        List<WebElement> columns = elements.findElements(By.tagName("td"));
        return columns;
    }

    public static WebElement shortcutsDropdown(final WebDriver driver) {
        return driver.findElement(By.id("shortcut-toggle"));
    }

    public static WebElement shortcutsCollectionsPage(final WebDriver driver, final String collectionsPage) {
        return driver.findElement(
                By.xpath("//*[@id=\"shortcut-dropdown-menu\"]/li/a[contains(text(),'" + collectionsPage + "')]"));
    }
}
