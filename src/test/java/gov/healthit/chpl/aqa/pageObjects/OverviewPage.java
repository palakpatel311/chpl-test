package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class OverviewPage definition.
 */
public final class OverviewPage extends BasePage {

    private OverviewPage() {}

    /**
     * Returns element holding ACB/ATL table.
     * @param driver WebDriver
     * @return element holding ACB/ATL table
     */
    public static WebElement acbAtlTable(final WebDriver driver) {
        return driver.findElement(By.id("acbAtlTable"));
    }

    /**
     * Returns element holding header text.
     * @param driver WebDriver
     * @param headerNumber is header location order on page that makes xpath unique for each header
     * @return header text element
     */
    public static WebElement headerText(final WebDriver driver, final String headerNumber) {
       return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/h2[" + headerNumber + "]"));
    }

    /**
     * Returns link element by link text.
     * @param driver WebDriver
     * @param linkText is link text to find the link on page
     * @return link element
     */
    public static WebElement navLinksOnOverviewPage(final WebDriver driver, final String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    /**
     * Returns element holding page content.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement pageContent(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]"));
     }

    /**
     * Returns element holding page title.
     * @param driver WebDriver
     * @return element holding page title
     */
    public static WebElement title(final WebDriver driver) {
        return driver.findElement(By.id("pageTitle"));
    }
}
