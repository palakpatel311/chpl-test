package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
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
}
