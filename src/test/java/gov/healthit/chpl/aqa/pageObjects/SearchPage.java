package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SearchPage definition.
 */
public final class SearchPage extends BasePage {
    private SearchPage() {}

    /**
     * Returns the acbFiltersLink.
     * @param driver WebDriver
     * @return acbFilters Link
     */
    public static WebElement acbFiltersLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[5]/ul/li[5]/st-list-multiple/ul/li[6]/label"));
    }

    /**
     * Returns the certification status filter button.
     * @param driver WebDriver
     * @return filter status button element
     */
    public static WebElement certStatusFiltersButton(final WebDriver driver) {
        return driver.findElement(By.id("filter-status-button"));
    }

    /**
     * Returns filter option.
     * @param driver WebDriver
     * @param selectfilter is desired filter name
     * @return filter option element
     */
    public static WebElement filterOption(final WebDriver driver, final String selectfilter) {
        return driver.findElement(By.id("filter-list-" + selectfilter.replaceAll(" ", "_")));
    }

    /**
     * Returns Browse button on Search page.
     * @param driver WebDriver
     * @return Browse button element
     */
    public static WebElement browseButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/div[1]/span[2]/button"));
    }

    /**
     * Returns the first search details button.
     * @param driver WebDriver
     * @return the first search result's details button
     */
    public static WebElement detailsLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
    }

    /**
     * Returns Get EHR Certification ID button.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement getEHRCertId(final WebDriver driver) {
        return driver.findElement(By.id("get-ehr-cert-id"));
     }

    /**
     * Returns 'More' filter button.
     * @param driver WebDriver
     * @return 'More' filter button element
     */
    public static WebElement moreFilter(final WebDriver driver) {
        return driver.findElement(By.id("filter-more-button"));
    }

    /**
     * Returns the pending mask "black screen".
     * @param driver WebDriver
     * @return the pending mask
     */
    public static WebElement pendingMask(final WebDriver driver) {
        return driver.findElement(By.id("pendingMask"));
    }

    /**
     * Returns text no results found when search does not return results .
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement noResultsFound(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"resultsSection\"]/div[2]/div/table/thead/tr/td/div/div/p"));
    }


    /**
     * Returns the result count element.
     * @param driver WebDriver
     * @return the the result count element
     */
    public static WebElement resultCount(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/thead/tr/td/div/div/div/div"));
    }

    /**
     * Returns results section that shows search results.
     * @param driver WebDriver
     * @return results section element
     */
    public static WebElement resultsSection(final WebDriver driver) {
        return driver.findElement(By.id("resultsSection"));
    }

    /**
     * Returns status column in results section.
     * @param driver WebDriver
     * @return data element in status column
     */
    public static WebElement resultsStatus(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"resultsSection\"]/div[2]/div/table/tbody/tr/td[7]/a"));
    }

    /**
     * Returns the first search result's CHPL ID.
     * @param driver WebDriver
     * @return the first search result's CHPL ID
     */
    public static WebElement searchResultsChplId(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]"));
    }

    /**
     * Returns main search field element.
     * @param driver WebDriver
     * @return the search field element
     */
    public static WebElement searchField(final WebDriver driver) {
        return driver.findElement(By.id("searchField"));
    }

    /**
     * Returns 'Select All' link on Certification Status' filter.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement selectAllStatus(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[1]/ul/st-list-multiple/ul/li[1]/a[1]"));
    }

    /**
     * Returns ONC ACB list on search filters.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement viewONCACBList(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[5]/ul/li[4]/a"));
    }

    /**
     * Returns download search results button on top search filters.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement downloadsearchResultsButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='dropdown-download-button']"));
    }

    /**
     * Returns download search results button for default 50 search results download on dropdown list.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement download50ResultButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[6]/ul/ai-results-download/li[13]/button"));
    }

    /**
     * Returns page size filter dropdown on search results page.
     * @param driver WebDriver
     * @return dropdown list element
     */
    public static WebElement searchResultPerPage(final WebDriver driver) {
        return driver.findElement(By.xpath("//select[@id='pageSizeTop']"));
    }

    /**
     * Returns text shown on search results dropdown filter for greater than 50 size selection.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement searchResultText(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[6]/ul/ai-results-download/li[13]/span"));
    }

    /**
     * Returns text that holds chpl id in search results.
     * @param driver WebDriver
     * @param chplID is CHPL ID on search results
     * @return text element
     */
    public static WebElement loadChplID(final WebDriver driver, final String chplID) {
        return driver.findElement(By.xpath("//td[contains(text(),'" + chplID + "')]"));
    }

    /**
     * Returns elements in Certification Status filter.
     * @param driver WebDriver
     * @return list element
     */
    public static WebElement certStatusFilterOptions(final WebDriver driver) {
        return driver.findElement(By.cssSelector("#filters > div.col-sm-8 > div.btn-group.dropdown.open > ul"));
    }

    public static WebElement surveillanceDropdown(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='surveillance-toggle']"));
    }

    public static WebElement complaintsReporting(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-dropdown-menu\"]/li[4]/a"));
    }
}
