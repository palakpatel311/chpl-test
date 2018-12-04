package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class CMSidReverseLookupPage definition.
 */
public final class CMSidReverseLookupPage extends BasePage {
    private CMSidReverseLookupPage() {}

    /**
     * Returns paragraph that contains CMS ID.
     * @param driver WebDriver
     * @return the results paragraph
     */
    public static WebElement cmsIdResults(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"widget-dropdown\"]/ai-cms-widget-display/div/p/strong"));
    }

    /**
     * Certification Id input field element on CMS ID Reverse Lookup Page.
     * @param driver WebDriver
     * @return the cert ID element
     */
    public static WebElement inputCertificationId(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"certIdsField\"]"));
    }

    /**
     * Element to locate chpl Id column in certification Id results table on CMS ID Reverse Lookup Page.
     * @param driver WebDriver
     * @return the column body element
     */
    public static WebElement chplIdColumnInCertIdResultsTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody"));
    }

    /**
     * Get the button that generates a CMS Cert ID.
     * @param driver WebDriver
     * @return the button
     */
    public static WebElement generateCmsIdButton(final WebDriver driver) {
       return driver.findElement(By.id("get-ehr-cert-id"));
    }

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        return driver.findElement(By.id("main-content"));
    }

    /**
     * Results section that shows CMS ID look up results in reverse lookup tool.
     * @param driver WebDriver
     * @return results section element
     */
    public static WebElement searchLookupResults(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div/div/div/span/button/i"));
    }

    /**
     * Toggle for widget display.
     * @param driver WebDriver
     * @return the toggle
     */
    public static WebElement widgetToggle(final WebDriver driver) {
        return driver.findElement(By.id("widget-toggle"));
    }
}
