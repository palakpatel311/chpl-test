package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import gov.healthit.chpl.aqa.pageObjects.DeveloperDashboardPage;

/**
 * Class DeveloperDashboardSteps definition.
 */
public class DeveloperDashboardSteps extends Base {

    @And("^I edit the developer website field to \"([^\"]*)\"$")
    public void setDeveloperWebsiteField(final String developerWebsite) {
        DeveloperDashboardPage.editDeveloperWebsite(getDriver()).clear();
        DeveloperDashboardPage.editDeveloperWebsite(getDriver()).sendKeys(developerWebsite);
    }

    @And("^I save the developer edit information$")
    public void saveDeveloperEditInformation() {
        WebElement submitButton = DeveloperDashboardPage.saveDeveloperInformation(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", submitButton);
    }

    @And("^I edit the developer information$")
    public void editDeveloperInfo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DeveloperDashboardPage.editDeveloperInformation(getDriver())));
        WebElement button = DeveloperDashboardPage.editDeveloperInformation(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    @And("^I click the request status with \"([^\"]*)\" in the tracking section$")
    public void clickWebsiteChangeRequestWithPendingONCACBAction(final String requestStatus) {
        getDriver().navigate().refresh();
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DeveloperDashboardPage.changeRequestStatus(getDriver(), requestStatus)));
        WebElement requestStatusButton = DeveloperDashboardPage.changeRequestStatus(getDriver(), requestStatus);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", requestStatusButton);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", requestStatusButton);
    }

    @And("^I \"([^\"]*)\"$")
    public void changeRequestAction(final String changeRequestAction) {
        DeveloperDashboardPage.changeRequestAction(getDriver(), changeRequestAction).click();
    }

    @And("^I go back to the change request$")
    public void goBackToChangeRequest() {
        DeveloperDashboardPage.goBackToChangeRequest(getDriver()).click();
    }

    @And("^I enter reason for change as \"([^\"]*)\"$")
    public void enterReasonForChange(final String reasonForChange) {
        DeveloperDashboardPage.withdrawChangeRequestReasonForChange(getDriver()).sendKeys(reasonForChange);
    }

    @And("^I click withdraw change request$")
    public void clickWithdrawChangeRequest() {
        DeveloperDashboardPage.submitWithdrawChangeRequest(getDriver()).click();
    }

    @And("^I edit the Submitted website field to \"([^\"]*)\"$")
    public void editSubmittedWebsite(final String submittedWebsite) {
        DeveloperDashboardPage.editChangeRequestSubmittedWebsite(getDriver()).clear();
        DeveloperDashboardPage.editChangeRequestSubmittedWebsite(getDriver()).sendKeys(submittedWebsite);
    }

    @And("^I save the edited change request$")
    public void saveEditedChangeRequest() {
        DeveloperDashboardPage.saveEditedChangeRequest(getDriver()).click();
    }

    @And("^I check the status log$")
    public void checkStatusLog() {
        DeveloperDashboardPage.statusLog(getDriver()).click();
    }
}

