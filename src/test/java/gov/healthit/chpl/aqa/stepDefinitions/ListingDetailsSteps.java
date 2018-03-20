package gov.healthit.chpl.aqa.stepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class DeleteDupListingsSteps definition.
 */

public class ListingDetailsSteps {
    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public ListingDetailsSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }
    /**
     * Assert that the Accessibility Standard equals the passed in value.
     * @param accessibilityText expected text
     */
    @Then("^Accessibility Standard should display \"([^\"]*)\"$")
    public void accessibilityStandardShouldDisplayUpdatedOtherWCAG(final String accessibilityText) {
        String actualString = ListingDetailsPage.accessibilityStandardText(driver).getText();
        assertEquals(actualString, accessibilityText);
    }
    /**
     * Loads a listing for given Database ID.
     * @param dbId the Database Id of a listing to load
     */
    @Given("^I am on listing details page of listing with database ID \"(.*)\"$")
    public void loadListingWithDbId(final String dbId) {
        driver.get(url + "#/product/" + dbId);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.mainContent(driver)));
    }
    /**
     * Open the details for designated certification criteria.
     * @param number criteria to open
     */
    @When("^I open details for criteria \"([^\"]*)\"$")
    public void iOpenDetailsForACriteria(final String number) {
        WebElement link = ListingDetailsPage.certificationCriteriaDetailsLink(driver, number);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }
    /**
     * Open the SED panel.
     */
    @When("^I look at SED details$")
    public void iLookAtSEDDetails() {
        WebElement link = ListingDetailsPage.sedAccordion(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }
    /**
     * Asserts that elements exist on the accordion.
     */
    @Then("^I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsExistOnDetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("details-certification-criteria")));
        assertTrue(driver.findElement(By.id("details-certification-criteria")).getText().contains("Certification Criteria"));
        assertTrue(driver.findElement(By.id("details-cqm")).getText().contains("Clinical Quality Measures"));
        assertTrue(driver.findElement(By.id("details-sed")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(driver.findElement(By.id("details-g1g2")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(driver.findElement(By.id("details-surveillance-activities")).getText().contains("Surveillance Activities"));
        assertTrue(driver.findElement(By.id("details-additional-information")).getText().contains("Additional Information"));
    }

    /**
     * Asserts that elements are in the correct order on the accordion.
     */
    @Then("^I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsInTheFollowingOrderCriteriaCQMsSEDG1G2SurveillanceAdditionalInfo() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));
    }
    /**
     * Assert that the QMS Standard section has the passed in value.
     * @param qmsText expected text
     */
    @Then("^QMS Standard should display \"([^\"]*)\"$")
    public void qmsStandardDisplaysCorrectText(final String qmsText) {
        String actualString = ListingDetailsPage.qmsStandardText(driver).getText();
        assertTrue(actualString.contains(qmsText), "Expect " + qmsText + " to be found in " + actualString);
    }
    /**
     * Asserts that criteria should also have the title.
     */
    @Then("^the criteria number should also include the criteria title$")
    public void theCriteriaNumberShouldAlsoIncludeTheCriteriaTitle() {
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "1").getText(), "170.315 (a)(1): Computerized Provider Order Entry (CPOE) - Medications");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "2").getText(), "170.315 (a)(2): CPOE - Laboratory");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "3").getText(), "170.315 (a)(3): CPOE - Diagnostic Imaging");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "4").getText(), "170.315 (a)(4): Drug-Drug, Drug-Allergy Interaction Checks for CPOE");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "5").getText(), "170.315 (a)(5): Demographics");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "6").getText(), "170.315 (a)(6): Problem List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "7").getText(), "170.315 (a)(7): Medication List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "8").getText(), "170.315 (a)(8): Medication Allergy List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "9").getText(), "170.315 (a)(14): Implantable Device List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(driver, "10").getText(), "170.315 (b)(3): Electronic Prescribing");
    }
    /**
     * Assert that Mandatory Disclosures URL exists and is correct.
     * @param targetUrl the URL value to assert
     */
    @Then("^the Mandatory Disclosures URL should be: \"(.*)\"$")
    public void theMandatoryDisclosuresUrlShouldBe(final String targetUrl) {
        String actualText = ListingDetailsPage.disclosureUrl(driver).getText();
        assertTrue(actualText.contains(targetUrl), "Expect " + targetUrl + " to be found in " + actualText);
   }
    /**
     * Assert message when listing is not found.
     * @param notfoundText the text message to assert
     */
    @Then("^the page shows \"(.*)\" message$")
    public void verifyMessageonPage(final String notfoundText) {
        String actualString = ListingDetailsPage.mainContent(driver).getText();
        assertTrue(actualString.contains(notfoundText), "Expect " + notfoundText + " to be found in " + actualString);
    }
    /**
     * Assert that Test Procedure text is expected.
     * @param tpText expected text
     * @param number criteria to look in
     */
    @Then("^Test Procedure should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void testProcedureFieldShouldDisplay(final String tpText, final String number) {
        String actualString = ListingDetailsPage.testProcedure(driver, number).getText();
        assertTrue(actualString.contains(tpText), "Expect \"" + tpText + "\" to be found in \"" + actualString + "\"");
    }
    /**
     * Assert that the UCD Process equals the passed in value.
     * @param ucdText expected text
     */
    @Then("^UCD process should display \"([^\"]*)\"$")
    public void ucdProcessShouldDisplayUpdatedUcdText(final String ucdText) {
        String actualString = ListingDetailsPage.ucdProcessText(driver).getText();
        assertEquals(actualString, ucdText);
    }
    /**
     * Asserts correct text in SED section.
     * @param reportTitle expected text
     */
    @Then("^usability report text should read as \"([^\"]*)\"$")
    public void usabilityReportTitleReadsAsFullUsabilityReport(final String reportTitle) {
        String actualString = ListingDetailsPage.usabilityReportTitle(driver).getText();
        assertTrue(actualString.contains(reportTitle), "Expect " + reportTitle + " to be found in " + actualString);
    }

    /**
     * Asserts for correct text in SED section.
     * @param userDescTitle expected text
     */
    @Then("^intended user description header should show as \"([^\"]*)\"$")
    public void theHeaderShouldBeNamedDescriptionOfIntendedUsers(final String userDescTitle) {
        String actualString = ListingDetailsPage.intendedUserDescriptionTitle(driver).getText();
        assertTrue(actualString.contains(userDescTitle), "Expect " + userDescTitle + " to be found in " + actualString);
    }

    /**
     * Asserts correct text for download button.
     * @param downloadbtnTitle expected text for download button
     */
    @Then("^download button title should read as \"([^\"]*)\"$")
    public void theDownloadButtonTitleShouldReadAsDownloadSEDDetails(final String downloadbtnTitle) {
        String actualString = ListingDetailsPage.downloadSEDDetailsButton(driver).getText();
        assertTrue(actualString.contains(downloadbtnTitle), "Expect " + downloadbtnTitle + " to be found in " + actualString);
    }
    /**
     * Asserts that this listing has no criteria tested for SED.
     * @param nodataText expected text
     */
    @Then("^there should be text \"([^\"]*)\"$")
    public void thereShouldBeTextNoCertificationCriteriaWereTestedForSED(final String nodataText) {
        String actualString = ListingDetailsPage.nosedData(driver).getText();
        assertTrue(actualString.contains(nodataText), "Expect " + nodataText + " to be found in " + actualString);
    }

}
