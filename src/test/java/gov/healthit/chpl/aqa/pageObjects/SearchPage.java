package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SearchPage definition.
 */
public final class SearchPage {
    private SearchPage() {}

    private static WebElement element = null;

    /**
     * Returns the acbFiltersLink.
     * @param driver WebDriver
     * @return acbFilters Link
     */
    public static WebElement acbFiltersLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[5]/ul/li[5]/st-list-multiple/ul/li[6]/label"));
        return element;
    }

    /**
     * Returns the certification status filter button.
     * @param driver WebDriver
     * @return filter status button element
     */
    public static WebElement certStatusFiltersButton(final WebDriver driver) {
        element = driver.findElement(By.id("filter-status-button"));
        return element;
    }

    /**
     * Returns filter option.
     * @param driver WebDriver
     * @param selectfilter is desired filter name
     * @return filter option element
     */
    public static WebElement filterOption(final WebDriver driver, final String selectfilter) {
        element = driver.findElement(By.id("filter-list-" + selectfilter.replaceAll(" ", "_")));
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
     * @param driver WebDriver
     * @return the first search result's details button
     */
    public static WebElement detailsLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
        return element;
    }

    /**
     * Returns Get EHR Certification ID button.
     * @param driver WebDriver
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
     * @param driver WebDriver
     * @return the the result count element
     */
    public static WebElement resultCount(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/thead/tr/td/div/div/div/div"));
        return element;
    }

    /**
     * Returns results section that shows search results.
     * @param driver WebDriver
     * @return results section element
     */
    public static WebElement resultsSection(final WebDriver driver) {
        element = driver.findElement(By.id("resultsSection"));
        return element;
    }

    /**
     * Returns status column in results section.
     * @param driver WebDriver
     * @return data element in status column
     */
    public static WebElement resultsStatus(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"resultsSection\"]/div[2]/div/table/tbody/tr/td[7]/a"));
        return element;
    }

    /**
     * Returns the first search result's CHPL ID.
     * @param driver WebDriver
     * @return the first search result's CHPL ID
     */
    public static WebElement searchResultsChplId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]"));
        return element;
    }

    /**
     * Returns main search field element.
     * @param driver WebDriver
     * @return the search field element
     */
    public static WebElement searchField(final WebDriver driver) {
        element = driver.findElement(By.id("searchField"));
        return element;
    }

    /**
     * Returns 'Select All' link on Certification Status' filter.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement selectAllStatus(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[1]/ul/st-list-multiple/ul/li[1]/a[1]"));
        return element;
    }

    public static WebElement viewONCACBList(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[5]/ul/li[4]/a"));
    }
}
