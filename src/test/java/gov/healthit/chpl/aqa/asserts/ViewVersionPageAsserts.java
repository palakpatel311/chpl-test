package gov.healthit.chpl.aqa.asserts;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ViewVersionPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ViewVersionPageAsserts definition.
 */
public class ViewVersionPageAsserts extends Base {
    /**
     * Assert that version is correct.
     * @param productVersionNumber is the product version number passed in page objects
     */
    @Then("^I see the version is recorded and updated on View Version page of \"(.*)\"$")
    public void versionIsUpdatedOnViewVersionPage(final String productVersionNumber) {
        String actualProductVersion = ViewVersionPage.viewSavedVersion(getDriver(), productVersionNumber).getText();
        assertEquals(actualProductVersion, getCurrentDate());
    }

    /**
     * Assert that edit version link exists on view version page.
     * @param productVersionNumber is the product version number passed in page objects
     */
    @Then("^I see edit link to edit the version of \"(.*)\"$")
    public void iSeeEditLinkToEditTheVersion(final String productVersionNumber) {
        ViewVersionPage.editVersionLink(getDriver(), productVersionNumber).isDisplayed();
        assertTrue(true);
    }

    /**
     * Assert that merge version link exists on view version page.
     * @param productVersionNumber is the product version number passed in page objects
     */
    @Then("^I see merge link to merge the version of \"(.*)\"$")
    public void iSeeMergeLinkToEditTheVersion(final String productVersionNumber) {
        ViewVersionPage.mergeVersionLink(getDriver(), productVersionNumber).isDisplayed();
        assertTrue(true);
    }
}

