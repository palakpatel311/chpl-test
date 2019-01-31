package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ListingDetailsAsserts definition.
 */
public class ListingDetailsAsserts extends Base {

    /**
     * Asserts for correct data in Targeted User field.
     * @param targetedUser expected text
     */
    @Then("^Targeted Users should show correct data \"([^\"]*)\"$")
    public void verifyTargetedUserData(final String targetedUser) {
        String actualString = ListingDetailsPage.targetedUser(getDriver()).getText();
        assertTrue(actualString.contains(targetedUser), "Expect " + targetedUser + " to be found in " + actualString);
    }
}
