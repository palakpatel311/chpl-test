package gov.healthit.chpl.aqa.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ListingDetailsPage definition.
 */
public final class ListingDetailsPage extends BasePage {

    private static final int CRITERIA_COLUMN = 3;

    private ListingDetailsPage() {}

    public static WebElement accessibilityStandardByCriteriaText(final WebDriver driver, final String criteria) {
        String xpath = "//*[@id=\"criteria_" + criteria + "_details_row_Accessibility_Standard\"]/td[2]/ul/li";
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Returns Additional Information Accordion element.
     * @param driver WebDriver
     * @return Additional Information Accordion element
     */
    public static WebElement additionalInfoAccordion(final WebDriver driver) {
        return driver.findElement(By.id("details-additional-information"));
    }

    /**
     * Returns the element that holds associated criteria number for a Measure Name in Successfully Tested G1/G2 Measures section .
     * @param driver WebDriver
     * @param mName is measure Name
     * @return associatedCriteria element
     * return null if criteria was not found in Associated Criteria column
     */
    public static WebElement associatedCriteria(final WebDriver driver, final String mName) {
        WebElement table = driver.findElement(By.xpath("//*[@id=\"panel-g1g2\"]/ai-g1g2/div/table/tbody"));
        ArrayList<WebElement> rows = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            ArrayList<WebElement> cols = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
            if (cols.get(0).getText().equalsIgnoreCase(mName)) {
                return cols.get(CRITERIA_COLUMN);
            }
        }
        return null;
    }

    /**
     * Return Certification Criteria Accordion on listing page.
     * @param driver WebDriver
     * @return Certification Criteria Accordion element
     */
    public static WebElement certificationCriteriaAccordion(final WebDriver driver) {
        return driver.findElement(By.id("details-certification-criteria"));
    }

    /**
     * Get the link to a criteria details section.
     * @param driver WebDriver
     * @param number criteria number
     * @return the link element
     */
    public static WebElement certificationCriteriaDetailsLink(final WebDriver driver, final String number) {
        return driver.findElement(By.id("criteria_" + number + "_details_link"));
    }

    /**
     * Return CMS Widget button for listing.
     * @param driver WebDriver
     * @param id database id of listing
     * @return the button
     */
    public static WebElement cmsWidgetButton(final WebDriver driver, final String id) {
        return driver.findElement(By.id("toggle-cms-" + id));
    }

    /**
     * CQM Accordion on listing details page.
     * @param driver WebDriver
     * @return CQM Accordion element
     */
    public static WebElement cqmAccordion(final WebDriver driver) {
        return driver.findElement(By.id("details-cqm"));
    }

