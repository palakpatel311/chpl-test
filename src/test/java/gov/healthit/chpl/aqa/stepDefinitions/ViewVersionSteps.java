package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.Keys;
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
     * @param versionId is used to navigate to the view version page of that product
     * @param developerId is Developer ID
     * @param productId is Product ID
     **/

    @Given("^I navigate to the version edit page for version \"([^\"]*)\" of product \"([^\"]*)\" of developer \"([^\"]*)\"$")
    public void editVersionPage(final String versionId, final String productId, final String developerId) {
        getDriver().get(getUrl() + "#/organizations/developers/" + developerId + "/products/" + productId + "/versions/" + versionId);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ViewVersionPage.viewVersionPageTitle(getDriver())));
    }

    /**
     * Edit the version of a product.
     * @param versionId is the product version id passed in page objects
     **/
    @And("^I edit for version \"(.*)\"$")
    public void editVersion(final String versionId) {
        ViewVersionPage.editVersionLink(getDriver(), versionId).click();
        ViewVersionPage.editVersionField(getDriver()).clear();
        ViewVersionPage.editVersionField(getDriver()).sendKeys(getCurrentDate());
        getWait().until(ExpectedConditions.elementToBeClickable(ViewVersionPage.editVersionSaveButton(getDriver(), versionId)));
        ViewVersionPage.editVersionSaveButton(getDriver(), versionId).click();
        getWait().until(ExpectedConditions.visibilityOf(ViewVersionPage.lastModifiedDateOnVersionEdit(getDriver(), versionId)));
        getWait().until(ExpectedConditions.visibilityOf(ViewVersionPage.viewSavedVersion(getDriver(), versionId)));
    }

    /**
     * Click merge version link of a product.
     * @param versionId is the product version id passed in page objects
     **/
    @And("^I click the merge version link for version \"([^\"]*)\"$")
    public void iClickMergeVersionLink(final String versionId) {
        ViewVersionPage.mergeVersionLink(getDriver(), versionId).click();
    }

    /**
     * Clear version field.
     * @param value to be entered
     **/
    @And("^I set the version field to \"([^\"]*)\"$")
    public void setVersionField(final String value) {
        ViewVersionPage.editVersionField(getDriver()).clear();
        ViewVersionPage.editVersionField(getDriver()).sendKeys(value);
        ViewVersionPage.editVersionField(getDriver()).sendKeys(Keys.TAB);
    }

    /**
     * Click Split link of a version.
     * @param versionId is the version id passed in page objects
     **/
    @And("^I click the split version link for version \"(.*)\"$")
    public void clickSplitVersionLink(final String versionId) {
        ViewVersionPage.splitVersionLink(getDriver(), versionId).click();
    }
}
