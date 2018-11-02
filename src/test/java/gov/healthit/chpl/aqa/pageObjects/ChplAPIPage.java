package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ChplAPIPage definition.
 */
public final class ChplAPIPage {
    private ChplAPIPage() {}
    private static WebElement element = null;

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
     * Controller link.
     * @param driver WebDriver
     * @return controller link element
     * @param controller desired controller to open
     */
    public static WebElement controllerLink(final WebDriver driver, final String controller) {
        element = driver.findElement(By.xpath("//*[@id=\"" + controller + "*\"]/li/h4/a"));
        return element;
    }

    /**
     * Certified Product endpoint link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement certifiedProductsEndpoint(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"getCertifiedProductsByVersionUsingGET\"]/a/div/span[3]"));
        return element;
    }

    /**
     * Certified Product Endpoint Implementation Notes.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement certifiedProductsImplementationNotes(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[2]/div/ul/li[19]/ul/li[1]/div[2]/div/p"));
        return element;
    }
}
