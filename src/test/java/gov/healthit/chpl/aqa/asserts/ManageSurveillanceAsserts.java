package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.pageObjects.SurveillanceManagePage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;
import gov.healthit.chpl.aqa.stepDefinitions.Hooks;
/**
 * Class ManageSurveillanceAsserts definition.
 */
public class ManageSurveillanceAsserts extends Base {

    /**
     * Verify surveillance search results load by validating CHPL ID in results.
     * @param chplId is chplId to look up
     * @throws Exception if results did not load and chplId was not found
     */
    @Then("^I see the surveillance results for \"([^\"]*)\"$")
    public void testSurveillanceResultsAsExpected(final String chplId) throws Exception {
        try {
            WebElement table = DpManagementPage.manageSurveillanceTable(getDriver());
            List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));
            assertEquals(rows.size(), 1, "Expect to find 1 row, found" + rows.size());
            String actualString = rows.get(0).findElement(By.xpath("td[1]/button")).getText();
            assertTrue(actualString.contains(chplId), "Expect \"" + chplId + "\" to be found in \"" + actualString + "\"");
        } catch (NoSuchElementException nsee) {
            Hooks.takeScreenshot(chplId);
            assertTrue(false, chplId + ": " + nsee.getMessage());
        }
    }

    @Then("^the option to Initiate Surveillance should not be available$")
    public void verifyInitiateSurveillanceOptionDoesNotDisplay() {
        boolean initiateButtonFound = false;
        try {
            initiateButtonFound = SurveillanceManagePage.initiateSurveillanceButton(getDriver()).isDisplayed();
            fail("Found initiate button when shouldn't have");
        } catch (NoSuchElementException e) {
            assertFalse(initiateButtonFound, "Initiate Surveillance button is available");
        }
    }

    @Then("^the edit button should not show for existing surveillance activities$")
    public void verifyEditSurveillanceButtonDoesNotDisplay() {
        boolean editeButtonFound = false;
        try {
            editeButtonFound = SurveillanceManagePage.editSurveillanceButton(getDriver()).isDisplayed();
            fail("Found edit button when shouldn't have");
        } catch (NoSuchElementException e) {
            assertFalse(editeButtonFound, "Edit Surveillance button is available");
        }
    }

    @Then("^I see error message \"([^\"]*)\"$")
    public void verifyErrorMessageOn2014SurveillanceUpload(final String errorText) {
        String errorMessage = SurveillanceManagePage.errorTextOnSurveillanceInspect(getDriver()).getText();

        assertTrue(errorMessage.contains(errorText), "no errors were found");
        SurveillanceManagePage.rejectButtonOnSurveillanceInspect(getDriver()).click();
        WebElement button = DpManagementPage.yesOnConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }
}
