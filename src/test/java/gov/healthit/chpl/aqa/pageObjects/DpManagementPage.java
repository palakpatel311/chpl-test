package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class DpManagementPage definition.
 */

public class DpManagementPage {
    private WebDriver driver;
    private static WebElement element = null;

    /**
     * Returns choose file button for new listing upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement chooseFileForNewListingUploadButton(final WebDriver driver) {
        element = driver.findElement(By.id("listing-file-upload"));
        return element;
    }

    /**
     * Returns choose file button for bulk surveillance upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement chooseFileForSurveillanceUploadButton(final WebDriver driver) {
        element = driver.findElement(By.id("surveillance-file-upload"));
        return element;
    }

    /**
     * Get the CHPL Product Number value in surveillance search results.
     * @param driver WebDriver
     * @return the CHPL Product Number element
     * returns null if element was not found
     */
    public static WebElement chplProductNumber(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div/div[3]/table/tbody/tr[1]/td"));
        return element;
    }

    /**
     * Returns Developer and Product Management link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement dpManagementLink(final WebDriver driver) {
        element = driver.findElement(By.linkText("Developer & Product Management"));
        return element;
    }

    /**
     * Returns Manage Surveillance Activity link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement manageSurveillanceActivityLink(final WebDriver driver) {
        element = driver.findElement(By.linkText("Manage Surveillance Activity"));
        return element;
    }

    /**
     * Returns Confirm Pending Products link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement confirmPendingProductsLink(final WebDriver driver) {
        element = driver.findElement(By.linkText("Confirm Pending Product"));
        return element;
    }

    /**
     * Returns Pending Listings table in Confirm Pending Listings section.
     * @param driver WebDriver
     * @return table element
     */
    public static WebElement pendingListingsTable(final WebDriver driver) {
        element = driver.findElement(By.id("pending-listings-table"));
        return element;
    }

    /**
     * Returns surveillanceSearch input box.
     * @param driver WebDriver
     * @return surveillanceSearch element
     */
    public static WebElement surveillanceSearch(final WebDriver driver) {
        element = driver.findElement(By.id("surveillanceSearch"));
        return element;
    }

    /**
     * Returns Surveillance search button.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement survSearchButton(final WebDriver driver) {
        element = driver.findElement(By.id("surveillance-search-button"));
        return element;
    }

    /**
     * Returns upload file button for new listing upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement uploadChosenNewListingFileButton(final WebDriver driver) {
        element = driver.findElement(By.cssSelector("[id^='listing-file-confirm-']"));
        return element;
    }

    /**
     * Returns upload file button for new listing upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement uploadChosenSurveillanceFileButton(final WebDriver driver) {
        element = driver.findElement(By.cssSelector("[id^='surveillance-file-confirm-']"));
        return element;
    }

}
