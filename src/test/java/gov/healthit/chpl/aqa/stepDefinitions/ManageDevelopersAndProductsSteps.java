package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.cli.Main;
import cucumber.api.java.en.And;
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
     * Get user to Manage Surveillance Activity section.
     */
    @And("^I navigate to Manage Surveillance Activity section$")
    public void loadManageSurveillanceActivityPage() {
        getDriver().get(getUrl() + "#/surveillance/manage");
    }

    /**
     * Search for given CHPL Id on Manage Surveillance Activity Page.
     * @param chplId is chplId to look up
     * @throws Exception if screenshot cannot be taken
     */
    @When("^I search for \"([^\"]*)\" in Manage Surveillance Activity section$")
    public void searchForChplIdInSurvSearch(final String chplId) throws Exception {
        DpManagementPage.surveillanceSearch(getDriver()).sendKeys(chplId);
        Thread.sleep(DEBOUNCE_TIME); // need to wait for smart-table component to recognize text
    }

    /**
     * Navigate to Upload Certified Products page.
     */
    @And("^I am on Upload Listings page$")
    public void loadUploadCertifiedProductsPage() {
        WebElement button = DpManagementPage.administrationNavLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
        DpManagementPage.administrationUploadNavLink(getDriver()).click();
    }

    /**
     * Navigate to Upload Certified Products page.
     */
    @And("^I am on Upload Surveillance page$")
    public void loadUploadSurveillancePage() {
        WebElement button = DpManagementPage.surveillanceNavLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
        DpManagementPage.surveillanceUploadNavLink(getDriver()).click();
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
        DpManagementPage.chooseFileButtonListingUpload(getDriver()).sendKeys(filename);
        DpManagementPage.uploadFileButtonListingUpload(getDriver()).click();
    }

    /**
     * Navigate to Confirm Pending Products page.
     */
    @When("^I go to Confirm Pending Products Page$")
    public void loadConfirmPendingProductsPage() {
        WebElement button = DpManagementPage.administrationNavLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
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
            .until(ExpectedConditions.visibilityOf(ManageDevelopersAndProductsPage.updateSuccessfulToastContainer(getDriver())));

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
     * Upload a listing with invalid inputs in specific fields.
     * @throws URISyntaxException if there is an exception
     * @param fieldinUploadFile is a field in upload file that has invalid input
     */
    @When("^I upload a 2015 listing with invalid input in \"([^\"]*)\"$")
    public void uploadListingWithLongTestTaskIDsParticipantIDs(final String fieldinUploadFile) throws URISyntaxException {
        URL resource = Main.class.getResource("/2015_Test_SLI_longIDsInvCertDate.csv");
        String absolutePath = Paths.get(resource.toURI()).toString();

        DpManagementPage.chooseFileButton(getDriver()).sendKeys(absolutePath);
        DpManagementPage.uploadFileButtonListingUpload(getDriver()).click();
    }

    /**
     * Assert that SED End Date of Testing displays date value on Manage Developers and Products page.
     * @param sedEndDate the date value to assert
     */
    @Then("^SED End Date of Testing field should display the date \"([^\"]*)\" in listing details section$")
    public void testSedEndDateOfTestingDisplayedInListingDetailsDpmgmt(final String sedEndDate) {
        WebElement link = ListingDetailsPage.sedAccordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
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
     * Load listing's edit page.
     */
    @When("^I am on listing details page of uploaded listing$")
    public void loadProductManagementPage() {
        getDriver().get(getUrl() + "#/listing/" + this.chplProductNumber);
        getWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.editCPLink(getDriver())));
    }

    /**
     * Open Edit form.
     */
    @And("^I open listing edit page$")
    public void openListingEditPage() {
        WebElement link = ListingDetailsPage.editCPLink(getDriver());
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

    /**
     * Upload a listing with special characters in Test Task and Participant fields.
     * @throws URISyntaxException if there is an exception
     * @param chplId is chpl id of listing to upload
     * @param fieldinUploadFile is a field in upload file that has bad input
     */
    @When("^I upload a 2015 listing with CHPL ID \"([^\"]*)\" that has bad input in \"([^\"]*)\"$")
    public void uploadListingWithBadInputsInTestTaskParticipantFields(final String chplId, final String fieldinUploadFile) throws URISyntaxException {
        URL resource = Main.class.getResource("/2015_Test_SLI_BadInputs.csv");
        String absolutePath = Paths.get(resource.toURI()).toString();

        DpManagementPage.chooseFileButton(getDriver()).sendKeys(absolutePath);
        DpManagementPage.uploadFileButtonListingUpload(getDriver()).click();
    }

    /**
     * Inspect listing details for bad data input to verify errors.
     * @param chplId is chpl id of listing to inspect
     */
    @And("^I inspect listing details for listing with CHPL ID \"([^\"]*)\"$")
    public void inspectListingDetails(final String chplId) {
        DpManagementPage.inspectButtonForBadDataListing(getDriver(), chplId).click();
    }

    /**
     * Upload a surveillance.
     * @throws URISyntaxException if there is an exception
     * @param filename is filename of upload file
     */
    @When("^I upload the \"(.*)\" surveillance activity$")
    public void uploadSurveillance(final String filename) throws URISyntaxException {
        URL resource = Main.class.getResource("/" + filename);
        String absolutePath = Paths.get(resource.toURI()).toString();

        DpManagementPage.chooseFileButton(getDriver()).sendKeys(absolutePath);
        getWait().until(ExpectedConditions.elementToBeClickable(DpManagementPage.uploadFileButtonForSurveillance(getDriver())));
        DpManagementPage.uploadFileButtonForSurveillance(getDriver()).click();
    }

    /**
     * Navigate to Confirm Pending Surveillance Activities page.
     */
    @When("^I go to Confirm Pending Surveillance Activities Page$")
    public void loadConfirmPendingSurveillanceActivitiesPage() {
        WebElement button = DpManagementPage.surveillanceNavLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
        DpManagementPage.confirmPendingSurveillanceActivitiesLink(getDriver()).click();
        getWait().until(ExpectedConditions.visibilityOf(DpManagementPage.pendingSurveillanceTable(getDriver())));
    }

    /**
     * Inspect Surveillance details.
     * @param chplId is chpl id of listing to inspect surveillance activity details
     */
    @And("^I inspect surveillance activity details for listing with CHPL ID \"([^\"]*)\"$")
    public void inspectSurveillanceDetails(final String chplId) {
        DpManagementPage.inspectButtonForPendingSurveillanceActivity(getDriver(), chplId).click();
    }

    /**
     * Confirm uploaded surveillance activity.
     * @param survChplId is chpl id of listing for surveillance activity
     * @throws Exception if there is an exception
     */
    @And("^I confirm surveillance activity for listing with CHPL ID \"([^\"]*)\"$")
    public void confirmUploadedSurveillanceActivity(final String survChplId) throws Exception {
        try {
            DpManagementPage.surveillanceEditButtonOnInspect(getDriver()).click();
            getWait().until(ExpectedConditions.visibilityOf(DpManagementPage.surveillanceStartDateOnInspect(getDriver())));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate newDate = LocalDate.now();

            DpManagementPage.surveillanceStartDateOnInspect(getDriver()).clear();

            DpManagementPage.surveillanceStartDateOnInspect(getDriver()).sendKeys(dtf.format(newDate));

            DpManagementPage.surveillanceSaveButtonOnInspect(getDriver()).click();

            DpManagementPage.surveillanceConfirmButtonOnInspect(getDriver()).click();

            WebElement button = DpManagementPage.yesOnConfirm(getDriver());
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);

            getWait()
            .withTimeout(LONG_TIMEOUT, TimeUnit.SECONDS)
            .until(ExpectedConditions.visibilityOf(ManageDevelopersAndProductsPage.updateSuccessfulToastContainer(getDriver())));

        } catch (Exception e) {
            Hooks.takeScreenshot(survChplId);
            assertTrue(false, "in confirm:" + e.getMessage());
        }
    }
}
