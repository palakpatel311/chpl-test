package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.pageObjects.SurveillanceManagePage;


public class SurveillanceManageSteps extends Base {
    /**
     * Constructor creates new driver.
     */
    public SurveillanceManageSteps() {
    }

    /**
     * Get user to the Manage Surveillance page.
     */
    @Given("^I'm on Manage surveillance page$")
    public void userLoadsManageSurveillancePage() {
        getDriver().get(getUrl() + "#/surveillance/manage");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(SurveillanceManagePage.generalFilterInput(getDriver())));
    }

    /**
     * Search for given CHPL Id on Manage Surveillance Activity Page.
     *@param chplId is chplId to look up
     * @throws Exception if screenshot cannot be taken
     */
    @When("^I search for \"([^\"]*)\" in Manage Surveillance Activity section$")
    public void searchForChplIdInSurvSearch(final String chplId) throws Exception {
        DpManagementPage.surveillanceSearch(getDriver()).sendKeys(chplId);
        Thread.sleep(DEBOUNCE_TIME); // need to wait for smart-table component
                                     // to recognize text
    }

    @When("^I open Manage surveillance page of searched listing$")
    public void viewSurveillancedetails() {
        SurveillanceManagePage.chplIdButtonInFilteredResults(getDriver()).click();
        SurveillanceManagePage.chplIdTab(getDriver()).click();
        getWait().until(ExpectedConditions.visibilityOf(SurveillanceManagePage.surveillanceList(getDriver())));
    }

}
