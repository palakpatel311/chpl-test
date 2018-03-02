package gov.healthit.chpl.aqa.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ListingDetailsPage definition.
 */
public final class ListingDetailsPage {

    private ListingDetailsPage() {}
    private static WebElement element = null;
    public static WebElement accessibilityStandardText(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/div/table/tbody/tr[3]/td[2]/ul/li[1]"));
        return element;
    }

    public static WebElement additionalInfoAccordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-additional-information"));
        return element;
    }

    public static WebElement certificationCriteriaAccordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-certification-criteria"));
        return element;
    }

    /**
     * Get the link to a criteria details section.
     * @param driver WebDriver
     * @param number criteria number
     * @return the link element
     */
    public static WebElement certificationCriteriaDetailsLink(final WebDriver driver, final String number) {
        element = driver.findElement(By.id("criteria_" + number + "_details_link"));
        return element;
    }

    /**
     * Return CMS Widget button for listing.
     * @param driver WebDriver
     * @param id database id of listing
     * @return the button
     */
    public static WebElement cmsWidgetButton(final WebDriver driver, final String id) {
        element = driver.findElement(By.id("toggle-cms-" + id));
        return element;
    }

    public static WebElement cqmAccordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-cqm"));
        return element;
    }

    /**
     * Returns the Transparency Disclosure URL.
     *
     * @param driver WebDriver
     * @return the transparency disclosure URL
     */
    public static WebElement disclosureUrl(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/span/div[2]/a"));
        return element;
    }

    public static WebElement downloadSEDDetailsButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"sed-tasks-table\"]/tfoot/tr/td/button"));
        return element;
    }

    public static WebElement editCertifiedProductLink(final WebDriver driver) {
        element = driver.findElement(By.linkText("Edit Certified Product"));
        return element;
    }

    public static WebElement g1G2Accordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-g1g2"));
        return element;
    }

    public static WebElement intendedUserDescriptionTitle(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[2]/h4"));
        return element;
    }

    public static WebElement listingName(final WebDriver driver) {
        element = driver.findElement(By.id("listingName"));
        return element;
    }

    public static WebElement mainContent(final WebDriver driver) {
        element = driver.findElement(By.id("mainContent"));
        return element;
    }

    public static WebElement qmsStandardText(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[53]/div/div/div/table/tbody/tr[3]/td[2]/ul/li"));
        return element;
    }

    public static WebElement sedAccordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-sed"));
        return element;
    }

    public static WebElement sedCriteriaTable(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]"));
        return element;
    }

    /**
     * Returns certification criteria from the SED accordion.
     *
     * @param driver WebDriver
     * @param index the "nth" criteria (1-based)
     * @return the criteria at the "nth" position
     */
    public static WebElement sedCertificationCriteria(final WebDriver driver, final String index) {
        element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[" + index + "]"));
        return element;
    }

    public static WebElement surveillanceActivitiesAccordion(final WebDriver driver) {
        element = driver.findElement(By.id("details-surveillance-activities"));
        return element;
    }

    /**
     * Get the Test Procedure value for a given criteria.
     * @param driver WebDriver
     * @param number certification criteria
     * @return the test procedure element
     */
    public static WebElement testProcedure(final WebDriver driver, final String number) {
        WebElement table = driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_header\"]/div/table/tbody"));
        ArrayList<WebElement> rows = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            ArrayList<WebElement> cols = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
            if (cols.get(0).getText().equalsIgnoreCase("Test procedure")) {
                return cols.get(1);
            }
        }
        return null;
    }

    public static WebElement ucdProcessText(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr/td[2]"));
        return element;
    }

    public static WebElement usabilityReportTitle(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[1]/h4"));
        return element;
    }
}
