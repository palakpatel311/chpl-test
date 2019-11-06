package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.InactiveCertificatesPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class InactiveCertificatesPageAsserts definition.
 */
public class InactiveCertificatesPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for the Inactive Certificates page$")
    public void iSeePageTitleForInactiveCertificatesPage(final String expectedPageTitle) {
        String actualPageTitle = InactiveCertificatesPage.inactiveCertificatesPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
