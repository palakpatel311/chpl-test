package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.CollectionsPages;

/**
 * Class CollectionsPagesSteps definition.
 */
public class CollectionsPagesSteps extends Base {
    /**
     * Open ACB filter options.
     */
    @When("^I look at ACB filter options$")
    public void openAcbFilterOptions() {
        WebElement button = CollectionsPages.acbFilterButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", button);
    }

    /**
     * Loads collections pages.
     * @param ptitle to get the actual title of the page
     * @param pname to get page name in url
     */
    @Given("^I am on \"([^\"]*)\" collections page: \"([^\"]*)\"$")
    public void loadCollectionsPage(final String ptitle, final String pname) {
        getDriver().get(getUrl() + "#/collections/" + pname);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(CollectionsPages.mainContent(getDriver())));
    }

    /**
     * Loads collections pages.
     * @param pname to get page name in url
     * @param tEnv test environment in which tests will be run
     */
    @Given("^I am on collections page: \"([^\"]*)\" on \"([^\"]*)\"$")
    public void loadCollectionPage(final String pname, final String tEnv) {
        getDriver().get(getEnvUrl(tEnv) + "#/collections/" + pname);
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(CollectionsPages.mainContent(getDriver())));
    }

    /**
     * Assert updated CMS FAQ link is as expected.
     * @param cmsfaqLink link to FAQs on cms.gov site
     */
    @Then("^the CMS FAQ link should point to updated link: \"([^\"]*)\"$")
    public void verifyCMSFAQLink(final String cmsfaqLink) {
        String link = CollectionsPages.cmsFaqLink(getDriver()).getAttribute("href");
        assertTrue(link.contains(cmsfaqLink), "Expect " + cmsfaqLink + " to be found in " + link);
    }

    /**
     * Download SED Details.csv file.
     * @param fileName expected file name
     * @throws FileNotFoundException if the SED Details File not found
     */
    @When("^I download the \"([^\"]*)\" file$")
    public void downloadSEDDetailsFile(final String fileName) throws FileNotFoundException {
        WebElement link = CollectionsPages.sedDetailsFileButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
        super.checkIfFileIsDownloaded(fileName);
    }
}

