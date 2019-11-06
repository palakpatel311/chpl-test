package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.SedInfoFor2015Page;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class SedInfoFor2015PageAsserts definition.
 */
public class SedInfoFor2015PageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for SED Info for 2015 Products page$")
    public void iSeePageTitleForSedInfoFor2015Page(final String expectedPageTitle) {
        String actualPageTitle = SedInfoFor2015Page.sedInfoFor2015PageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
