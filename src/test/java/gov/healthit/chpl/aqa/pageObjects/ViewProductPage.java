package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ViewProductPage definition.
 */
public final class ViewProductPage extends BasePage {
    private ViewProductPage() {
    }

    public static WebElement viewProductPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//span[contains(text(),'View Product')]"));
    }

    public static WebElement editProductLink(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"product-component-edit-" + productId + "\"]/i"));
    }

    public static WebElement splitProductLink(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"product-component-split-" + productId + "\"]/i"));
    }

    public static WebElement mergeProductLink(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"product-component-merge-" + productId + "\"]/i"));
    }

    public static WebElement productNameField(final WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='productName']"));
    }

    public static WebElement productNameMissingErrorMessage(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-product-" + productId + "\"]/span/div/div/div"));
    }

    public static WebElement editProductSaveButton(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"product-component-save-" + productId + "\"]"));
    }

    public static WebElement viewProductName(final WebDriver driver, final String productId) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-product-" + productId + "\"]/span/span[2]"));
    }
}

