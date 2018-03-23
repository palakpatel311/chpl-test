package gov.healthit.chpl.aqa.stepDefinitions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.CollectionsPages;

/**
 * Class CollectionsPagesSteps definition.
 */
public class CollectionsPagesSteps {
    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public CollectionsPagesSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }
    }
    /**
     * Open ACB filter options.
     */
    @When("^I look at ACB filter options$")
    public void openAcbFilterOptions() {
        WebElement button = CollectionsPages.acbFilterButton(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    /**
     * Loads collections pages.
     * @param ptitle to get the actual title of the page
     * @param pname to get page name in url
     */
    @Given("^I am on \"([^\"]*)\" collections page: \"([^\"]*)\"$")
    public void loadCollectionsPage(final String ptitle, final String pname) {
      driver.get(url + "#/collections/" + pname);
      WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
      wait.until(ExpectedConditions.visibilityOf(CollectionsPages.mainContent(driver)));
    }

}
