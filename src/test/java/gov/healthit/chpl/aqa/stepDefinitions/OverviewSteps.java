package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
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

    /**
     * Click navigation links on Overview Page using link text.
     * @param linkText text of link
     */
    @When("^I click \"([^\"]*)\" link from left hand navigation$")
    public void clickNavigationLinkOnOverviewPage(final String linkText) {
       OverviewPage.navLinksOnOverviewPage(getDriver(), linkText).click();
    }
}

