package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
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
public class CMSIDsLookupSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public CMSIDsLookupSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Load the reverse lookup page.
     */
    @Given("^I am on the CMS ID Reverse Lookup page$")
    public void iAmOnTheCmsIdReverseLookupPage() {
        driver.get(url + "#/resources/cms_lookup");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(CMSidReverseLookupPage.mainContent(driver)));
    }

    /**
     * Look up a CMS ID in the reverse lookup tool.
     * @param cmsId ID to look up
     */
    @When("^I look up CMS ID \"(.*)\" in the reverse look-up tool$")
    public void lookUpCmsId(final String cmsId) {
        CMSidReverseLookupPage.inputCertificationId(driver).sendKeys(cmsId);
        CMSidReverseLookupPage.SearchLookupResults(driver).click();
    }

    /**
     * Add Listings to the CMS Widget.
     * @param chplIds semicolon separated list of DB IDs
     */
    @When("^I add \"([^\"]*)\" Listings to the CMS Widget$")
    public void addListingsToWidget(final String chplIds) {
        String[] ids = chplIds.split(";");
        for (String id : ids) {
            driver.get(url + "#/product/" + id);
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(driver)));
            ListingDetailsPage.cmsWidgetButton(driver, id).click();
        }
    }

    /**
     * Generate a CMS ID.
     */
    @When("^I generate a CMS ID$")
    public void generateCmsId() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        if (CMSidReverseLookupPage.widgetToggle(driver).getAttribute("aria-expanded").equals("false")) {
            CMSidReverseLookupPage.widgetToggle(driver).click();
        }
        wait.until(ExpectedConditions.visibilityOf(CMSidReverseLookupPage.generateCmsIdButton(driver)));
        CMSidReverseLookupPage.generateCmsIdButton(driver).click();
        wait.until(ExpectedConditions.visibilityOf(CMSidReverseLookupPage.cmsIdResults(driver)));
    }

    /**
     * Asserts that listings returned in result are as expected.
     * @param chplId id to expect
     */
    @Then("^I should see the listings \"(.*)\" that make up the CMS ID$")
    public void checkForListings(final String chplId) {
        String actualText = CMSidReverseLookupPage.CertIdResultsTable_CHPLIdcolumn(driver).getText();
        assertTrue(actualText.contains(chplId), "Expect " + chplId + " to be found in " + actualText);
    }

    /**
     * Assert that the generated CMS ID matches parameter.
     * @param cmsId expected CMS ID
     */
    @Then("^the generated CMS ID should be \"(.*)\"$")
    public void readCmsId(final String cmsId) {
        String actualText = CMSidReverseLookupPage.cmsIdResults(driver).getText();
        assertTrue(actualText.contains(cmsId), "Expect " + cmsId + " to be found in " + actualText);
    }
}
