package gov.healthit.chpl.aqa.stepDefinitions;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ChartsPage;

/**
 * Class ChartsSteps definition.
 */
public class ChartsSteps extends BaseSteps {
    /**
     * Get user to the Charts page.
     */
    @Given("^I am on CHPL charts page$")
    public void iAmOnCHPLChartsPage() {
        WebDriver driver = getDriver();
        driver.get(getUrl() + "#/charts");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChartsPage.mainContent(driver)));
    }

    /**
     * Assert that urlLink and text is correct.
     * @param textName expected Health IT Feedback Form
     * @param urlLink expected 'https://www.healthit.gov/form/healthit-feedback-form'
     */

    @Then("^\"([^\"]*)\" points to \"([^\"]*)\"$")
    public void healthITFeedbackFormPointsToURL(final String textName, final String urlLink) {
        WebDriver driver = getDriver();
        String actualText = ChartsPage.chartsHealthITFeedback(driver).getText();
        String actualURL = ChartsPage.chartsHealthITFeedback(driver).getAttribute("href");
        assertEquals(actualText, textName);
        assertEquals(actualURL, urlLink);
    }
}
