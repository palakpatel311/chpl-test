package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.CorrectiveActionStatusPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class CorrectiveActionStatusPageAsserts definition.
 */
public class CorrectiveActionStatusPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for the Corrective Action Status page$")
    public void iSeePageTitleForCorrctiveActionStatusPage(final String expectedPageTitle) {
        String actualPageTitle = CorrectiveActionStatusPage.correctiveActionStatusPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
