package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.OncAcbManagementPage;

public class OncAcbManagementSteps extends Base {

    @And("^I navigate to ONC ACB Management page$")
    public void navigateToONCACBManagementPage() {
        getDriver().get(getUrl() + "#/organizations/onc-acbs");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(OncAcbManagementPage.oncACBManagementPageTitle(getDriver())));
    }

    @And("^I access \"([^\"]*)\" ACB details$")
    public void iClickOnONCACBName(final String acb) {
        OncAcbManagementPage.oncACBName(getDriver(), acb).click();
    }

    @And("^I open the ACB edit form$")
    public void editACB() {
        WebElement link = OncAcbManagementPage.editONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(OncAcbManagementPage.markRetirementStatus(getDriver())));
    }

    @When("^I mark it as retired on \"([^\"]*)\"$")
    public void markRetired(final String date) throws Throwable {
        Actions act = new Actions(getDriver());
        act.moveToElement(OncAcbManagementPage.markRetirementStatus(getDriver())).click().build().perform();
        OncAcbManagementPage.retirementDate(getDriver()).clear();
        OncAcbManagementPage.retirementDate(getDriver()).sendKeys(date);
        WebElement link = OncAcbManagementPage.saveONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    @When("^I unretire an existing retired ACB$")
    public void iUnretireExistingRetiredACB() {
        if (OncAcbManagementPage.markRetirementStatus(getDriver()).isSelected()) {
            OncAcbManagementPage.retirementDate(getDriver()).clear();
            Actions act = new Actions(getDriver());
            act.moveToElement(OncAcbManagementPage.markRetirementStatus(getDriver())).click().build().perform();
        }
        OncAcbManagementPage.addressFirstLine(getDriver()).clear();
        OncAcbManagementPage.addressFirstLine(getDriver()).sendKeys("Test");
        OncAcbManagementPage.addressCity(getDriver()).clear();
        OncAcbManagementPage.addressCity(getDriver()).sendKeys("Test");
        OncAcbManagementPage.addressState(getDriver()).clear();
        OncAcbManagementPage.addressState(getDriver()).sendKeys("Test");
        OncAcbManagementPage.addressZipCode(getDriver()).clear();
        OncAcbManagementPage.addressZipCode(getDriver()).sendKeys("111");
        OncAcbManagementPage.addressCountry(getDriver()).clear();
        OncAcbManagementPage.addressCountry(getDriver()).sendKeys("Test");
        WebElement link = OncAcbManagementPage.saveONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    @When("^I edit ACB name to be \"([^\"]*)\" and edit it back to \"([^\"]*)\"$")
    public void editAcbName(final String newName, final String oldName) {
        OncAcbManagementPage.oncACBNameOnEditForm(getDriver()).clear();
        OncAcbManagementPage.oncACBNameOnEditForm(getDriver()).sendKeys(newName);
        WebElement savebutton = OncAcbManagementPage.saveONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", savebutton);
        WebElement editbutton = OncAcbManagementPage.editONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", editbutton);
        OncAcbManagementPage.oncACBNameOnEditForm(getDriver()).clear();
        OncAcbManagementPage.oncACBNameOnEditForm(getDriver()).sendKeys(oldName);
        savebutton = OncAcbManagementPage.saveONCACB(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", savebutton);
    }
}
