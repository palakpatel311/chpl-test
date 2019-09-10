package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SurveillanceReportPage definition.
 */
public final class SurveillanceReportPage extends BasePage {
    private SurveillanceReportPage() {}

    public static WebElement confirmMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]"));
    }

    public static WebElement deleteReportButton(final WebDriver driver) {
        return driver.findElement(By.id("quarterly-suveillance-delete"));
    }

    public static WebElement editSurveillanceDataButton(final WebDriver driver, final String friendlySurvId) {
        return driver.findElement(By.xpath("//*[@id=\"edit-surveillance-data-" + friendlySurvId + "\"]/i"));
    }

    public static WebElement editSurveillanceReport(final WebDriver driver, final String acbNameYearQuarter) {
        return driver.findElement(By.id("act-" + acbNameYearQuarter));
    }

    public static WebElement groundsForInitiatingInput(final WebDriver driver) {
        return driver.findElement(By.id("grounds-for-initiating"));
    }

    public static WebElement initiateSurveillanceReport(final WebDriver driver, final String acbNameYearQuarter) {
        return driver.findElement(By.id("initiate-" + acbNameYearQuarter));
    }

    public static WebElement listingsWithRelevantSurveillanceAccordion(final WebDriver driver) {
        return driver.findElement(By.id("relevant-listings-header"));
    }

    public static WebElement oncAcbs(final WebDriver driver, final String acbName) {
        return driver.findElement(By.id("onc-acb-" + acbName));
    }

    public static WebElement quarterlyReportFieldInput(final WebDriver driver, final String fieldInputId) {
        return driver.findElement(By.id(fieldInputId));
    }

    public static WebElement quarterlySurveillanceReportingSubtitle(final WebDriver driver, final String subTitle) {
        return driver.findElement(By.xpath("//strong[contains(text(),'" + subTitle + "')]"));
    }

    public static WebElement quarterlySurveillanceReportingTitle(final WebDriver driver, final String pageTitle) {
        return driver.findElement(By.xpath("//h2[contains(text(),'" + pageTitle + "')]"));
    }

    public static WebElement saveQuarterlyReport(final WebDriver driver) {
        return driver.findElement(By.id("quarterly-surveillance-save"));
    }

    public static WebElement saveSurveillanceDataButton(final WebDriver driver) {
        return driver.findElement(By.id("save-surveillance-data"));
    }

    public static WebElement surveillanceadditionalCostEvaluation(final WebDriver driver) {
        return driver.findElement(By.id("additional-costs-evaluation"));
    }

    public static WebElement surveillanceCompletedCapVerification(final WebDriver driver) {
        return driver.findElement(By.id("completed-cap-verification"));
    }

    public static WebElement surveillanceDirectionDeveloperResolution(final WebDriver driver) {
        return driver.findElement(By.id("direction-developer-resolution"));
    }

    public static WebElement surveillanceLimitationsEvaluation(final WebDriver driver) {
        return driver.findElement(By.id("limitations-evaluation"));
    }

    public static WebElement surveillanceNonDisclosureEvaluation(final WebDriver driver) {
        return driver.findElement(By.id("nondisclosure-evaluation"));
    }

    public static WebElement surveillanceOutcomeDropdown(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-outcome"));
    }

    public static WebElement surveillanceProcessTypeDropdown(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-process-type"));
    }

    public static WebElement surveillancePotentialCauses(final WebDriver driver) {
        return driver.findElement(By.id("nonconformity-causes"));
    }

    public static WebElement surveillanceNonConformityNature(final WebDriver driver) {
        return driver.findElement(By.id("nonconformity-nature"));
    }

    public static WebElement surveillanceStepsToEngage(final WebDriver driver) {
        return driver.findElement(By.id("steps-to-engage"));
    }

    public static WebElement surveillanceStepsToSurveil(final WebDriver driver) {
        return driver.findElement(By.id("steps-to-surveil"));
    }

    public static WebElement surveillancePageSubtitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[contains(text(),'Available reports')]"));
    }

    public static WebElement surveillancePageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h1[contains(text(),'CHPL Surveillance')]"));
    }

    public static WebElement transparencyDisclosureField(final WebDriver driver) {
        return driver.findElement(By.id("transparency-disclosure"));
    }

    public static WebElement viewListingSurveillanceDataButton(final WebDriver driver, final String chplId) {
        return driver.findElement(By.id("view-listing-data-" + chplId));
    }

    public static WebElement yesToConfirm(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

    public static WebElement yesToConfirmDelte(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

}

