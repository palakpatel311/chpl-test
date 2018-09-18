package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.pageObjects.ManageDevelopersAndProductsPage;

/**
 * All steps related to activities in the "Developer and Product Management" admin section,
 * navigated to via #/admin/dpManagement and including both ROLE_ADMIN and ROLE_ACB activities.
 */
public class ManageDevelopersAndProductsSteps extends BaseSteps {
    /** Default constructor. */
    public ManageDevelopersAndProductsSteps() {
        super();
    }

    /**
     * Loads a listing for given Database ID.
     * @param id the Database or CHPL ID of a listing to load
     */
    @Given("^I navigate to Manage Developers and Products page listing details section of listing with ID \"([^\"]*)\"$")
    public void loadListingDetailsDpManagementPage(final String id) {
        getDriver().get(getUrl() + "#/admin/dpManagement/manage/" + id);
        getShortWait().until(ExpectedConditions.visibilityOf(ManageDevelopersAndProductsPage.editCertifiedProductLink(getDriver())));
    }

    /**
     * Get user to Manage Surveillance Activity section.
     */
    @And("^I navigate to Manage Surveillance Activity section$")
    public void loadManageSurveillanceActivityPage() {
        DpManagementPage.dpManagementLink(getDriver()).click();
        DpManagementPage.manageSurveillanceActivityLink(getDriver()).click();
    }

    /**
     * Navigate to Upload Certified Products page.
     */
    @And("^I am on Upload Certified Products page$")
    public void loadUploadCertifiedProductsPage() {
        DpManagementPage.dpManagementLink(getDriver()).click();
        DpManagementPage.dpManagementUploadProductsSurveillance(getDriver()).click();
    }

    /**
     * Navigate to Confirm Pending Products page.
     */
    @When("^I go to Confirm Pending Products Page$")
    public void loadConfirmPendingProductsPage() {
        DpManagementPage.confirmPendingProductsLink(getDriver()).click();
        getShortWait().until(ExpectedConditions.visibilityOf(DpManagementPage.pendingListingsTable(getDriver())));
    }

    /**
     * Search for given CHPL Id on Manage Surveillance Activity Page.
     * @param chplId is chplId to look up
     * @throws Exception if screenshot cannot be taken
     */
    @When("^I search for \"([^\"]*)\" in Manage Surveillance Activity section$")
    public void searchForChplIdInSurvSearch(final String chplId) throws Exception {
        try {
            DpManagementPage.surveillanceSearch(getDriver()).sendKeys(chplId);
            DpManagementPage.survSearchButton(getDriver()).click();
            getLongWait().until(ExpectedConditions.visibilityOf(DpManagementPage.surveillanceSearchSingleResultTable(getDriver())));
        } catch (NoSuchElementException nsee) {
            Hooks.takeScreenshot("searchForChplIdInSurvSearch" + chplId);
            assertTrue(false, "chpl id search:" + nsee.getMessage());
        }
    }

    /**
     * Upload a listing.
     * @param edition is listing edition
     */
    @When("^I upload a \"([^\"]*)\" listing$")
    public void uploadAlisting(final String edition) {
        DpManagementPage.chooseFileButton(getDriver()).sendKeys(getFilePath() + File.separator + edition + "_Test_SLI.csv");
        DpManagementPage.uploadFileButton(getDriver()).click();
    }

