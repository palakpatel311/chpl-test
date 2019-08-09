package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SurveillanceReportPage definition.
 */
public final class SurveillanceReportPage extends BasePage {
    private SurveillanceReportPage() {}

    public static WebElement surveillancePageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h1[contains(text(),'CHPL Surveillance')]"));
    }

    public static WebElement expandOncAcbs(final WebDriver driver, final String acbName) {
        return driver.findElement(By.xpath("//div[@id='onc-acb-" + acbName + "']"));
    }

    public static WebElement availableYearQuarterForAcbs(final WebDriver driver, final String acbName) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/ui-view/div"));
    }

    public static WebElement initiateSurveillanceReport(final WebDriver driver, final String acbNameYearQuarter) {
        return driver.findElement(By.xpath("//button[@id='initiate-" + acbNameYearQuarter + "']"));
    }

    public static WebElement quarterlySurveillanceReportingTitle(final WebDriver driver, final String pageTitle) {
        return driver.findElement(By.xpath("//h2[contains(text(),'" + pageTitle + "')]"));
    }

    public static WebElement quarterlySurveillanceReportingSubtitle(final WebDriver driver, final String subTitle) {
        return driver.findElement(By.xpath("//strong[contains(text(),'" + subTitle + "')]"));
    }

    public static WebElement yesToConfirm(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

    public static WebElement confirmMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]"));
    }

    public static WebElement yesToConfirmDelte(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

    public static WebElement deleteReportButton(final WebDriver driver) {
        return driver.findElement(By.id("quarterly-suveillance-delete"));
    }

    public static WebElement transparencyDisclosureField(final WebDriver driver) {
        return driver.findElement(By.xpath("//textarea[@id='transparency-disclosure']"));
    }

    public static WebElement quarterlyReportFieldInput(final WebDriver driver, final String fieldInputId) {
        return driver.findElement(By.xpath("//textarea[@id='" + fieldInputId + "']"));
    }

    public static WebElement saveQuarterlyReport(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='quarterly-surveillance-save']"));
    }

    public static WebElement editSurveillanceReport(final WebDriver driver, final String acbNameYearQuarter) {
        return driver.findElement(By.xpath("//button[@id='act-" + acbNameYearQuarter + "']"));
    }

    public static WebElement surveillancePageSubtitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[contains(text(),'Available reports')]"));
    }
}

