package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ManageDevelopersAndProductsPage;

/**
 * Class ManageDevelopersAndProductsSteps definition.
 */

public class ManageDevelopersAndProductsSteps {
    private WebDriver driver;
    private static final int TIMEOUT = 60;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public ManageDevelopersAndProductsSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }

    /**
     * Loads a listing for given Database ID.
     * @param id the Database or CHPL ID of a listing to load
     */

    @Given("^I navigate to Manage Developers and Products page listing details section of listing with ID \"([^\"]*)\"$")
    public void loadListingDetailsDpManagement(final String id) {
        driver.get(url + "#/admin/dpManagement/manage/" + id);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ManageDevelopersAndProductsPage.editCertifiedProductLink(driver)));
    }

    /**
     * Assert that SED End Date of Testing displays date value on UI.
     * @param sedEndDate the URL value to assert
     */
    @Then("^SED End Date of Testing field should display the date \"([^\"]*)\"$")
    public void sedEndDateOfTestingShouldDisplayDate(final String sedEndDate) {
        String actualText = ManageDevelopersAndProductsPage.sedEndDateOfTesting(driver).getText();
        assertTrue(actualText.contains(sedEndDate), "Expect " + sedEndDate + " to be found in " + actualText);
    }

}
