package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
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
public class ManageDevelopersAndProductsSteps extends Base {
    private static final int CHPL_PRODUCT_NUMBER_PREFIX = 14;
    private String chplProductNumber; // Used to pass newly generated CHPL Product number between steps during upload

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
        getWait().until(ExpectedConditions.visibilityOf(ManageDevelopersAndProductsPage.editCertifiedProductLink(getDriver())));
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
     * Search for given CHPL Id on Manage Surveillance Activity Page.
     * @param chplId is chplId to look up
     * @throws Exception if screenshot cannot be taken
     */
    @When("^I search for \"([^\"]*)\" in Manage Surveillance Activity section$")
    public void searchForChplIdInSurvSearch(final String chplId) throws Exception {
        final long millisPerSecond = 1000;
        Date start = new Date();
        Date end;
        try {
            DpManagementPage.surveillanceSearch(getDriver()).sendKeys(chplId);
            DpManagementPage.survSearchButton(getDriver()).click();
            start = new Date();
            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(DpManagementPage.surveillanceSearchSingleResultTable(getDriver())));
            end = new Date();
            System.out.println("Found table in " + ((end.getTime() - start.getTime()) / millisPerSecond) + " seconds");
        } catch (NoSuchElementException nsee) {
            end = new Date();
            System.out.println("Did not find table in " + ((end.getTime() - start.getTime()) / millisPerSecond) + " seconds");
            Hooks.takeScreenshot("searchForChplIdInSurvSearch" + chplId);
            assertTrue(false, "chpl id search: " + nsee.getMessage());
        }
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
     * Upload a listing.
     * @param edition is listing edition
     * @param inputChplId initial CHPL ID
     */
    @When("^I upload a \"([^\"]*)\" listing with CHPL ID \"([^\"]*)\"$")
    public void uploadAlisting(final String edition, final String inputChplId) {
        List<CSVRecord> listing = getUploadFile(edition);
        String filename = writeTempFile(listing, inputChplId);
        System.out.println("Sending filename: " + filename);
        DpManagementPage.chooseFileButton(getDriver()).sendKeys(filename);
        DpManagementPage.uploadFileButton(getDriver()).click();
    }

    /**
     * Assert upload success message.
     * @throws Exception if screenshot can't be taken
     */
    @Then("^I see upload successful message$")
    public void testUploadSuccessText() throws Exception {
        String successText = DpManagementPage.uploadSuccessfulText(getDriver()).getText();
        try {
            assertTrue(successText.contains("was uploaded successfully"));
        } catch (AssertionError ae) {
            Hooks.takeScreenshot();
            throw (ae);
        }
    }

    /**
     * Navigate to Confirm Pending Products page.
     */
    @When("^I go to Confirm Pending Products Page$")
    public void loadConfirmPendingProductsPage() {
        DpManagementPage.confirmPendingProductsLink(getDriver()).click();
        getWait().until(ExpectedConditions.visibilityOf(DpManagementPage.pendingListingsTable(getDriver())));
    }

