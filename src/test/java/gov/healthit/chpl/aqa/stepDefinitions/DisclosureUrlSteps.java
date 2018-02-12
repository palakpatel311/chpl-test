package gov.healthit.chpl.aqa.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;


/**
 * Class DisclosureUrlSteps definition.
 */
public class DisclosureUrlSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public DisclosureUrlSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Loads a listing. First searches for listing, then loads that listing.
     * Waits until the Listing name exists.
     * @param chplId the CHPL Product Number to load
     */
    @Given("^I am on listing details page of listing with CHPL ID \"(.*)\"$")
    public void iAmOnListingDetailsPageOfListingWithCHPLID(final String chplId) {
        driver.get(url + "#/search");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        SearchPage.searchField(driver).sendKeys(chplId);
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
        SearchPage.detailsLink(driver).click();
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.listingName(driver)));
    }

    /**
     * Assert that updated URL exists.
     */
    @Then("^it should show updated url$")
    public void itShouldShowUpdatedUrl() {
        String actualString = ListingDetailsPage.disclosureUrl(driver).getText();
        assertTrue(actualString.contains("cehrt-disclosure-information"));
    }
}
