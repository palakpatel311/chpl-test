package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.SurveillanceReportPage;

/**
 * Class SurveillanceSteps definition.
 */
public class SurveillanceReportSteps extends Base {

    /**
     * Get user to the Surveillance Reports Page.
     **/
    @Given("^I navigate to the surveillance reports page$")
    public void editDeveloperPage() {
        getDriver().get(getUrl() + "#/surveillance/reporting");
    }

    /**
     * Expand ACBs.
     * @param acb - Drummond Group, ICSA Labs, SLI Compliance & UL LLC
     **/
    @And("I expand \"([^\"]*)\"$")
    public void iExpandACB(final String acb) {
        WebElement link = SurveillanceReportPage.oncAcbs(getDriver(), acb);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        SurveillanceReportPage.oncAcbs(getDriver(), acb).click();
    }

    /**
     * Initiate a quarterly surveillance report.
     * @param acbNameYearQuarter is the name of ACB, Year and Quarter for which a quarterly surveillance report will be initiated
     **/
    @And("I initate a quarterly surveillance report for \"([^\"]*)\"$")
    public void iInitiateQuarterlySurveillanceReportForACB(final String acbNameYearQuarter) {
        SurveillanceReportPage.initiateSurveillanceReport(getDriver(), acbNameYearQuarter).click();
    }

    /**
     * Click yes to confirm initiating a quarterly surveillance report.
     **/
    @When("^I confirm initiaing a quarterly surveillance report$")
    public void confirmInitiatingQuarterlySurveillanceReport() {
        WebElement button = SurveillanceReportPage.yesToConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    /**
     * Click yes to confirm deleting a quarterly surveillance report.
     **/
    @When("^I confirm deleting a quarterly surveillance report$")
    public void confirmDeletingQuarterlySurveillanceReport() {
        WebElement link = SurveillanceReportPage.yesToConfirm(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        SurveillanceReportPage.yesToConfirm(getDriver()).click();
    }

    /**
     * Click delete button to delete a quarterly surveillance report.
     **/
    @And("I delete the quarterly surveillance report$")
    public void iDeleteQuarterlySurveillanceReport() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", SurveillanceReportPage.transparencyDisclosureField(getDriver()));
        SurveillanceReportPage.deleteReportButton(getDriver()).click();
    }

    /**
     * Clear the "Surveillance Activities/Reactive Summary/Prioritized Elements/Transparency Disclosure" field and enter a value.
     * @param value to be entered
     * @param inputId is the id of the field in the Quarterly Report section
     **/
    @And("I set \"([^\"]*)\" field to \"([^\"]*)\"$")
    public void setQuarterlySurveillanceReportField(final String inputId, final String value) {
        SurveillanceReportPage.quarterlyReportFieldInput(getDriver(), inputId).clear();
        SurveillanceReportPage.quarterlyReportFieldInput(getDriver(), inputId).sendKeys(value);
        SurveillanceReportPage.quarterlyReportFieldInput(getDriver(), inputId).sendKeys(Keys.TAB);
    }

    /**
     * Click save button to save the quarterly surveillance report.
     **/
    @And("I save the quarterly surveillance report$")
    public void isaveQuarterlySurveillanceReport() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", SurveillanceReportPage.transparencyDisclosureField(getDriver()));
        SurveillanceReportPage.saveQuarterlyReport(getDriver()).click();
    }

    /**
     * Edit a quarterly surveillance report.
     * @param acbNameYearQuarter is the name of ACB, Year and Quarter for which a quarterly surveillance report will be edited
     **/
    @And("I edit a quarterly surveillance report for \"([^\"]*)\"$")
    public void ieditQuarterlySurveillanceReport(final String acbNameYearQuarter) {
        SurveillanceReportPage.editSurveillanceReport(getDriver(), acbNameYearQuarter).click();
    }
}

