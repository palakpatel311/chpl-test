package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ChplSearchPageAsserts definition.
 */
public class ChplSearchPageAsserts extends Base {

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
     * Asserts that expected listing is returned in result.
     * @param chplId id for listing to expect in search results
     */
    @Then("^I should see listing \"([^\"]*)\" in CHPL search results$")
    public void searchResultsShowSliListing(final String chplId) {
        String actualText = SearchPage.searchResultsChplId(getDriver()).getText();
        assertTrue(actualText.contains(chplId), "Expect " + chplId + " to be found in " + actualText);
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
     * Assert CCHIT filter option checkbox is unchecked.
     * @param selectfilter is filter option unselected
     */
    @Then("^I see that \"([^\"]*)\" checkbox is unchecked$")
    public void verifyCCHITOptionUnchecked(final String selectfilter) {
        WebElement link = SearchPage.viewONCACBList(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        assertTrue(!(SearchPage.filterOption(getDriver(), selectfilter).isSelected()));
    }
}
