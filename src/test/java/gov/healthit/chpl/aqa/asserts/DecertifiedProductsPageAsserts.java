package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DecertifiedProductsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class DecertifiedProductsPageAsserts definition.
 */
public class DecertifiedProductsPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for the Decertified Products page$")
    public void iSeePageTitleForDecertifiedProductsPage(final String expectedPageTitle) {
        String actualPageTitle = DecertifiedProductsPage.decertifiedProductsPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
