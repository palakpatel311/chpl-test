package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class ListingDetailsSteps definition.
 */

public class ListingDetailsSteps extends Base {

    /**
     * Default constructor.
     */
    public ListingDetailsSteps() {
        super();
    }

    /**
     * Loads a listing for given Database ID.
     * @param id the Database or CHPL ID of a listing to load
     */
    @Given("^I am on listing details page of listing with ID \"(.*)\"$")
    public void loadListingWithDbId(final String id) {
        getDriver().get(getUrl() + "#/product/" + id);
        getWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.mainContent(getDriver())));
    }

    /**
     * Open the details for designated certification criteria.
     * @param number criteria to open
     */
    @When("^I open details for criteria \"([^\"]*)\"$")
    public void iOpenDetailsForACriteria(final String number) {
        WebElement link = ListingDetailsPage.certificationCriteriaDetailsLink(getDriver(), number);
        //        Actions actions = new Actions(getDriver());
        //        actions.moveToElement(link);
        //        actions.perform();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", link);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Open the SED panel.
     */
    @When("^I look at SED details$")
    public void iLookAtSEDDetails() {
        WebElement link = ListingDetailsPage.sedAccordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Open Additional Information Accordion.
     */
    @When("^I look at Additional Information$")
    public void iLookAtAdditionalInformation() {
        WebElement link = ListingDetailsPage.additionalInfoAccordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        getWait().until(ExpectedConditions.visibilityOf(ListingDetailsPage.meaningfulUseUsers(getDriver())));
    }

    /**
     * Open the G1/G2 panel.
     */
    @When("^I look at Successfully Tested G1G2 Measures$")
    public void iLookAtG1G2Measures() {
        WebElement link = ListingDetailsPage.g1g2Accordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Select view all CQMs and open CQM accordion.
     */
    @When("^I look at CQM details on listing details page$")
    public void opencqmPanel() {
        ListingDetailsPage.viewAllCertificationCriteriaCQMs(getDriver()).click();
        WebElement link = ListingDetailsPage.cqmAccordion(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Open edit certified product link form.
     */
    @And("^I click on edit certified product link$")
    public void iClickOnEditCertifiedProductLink() {
        WebElement link = ListingDetailsPage.editCPLink(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Clear the ACB Certification field and enter a value.
     */
    @And("^I set the ACB certification field$")
    public void iSetACBCertificationField() {
        ListingDetailsPage.editAcbCertificationId(getDriver()).clear();
        ListingDetailsPage.editAcbCertificationId(getDriver()).sendKeys(getCurrentDate());
        ListingDetailsPage.reasonForChangeField(getDriver()).sendKeys("test");
        ListingDetailsPage.reasonForChangeField(getDriver()).sendKeys(Keys.TAB);
        ListingDetailsPage.editCPSaveButton(getDriver()).click();
    }

    /**
     * Clear the Mandatory Disclosures URL field and enter a value.
     * @param url is www.example.com
     */
    @And("^I set the Mandatory Disclosures URL filed to \"([^\"]*)\"$")
    public void iSetMandatoryDisclosuresURLField(final String url) {
        ListingDetailsPage.editMandatoryDisclosureURLField(getDriver()).clear();
        ListingDetailsPage.editMandatoryDisclosureURLField(getDriver()).sendKeys(url);
        ListingDetailsPage.editMandatoryDisclosureURLField(getDriver()).sendKeys(Keys.RETURN);
    }

    /**
     * Clear the Report File Location field and enter a value.
     */
    @And("^I set the Report File Location field$")
    public void iSetReportFileLocationField() {
        ListingDetailsPage.reportFileLocationField(getDriver()).clear();
        ListingDetailsPage.reportFileLocationField(getDriver()).sendKeys("https://" + getCurrentDate() + ".pdf");
        ListingDetailsPage.reasonForChangeField(getDriver()).sendKeys("test");
        ListingDetailsPage.editCPSaveButton(getDriver()).click();
    }

    /**
     * Clear the certification date field and enter a value.
     * @param value to be entered
     **/
    @And("^I set the certification date field to \"(.*)\"$")
    public void setCertificationDate(final String value) {
        ListingDetailsPage.certificationDateField(getDriver()).clear();
        ListingDetailsPage.certificationDateField(getDriver()).sendKeys(value);
        ListingDetailsPage.certificationDateField(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Clear the product code field and enter a value.
     * @param value to be entered
     **/
    @And("^I set the product code field to \"(.*)\"$")
    public void setProductCode(final String value) {
        ListingDetailsPage.productCodeField(getDriver()).clear();
        ListingDetailsPage.productCodeField(getDriver()).sendKeys(value);
        ListingDetailsPage.productCodeField(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Clear the version code field and enter a value.
     * @param value to be entered
     **/
    @And("^I set the version code field to \"(.*)\"$")
    public void setVersionCode(final String value) {
        ListingDetailsPage.versionCodeField(getDriver()).clear();
        ListingDetailsPage.versionCodeField(getDriver()).sendKeys(value);
        ListingDetailsPage.versionCodeField(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Clear the ics field and enter a value.
     * @param value to be entered
     **/
    @And("^I set the ICS field to \"(.*)\"$")
    public void setIcsField(final String value) {
        ListingDetailsPage.icsField(getDriver()).clear();
        ListingDetailsPage.icsField(getDriver()).sendKeys(value);
        ListingDetailsPage.icsField(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Add a certification status.
     **/
    @And("^I add a certification status$")
    public void addCertificationStatus() {
        ListingDetailsPage.addCertificationStatus(getDriver()).click();
    }

    /**
     * Select certification status from the drop-down list.
     * @param certificationStatus selected from the drop-down list
     **/
    @And("^I select \"(.*)\" certification status from the drop-down list$")
    public void selectCertificationStatusFromDropDown(final String certificationStatus) {
        ListingDetailsPage.clickCertificationStatus(getDriver()).click();
        ListingDetailsPage.selectCertificationStatus(getDriver(), certificationStatus).click();
        ListingDetailsPage.clickCertificationStatus(getDriver()).click();
        ListingDetailsPage.clickCertificationStatus(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Clear Other ACB field and enter a value.
     **/
    @And("^I set the Other ACB field$")
    public void setOtherACBField() {
        ListingDetailsPage.otherACBField(getDriver()).clear();
        ListingDetailsPage.otherACBField(getDriver()).sendKeys(getCurrentDate());
        WebElement link = ListingDetailsPage.editCPSaveButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", link);
        ListingDetailsPage.editCPSaveButton(getDriver()).click();
    }

    /**
     * Expand the Additional Information section on Listing details page.
     **/
    @And("^I expand the Additional Information section on listing details page$")
    public void exapndAdditionalInformationSection() {
        ListingDetailsPage.addtionalInformationSection(getDriver()).click();
    }

    /**
     * Clear Relied Upon Software field and enter a value.
     **/
    @And("^I set the Relied Upon Software Field$")
    public void setReliedUponSoftwareField() {
        ListingDetailsPage.reliedUponSoftwareField(getDriver()).clear();
        ListingDetailsPage.reliedUponSoftwareField(getDriver()).sendKeys(getCurrentDate());
        WebElement link = ListingDetailsPage.editCPSaveButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", link);
        ListingDetailsPage.editCPSaveButton(getDriver()).click();
    }
}
