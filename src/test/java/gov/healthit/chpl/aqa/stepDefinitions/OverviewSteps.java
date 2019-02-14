package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.OverviewPage;

/**
 * Class OverviewSteps definition.
 */
public class OverviewSteps extends Base {
    /**
     * Constructor creates new driver.
     */
    public OverviewSteps() {
    }

    /**
     * Get user to the Overview page.
     */
    @Given("^I'm on Overview page$")
    public void userLoadsOverviewPage() {
        getDriver().get(getUrl() + "#/resources/overview");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(OverviewPage.mainContent(getDriver())));
    }
}

