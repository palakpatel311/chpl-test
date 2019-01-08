package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
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
}
