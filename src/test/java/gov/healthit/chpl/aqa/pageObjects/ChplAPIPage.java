package gov.healthit.chpl.aqa.pageObjects;

import java.util.List;

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

    /**
     * Returns Content text under Certified Health IT Product Listing.
     * @param driver Webdriver
     * @return content
     */
    public static WebElement chplContentText(final WebDriver driver) {
        return driver.findElement(By.xpath("//span[@swagger-translate='infoContactCreatedBy']"));
    }

    /**
     * Returns Health IT Feedback Form URL.
     * @param driver WebDriver
     * @return URL
     */
    public static WebElement healthITFeedBackFormURL(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[@ng-bind='ui.infos.contact.url']"));
    }

    /**
     * Returns element holding page title.
     * @param driver WebDriver
     * @return element holding page title
     */
    public static WebElement title(final WebDriver driver) {
        return driver.findElement(By.xpath("//h1[contains(text(),'CHPL API')]"));
    }

    /**
     * Returns element swagger holding contents of Controller.
     * @param driver WebDriver
     * @return element holding contents of Controller
     */
    public static List<WebElement> controllerElementList(final WebDriver driver) {
        return driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"));
    }

    /**
     * Returns element holding the name of Controller.
     * @param driver WebDriver
     * @param xPathElement holding name of Controller
     * @return element holding name of Controller
     */
    public static WebElement controllerElementName(final WebDriver driver, final String xPathElement) {
        return driver.findElement(By.xpath(xPathElement));
    }
}


