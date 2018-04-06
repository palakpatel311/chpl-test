package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
public class ChplSearchSteps {
    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public ChplSearchSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }
    /**
     * Get user to CHPL search page.
     */
    @Given("^I am on CHPL search page$")
    public void iAamOnCHPLSearchPage() {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(SearchPage.pendingMask(driver))));
    }
    /**
     * @param chplId Search for a listing with given chplId.
     * Used text search on page here due to issues with element textFound
     */
    @When("^I search for a listing with CHPL ID \"(.*)\"$")
    public void searchForCHPLID(final String chplId) {
        SearchPage.searchField(driver).sendKeys(chplId);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + chplId + "')]")));
    }
    /**
     * Open Certification Status filter options.
     */
    @And("^I look at Certification Status options$")
    public void viewCertStatusFilterOptions() {
        SearchPage.browseButton(driver).click();
        SearchPage.certStatusFiltersButton(driver).click();
    }
    /**
     * Select desired filter option.
     * @param filterOption is desired filter option
     */
    @And("^I apply \"([^\"]*)\" filter$")
    public void selectFilterOption(final String filterOption) {
        SearchPage.filterOption(driver, filterOption).click();
        SearchPage.certStatusFiltersButton(driver).click();
    }
    /**
     * Open ACB filter options.
     */
    @When("^I look at ACB filter options selected for default search$")
    public void viewAcbFilterOptions() {
        SearchPage.browseButton(driver).click();
        SearchPage.moreFilter(driver).click();
    }
    /**
     * Assert filter option checkbox is checked.
     * @param selectfilter is filter option selected
     */
    @Then("^I see that \"([^\"]*)\" checkbox is checked$")
    public void verifySLIOptionChecked(final String selectfilter) {
        assertTrue(SearchPage.filterOption(driver, selectfilter).isSelected());
    }
    /**
     * Assert message when no results found.
     */
    @Then("^the search page shows 'No results found' message$")
    public void verifyMessage() {
        assertTrue(SearchPage.noResultsFound(driver).getText().contains("No results found"));
    }
    /**
     * Loads a listing. First searches for listing, then loads that listing.
     * Waits to open Listing page until there's only one result, then waits on listing page until the Listing name exists.
     * @param chplId the CHPL Product Number to load
     */
    @Given("^I am on listing details page of listing with CHPL ID \"(.*)\"$")
    public void iAmOnListingDetailsPageOfListingWithCHPLID(final String chplId) {
        driver.get(url + "#/search");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(SearchPage.pendingMask(driver))));
        SearchPage.searchField(driver).sendKeys(chplId);
        wait.until(ExpectedConditions.textToBePresentInElement(SearchPage.resultCount(driver), "1 - 1 of 1 Result"));
        SearchPage.detailsLink(driver).click();
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(driver)));
    }
    /**
     * Asserts that expected listing is returned in result.
     * @param chplId id for listing to expect in search results
     */
    @Then("^I should see listing \"([^\"]*)\" in CHPL search results$")
    public void searchResultsShowSliListing(final String chplId) {
        String actualText = SearchPage.searchResultsChplId(driver).getText();
        assertTrue(actualText.contains(chplId), "Expect " + chplId + " to be found in " + actualText);
    }
    /**
     * Asserts that given listing shows expected status.
     * @param status of listing to expect in search results
     */
    @Then("^the certification status of the listing shows as \"([^\"]*)\"$")
    public void searchResultsShowNewStatus(final String status) {
        String currentStatus = SearchPage.resultsStatus(driver).getAttribute("uib-tooltip");
        assertTrue(currentStatus.contains(status), "Expect " + status + " status found as " + currentStatus);
    }

}
