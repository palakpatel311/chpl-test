package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class SurveillanceManagePage definition.
 */
public final class SurveillanceManagePage extends BasePage {
    private SurveillanceManagePage() {}

    public static WebElement generalFilterInput(final WebDriver driver) {
        return driver.findElement(By.id("generalFilter"));
    }

    public static WebElement chplIdButtonInFilteredResults(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-manage\"]"
                + "/div[2]/div/div/div/div[1]/div[2]/div/div/div/table/tbody/tr/td[1]/button"));
    }

    public static WebElement chplIdTab(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-manage\"]/div[2]/div/div/ul/li[2]/a/uib-tab-heading"));
    }

    /* need IDs for page objects on Manage Surveillance*/
    public static WebElement editSurveillanceButton(final WebDriver driver) {
        return driver.findElement(
                By.xpath("//*[@id=\"surveillance-manage\"]/div[2]/div/div/div/div[2]/span/chpl-surveillance-management-view/div/ai-surveillance/div/div[1]/div/button"));
    }

    public static WebElement errorTextOnSurveillanceInspect(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/ai-surveillance-inspect/div/div[2]/div[1]/div/strong/div/ul/li"));
    }

    public static WebElement initiateSurveillanceButton(final WebDriver driver) {
        return driver.findElement(
                By.xpath("//*[@id=\"surveillance-manage\"]/div[2]/div/div/div/div[2]/span/chpl-surveillance-management-view/div/ai-surveillance/div/div[2]/button"));
    }

    public static WebElement manageSurveillanceActivityLink(final WebDriver driver) {
        return driver.findElement(By.linkText("Manage Surveillance Activity"));
    }

    public static WebElement rejectButtonOnSurveillanceInspect(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/ai-surveillance-inspect/div/div[3]/button[1]"));
    }

    public static WebElement surveillanceList(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-manage\"]"
                + "/div[2]/div/div/div/div[2]/span/chpl-surveillance-management-view/div/ai-surveillance/div"));
    }

    public static WebElement surveillanceDataTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-manage\"]"
                + "/div[2]/div/div/div/div[1]/div[2]/div/div/div/table"));
    }
}
