package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPIDocumentationSteps definition.
 */
public class ChplAPIDocumentationSteps extends Base {

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
        wait.until(ExpectedConditions.visibilityOf(ChplAPIPage.mainContent(getDriver())));
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

}
