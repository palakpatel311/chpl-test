package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ViewDeveloperPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ViewDeveloperPageAsserts definition.
 */
public class ViewDeveloperPageAsserts extends Base {

    /**
     * Assert that developer edit link exists on view developer page.
     * @param developerId is the developer id passed in page objects
     */
    @Then("^I see developer edit link for developer \"([^\"]*)\"$")
    public void iSeeDeveloperEditLink(final String developerId) {
        try {
            assertTrue(ViewDeveloperPage.editDeveloperLink(getDriver(), developerId).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Unable to find developer edit link");
        }
    }

    /**
     * Assert that developer split link exists on view developer page.
     * @param developerId is the developer id passed in page objects
     */
    @Then("^I see developer split link for developer \"([^\"]*)\"$")
    public void iSeeDeveloperSplitLink(final String developerId) {
        try {
            assertTrue(ViewDeveloperPage.splitDeveloperLink(getDriver(), developerId).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Unable to find developer split link");
        }
    }

    /**
     * Assert that developer merge link exists on view developer page.
     * @param developerId is the developer id passed in page objects
     */
    @Then("^I see developer merge link for developer \"([^\"]*)\"$")
    public void iSeeDeveloperMergeLink(final String developerId) {
        try {
            assertTrue(ViewDeveloperPage.mergeDeveloperLink(getDriver(), developerId).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Unable to find developer merge link");
        }
    }

    /**
     * Assert that developer name is correct.
     */
    @Then("^I see the edited developer information is recorded and updated on View Developer page$")
    public void editedDeveloperInformationRecordedAndUpdated() {
        String actualDeveloperName = ViewDeveloperPage.viewDeveloperName(getDriver()).getText();
        assertEquals((actualDeveloperName.split(" ")[0]).trim(), getCurrentDate());
    }

    /**
     * Assert that "Field is required" error message is displayed for Developer Name.
     * @param expectedErrorMessage is the expected error message
     */
    @Then("^I see \"(.*)\" error message for developer name field$")
    public void iSeeFieldIsRequiredErrorForDeveloperName(final String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ViewDeveloperPage.developerNameMissingErrorMessage(getDriver())));
        String actualErrorMessage = ViewDeveloperPage.developerNameMissingErrorMessage(getDriver()).getText();
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    /**
     * Assert that "Field is required" error message is displayed for Developer Name.
     * @param expectedErrorMessage is the expected error message
     */
    @Then("^I see \"(.*)\" error message for email field$")
    public void iSeeFieldIsRequiredErrorForEmail(final String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ViewDeveloperPage.emailMissingErrorMessage(getDriver())));
        String actualErrorMessage = ViewDeveloperPage.emailMissingErrorMessage(getDriver()).getText();
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    /**
     * Assert that expected text is displayed in developers to merge section.
     * @param expectedText is "At least one other Developer must be selected to merge"
     */
    @Then("^I see \"([^\"]*)\" in developers to merge section$")
    public void iSeeMessageInDevelopersToMergeSection(final String expectedText) {
        String actualText = ViewDeveloperPage.developerToMergeMessage(getDriver()).getText();
        assertEquals(expectedText, actualText);
    }

    /**
     * Assert that expected text is displayed in Products moving to new Developer section.
     * @param expectedText is "At least one Product must be selected to move"
     */
    @Then("^I see \"([^\"]*)\" in products moving to new developer section$")
    public void iSeeMessageInProductsMovingToNewDeveloperSection(final String expectedText) {
        String actualText = ViewDeveloperPage.productsMovingToNewDeveloperMessage(getDriver()).getText();
        assertEquals(actualText, expectedText);
    }

}

