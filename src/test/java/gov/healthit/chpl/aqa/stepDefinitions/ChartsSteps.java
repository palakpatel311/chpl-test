package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.ChartsPage;

/**
 * Class ChartsSteps definition.
 */
public class ChartsSteps extends Base {
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
}
