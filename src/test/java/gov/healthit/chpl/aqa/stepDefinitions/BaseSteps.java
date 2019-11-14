package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.BasePage;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;
/**
 * Class BaseSteps definition.
 */
public class BaseSteps extends Base {
    /**
     * Click CHPL Resources Top Navigation.
     */
    @When("^I click CHPL Resources Top Navigation Link$")
    public void iclickCHPLResourcesTopNavigationLink() {
        getWait().until(ExpectedConditions.visibilityOf(BasePage.chplResourcesDropdown(getDriver())));
        getWait().until(ExpectedConditions.not(ExpectedConditions.visibilityOf(SearchPage.pendingMask(getDriver()))));
        getWait().until(ExpectedConditions.elementToBeClickable(BasePage.chplResourcesDropdown(getDriver())));
        BasePage.chplResourcesDropdown(getDriver()).click();
    }

    /**
     * Assert that title should be CHPL API.
     * @param title expected as CHPL API
     */
    @Then("^the page title should be \"([^\"]*)\"$")
    public void pageTitleShouldBe(final String title) {
        String pageTitle = getDriver().getTitle();
        Assert.assertEquals(pageTitle, title);
    }

    @When("^I click Shortcuts top navigation link$")
    public void iClickShortcutsTopNavigationLink() {
        BasePage.shortcutsDropdown(getDriver()).click();
    }

    @And("^I open \"([^\"]*)\" page$")
    public void iOpenCollectionsPage(final String collectionsPage) {
        BasePage.shortcutsCollectionsPage(getDriver(), collectionsPage).click();
        getWait().until(ExpectedConditions.not(ExpectedConditions.visibilityOf(BasePage.shortcutsCollectionsPage(getDriver(), collectionsPage))));
    }
}
