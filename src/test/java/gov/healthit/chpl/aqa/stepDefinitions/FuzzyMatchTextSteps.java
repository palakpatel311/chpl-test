package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class FuzzyMatchTextSteps definition.
 */
public class FuzzyMatchTextSteps {

    private WebDriver driver;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public FuzzyMatchTextSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Open the details for designated certification criteria.
     * @param number criteria to open
     */
    @When("^I open details for criteria \"([^\"]*)\"$")
    public void iOpenDetailsForACriteria(final String number) {
        WebElement link = ListingDetailsPage.certificationCriteriaDetailsLink(driver, number);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /**
     * Open the SED panel.
     */
    @When("^I look at SED details$")
    public void iLookAtSEDDetails() {
        WebElement link = ListingDetailsPage.sedAccordion(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /**
     * Assert that the QMS Standard section has the passed in value.
     * @param qmsText expected text
     */
    @Then("^QMS Standard should display \"([^\"]*)\"$")
    public void qmsStandardDisplaysCorrectText(final String qmsText) {
        String actualString = ListingDetailsPage.qmsStandardText(driver).getText();
        assertTrue(actualString.contains(qmsText), "Expect " + qmsText + " to be found in " + actualString);
    }

    /**
     * Assert that the Accessibility Standard equals the passed in value.
     * @param accessibilityText expected text
     */
    @Then("^Accessibility Standard should display \"([^\"]*)\"$")
    public void accessibilityStandardShouldDisplayUpdatedOtherWCAG(final String accessibilityText) {
        String actualString = ListingDetailsPage.accessibilityStandardText(driver).getText();
        assertEquals(actualString, accessibilityText);
    }
    /**
     * Assert that the UCD Process equals the passed in value.
     * @param ucdText expected text
     */
    @Then("^UCD process should display \"([^\"]*)\"$")
    public void ucdProcessShouldDisplayUpdatedUcdText(final String ucdText) {
        String actualString = ListingDetailsPage.ucdProcessText(driver).getText();
        assertEquals(actualString, ucdText);
    }
}
