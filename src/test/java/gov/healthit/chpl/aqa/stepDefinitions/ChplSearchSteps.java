package gov.healthit.chpl.aqa.stepDefinitions;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
     * Assert filter option checkbox is checked.
     * @param selectfilter is filter option selected
     */
    @Then("^I see that \"([^\"]*)\" checkbox is checked$")
    public void verifySLIOptionChecked(final String selectfilter) {
        assertTrue(SearchPage.filterOption(getDriver(), selectfilter).isSelected());
    }

    /**
     * Assert message when no results found.
     */
    @Then("^the search page shows 'No results found' message$")
    public void verifyMessage() {
        assertTrue(SearchPage.noResultsFound(getDriver()).getText().contains("No results found"));
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
     * Asserts that expected listing is returned in result.
     * @param chplId id for listing to expect in search results
     */
    @Then("^I should see listing \"([^\"]*)\" in CHPL search results$")
    public void searchResultsShowSliListing(final String chplId) {
        String actualText = SearchPage.searchResultsChplId(getDriver()).getText();
        assertTrue(actualText.contains(chplId), "Expect " + chplId + " to be found in " + actualText);
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
     * Asserts that given listing shows in search results.
     * @param chplId of listing to expect in search results
     */
    @Then("^the only listing with CHPL ID \"([^\"]*)\" appears in search results$")
    public void searchResultsShowListing(final String chplId) {
        String listing = SearchPage.searchResultsChplId(getDriver()).getText();
        assertTrue(listing.contains(chplId), "Expect " + chplId + " found as " + listing);
        String itemcount = SearchPage.resultCount(getDriver()).getText();
        assertTrue(itemcount.contains("1 - 1 of 1 Result"), "Expect" + itemcount + " count found as " + itemcount);
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

    /**
     * Click on download search-results button that displays data categories to include.
     * @param searchResultsChplID expected CHPL ID on search results page
     */
    @When("^I wait for \"([^\"]*)\" to load in the webpage and I click Download Search Results button$")
    public void clickOnDownloadSearchResultsButton(final String searchResultsChplID) {
        SearchPage.browseButton(getDriver()).click();
        WebElement link = SearchPage.downloadsearchResultsButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(SearchPage.loadChplID(getDriver(), searchResultsChplID)));
    }

    /**
     * Download the Search-Results file and check whether complete file is downloaded.
     * @throws Throwable Exception if the expected file not found
     */
    @And("^I click download 50 Results button$")
    public void clickDownload50ResultsButton() throws Throwable {
        WebElement link = SearchPage.download50ResultButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        checkCompleteFileDownload("search-results", ".csv");
    }

    /**
     * Read the data from downloaded CSV file.
     * Asserts that expected filter options and CHPL ID consists in the downloaded search-results.csv file
     * @param headers expected name of each column header in the CSV file
     * @param chplId expected CHPL ID
     * @throws FileNotFoundException if the expected file not found
     */

    @Then("^the file is downloaded and contains selected filter options as \"([^\"]*)\" where CHPL ID is \"([^\"]*)\"$")
    public void readDownloadedCSVFile(final String headers, final String chplId) throws FileNotFoundException {
        String[] headerArray = headers.split(",");
        List<String> headerList = Arrays.asList(headerArray);
        List<String> csvHeaderList = new ArrayList<>();
        File[] files = Hooks.getDownloadDirectory().listFiles();
        for (File file : files) {
            Scanner scanner = new Scanner(file);
            Scanner dataScanner = null;
            boolean headersChecked = false;
            boolean foundChpId = false;
            while (!foundChpId && scanner.hasNextLine()) {
                dataScanner = new Scanner(scanner.nextLine());
                dataScanner.useDelimiter(",");
                while (dataScanner.hasNext()) {
                    String data = dataScanner.next();
                    if (headersChecked) {
                        if (data.equalsIgnoreCase(chplId)) {
                            foundChpId = true;
                            break;
                        }
                    } else {
                        csvHeaderList.add(data);
                    }
                }
                if (!headersChecked) {
                    for (String  header : headerList) {
                        assertTrue(csvHeaderList.contains(header), "The search option [ " + header + " ] is missing in the CSV file");
                        headersChecked = true;
                    }
                }
            }
            assertTrue(foundChpId, "chpl id [ " + chplId + " ] not found");
            scanner.close();
        }
    }

    /**
     * Change the count of search results per page.
     * @param count expected count of search results per page
     */
    @And("^I scroll down to select \"([^\"]*)\" results per page for results display$")
    public void scrollDownToSelectResultsPerPage(final String count) {
        SearchPage.browseButton(getDriver()).click();
        WebElement searchResultPerPageDropDown = SearchPage.searchResultPerPage(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", searchResultPerPageDropDown);
        Select sel = new Select(searchResultPerPageDropDown);
        sel.selectByVisibleText(count);
    }

    /**
     * Click Download Results button in search filters.
     */
    @When("^I click Download Results button in search filters to download the search results$")
    public void clickDownloadResultsButtonInSearchFilters() {
        WebElement downloadButton = SearchPage.downloadsearchResultsButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", downloadButton);
    }

    /**
     * Asserts that expected text is correct.
     * @param text expected Please reduce results to less than 50 to download them
     */
    @Then("^I see that download for >50 count is not allowed and alert \"([^\"]*)\" is displayed$")
    public void resultText(final String text) {
        WebElement link = SearchPage.searchResultText(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        String actualText = SearchPage.searchResultText(getDriver()).getText();
        assertEquals(actualText, text);
    }
}
