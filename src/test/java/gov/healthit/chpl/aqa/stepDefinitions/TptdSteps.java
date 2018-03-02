package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class TptdSteps definition.
 */
public class TptdSteps {

    private WebDriver driver;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public TptdSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Assert that Test Procedure text is expected.
     * @param tpText expected text
     * @param number criteria to look in
     */
    @Then("^Test Procedure should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void testProcedureFieldShouldDisplay(final String tpText, final String number) {
        String actualString = ListingDetailsPage.testProcedure(driver, number).getText();
        assertTrue(actualString.contains(tpText), "Expect \"" + tpText + "\" to be found in \"" + actualString + "\"");
    }
}
