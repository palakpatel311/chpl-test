package gov.healthit.chpl.aqa.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;

/**
 * Class DeleteDupListingsSteps definition.
 */

public class DeleteDupListingsSteps {

    private WebDriver driver;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public DeleteDupListingsSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }

    @Given("^I am on CHPL search page$")
    public void i_am_on_CHPL_search_page() throws Throwable {
        driver.get(url);
    }

    @When("^I search for a listing with CHPL ID \"(.*)\"$")
    public void i_search_for_a_listing_with_CHPL_ID_MEDI_IR(final String chplId) throws Throwable {
        SearchPage.searchField(driver).sendKeys(chplId);
    }

    @Then("^the search page shows 'No results found' message$")
    public void the_search_page_shows_No_results_found_message() throws Throwable {
        assertTrue(SearchPage.noResultsFound(driver).getText().contains("No results found"));
    }

    @Given("^I am on listing details page of listing with database ID \"(.*)\"$")
    public void i_am_on_listing_details_page_of_listing_with_CHPL_ID_MEDI_IR(final String dbId) throws Throwable {
        driver.get(url + "#/product/" + dbId);
    }

    @Then("^the page shows 'This listing does not exist' message$")
    public void the_page_shows_This_listing_does_not_exist_message() throws Throwable {
        assertTrue(ListingDetailsPage.mainContent(driver).getText().contains("This listing does not exist"));
    }
}
