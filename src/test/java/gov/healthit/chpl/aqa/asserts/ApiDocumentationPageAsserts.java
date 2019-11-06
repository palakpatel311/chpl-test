package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ApiDocumentationPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ApiDocumentationPageAsserts definition.
 */
public class ApiDocumentationPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" as the page title for the Api Documentation page$")
    public void iSeePageTitleForApiDocumentaionPage(final String expectedPageTitle) {
        String actualPageTitle = ApiDocumentationPage.apiDocumentationPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
