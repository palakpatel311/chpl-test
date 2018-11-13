package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ChplAPIPage definition.
 */
public final class ChplAPIPage extends BasePage {

    private ChplAPIPage() {}

    /**
     * Controller link.
     * @param driver WebDriver
     * @return controller link element
     * @param controller desired controller to open
     */
    public static WebElement controllerLink(final WebDriver driver, final String controller) {
        return driver.findElement(By.xpath("//*[@id=\"" + controller + "*\"]/li/h4/a"));
    }

    /**
     * Certified Product Endpoint Implementation Notes.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement certifiedProductsImplementationNotes(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[2]/div/ul"));
    }

    /**
     * Endpoint link.
     * @param driver WebDriver
     * @return link element
     * @param endpoint is given endpoint to view details
     */
    public static WebElement endpointLink(final WebDriver driver, final String endpoint) {
        return driver.findElement(By.xpath("//*[@id=\"" + endpoint + "\"]/a/div/span[1]"));
    }
    /*
    public static WebElement healthITFeedBackFormLink(final WebDriver driver) {
        element = driver.findElement(By.xpath("//a[contains(text(),'https://www.healthit.gov/form/healthit-feedback-fo')]"));
        return element;
    }*/
    /**
     * Content text under Certified Health IT Product Listing.
     * @param driver Webdriver
     * @return content
     */
    public static WebElement chplContentText(final WebDriver driver) {
        return driver.findElement(By.xpath("//span[@swagger-translate='infoContactCreatedBy']"));
    }
    /**
     * Health IT Feedback Form URL.
     * @param driver WebDriver
     * @return URL
     */
    public static WebElement healthITFeedBackFormURL(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[@ng-bind='ui.infos.contact.url']"));
    }

}
