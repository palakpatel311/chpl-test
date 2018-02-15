package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ChplDownloadPage definition.
 */
public class ChplDownloadPage {

    private WebDriver driver;
    private static WebElement element = null;

    /**
     * Returns element holding main content
     * @driver webdriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("mainContent"));
        return element;
    }

    public static WebElement definitionSelectList(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"definitionSelect\"]"));
        return element;
    }

    public static WebElement downloadSelectList(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='downloadSelect']"));
        return element;
    }

    public static WebElement loginButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"admin\"]/li/div/form/button[1]"));
        return element;
    }

    public static WebElement loginMenuDropdown(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"login-toggle\"]/span[1]"));
        return element;
    }

}
