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

    public static WebElement searchField(final WebDriver driver) {
        element = driver.findElement(By.id("searchField"));
        return element;
    }
    public static WebElement searchResultsChplId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]"));
        return element;
    }

    public static WebElement detailsLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
        return element;
    }

    public static WebElement disclosureUrl(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/span/div[2]/a"));
        return element;
    }

}
