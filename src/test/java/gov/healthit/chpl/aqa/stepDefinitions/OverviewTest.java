package gov.healthit.chpl.aqa.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

/**
 * Class OverviewTest definition.
 */
public class OverviewTest {

    private WebDriver driver;
    private static final int DELAY = 60;
private String url = System.getProperty("url");
    
    /**
     * Constructor creates new driver.
     */

    public OverviewTest() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
       }
    }

    @When("^User is on Overview page$")
    public void userClicksOnOverviewPageLinkInNavigationMenu() throws Throwable {
        driver.get(url + "#/resources/overview");
    }

    @Then("^Overview page loads successfully and shows correct title$")
    public void overviewPageLoadsSuccessfullyAndVerifyTitle() throws Throwable {
        Assert.assertTrue(driver.getTitle().contains("CHPL Product Details"));
    }

    @Then("^ONC-ACB and ONC-ATL information table shows data from databse$")
    public void theTableShowsDataFromDatabse() throws Throwable {
        int numRows = 7;
        int numCols = 4;
        driver.get(url + "#/resources/overview");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);

        // Print and validate ACB  table data
        for (int numberOfRows = 1; numberOfRows <= numRows; numberOfRows++) {
            for (int numberOfCol = 1; numberOfCol <= numCols; numberOfCol++) {
                String sValue = driver.findElement(By.xpath("//*[@id='mainContent']/div[2]/table[2]/tbody/tr[" + numberOfRows + "]/td[" + numberOfCol + "]")).getText();
                System.out.println(sValue);
                driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
            }
        }
    }
}
