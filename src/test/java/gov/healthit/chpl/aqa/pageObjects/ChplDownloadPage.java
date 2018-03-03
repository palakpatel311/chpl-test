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
     * Returns element holding main content.
     * @param driver WebDriver
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

    public static WebElement downloadFileButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadChplLink\"]"));
        return element;
    }

    public static WebElement downloadDefinitionButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadChplDefinitionLink\"]"));
        return element;
    }

    public static WebElement downloadoption2015editionProductsFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[1]"));
        return element;
    }
    public static WebElement downloadoption2014editionProductsFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[2]"));
        return element;
    }

    public static WebElement downloadoption2011editionProductsFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[3]"));
        return element;
    }

    public static WebElement downloadoption2015summaryFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[4]"));
        return element;
    }
    public static WebElement downloadoption2014summaryFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[5]"));
        return element;
    }
    public static WebElement downloadoptionSurveillanceFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[6]"));
        return element;
    }
    public static WebElement downloadoptionNonconformitiesFile(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"downloadSelect\"]/option[7]"));
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