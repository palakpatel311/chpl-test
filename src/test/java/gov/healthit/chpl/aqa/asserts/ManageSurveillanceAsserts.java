package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
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
}
