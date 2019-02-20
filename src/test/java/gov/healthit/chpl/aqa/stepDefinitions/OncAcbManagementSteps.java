package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.OncAcbManagementPage;

/**
 * Class ONC ACB Management step definition.
 */
public class OncAcbManagementSteps extends Base {

    /**
     * Get user to ONC ACB Management  page.
     */
    @When("^I navigate to ONC ACB Management page$")
    public void navigateToONCACBManagementPage() {
        WebElement link = OncAcbManagementPage.oncACBManagementLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Navigate to ONC ACB Listing.
     * @param listingName is the name of ONC ACB listing
     */
    @And("^I click on \"([^\"]*)\"$")
    public void iClickOnONCACBListing(final String listingName) {
        WebElement link =  OncAcbManagementPage.oncACBName(getDriver(), listingName);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Edit ONC ACB Listing.
     */
    @And("^I edit an ACB$")
    public void editACB() {
        WebElement link = OncAcbManagementPage.editONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Retire the ACB on a specific date.
     * @param date set the retirement date
     */
    @And("^I mark it as retired on \"([^\"]*)\"$")
    public void markRetired(final String date) {
        OncAcbManagementPage.markRetirementStatus(getDriver()).click();
        WebElement retirementDate = getDriver().findElement(By.id("retirement-date"));
        retirementDate.sendKeys(date);
        OncAcbManagementPage.saveONCACB(getDriver()).click();
    }

    /**
     * Unretire an existing retired ACB.
     */
    @And("^I unretire an existing retired ACB$")
    public void iUnretireExisitngRetiredACB() {
        OncAcbManagementPage.markRetirementStatus(getDriver()).click();
        OncAcbManagementPage.saveONCACB(getDriver()).click();
    }
}