    /**
     * Open inspect screen.
     * @throws Exception if there is an exception
     */
    @And("^I open inspect form to inspect listing details$")
    public void openInspectScreen() throws Exception {
        try {
        getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(DpManagementPage.inspectButtonForUploadedListing(getDriver(), this.chplProductNumber)));
            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.elementToBeClickable(DpManagementPage.inspectButtonForUploadedListing(getDriver(), this.chplProductNumber)));
            DpManagementPage.inspectButtonForUploadedListing(getDriver(), this.chplProductNumber).click();
            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(DpManagementPage.nextOnInspectButton(getDriver())));
        } catch (Exception e) {
            Hooks.takeScreenshot(this.chplProductNumber);
            assertTrue(false, "in confirm:" + e.getMessage());
        }
    }

    /**
     * Verify warning on inspect screen.
     */
    @Then("^I see warnings for duplicate macra measures in G1 and G2$")
    public void verifyWarningOnInspect() {

        String warning = DpManagementPage.warningErrorTextOnInspect(getDriver()).getText();
        assertTrue(warning
        .contains("Certification 170.315 (a)(1) contains duplicate G1 Macra Measure: 'EH/CAH Stage 3'. The duplicates have been removed"),
        "no warnings were found");
        assertTrue(warning
        .contains("Certification 170.315 (a)(1) contains duplicate G2 Macra Measure: 'EH/CAH Stage 3'. The duplicates have been removed"),
        "no warnings were found");
    }

    /**
     * Confirm uploaded listing.
     * @param edition is listing edition
     * @param testChplId is chpl id of listing to confirm
     * @throws Exception if there is an exception
     */
    @And("^I confirm \"([^\"]*)\" listing with CHPL ID \"([^\"]*)\"$")
    public void confirmUploadedListing(final String edition, final String testChplId) throws Exception {
        try {
            DpManagementPage.nextOnInspectButton(getDriver()).click();

            if (DpManagementPage.isProductNewDivElementPresent(getDriver())) {
                DpManagementPage.createNewProductOptionOnInspect(getDriver()).click();
            }
            DpManagementPage.nextOnInspectButton(getDriver()).click();

            if (DpManagementPage.isVersionNewDivElementPresent(getDriver())) {
                DpManagementPage.createNewVersionOptionOnInspect(getDriver()).click();
            }
            DpManagementPage.nextOnInspectButton(getDriver()).click();

            DpManagementPage.confirmButtonOnInspect(getDriver()).click();

            WebElement button = DpManagementPage.yesOnConfirm(getDriver());
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);

            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(DpManagementPage.updateSuccessfulToastContainer(getDriver())));

            getDriver().get(getUrl() + "/#/product/" + this.chplProductNumber);
            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(ListingDetailsPage.mainContent(getDriver())));
        } catch (Exception e) {
            Hooks.takeScreenshot(this.chplProductNumber);
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
     * Load listing details to verify listing was uploaded successfully.
     * @param ed - edition digits in CHPL ID
     */
    @Then("^I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded \"([^\"]*)\" listing$")
    public void testVerifyUploadWasSuccessful(final String ed) {
        String testListingName = "New product";
        String actualString = ListingDetailsPage.listingName(getDriver()).getText();
        assertEquals(actualString, testListingName);
    }

    private List<CSVRecord> getUploadFile(final String edition) {
        try {
            File listing = new File(System.getProperty("user.dir") + File.separator + "src"
                    + File.separator + "test" + File.separator + "resources" + File.separator + edition + "_Test_SLI.csv");
            /**
             * This should work, but I can't figure out why it isn't.
             * InputStream listing = ManageDevelopersAndProductsSteps.class.getResourceAsStream("test/resources/" + edition + "_Test_SLI.csv");
             */
            try (CSVParser parser = CSVParser.parse(listing, Charset.forName("UTF-8"), CSVFormat.EXCEL)) {
                return parser.getRecords();
            }
        } catch (IOException e) {
            return null;
        }
    }

    private String writeTempFile(final List<CSVRecord> listing, final String inputChplId) {
        File temp = null;
        String newChplId = getNewChplId(inputChplId);
        try {
            temp = File.createTempFile("upload", ".csv");
            temp.deleteOnExit();
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(temp),
                    Charset.forName("UTF-8").newEncoder()
                    );
                    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL)) {
                for (CSVRecord record : listing) {
                    ArrayList<String> row = new ArrayList<String>();
                    for (String s : record) {
                        if (s.equalsIgnoreCase(inputChplId)) {
                            s = newChplId;
                        }
                        row.add(s);
                    }
                    csvPrinter.printRecord(row);
                }
            }
            return temp.getAbsolutePath();
        } catch (IOException e) {
            return null;
        }
    }

    private String getNewChplId(final String inputChplId) {
        Calendar now = Calendar.getInstance();

        String newPid = "" + CHARS.charAt(now.get(Calendar.MONTH))
        + CHARS.charAt(now.get(Calendar.DAY_OF_MONTH))
        + CHARS.charAt(now.get(Calendar.HOUR_OF_DAY))
        + CHARS.charAt(now.get(Calendar.MINUTE));

        String newVid = "" + CHARS.charAt(now.get(Calendar.MINUTE))
        + CHARS.charAt(now.get(Calendar.SECOND));

        this.chplProductNumber = inputChplId.substring(0, CHPL_PRODUCT_NUMBER_PREFIX) + newPid + "." + newVid + ".00.1.180707";
        return this.chplProductNumber;
    }

    /**
     * Open Edit form.
     */
    @And("^I open listing edit page$")
    public void openListingEditPage() {
        WebElement link = ManageDevelopersAndProductsPage.editCertifiedProductLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Open CQM accordion.
     */
    @When("^I look at CQM details$")
    public void opencqmPanel() {
        WebElement link = ManageDevelopersAndProductsPage.cqmAccordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Asserts newly added version for CQMs are correct.
     * @param version is expected version
     * @param cqm is given CQM
     */
    @Then("^there should be version \"([^\"]*)\" available for \"([^\"]*)\"$")
    public void checkCqmVersion(final String version, final String cqm) {
        String cmsversion = ManageDevelopersAndProductsPage.cmsVersion(getDriver(), cqm).getText();
        assertTrue(cmsversion.contains(version), "Expect " + version + " to be found in " + cmsversion);
    }
}
