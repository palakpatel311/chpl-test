package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;
import gov.healthit.chpl.aqa.stepDefinitions.Hooks;
/**
 * Class ManageSurveillanceAsserts definition.
 */
public class ManageSurveillanceAsserts extends Base {

    /**
     * Verify surveillance search results load by validating CHPL ID in results.
     * @param chplId is chplId to look up
     * @throws Exception if results did not load and chplId was not found
     */
    @Then("^I see the surveillance results for \"([^\"]*)\"$")
    public void testSurveillanceResultsAsExpected(final String chplId) throws Exception {
        try {
            String actualString = DpManagementPage.manageProductSurveillance(getDriver()).getText();
            assertTrue(actualString.contains(chplId), "Expect \"" + chplId + "\" to be found in \"" + actualString + "\"");
        } catch (NoSuchElementException nsee) {
            Hooks.takeScreenshot(chplId);
            assertTrue(false, chplId + ": " + nsee.getMessage());
        }
    }
}
