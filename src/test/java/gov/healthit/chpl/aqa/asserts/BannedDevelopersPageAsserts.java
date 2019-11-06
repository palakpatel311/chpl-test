package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.BannedDevelopersPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class BannedDevelopersPageAsserts definition.
 */
public class BannedDevelopersPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for the Banned Developers page$")
    public void iSeePageTitleForBannedDevelopersPage(final String expectedPageTitle) {
        String actualPageTitle = BannedDevelopersPage.bannedDevelopersPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}

