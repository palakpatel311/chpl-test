package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertTrue;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class SEDTweaksSteps definition.
 */
public class SEDTweaksSteps {

    private WebDriver driver;
    private static final int DELAY = 20;

    public SEDTweaksSteps() {
        driver = Hooks.getDriver();
    }

    @Given("^I am on the Details page of Listing \"([^\"]*)\"$")
    public void iAmOnAListingSDetailsPages(final String arg1) throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/product/" + arg1);
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        Assert.assertTrue(driver.getTitle().contains("CHPL Product Details"));
    }


    @Then("^I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsExistOnDetailsPage() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("details-certification-criteria")));
        assertTrue(driver.findElement(By.id("details-certification-criteria")).getText().contains("Certification Criteria"));
        assertTrue(driver.findElement(By.id("details-cqm")).getText().contains("Clinical Quality Measures"));
        assertTrue(driver.findElement(By.id("details-sed")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(driver.findElement(By.id("details-g1g2")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(driver.findElement(By.id("details-surveillance-activities")).getText().contains("Surveillance Activities"));
        assertTrue(driver.findElement(By.id("details-additional-information")).getText().contains("Additional Information"));

    }

    @Then("^I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsInTheFollowingOrderCriteriaCQMsSEDG1G2SurveillanceAdditionalInfo() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
        assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));

    }

    @When("^I open SED details accordion$")
    public void iOpenSEDAccordion() throws Throwable {
        ListingDetailsPage.sedDetailsAccordionOpen(driver);
    }

    @Then("^usability report text should read as 'Full Usability Report'$")
    public void usabilityReportTitleReadsAsFullUsabilityReport() throws Throwable {

        assertTrue(ListingDetailsPage.usabilityReportTitle(driver).getText().contains("Full Usability Report"));
    }

    @Then("^intended user description header should show as 'Description of Intended Users'$")
    public void theHeaderShouldBeNamedDescriptionOfIntendedUsers() throws Throwable {

        assertTrue(ListingDetailsPage.intendedUserDescriptionTitle(driver).getText().contains("Description of Intended Users"));
    }

    @Then("^the header name should read as 'Date SED Testing was Completed'$")
    public void theHeaderShouldBeNamedAsDateSEDTestingWasCompleted() throws Throwable {

        assertTrue(ListingDetailsPage.sedTestingCompleteDateTitle(driver).getText().contains("Date SED Testing was Completed"));
    }

    @Then("^the download button title should read as 'Download SED Details'$")
    public void theDownloadButtonTitleShouldReadAsDownloadSEDDetails() throws Throwable {

        assertTrue(ListingDetailsPage.downloadSEDDetailsButton(driver).getText().contains("Download SED Details"));
    }

    @Then("^the criteria number should also include the criteria title$")
    public void theCriteriaNumberShouldAlsoIncludeTheCriteriaTitle() throws Throwable {
        assertTrue(ListingDetailsPage.sedCertificationCriteria(driver).getText().contains("170.315 (a)(1): Computerized Provider Order Entry (CPOE) - Medications"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria2(driver).getText().contains("170.315 (a)(2): CPOE - Laboratory"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria3(driver).getText().contains("170.315 (a)(3): CPOE - Diagnostic Imaging"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria4(driver).getText().contains("170.315 (a)(4): Drug-Drug, Drug-Allergy Interaction Checks for CPOE"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria5(driver).getText().contains("170.315 (a)(5): Demographics"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria6(driver).getText().contains("170.315 (a)(6): Problem List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria7(driver).getText().contains("170.315 (a)(8): Medication Allergy List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria8(driver).getText().contains("170.315 (a)(14): Implantable Device List"));
        assertTrue(ListingDetailsPage.sedCertificationCriteria9(driver).getText().contains("170.315 (b)(3): Electronic Prescribing"));
    }

    @Then("^there should be text 'No Certification Criteria were tested for SED'$")
    public void thereShouldBeTextNoCertificationCriteriaWereTestedForSED() throws Throwable {

        assertTrue(driver.getPageSource().contains("No Certification Criteria were tested for SED."));
    }

}
