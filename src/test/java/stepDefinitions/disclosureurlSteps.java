package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import gov.healthit.chpl.aqa.pageObjects.SearchPage;

/**
 * Class DisclosureUrlSteps definition.
 */
public class DisclosureUrlSteps {
    private WebDriver driver;
    private static final int DELAY = 20;

    public DisclosureUrlSteps() {
        driver = Hooks.getDriver();
    }

    @Given("^I am on listing details page of listing with CHPL ID \"(.*)\"$")
    public void iAmOnListingDetailsPageOfListingWithCHPLID(final String chplId) throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/search");
        //driver.get("https://chpl.healthit.gov/#/search");
        SearchPage.searchField(driver).sendKeys(chplId);
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        SearchPage.detailsLink(driver).click();
    }

    @Then("^it should show updated url$")
    public void itShouldShowUpdatedUrl() throws Throwable {
        String actualString = SearchPage.disclosureUrl(driver).getText();
        Assert.assertTrue(actualString.contains("cehrt-disclosure-information"));
    }

}
