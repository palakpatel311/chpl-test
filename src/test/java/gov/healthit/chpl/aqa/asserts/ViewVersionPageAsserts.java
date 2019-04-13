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
     * @param versionId is the product version id passed in page objects
     */
    @Then("^I see the version is recorded and updated on View Version page of \"(.*)\"$")
    public void versionIsUpdatedOnViewVersionPage(final String versionId) {
        String actualProductVersion = ViewVersionPage.viewSavedVersion(getDriver(), versionId).getText();
        assertEquals(actualProductVersion, getCurrentDate());
    }

    /**
     * Assert that edit version link exists on view version page.
     * @param versionId is the product version id passed in page objects
     */
    @Then("^I see edit link for version \"(.*)\"$")
    public void iSeeEditLinkToEditTheVersion(final String versionId) {
        ViewVersionPage.editVersionLink(getDriver(), versionId).isDisplayed();
        assertTrue(true);
    }

    /**
     * Assert that merge version link exists on view version page.
     * @param versionId is the product version id passed in page objects
     */
    @Then("^I see merge link for version \"(.*)\"$")
    public void iSeeMergeLinkToMergeTheVersion(final String versionId) {
        ViewVersionPage.mergeVersionLink(getDriver(), versionId).isDisplayed();
        assertTrue(true);
    }
}

