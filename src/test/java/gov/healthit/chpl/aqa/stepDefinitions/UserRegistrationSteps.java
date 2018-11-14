package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.UserRegistrationPage;
/**
 * Class UserRegistrationSteps definition.
 */
public class UserRegistrationSteps extends BaseSteps {
    /**
     * Get user to the User Registration Page.
     * Click Create New Account
     */
    @Given("^I am on User Registration page$")
    public void userRegistrationPage() {
        WebDriver driver =  getDriver();
        driver.get(getUrl() + "#/registration/create-user/laskdjfkdsaf");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOf(UserRegistrationPage.createNewAccount(driver))).click();
    }
    /**
     * Assert that URL and text is correct.
     * @param textName expected Health IT Feedback Form
     * @param urlLink expected 'https://www.healthit.gov/form/healthit-feedback-form'
     */
    @Then("^\"([^\"]*)\", points to \"([^\"]*)\"$")
    public void userRegistrationHealthITForm(final String textName, final String urlLink) {
        WebDriver driver = getDriver();
        String actualText = UserRegistrationPage.healthITFeedbackForm(driver).getText();
        String actualURL = UserRegistrationPage.healthITFeedbackForm(driver).getAttribute("href");
        assertEquals(actualText, textName);
        assertEquals(actualURL, urlLink);
    }
}
