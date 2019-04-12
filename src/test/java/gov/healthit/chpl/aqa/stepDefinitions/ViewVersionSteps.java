package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.ViewVersionPage;

/**
 * Class ViewVersionSteps definition.
 */
public class ViewVersionSteps extends Base {
    /**
     * Get user to the View Version Page.
     * @param productVersionNumber is used to navigate to the view version page of that product
     **/

    @Given("^I navigate to edit version page of listing \"(.*)\"$")
    public void editVersionPage(final String productVersionNumber) {
        getDriver().get(getUrl() + "#/organizations/developers/1816/products/1742/versions/" + productVersionNumber);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ViewVersionPage.viewVersionPageTitle(getDriver())));
    }

    /**
     * Edit the version of a product.
     * @param productVersionNumber is the product version number passed in page objects
     **/
    @And("^I edit the version of \"(.*)\"$")
    public void editVersion(final String productVersionNumber) {
        ViewVersionPage.editVersionLink(getDriver(), productVersionNumber).click();
        ViewVersionPage.editVersionField(getDriver()).clear();
        ViewVersionPage.editVersionField(getDriver()).sendKeys(getCurrentDate());
        ViewVersionPage.editVersionSaveButton(getDriver(), productVersionNumber).click();
    }
}

