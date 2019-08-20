package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.SurveillanceComplaintsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class SurveillanceComplaintsAsserts definition.
 */
public class SurveillanceComplaintsAsserts extends Base {
    private static final int ACBCOMPLAINTID_COL = 3;
    private static final int ONCCOMPLAINTID_COL = 4;

    @Then("^\"([^\"]*)\" form should open to add new complaint$")
    public void verifyAddComplaintFormOpens(final String title)  {
       String complaintFormTitle = SurveillanceComplaintsPage.addComplaintFormTitle(getDriver()).getText();
       assertTrue(complaintFormTitle.contains(title), "Expect " + title + " to be found in " + complaintFormTitle);
    }

    /**
     * Verify that complaint was added successfully.
     * Assert value in ONC-ACB Complaint Id column in complaints view table
     * @param acbComplaintId is value to look for in Complaint Id column
     */
    @Then("^a new complaint with given \"([^\"]*)\" should be added to CHPL$")
    public void verifyComplaintIsAdded(final String acbComplaintId) {
        getDriver().navigate().refresh();
        boolean isFound = false;

        WebElement table = SurveillanceComplaintsPage.complaintsTable(getDriver());
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(ACBCOMPLAINTID_COL).getText().equals(acbComplaintId)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "Text: " + acbComplaintId + " not found");
    }

    @Then("^\"([^\"]*)\" form should open$")
    public void verifyEditComplaintFormOpens(final String title) {
        String complaintFormTitle = SurveillanceComplaintsPage.addComplaintFormTitle(getDriver()).getText();
        assertTrue(complaintFormTitle.contains(title), "Expect " + title + " to be found in " + complaintFormTitle);
    }

    /**
     * Verify that edits to complaint data saved successfully.
     * Assert value in ONC Complaint Id column in complaints view table post save
     * @param oncComplaintID is value to look for in ONC Complaint Id column
     */
    @Then("^the edits should save and show \"([^\"]*)\" in complaints view table$")
    public void verifyEditsSave(final String oncComplaintID) {
        getDriver().navigate().refresh();
        boolean isFound = false;

        WebElement table = SurveillanceComplaintsPage.complaintsTable(getDriver());
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(ONCCOMPLAINTID_COL).getText().equals(oncComplaintID)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "Text: " + oncComplaintID + " not found");
    }

    /**
     * Verify that complaint was deleted successfully.
     * Assert that value is not found in ONC-ACB Complaint Id column in complaints view table
     * @param acbComplaintId is value to look for in Complaint Id column
     */
    @Then("^the complaint with ONC-ACB Complaint ID \"([^\"]*)\" should not display in complaints view table$")
    public void verifyComplaintIsDeleted(final String acbComplaintId) {
        getDriver().navigate().refresh();
        boolean isFound = false;

        WebElement table = SurveillanceComplaintsPage.complaintsTable(getDriver());
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(ACBCOMPLAINTID_COL).getText().equals(acbComplaintId)) {
                isFound = true;
                break;
            }
        }
        assertFalse(isFound);
    }

    @Then("^the listing \"([^\"]*)\" should be associated to the complaint$")
    public void verifyListingWasAssociatedToComplaint(final String chplId) {
        String actualValue = SurveillanceComplaintsPage.associatedListingValue(getDriver()).getText();
        assertTrue(actualValue.contains(chplId), "Expect " + chplId + " to be found in " + actualValue);
    }

    @Then("^the surveillance \"([^\"]*)\" should be associated to the complaint$")
    public void verifySurveillanceWasAssociatedToComplaint(final String survId) {
        String actualValue = SurveillanceComplaintsPage.associatedSurveillanceValue(getDriver()).getText();
        assertTrue(actualValue.contains(survId), "Expect " + survId + " to be found in " + actualValue);
    }

    @Then("^the criteria \"([^\"]*)\" should be associated to the complaint$")
    public void verifyCriteriaWasAssociatedToComplaint(final String criteria) {
        String actualValue = SurveillanceComplaintsPage.associatedCriteriaValue(getDriver()).getText();
        assertTrue(actualValue.contains(criteria), "Expect " + criteria + " to be found in " + actualValue);
    }

    @Then("^I see \"([^\"]*)\" as the page title on Complaints Reporitng page$")
    public void iSeeComplaintsReportingPageTitle(final String expectedPageTitle) {
        WebElement link = SurveillanceComplaintsPage.complaintsReportingPageTitle(getDriver(), expectedPageTitle);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        String actualPageTitle = SurveillanceComplaintsPage.complaintsReportingPageTitle(getDriver(), expectedPageTitle).getText();
        assertTrue(actualPageTitle.contains(expectedPageTitle));
    }

}
