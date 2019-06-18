package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.CMSidReverseLookupPage;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class CMSIDsLookupSteps definition.
 */
public class CMSIDsLookupSteps extends Base {

   /**
    * Default constructor.
    */
   public CMSIDsLookupSteps() {
       super();
   }

    /**
     * Load the reverse lookup page.
     */
    @Given("^I am on the CMS ID Reverse Lookup page$")
    public void iAmOnTheCmsIdReverseLookupPage() {
        getDriver().get(getUrl() + "#/resources/cms-lookup");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(CMSidReverseLookupPage.mainContent(getDriver())));
    }

    /**
     * Look up a CMS ID in the reverse lookup tool.
     * @param cmsId ID to look up
     */
    @When("^I look up CMS ID \"(.*)\" in the reverse look-up tool$")
    public void lookUpCmsId(final String cmsId) {
        CMSidReverseLookupPage.inputCertificationId(getDriver()).sendKeys(cmsId);
        CMSidReverseLookupPage.searchLookupResults(getDriver()).click();
    }

    /**
     * Add Listings to the CMS Widget.
     * @param chplIds semicolon separated list of DB IDs
     */
    @When("^I add \"([^\"]*)\" Listings to the CMS Widget$")
    public void addListingsToWidget(final String chplIds) {
        String[] ids = chplIds.split(";");
        for (String id : ids) {
            getDriver().get(getUrl() + "#/product/" + id);
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(getDriver())));
            ListingDetailsPage.cmsWidgetButton(getDriver(), id).click();
        }
    }

    /**
     * Generate a CMS ID.
     */
    @When("^I generate a CMS ID$")
    public void generateCmsId() {
       getWait().until(ExpectedConditions.elementToBeClickable(CMSidReverseLookupPage.generateCmsIdButton(getDriver())));
        CMSidReverseLookupPage.generateCmsIdButton(getDriver()).click();
   }

    /**
     * Asserts that listings returned in result are as expected.
     * @param chplId id to expect
     */
    @Then("^I should see the listings \"(.*)\" that make up the CMS ID$")
    public void checkForListings(final String chplId) {
        String actualText = CMSidReverseLookupPage.chplIdColumnInCertIdResultsTable(getDriver()).getText();
        assertTrue(actualText.contains(chplId), "Expect " + chplId + " to be found in " + actualText);
    }

    /**
     * Assert that the generated CMS ID matches parameter.
     * @param cmsId expected CMS ID
     */
    @Then("^the generated CMS ID should be \"(.*)\"$")
    public void readCmsId(final String cmsId) {
        String actualText = CMSidReverseLookupPage.cmsIdResults(getDriver()).getText();
        assertTrue(actualText.contains(cmsId), "Expect " + cmsId + " to be found in " + actualText);
    }
}
