package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;

/**
 * Class DpManagementSteps definition.
 */

public class DpManagementSteps {
    private WebDriver driver;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public DpManagementSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }

    /**
     * Get user to CHPL search page.
     */
    @And("^I navigate to Manage Surveillnace Activity section$")
    public void iAamOnCHPLSearchPage() {
        DpManagementPage.dpManagementLink(driver).click();
        DpManagementPage.manageSurveillanceActivityLink(driver).click();
    }

    /**
     * Get user to CHPL search page.
     * @param chplId is chplId to look up
     */
    @When("^I search for \"([^\"]*)\" in Manage Surveillance Activity section$")
    public void iSearchForChplIdInSurvSearch(final String chplId) {
        DpManagementPage.surveillanceSearch(driver).sendKeys(chplId);
        DpManagementPage.survSearchButton(driver).click();
    }

    /**
     * Verify surveillance search results load by validating CHPL ID in results.
     * @param chplId is chplId to look up
     * @throws Exception if results did not load and chplId was not found
     */
    @Then("^I see the surveillance results for \"([^\"]*)\"$")
    public void surveillanceResultsAsExpected(final String chplId) throws Exception {
        String actualString = DpManagementPage.chplProductNumber(driver).getText();
        assertTrue(actualString.contains(chplId), "Expect \"" + chplId + "\" to be found in \"" + actualString + "\"");
    }

}
