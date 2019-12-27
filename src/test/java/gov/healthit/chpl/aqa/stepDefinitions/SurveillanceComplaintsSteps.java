package gov.healthit.chpl.aqa.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.SurveillanceComplaintsPage;

/**
 * Class SurveillanceComplaintsSteps definition.
 */
public class SurveillanceComplaintsSteps extends Base {
    @Given("^I am on complaints page$")
    public void loadComplaintsPage() {
        getDriver().get(getUrl() + "#/surveillance/complaints");
    }

    @When("^I click Add New Complaint button$")
    public void clickAddNewComplaintButton() {
      SurveillanceComplaintsPage.addNewComplaintButton(getDriver()).click();
      getWait().until(ExpectedConditions.visibilityOf(SurveillanceComplaintsPage.oncACBField(getDriver())));
    }

    /**
     * Fill data in complaint form.
     * @param acb is ACB for which complaint is being entered
     * @param receivedDate is received date of complaint
     * @param closedDate is date when complaint was closed
     * @param acbComplaintId ACB complaint ID
     * @param oncComplaintId ONC complaint ID
     * @param complainantType is type of complainant
     * @param summary is summary of a complaint
     */
    @When("^I enter complaint data in fields: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void enterDataInComplaintFields(final String acb, final String receivedDate, final String closedDate,
            final String acbComplaintId, final String oncComplaintId, final String complainantType,
            final String summary) {
        getWait().until(ExpectedConditions.visibilityOf(SurveillanceComplaintsPage.oncACBField(getDriver())));
        SurveillanceComplaintsPage.oncACBField(getDriver()).sendKeys(acb);
        SurveillanceComplaintsPage.receivedDate(getDriver()).sendKeys(receivedDate);
        SurveillanceComplaintsPage.closedDate(getDriver()).sendKeys(closedDate);
        SurveillanceComplaintsPage.oncACBComplaintId(getDriver()).sendKeys(acbComplaintId);
        SurveillanceComplaintsPage.oncComplaintId(getDriver()).sendKeys(oncComplaintId);
        SurveillanceComplaintsPage.complainantType(getDriver()).sendKeys(complainantType);
        SurveillanceComplaintsPage.summary(getDriver()).sendKeys(summary);
    }

    @When("^I click save button$")
    public void clickSaveButton() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", SurveillanceComplaintsPage.saveButtonOnNewComplaintForm(getDriver()));
        getWait().until(ExpectedConditions.visibilityOf(SurveillanceComplaintsPage.complaintsTable(getDriver())));
    }

    /**
     * Edit a complaint.
     * @param acbComplaintId is a ACB complaint ID of a complaint to be edited
     */
    @When("^I click Edit complaint for ONC-ACB Complaint ID \"([^\"]*)\"$")
    public void clickEditComplaint(final String acbComplaintId) {
        getDriver().navigate().refresh();
        getWait().until(ExpectedConditions.visibilityOf(SurveillanceComplaintsPage.complaintsTable(getDriver())));

        List<WebElement> acbComplaintIdValue = getDriver().findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table/tbody/tr/td[4]"));
        List<WebElement> allEditButtons = getDriver().findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table/tbody/tr/td[7]/button/i"));

        for (int i = 0; i < acbComplaintIdValue.size(); i++) {

            if (acbComplaintIdValue.get(i).getText().equals(acbComplaintId)) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", allEditButtons.get(i));
                break;
            }
        }
    }

    @When("^I edit data in ONC Complaint ID field to \"([^\"]*)\"$")
    public void editDataInComplaintFields(final String oncComplaintId) {
        SurveillanceComplaintsPage.oncComplaintId(getDriver()).clear();
        SurveillanceComplaintsPage.oncComplaintId(getDriver()).sendKeys(oncComplaintId);
    }

    /**
     * Delete a complaint.
     * @param acbComplaintId is a ACB complaint ID of a complaint to be deleted
     */
    @And("^I click delete button to delete complaint with ONC-ACB Complaint ID \"([^\"]*)\"$")
    public void clickDeleteComplaintButton(final String acbComplaintId) {
        getDriver().navigate().refresh();
        getWait().until(ExpectedConditions.visibilityOf(SurveillanceComplaintsPage.complaintsTable(getDriver())));

        List<WebElement> acbComplaintIdValue = getDriver().findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table/tbody/tr/td[4]"));
        List<WebElement> allEditButtons = getDriver().findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table/tbody/tr/td[7]/button[2]"));

        for (int i = 0; i < acbComplaintIdValue.size(); i++) {

            if (acbComplaintIdValue.get(i).getText().equals(acbComplaintId)) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", allEditButtons.get(i));
                break;
            }
        }    }

    @When("^I confirm delete$")
    public void confirmDelete() {
        WebElement button = SurveillanceComplaintsPage.yesToConfirmDelete(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    @When("^I associate listing \"([^\"]*)\" to the complaint$")
    public void associateListingToComplaint(final String chplId) {
        WebElement inputText = SurveillanceComplaintsPage.certifiedProductField(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", inputText);
        SurveillanceComplaintsPage.certifiedProductField(getDriver()).sendKeys(chplId);
        SurveillanceComplaintsPage.certifiedProductField(getDriver()).sendKeys(Keys.ENTER);
    }

    @When("^I associate surveillance \"([^\"]*)\" to the complaint$")
    public void associateSurveillanceToComplaint(final String survId) {
        WebElement selectBox = SurveillanceComplaintsPage.surveillanceField(getDriver());
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText(survId);
    }

    @When("^I associate criteria \"([^\"]*)\" to the complaint$")
    public void associateriteriaToComplaint(final String criteria) {
        WebElement selectBox = SurveillanceComplaintsPage.criteriaField(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", selectBox);
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText(criteria);
    }

    @When("^I edit data in Closed Date field to \"([^\"]*)\"$")
    public void editDataInClosedDateField(final String closedDate) {
    	SurveillanceComplaintsPage.closedDate(getDriver()).sendKeys(closedDate);
    }
}
