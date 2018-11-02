package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPIDocumentationSteps definition.
 */
public class ChplAPIDocumentationSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 60;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public ChplAPIDocumentationSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
       }
    }

    /**
     * Get user to the API Documentation page.
     */
    @Given("^I am on CHPL API page$")
    public void userLoadsOverviewPage() {
        driver.get(url + "#/resources/chpl_api");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChplAPIPage.mainContent(driver)));
    }

    /**
     * Click open Controller list.
     * @param controller desired controller to open
     */
    @When("^I click on \"([^\"]*)\" to see operations list$")
    public void openController(final String controller) {
        WebElement link = ChplAPIPage.controllerLink(driver, controller);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /**
     * Click open Certified Product endpoint details.
     */
    @And("^I click on Certified Products endpoint link to view details$")
    public void viewCertifiedProductDetails() {
        WebElement link = ChplAPIPage.certifiedProductsEndpoint(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /**
     * Assert that text is updated.
     * @param imptext expected text
     */
    @Then("^implementation note should show updated text \"([^\"]*)\"$")
    public void verifyUpdatedTextInCertifiedProductEndpointDetails(final String imptext) {
        String impNotes = ChplAPIPage.certifiedProductsImplementationNotes(driver).getText();
        assertTrue(impNotes.contains(imptext), "Expect " + imptext + " to be found in " + impNotes);
    }
}
