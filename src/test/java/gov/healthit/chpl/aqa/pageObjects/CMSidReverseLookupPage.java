package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class CMSidReverseLookupPage definition.
 */
public final class CMSidReverseLookupPage {

    private CMSidReverseLookupPage() {}
    private static WebElement element = null;

    /**
     * Returns paragraph that contains CMS ID.
     * @param driver WebDriver
     * @return the results paragraph
     */
    public static WebElement cmsIdResults(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"widget-dropdown\"]/ai-cms-widget-display/div/p/strong"));
        return element;
    }

    public static WebElement inputCertificationId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"certIdsField\"]"));
        return element;
    }

    public static WebElement chplIdColumnInCertIdResultsTable(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody"));
        return element;
    }

    /**
     * Get the button that generates a CMS Cert ID.
     * @param driver WebDriver
     * @return the button
     */
    public static WebElement generateCmsIdButton(final WebDriver driver) {
        element = driver.findElement(By.id("get-ehr-cert-id"));
        return element;
    }

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("mainContent"));
        return element;
    }

    public static WebElement searchLookupResults(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div/div/div/span/button/i"));
        return element;
    }

    /**
     * Toggle for widget display.
     * @param driver WebDriver
     * @return the toggle
     */
    public static WebElement widgetToggle(final WebDriver driver) {
        element = driver.findElement(By.id("widget-toggle"));
        return element;
    }
}
