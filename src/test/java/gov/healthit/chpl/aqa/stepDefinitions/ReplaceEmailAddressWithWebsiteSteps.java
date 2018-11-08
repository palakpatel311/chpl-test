package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChartsPage;
import gov.healthit.chpl.aqa.pageObjects.ChplResourcesDropdownPage;
public class ReplaceEmailAddressWithWebsiteSteps extends BaseSteps{

    /**
     * Get user to the Charts page.// chpl charts java file
     */
    @Given("^I am on CHPL Charts page$")
    public void healthITFeedPageElement() throws Throwable {
        WebDriver driver = getDriver();
        driver.get(getUrl() + "#/charts");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChartsPage.healthITFeedBackLink(driver)));
    }

    /**
     * Assert that link text is correct.
     * @throws Throwable if unable to ...
     */

    @Then("^Verify the text of Health IT Feedback Form$")
    public void healthITFeedbackLinkTextShouldBe() throws Throwable {
        String linkText = "Health IT Feedback Form";
        assertEquals(ChartsPage.healthITFeedbackLinkText(getDriver()), linkText);
    }

    /**
     * Click Resources top navigation link -- navigation link step class for each page object
     */

    @When("^I click CHPL Resources Top Navigation Link$")
    public void i_click_CHPL_Resources_Top_Navigation_Link() throws Throwable {
        WebDriver driver =  getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChplResourcesDropdownPage.CHPLResourcesDropdown(driver))).click();
    }

    /**
     * Assert that Contact Us contains href
     * @param text expected "Contact US" points to 'https://www.healthit.gov/form/healthit-feedback-form'
     */

    @Then("^I see Contact us link points to Health IT Feedback Form$")
    public void ContactUsLinkPointsHealthITFeedbackForm() throws Throwable {
        String linkText = "Contact Us";
        assertEquals(ChplResourcesDropdownPage.ContactUsLink(getDriver()), linkText);	
    }

}



