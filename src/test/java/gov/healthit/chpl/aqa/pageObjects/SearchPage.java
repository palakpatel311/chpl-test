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

    public static WebElement certId_Link1(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"toggle-cms-8169\"]"));
        return element;
    }

    public static WebElement certId_Link2(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"toggle-cms-8969\"]"));
        return element;
    }

    public static WebElement getEHR_certId(final WebDriver driver) {
        element = driver.findElement(By.id("get-ehr-cert-id"));
        return element;
    }

    /**
     * Returns the first search details button.
     *
     * @param driver webdriver
     * @return the first search result's details button
     */
    public static WebElement detailsLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
        return element;
    }

    /**
     * Returns main search field element.
     *
     * @param driver webdriver
     * @return the search field element
     */
    public static WebElement searchField(final WebDriver driver) {
        element = driver.findElement(By.id("searchField"));
        return element;
    }

    /**
     * Returns the result count element.
     *
     * @param driver webdriver
     * @return the the result count elemetn
     */
    public static WebElement resultCount(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/thead/tr/td/div/div/div/div"));
        return element;
    }

    /**
     * Returns the first search result's CHPL ID.
     *
     * @param driver webdriver
     * @return the first search result's CHPL ID
     */
    public static WebElement searchResultsChplId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]"));
        return element;
    }
}
