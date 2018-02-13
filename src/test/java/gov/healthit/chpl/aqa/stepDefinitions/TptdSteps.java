package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class TptdSteps definition.
 */
public class TptdSteps {

    private WebDriver driver;
    private static final int DELAY = 20;
private String url = System.getProperty("url");
    
    /**
     * Constructor creates new driver.
     */

    public TptdSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }

    @Given("^I am on Details page of Listing \"([^\"]*)\"$")
    public void iAmOnAListingDetailsPage(final String arg1) throws Throwable {
        driver.get(url + "#/product/" + arg1);
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
    }

    @When("^I look at criteria details for criteria c2$")
    public void iLookAtCriteriaDetailsC2() throws Throwable {
        ListingDetailsPage.certificationCriteriaC2ViewDetails(driver);
    }

    @Then("^Test Procedure field should display 'Name: ONC Test Method' text$")
    public void testProcedureFieldShouldDisplayNameONCTestMethodText() throws Throwable {
        assertTrue(driver.getPageSource().contains("Name: ONC Test Method"));
    }

    @When("^I look at criteria details for criteria c3$")
    public void iLookAtCriteriaDetailsC3() throws Throwable {
        ListingDetailsPage.certificationCriteriaC3ViewDetails(driver);
    }

    @When("^I look at criteria details for criteria f1$")
    public void iLookAtCriteriaDetailsF1() throws Throwable {
        ListingDetailsPage.certificationCriteriaF1ViewDetails(driver);
    }
}
