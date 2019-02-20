package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;

/**
 * Class ChplSearchSteps definition.
 */
public class ChplSearchSteps extends Base {

    /**
     * Constructor creates new driver.
     */
    public ChplSearchSteps() {
    }

    /**
     * Get user to CHPL search page.
     */
    @Given("^I am on CHPL search page$")
    public void iAamOnCHPLSearchPage() {
        getDriver().get(getUrl());
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(SearchPage.pendingMask(getDriver()))));
    }

    /**
     * Search for a listing that I expect to find.
     * @param chplId the Listing's CHPL ID
     */
    @When("^I search for a listing with CHPL ID \"(.*)\"$")
    public void searchForCHPLID(final String chplId) {
        SearchPage.searchField(getDriver()).sendKeys(chplId);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + chplId + "')]")));
    }

    /**
     * Searching for a listing that I expect to not find.
     * @param chplId the Listing's CHPL ID
     */
    @When("^I search for a missing listing with CHPL ID \"(.*)\"$")
    public void searchForMissingCHPLID(final String chplId) {
        SearchPage.searchField(getDriver()).sendKeys(chplId);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(SearchPage.resultsSection(getDriver())));
    }

    /**
     * Open Certification Status filter options.
     */
    @And("^I look at Certification Status options$")
    public void viewCertStatusFilterOptions() {
        SearchPage.browseButton(getDriver()).click();
        SearchPage.certStatusFiltersButton(getDriver()).click();
    }

    /**
     * Select desired filter option.
     * @param filterOption is desired filter option
     */
    @And("^I apply \"([^\"]*)\" filter$")
    public void selectFilterOption(final String filterOption) {
        SearchPage.filterOption(getDriver(), filterOption).click();
        SearchPage.certStatusFiltersButton(getDriver()).click();
    }

    /**
     * Open ACB filter options.
     */
    @When("^I look at ACB filter options selected for default search$")
    public void viewAcbFilterOptions() {
        SearchPage.browseButton(getDriver()).click();
        SearchPage.moreFilter(getDriver()).click();
    }

    /**
     * Loads a listing. First searches for listing, then loads that listing.
     * Waits to open Listing page until there's only one result, then waits on listing page until the Listing name exists.
     * @param chplId the CHPL Product Number to load
     */
    @Given("^I am on listing details page of listing with CHPL ID \"(.*)\"$")
    public void iAmOnListingDetailsPageOfListingWithCHPLID(final String chplId) {
        getDriver().get(getUrl() + "#/search");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(SearchPage.pendingMask(getDriver()))));
        SearchPage.searchField(getDriver()).sendKeys(chplId);
        wait.until(ExpectedConditions.textToBePresentInElement(SearchPage.resultCount(getDriver()), "1 - 1 of 1 Result"));
        SearchPage.detailsLink(getDriver()).click();
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(getDriver())));
    }

    /**
     * Asserts that given listing shows expected status.
     * @param status of listing to expect in search results
     */
    @Then("^the certification status of the listing shows as \"([^\"]*)\"$")
    public void searchResultsShowNewStatus(final String status) {
        String currentStatus = SearchPage.resultsStatus(getDriver()).getAttribute("uib-tooltip");
        assertTrue(currentStatus.contains(status), "Expect " + status + " status found as " + currentStatus);
    }

    /**
     * Select all certification status.
     */
    @And("^I select all status on Certification Status filter$")
    public void selectAllCertStatusFilters() {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(SearchPage.certStatusFiltersButton(getDriver())));
        SearchPage.certStatusFiltersButton(getDriver()).click();
        SearchPage.selectAllStatus(getDriver()).click();
    }
}
