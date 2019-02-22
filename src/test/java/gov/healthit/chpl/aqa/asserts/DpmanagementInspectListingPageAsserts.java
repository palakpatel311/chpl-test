package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class DpmanagementInspectListingPageAsserts definition.
 */
public class DpmanagementInspectListingPageAsserts extends Base {
    /**
     * Verify warnings on inspect screen.
     * @param warning is expected warning message
     * @param field is field for which warning message is expected
     */
    @Then("^I see warning: \"([^\"]*)\" for duplicate value in \"([^\"]*)\"$")
    public void verifyWarningOnInspect(final String warning, final String field) {

        String warningMessage = DpManagementPage.warningTextOnInspect(getDriver()).getText();

        assertTrue(warningMessage.contains(warning), "no warnings were found for"  + field);
        DpManagementPage.rejectButtonOnInspect(getDriver()).click();
        WebElement button = DpManagementPage.yesOnConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    /**
     * Verify errors for bad inputs in Test Task and Participant fields on inspect screen.
     * @param error is expected error message
     * @param field is field for which error message is expected
     */
    @Then("^I see error: \"(.*)\" for bad value in \"([^\"]*)\"$")
    public void verifyErrorsForTestTasksOnInspect(final String error, final String field) {

        String errorMessage = DpManagementPage.errorTextOnInspect(getDriver()).getText();

        assertTrue(errorMessage.contains(error), "no errors were found for"  + field);
        DpManagementPage.rejectButtonOnInspect(getDriver()).click();
        WebElement button = DpManagementPage.yesOnConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    /**
     * Verify warnings non-integer inputs in Test Task and Participant fields on inspect screen.
     * @param warning is expected warning message
     * @param field is field for which warning message is expected
     */
    @Then("^I see warning \"(.*)\" for non-integer numeric number in \"([^\"]*)\"$")
    public void verifyWarningsForTestTasksOnInspect(final String warning, final String field) {

        String warningMessage = DpManagementPage.warningTextOnInspect(getDriver()).getText();

        assertTrue(warningMessage.contains(warning), "no warnings were found for"  + field);
        DpManagementPage.rejectButtonOnInspect(getDriver()).click();
        WebElement button = DpManagementPage.yesOnConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }
}
