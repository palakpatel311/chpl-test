package gov.healthit.chpl.aqa.stepDefinitions;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplResourcesDropdownPage;

/**
 * Class CHPLResourcesDropdownSteps definition.
 */
public class CHPLResourcesDropdownSteps extends BaseSteps {
    /**
     * Click CHPL Resources Top Navigation.
     */

    @When("^I click CHPL Resources Top Navigation Link$")
    public void iclickCHPLResourcesTopNavigationLink() {
        WebDriver driver =  getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChplResourcesDropdownPage.chplResourcesDropdown(driver))).click();
    }

    /**
     * Assert that Contact Us contains URL.
     * @param urlLink expected 'https://www.healthit.gov/form/healthit-feedback-form'
     */
    @Then("^I see Contact Us link points to \"([^\"]*)\"$")
    public void contactUsLinkPointsHealthITFeedbackForm(final String urlLink) {
        WebDriver driver = getDriver();
        String actualURL = ChplResourcesDropdownPage.contactUsURL(driver).getAttribute("href");
        assertEquals(actualURL, urlLink);
    }
}
