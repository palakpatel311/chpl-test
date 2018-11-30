package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPISteps definition.
 */
public class ChplAPISteps extends Base {
    /**
     * Assert that link is correct.
     * @param urlLink expected as Link
     * @param text expected as Content
     */
    @Then("^Verify \"(.*)\" under Certified Health IT Product Listing is followed by \"(.*)\"$")
    public void verifyContentUnderCertifiedHealthITProductListingAndURL(final String text, final String urlLink) {
        WebDriver driver = getDriver();
        String actualText = ChplAPIPage.chplContentText(driver).getText();
        String actualURL = ChplAPIPage.healthITFeedBackFormURL(driver).getAttribute("href");
        assertEquals(actualText, text);
        assertEquals(actualURL, urlLink);
    }

    /**
     * Click all the controller elements link.
     * @param controllerName as the name of Controller
     */
    @When("^I click on \"([^\"]*)\" link$")
    public void iClickOnLink(final String controllerName) {
        WebElement link = ChplAPIPage.controllerLink(getDriver(), controllerName);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Assert that APIs from webpage is present in the example API Endpoints.
     * @param apiEndpoints as the details of controller
     */
    @Then("^list of \"(.*)\" operations should be displayed without deprecated calls$")
    public void listOfOperationsShouldBeDisplayed(final String apiEndpoints) {
        WebDriver driver = getDriver();
        List<WebElement> apiElements = ChplAPIPage.controllerElementList(driver);
        List<String> apiListFromPage = new ArrayList<>();
        List<String> apiListFromEndpoints = Arrays.asList(apiEndpoints.split("--"));
        // Checking if the API from the webpage is present in the API Endpoints
        for (WebElement apiLink : apiElements) {
            String apiName = apiLink.getText();
            apiListFromPage.add(apiName);
            assertTrue(apiListFromEndpoints.contains(apiName), "Unknown API found: " + apiName);
        }
        // Checking if the API from the API Endpoints is present in the webpage
        for (String apiData : apiListFromEndpoints) {
            assertTrue(apiListFromPage.contains(apiData), "API not found in the webpage :-" + apiData);
        }
    }
}
