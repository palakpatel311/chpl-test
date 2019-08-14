package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;
import gov.healthit.chpl.aqa.stepDefinitions.Hooks;

/**
 * Class DpmanagementUploadPageAsserts definition.
 */
public class DpmanagementUploadPageAsserts extends Base {
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
     * Assert upload success message for surveillance upload.
     * @throws Exception if screenshot can't be taken
     */
    @Then("^I see upload successful message for surveillance upload$")
    public void testUploadSuccessTextForSurveillanceUpload() throws Exception {
        String successText = DpManagementPage.uploadSuccessfulTextSurveillanceUpload(getDriver()).getText();
        try {
            assertTrue(successText.contains("was uploaded successfully"));
        } catch (AssertionError ae) {
            Hooks.takeScreenshot();
            throw (ae);
        }
    }

    /**
     * Assert errors in upload failure message.
     * @param errorMessage expected error message for upload failure
     */
    @Then("^I see upload failure with appropriate error message \"([^\"]*)\" to indicate failure due to invalid data$")
    public void verifyLongTestTaskIdAndParticipantIdErrorsOnUpload(final String errorMessage) {
        String actualString = DpManagementPage.uploadFailureErrorMessage(getDriver()).getText();
        assertTrue(actualString.contains(errorMessage), "Expect \"" + errorMessage + "\" to be found in \"" + actualString + "\"");
    }

    /**
     * Load listing details to verify surveillance was uploaded successfully.
     */
    @Then("^I see that surveillance was uploaded successfully for listing with CHPL ID 15.05.05.2760.ISCD.01.00.1.181101 and listing details show surveillance activity$")
    public void verifySurveillanceConfirmWasSuccessful() {
        getDriver().get(getUrl() + "/#/listing/9713/surveillance");

        getWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.certificationCriteriaAccordion(getDriver())));

        getWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.surveillanceActivitiesPanel(getDriver())));
        String surveillanceText = ListingDetailsPage.surveillanceActivitiesPanel(getDriver()).getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd" + ", " + "yyyy");
        LocalDate newDate = LocalDate.now();

        assertTrue(surveillanceText.contains("Open Surveillance, Began " + dtf.format(newDate) + ": 1 Open and 2 Closed Non-Conformities Were Found"));
    }
}
