package gov.healthit.chpl.aqa.asserts;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DeveloperDashboardPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class DeveloperDashboardPageAsserts definition.
 */
public class DeveloperDashboardPageAsserts extends Base {

    @Then("^I see \"([^\"]*)\" in the details section$")
    public void submittedWebsiteInDetails(final String expectedSubmittedWebsite) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DeveloperDashboardPage.changeRequestSubmittedWebsite(getDriver())));
        String actualSubmittedWebsite = DeveloperDashboardPage.changeRequestSubmittedWebsite(getDriver()).getText();
        assertTrue(actualSubmittedWebsite.contains(expectedSubmittedWebsite));
    }

    @Then("^I see \"([^\"]*)\" message$")
    public void withdrawChangeRequestMessage(final String expectedWithdrawChangeRequestMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DeveloperDashboardPage.withdrawChangeRequestMessage(getDriver())));
        String actualWithdrawChangeRequestMessage = DeveloperDashboardPage.withdrawChangeRequestMessage(getDriver()).getText();
        assertTrue(actualWithdrawChangeRequestMessage.contains(expectedWithdrawChangeRequestMessage));
    }

    @Then("^I see the form title as \"([^\"]*)\"$")
    public void iSeeWithdrawChangeRequestFormTitle(final String expectedWithdrawChangeRequestTitle) {
        String actualWithdrawChangeRequestTitle = DeveloperDashboardPage.withdrawChangeRequestTitle(getDriver()).getText();
        assertTrue(actualWithdrawChangeRequestTitle.contains(expectedWithdrawChangeRequestTitle));
    }

    @Then("^I see the \"([^\"]*)\" section$")
    public void titleTrackingSection(final String expectedTitle) {
        String actualTitle = DeveloperDashboardPage.trackingTitle(getDriver(), expectedTitle).getText();
        assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("^I see \"([^\"]*)\" as the title for developer dashboard$")
    public void developerDashboardTitle(final String expectedDeveloperDashboardTitle) {
        String actualDeveloperDashboardTitle = DeveloperDashboardPage.pageTitle(getDriver(), expectedDeveloperDashboardTitle).getText();
        assertTrue(actualDeveloperDashboardTitle.contains(expectedDeveloperDashboardTitle));
    }

    @Then("^I see the change status message as \"([^\"]*)\"$")
    public void changeStatusMessage(final String expectedChangeStatusMessage) {
        String actualChangeStatusMessage = DeveloperDashboardPage.pageTitle(getDriver(), expectedChangeStatusMessage).getText();
        assertTrue(actualChangeStatusMessage.contains(expectedChangeStatusMessage));
    }
}