    /**
     * CQM data Table under CQM accordion.
     * @param driver WebDriver
     * @return Table element
     */
    public static WebElement cqmDataTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-cqm\"]/table"));
    }

    /**
     * Returns the Transparency Disclosure URL.
     * @param driver WebDriver
     * @return the transparency disclosure URL
     */
    public static WebElement disclosureUrl(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"product-information-mandatory-disclosures-url\"]/a"));
    }

    /**
     * Returns download SED details button element to download SED data.
     * @param driver WebDriver
     * @return download SED details button element
     */
    public static WebElement downloadSEDDetailsButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"sed-tasks-table\"]/tfoot/tr/td/button"));
    }

    /**
     * Get the link to edit certified product page.
     * @param driver WebDriver
     * @return edit certified product link element
     */
    public static WebElement editCertifiedProductLink(final WebDriver driver) {
        return driver.findElement(By.linkText("Edit Certified Product"));
    }

    /**
     * Get the Functionality Tested value for a given criteria.
     * @param driver WebDriver
     * @param number certification criteria
     * @return the Functionality Tested value
     */
    public static WebElement functionalityTested(final WebDriver driver, final String number) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_row_Functionality_Tested\"]/td[2]"));
    }

    /**
     * Return G1/G2 Accordion on listing page.
     * @param driver WebDriver
     * @return G1/G2 Accordion element
     */
    public static WebElement g1g2Accordion(final WebDriver driver) {
        return driver.findElement(By.id("details-g1g2"));
    }

    /**
     * Returns the element that holds G1/G2 Measure Name for a criteria.
     * @param driver WebDriver
     * @param criteriaNumber relevant criteria
     * @param g either "G1" or "G2"
     * @return the table cell containing the list of G1 or G2 Measure Names (or "None", if none exist)
     */
    public static WebElement gMeasureName(final WebDriver driver, final String criteriaNumber, final String g) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + criteriaNumber + "_details_row_Measures_" + g + "\"]/td[2]"));
    }

    /**
     * Returns the element that holds Intended User Description Title.
     * @param driver WebDriver
     * @return Title element
     */
    public static WebElement intendedUserDescriptionTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[2]/h4"));
    }

    /**
     * Returns listing name of a listing.
     * @param driver WebDriver
     * @return listing name element
     */
    public static WebElement listingName(final WebDriver driver) {
        return driver.findElement(By.id("listing-name"));
    }

    /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        return driver.findElement(By.id("main-content"));
    }

    /**
     * Returns Meaningful Use Users data.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement meaningfulUseUsers(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-additional-information-estimated-number-of-meaningful-use-users\"]/p"));
    }

    /**
     * Get the Privacy and Security Framework value for a given criteria.
     * @param driver WebDriver
     * @param number certification criteria
     * @return the Privacy and Security Framework value
     */
    public static WebElement privacySecurityFramework(final WebDriver driver, final String number) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_row_Privacy_Security_Framework\"]/td[2]"));
    }

    /**
     * Returns product history eye button element.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement productHistoryEye(final WebDriver driver) {
        return driver.findElement(By.id("view-product-history"));
    }

    /**
     * Returns product history eye button element.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement productHistoryTable(final WebDriver driver) {
        return driver.findElement(By.id("product-history-table"));
    }

    /**
     * Returns text on product history modal.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement productHistoryText(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"product-history-modal\"]/div[2]/span"));
    }

    /**
     * Returns CHPL Product number.
     * @param driver WebDriver
     * @return CHPL Product number element
     */
    public static WebElement productNumber(final WebDriver driver) {
        return driver.findElement(By.xpath("//p[contains(text(),'CHPL Product Number:')]"));
    }

    /**
     * Returns element that holds QMS Standard text.
     * @param driver WebDriver
     * @param number certification criteria
     * @return text element
     */
    public static WebElement qmsStandardText(final WebDriver driver, final String number) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_header\"]/div/table/tbody/tr[3]/td[2]/ul/li"));
    }

    /**
     * Returns element that holds no data in SED section text.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement nosedData(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/p"));
    }

    /**
     * Returns the element that holds Required Text for a Measure Name in Successfully Tested G1/G2 Measures section .
     * @param driver WebDriver
     * @param reqTest is Required Test text
     * @return requiredText element
     * return null if Required text was not found as expected
     */
    public static WebElement measureNameForReqTest(final WebDriver driver, final String reqTest) {
        WebElement table = driver.findElement(By.xpath("//*[@id=\"panel-g1g2\"]/ai-g1g2/div/table/tbody"));
        ArrayList<WebElement> rows = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            ArrayList<WebElement> cols = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
            if (cols.get(1).getText().equalsIgnoreCase(reqTest)) {
                return cols.get(0);
            }
        }
        return null;
    }

    /**
     * View all certification criteria and CQMs check box.
     * @param driver WebDriver
     * @return checkbox input element
     */
    public static WebElement viewAllCertificationCriteriaCQMs(final WebDriver driver) {
        return driver.findElement(By.id("viewAllCerts"));
    }

    /**
     * Return SED Accordion on listing page.
     * @param driver WebDriver
     * @return SED Accordion element
     */
    public static WebElement sedAccordion(final WebDriver driver) {
        return driver.findElement(By.id("details-sed"));
    }

    /**
     * Return SED panel containing SED details on listing page.
     * @param driver WebDriver
     * @return SED panel element
     */
    public static WebElement sedPanel(final WebDriver driver) {
        return driver.findElement(By.id("panel-sed"));
    }

    /**
     * Returns SED Criteria Table element.
     * @param driver WebDriver
     * @return Table element
     */
    public static WebElement sedCriteriaTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]"));
    }

    /**
     * Returns certification criteria from the SED accordion.
     * @param driver WebDriver
     * @param index the "nth" criteria (1-based)
     * @return the criteria at the "nth" position
     */
    public static WebElement sedCertificationCriteria(final WebDriver driver, final String index) {
        return driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[" + index + "]"));
    }

    /**
     * Returns Surveillance Activities Accordion on listing details page.
     * @param driver WebDriver
     * @return Surveillance Activities Accordion element
     */
    public static WebElement surveillanceActivitiesAccordion(final WebDriver driver) {
        return driver.findElement(By.id("details-surveillance-activities"));
    }

    /**
     * Returns Targeted User data from additional Info panel.
     * @param driver WebDriver
     * @return the text element
     */
    public static WebElement targetedUser(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-additional-information-developer-identified-targeted-user\"]/ul/li"));
    }

    /**
     * Get the Test Procedure value for a given criteria.
     * @param driver WebDriver
     * @param number certification criteria
     * @return the test procedure element
     */
    public static WebElement testProcedure(final WebDriver driver, final String number) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_row_Test_procedure\"]/td[2]"));
    }

    /**
     * Get the Test tool value for a given criteria.
     * @param driver WebDriver
     * @param number certification criteria
     * @return the test tool text element
     */
    public static WebElement testTool(final WebDriver driver, final String number) {
        return driver.findElement(By.xpath("//*[@id=\"criteria_" + number + "_details_row_Test_tool\"]/td[2]"));
    }

    /**
     * Returns the Test Results Summary URL.
     * @param driver WebDriver
     * @return the value of URL element
     */
    public static WebElement testResultsSummaryUrl(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-additional-information-test-results-summary\"]/a"));
    }

    /**
     * Returns element that holds UCD Process Text.
     * @param driver WebDriver
     * @return Text element
     */
    public static WebElement ucdProcessText(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr/td[2]"));
    }

    /**
     * Returns the element that holds Usability Report Title.
     * @param driver WebDriver
     * @return Title element
     */
    public static WebElement usabilityReportTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[1]/h4"));
    }

    /**
     * Returns the UCD (Full Usability Report) URL.
     * @param driver WebDriver
     * @return the UCD URL element
     */
    public static WebElement ucdUrl(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[1]/a"));
    }
}
