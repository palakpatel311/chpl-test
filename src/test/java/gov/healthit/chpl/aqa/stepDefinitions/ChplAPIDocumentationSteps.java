package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.BasePage;
import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPIDocumentationSteps definition.
 */
public class ChplAPIDocumentationSteps extends BaseSteps {

    /**
     * Constructor creates new driver.
     */
    public ChplAPIDocumentationSteps() {
        super();
       }

    /**
     * Get user to the API Documentation page.
     */
    @Given("^I am on CHPL API page$")
    public void userLoadsAPIPage() {
        getDriver().get(getUrl() + "#/resources/chpl_api");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(BasePage.mainContent(getDriver())));
    }

    /**
     * Click open Controller list.
     * @param controller desired controller to open
     */
    @When("^I click on \"([^\"]*)\" to see operations list$")
    public void openController(final String controller) {
        WebElement link = ChplAPIPage.controllerLink(getDriver(), controller);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Click open given endpoint details.
     * @param apiEndpoint given endpoint to view details
     * @param endpointLink link to open details
     */
    @And("^I click on \"([^\"]*)\" using \"([^\"]*)\" link to view details$")
    public void viewEndpointDetails(final String apiEndpoint, final String endpointLink) {
        WebElement link = ChplAPIPage.endpointLink(getDriver(), endpointLink);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Assert that text is updated.
     * @param imptext expected text
     */
    @Then("^endpoint details should show updated text \"([^\"]*)\"$")
    public void verifyUpdatedTextInCertifiedProductEndpointDetails(final String imptext) {
        String impNotes = ChplAPIPage.certifiedProductsImplementationNotes(getDriver()).getText();
        assertTrue(impNotes.contains(imptext), "Expect " + imptext + " to be found in " + impNotes);
    }
}
