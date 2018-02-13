package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class FuzzyMatchTextSteps definition.
 */
public class FuzzyMatchTextSteps {

    private WebDriver driver;
    private static final int DELAY = 20;
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

    @Given("^I am on listing details page \"([^\"]*)\"$")
    public void iAmOnListingDetailsPage(final String arg1) throws Throwable {
        driver.get(url + "#/product/" + arg1);
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        Assert.assertTrue(driver.getTitle().contains("CHPL Product Details"));
    }

    @When("^I look at criteria details for criteria g4$")
    public void iLookAtCriteriaDetailsG4() throws Throwable {
        ListingDetailsPage.certificationCriteriaG4ViewDetails(driver).click();
    }

    @Then("^QMS Standard should display updated '21 CFR 820' text$")
    public void qmsStandardDisplaysCorrectText() throws Throwable {
        String actualString = ListingDetailsPage.qmsStandardText(driver).getText();
        assertTrue(actualString.contains("21 CFR Part 820"));
    }

    @When("^I look at criteria details for criteria g5$")
    public void iLookAtCriteriaDetailsForCriteriaG5() throws Throwable {
        Actions action = new Actions(driver);
        action.moveToElement(ListingDetailsPage.certificationCriteriaG5ViewDetails(driver)).click().perform();
    }

    @Then("^Accessibility Standard should display updated 'WCAG Level' text$")
    public void accessibilityStandardShouldDisplayUpdatedOtherWCAG() throws Throwable {
        String actualString = ListingDetailsPage.acceessibilityStandardText(driver).getText();
        assertTrue(actualString.contains("WCAG Level"));
    }

    @When("^I look at SED details$")
    public void iLookAtSEDDetails() throws Throwable {
        ListingDetailsPage.sedDetailsAccordionOpen(driver);
    }

    @Then("^UCD process should display updated 'IS0 9001' text$")
    public void ucdProcessShouldDisplayUpdatedNISTIRText() throws Throwable {
        String actualString = ListingDetailsPage.ucdProcessText(driver).getText();
        assertTrue(actualString.contains("IS0 9001"));
    }
        
    @Then("^UCD process should display updated 'NISTIR 7741' text$")
    public void ucdProcessShouldDisplaycleantext() throws Throwable {
    String actualString = ListingDetailsPage.ucdProcessText(driver).getText();
    assertTrue(actualString.contains("NISTIR 7741"));
    }
}
