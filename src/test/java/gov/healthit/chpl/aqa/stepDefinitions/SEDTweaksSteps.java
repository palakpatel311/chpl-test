package gov.healthit.chpl.aqa.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class SEDTweaksSteps definition.
 */
public class SEDTweaksSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public SEDTweaksSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Loads a listing. Waits until the Listing name exists.
     * @param chplId the database id of the requested listing
     */
    @Given("^I am on the Details page of Listing \"([^\"]*)\"$")
    public void iAmOnAListingsDetailsPages(final String chplId) {
        driver.get(url + "#/product/" + chplId);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(driver)));
    }

    /**
     * Opens the SED section of the accordion.
     */
    @When("^I open SED details accordion$")
    public void iOpenSEDAccordion() {
        ListingDetailsPage.sedDetailsAccordionOpen(driver);
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
     * Asserts correct text in SED section.
     */
    @Then("^usability report text should read as 'Full Usability Report'$")
    public void usabilityReportTitleReadsAsFullUsabilityReport() {
        assertTrue(ListingDetailsPage.usabilityReportTitle(driver).getText().contains("Full Usability Report"));
    }

    /**
     * Asserts for correct text in SED section.
     */
    @Then("^intended user description header should show as 'Description of Intended Users'$")
    public void theHeaderShouldBeNamedDescriptionOfIntendedUsers() {
        assertTrue(ListingDetailsPage.intendedUserDescriptionTitle(driver).getText().contains("Description of Intended Users"));
    }

    /**
     * Asserts correct text for Date SED Testing.
     */
    @Then("^the header name should read as 'Date SED Testing was Completed'$")
    public void theHeaderShouldBeNamedAsDateSEDTestingWasCompleted() {
        assertTrue(ListingDetailsPage.sedTestingCompleteDateTitle(driver).getText().contains("Date SED Testing was Completed"));
    }

    /**
     * Asserts correct text for download button.
     */
    @Then("^the download button title should read as 'Download SED Details'$")
    public void theDownloadButtonTitleShouldReadAsDownloadSEDDetails() {
        assertTrue(ListingDetailsPage.downloadSEDDetailsButton(driver).getText().contains("Download SED Details"));
    }

    /**
     * Asserts that criteria should also have the title.
     */
    @Then("^the criteria number should also include the criteria title$")
    public void theCriteriaNumberShouldAlsoIncludeTheCriteriaTitle() {
        assertTrue(ListingDetailsPage.sedCertificationCriteria(driver).getText().contains("170.315 (a)(1): Computerized Provider Order Entry (CPOE) - Medications"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria2(driver).getText().contains("170.315 (a)(2): CPOE - Laboratory"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria3(driver).getText().contains("170.315 (a)(3): CPOE - Diagnostic Imaging"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria4(driver).getText().contains("170.315 (a)(4): Drug-Drug, Drug-Allergy Interaction Checks for CPOE"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria5(driver).getText().contains("170.315 (a)(5): Demographics"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria6(driver).getText().contains("170.315 (a)(6): Problem List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria7(driver).getText().contains("170.315 (a)(7): Medication List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria8(driver).getText().contains("170.315 (a)(8): Medication Allergy List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria9(driver).getText().contains("170.315 (a)(14): Implantable Device List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria10(driver).getText().contains("170.315 (b)(3): Electronic Prescribing"));
    }

    /**
     * Asserts that this listing has no criteria tested for SED.
     */
    @Then("^there should be text 'No Certification Criteria were tested for SED'$")
    public void thereShouldBeTextNoCertificationCriteriaWereTestedForSED() {
        assertTrue(driver.getPageSource().contains("No Certification Criteria were tested for SED."));
    }
}
