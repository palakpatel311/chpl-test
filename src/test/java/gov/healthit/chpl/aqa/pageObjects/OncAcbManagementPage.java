package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class OncAcbManagementPage definition.
 */
public final class OncAcbManagementPage extends BasePage {
    private OncAcbManagementPage() {}

    public static WebElement oncACBManagementLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(),'ONC-ACB Management')]"));
    }

    public static WebElement oncACBName(final WebDriver driver, final String oncAcbName) {
        return driver.findElement(By.xpath(" //a[contains(text(),'" + oncAcbName + "')]"));
    }

    public static WebElement editONCACB(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/ai-acb-management/section/div/div[2]/div/button"));
    }

    public static WebElement markRetirementStatus(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"acb-retired\"]"));
    }

    public static WebElement retirementDate(final WebDriver driver) {
        return driver.findElement(By.xpath("///*[@id=\"retirement-date\"]"));
    }

    public static WebElement saveONCACB(final WebDriver driver) {
        return driver.findElement(By.xpath("\r\n" + "/html/body/div[1]/div/div/div/div[3]/button[1]"));
    }

    public static WebElement retirementStatus(final WebDriver driver, final String retirementStatus) {
        return driver.findElement(By.xpath("//span[contains(text(),'Retired: " + retirementStatus + "')]"));
    }

    public static WebElement retirementDateIs(final WebDriver driver, final String reitrementDate) {
        return driver.findElement(By.xpath("//span[contains(text(),'Retirement Date:" + reitrementDate + "')]"));
    }

    public static WebElement errorMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/p"));
    }
}

