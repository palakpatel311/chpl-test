package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SearchPage definition.
 */
public class SearchPage {
    private WebDriver driver;
    private static WebElement element = null;

    /**
     * Returns the acbFiltersLink.
     *
     * @param driver webdriver
     * @return acbFilters Link
     */
    public static WebElement acbFiltersLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[5]/ul/li[5]/st-list-multiple/ul/li[6]/label"));
        return element;
    }
    /**
     * Returns SLI Compliance ACB filter option.
     * @param driver WebDriver
     * @param acb is acb name
     * @return SLI Compliance ACB filter option element
     */
    public static WebElement acbSLIFilter(final WebDriver driver, final String acb) {
        element = driver.findElement(By.id("filter-list-" + acb));
        return element;
    }
    /**
     * Returns Browse button on Search page.
     * @param driver WebDriver
     * @return Browse button element
     */
    public static WebElement browseButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/div[1]/span[2]/button"));
        return element;
    }
    /**
     * Returns the first search details button.
     * @param driver webdriver
     * @return the first search result's details button
     */
    public static WebElement detailsLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
        return element;
    }
    /**
     * Returns Get EHR Certification ID button.
     * @param driver webdriver
     * @return button element
     */
    public static WebElement getEHRCertId(final WebDriver driver) {
        element = driver.findElement(By.id("get-ehr-cert-id"));
        return element;
    }
    /**
     * Returns 'More' filter button.
     * @param driver WebDriver
     * @return 'More' filter button element
     */
    public static WebElement moreFilter(final WebDriver driver) {
        element = driver.findElement(By.id("filter-more-button"));
        return element;
    }
    /**
     * Returns the pending mask "black screen".
     * @param driver WebDriver
     * @return the pending mask
     */
    public static WebElement pendingMask(final WebDriver driver) {
        element = driver.findElement(By.id("pendingMask"));
        return element;
    }
    /**
     * Returns text no results found when search does not return results .
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement noResultsFound(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"resultsSection\"]/div[2]/div/table/thead/tr/td/div/div/p"));
        return element;
    }

    /**
     * Returns the result count element.
     * @param driver webdriver
     * @return the the result count element
     */
    public static WebElement resultCount(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/thead/tr/td/div/div/div/div"));
        return element;
    }
    /**
     * Returns results section that shows search results.
     * @param driver webdriver
     * @return results section element
     */
    public static WebElement resultsSection(final WebDriver driver) {
        element = driver.findElement(By.id("resultsSection"));
        return element;
    }
    /**
     * Returns status column in results section.
     * @param driver webdriver
     * @return data element in status column
     */
    public static WebElement resultsStatus(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"resultsSection\"]/div[2]/div/table/tbody/tr/td[7]"));
        return element;
    }

    /**
     * Returns the first search result's CHPL ID.
     * @param driver webdriver
     * @return the first search result's CHPL ID
     */
    public static WebElement searchResultsChplId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]"));
        return element;
    }
    /**
     * Returns main search field element.
     * @param driver webdriver
     * @return the search field element
     */
    public static WebElement searchField(final WebDriver driver) {
        element = driver.findElement(By.id("searchField"));
        return element;
    }

}
