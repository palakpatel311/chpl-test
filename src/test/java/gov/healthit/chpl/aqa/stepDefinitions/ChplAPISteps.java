package gov.healthit.chpl.aqa.stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
     * Assert that title should be CHPL API.
     * @param title expected as CHPL API
     */
    @Then("^CHPL API page title should be \"([^\"]*)\"$")
    public void chplApiPageTitleShouldBe(final String title) {
        String chplAPITitle = getDriver().getTitle();
        Assert.assertEquals(chplAPITitle, title);
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
    @Then("^list of \"([^\"]*)\" operations should be displayed without deprecated calls$")
    public void listOfOperationsShouldBeDisplayed(final String apiEndpoints) {
        WebDriver driver = getDriver();
        // Get element from the webpage into the list
        List<WebElement> listWebElements = ChplAPIPage.controllerElementList(driver);
        // Creating a list to hold all the API listed on the webpage by swagger
        List<String> apiListFromPage = new ArrayList<>();
        // Get text of the Web Elements list
        for (WebElement wElement : listWebElements) {
            apiListFromPage.add(wElement.getText());
        }
        System.out.println("apiEndpoints" + apiEndpoints);
        // Checking if the API from the webpage is present in the example API endpoints
        for (String api : apiListFromPage) {
            assertTrue(apiEndpoints.contains(api));
        }
    }
}