    /**
     * Confirm uploaded listing.
     * @param edition is listing edition
     * @param testChplId is chpl id of listing to confirm
     * @throws Exception if there is an exception
     */
    @And("^I confirm \"([^\"]*)\" listing with CHPL ID \"([^\"]*)\"$")
    public void confirmUploadedListing(final String edition, final String testChplId) throws Exception {
        Calendar now = Calendar.getInstance();

        String newPid = "" + CHARS.charAt(now.get(Calendar.MONTH))
        + CHARS.charAt(now.get(Calendar.DAY_OF_MONTH))
        + CHARS.charAt(now.get(Calendar.HOUR_OF_DAY))
        + CHARS.charAt(now.get(Calendar.MINUTE));

        String newVid = "" + CHARS.charAt(now.get(Calendar.MINUTE))
        + CHARS.charAt(now.get(Calendar.SECOND));

        String confListingId = edition.substring(2) + ".05.05.1447." + newPid + "." + newVid + ".00.1.180707";

        try {
            getLongWait().until(ExpectedConditions.visibilityOf(DpManagementPage.inspectButtonForUploadedListing(getDriver(), testChplId)));
            getLongWait().until(ExpectedConditions.elementToBeClickable(DpManagementPage.inspectButtonForUploadedListing(getDriver(), testChplId)));
            DpManagementPage.inspectButtonForUploadedListing(getDriver(), testChplId).click();

            DpManagementPage.nextOnInspectButton(getDriver()).click();

            if (DpManagementPage.isProductNewDivElementPresent(getDriver())) {
                DpManagementPage.createNewProductOptionOnInspect(getDriver()).click();
            }
            DpManagementPage.nextOnInspectButton(getDriver()).click();

            if (DpManagementPage.isVersionNewDivElementPresent(getDriver())) {
                DpManagementPage.createNewVersionOptionOnInspect(getDriver()).click();
            }
            DpManagementPage.nextOnInspectButton(getDriver()).click();

            DpManagementPage.editOnInspectButton(getDriver()).click();

            DpManagementPage.productIdOnInspect(getDriver()).clear();
            DpManagementPage.productIdOnInspect(getDriver()).sendKeys(newPid);

            DpManagementPage.productVersionOnInspect(getDriver()).clear();
            DpManagementPage.productVersionOnInspect(getDriver()).sendKeys(newVid);

            DpManagementPage.saveCpOnInspect(getDriver()).click();
            getShortWait().until(ExpectedConditions.textToBePresentInElement(DpManagementPage.inspectModalLabel(getDriver()), confListingId));

            DpManagementPage.confirmButtonOnInspect(getDriver()).click();

            WebElement button = DpManagementPage.yesOnConfirm(getDriver());
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);

            getLongWait().until(ExpectedConditions.visibilityOf(DpManagementPage.updateSuccessfulToastContainer(getDriver())));

            getDriver().get(getUrl() + "/#/product/" + confListingId);
            getLongWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.mainContent(getDriver())));
        } catch (Exception e) {
            Hooks.takeScreenshot(confListingId);
            assertTrue(false, "in confirm:" + e.getMessage());
        }
    }

    /**
     * Assert that SED End Date of Testing displays date value on Manage Developers and Products page.
     * @param sedEndDate the date value to assert
     */
    @Then("^SED End Date of Testing field should display the date \"([^\"]*)\" in listing details section$")
    public void testSedEndDateOfTestingDisplayedInListingDetailsDpmgmt(final String sedEndDate) {
        String actualText = ManageDevelopersAndProductsPage.sedEndDateOfTesting(getDriver()).getText();
        assertTrue(actualText.contains(sedEndDate), "Expect " + sedEndDate + " to be found in " + actualText);
    }

    /**
     * Assert that SED End Date of Testing displays date value on listing details page.
     * @param sedEndDate the date value to assert
     */
    @Then("^SED Testing End Date shows as \"([^\"]*)\" in SED details section$")
    public void testSedTestingEndDateDisplayedInSedDetails(final String sedEndDate) {
        String actualText = ListingDetailsPage.sedPanel(getDriver()).getText();
        assertTrue(actualText.contains(sedEndDate), "Expect " + sedEndDate + " to be found in " + actualText);
    }

    /**
     * Verify surveillance search results load by validating CHPL ID in results.
     * @param chplId is chplId to look up
     * @throws Exception if results did not load and chplId was not found
     */
    @Then("^I see the surveillance results for \"([^\"]*)\"$")
    public void testSurveillanceResultsAsExpected(final String chplId) throws Exception {
        try {
            String actualString = DpManagementPage.chplProductNumber(getDriver()).getText();
            assertTrue(actualString.contains(chplId), "Expect \"" + chplId + "\" to be found in \"" + actualString + "\"");
        } catch (NoSuchElementException nsee) {
            Hooks.takeScreenshot(chplId);
            assertTrue(false, chplId + ": " + nsee.getMessage());
        }
    }

    /**
     * Assert upload success message.
     */
    @Then("^I see upload successful message$")
    public void testUploadSuccessText() {
        String successText = DpManagementPage.uploadSuccessfulText(getDriver()).getText();
        assertTrue(successText.contains("was uploaded successfully"));
    }

    /**
     * Load listing details to verify listing was uploaded successfully.
     * @param ed - edition digits in CHPL ID
     */
    @Then("^I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded \"([^\"]*)\" listing$")
    public void testVerifyUploadWasSuccessful(final String ed) {
        String testListingName = "New product";
        String actualString = ListingDetailsPage.listingName(getDriver()).getText();
        assertEquals(actualString, testListingName);
    }
}
