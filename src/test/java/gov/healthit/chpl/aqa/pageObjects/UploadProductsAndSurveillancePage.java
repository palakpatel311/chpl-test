package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class UploadProductsAndSurveillancePage definition.
 */
public class UploadProductsAndSurveillancePage {

    private WebDriver driver;
    private static WebElement element = null;

    /**
     * Returns choose file button element.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement chooseFileButton(final WebDriver driver) {
        element = driver.findElement(By.id("listing-file-upload"));
        return element;
    }

    /**
     * Returns element that holds text message displayed after successful upload.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement successfulUploadTextMessage(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[1]/div"));
        return element;
    }

    /**
     * Returns upload file button element.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement uploadFileButton(final WebDriver driver) {
        element = driver.findElement(By.id("listing-file-confirm-0"));
        return element;
    }

    /**
     * Returns Upload Products and Surveillance link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement uploadProductsAndSurveillanceLink(final WebDriver driver) {
        element = driver.findElement(By.linkText("Upload Products & Surveillance"));
        return element;
    }

}
