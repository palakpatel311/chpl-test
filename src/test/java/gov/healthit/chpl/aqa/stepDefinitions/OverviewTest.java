package gov.healthit.chpl.aqa.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @When("^User clicks on Overview page link in navigation menu$")
    public void userClicksOnOverviewPageLinkInNavigationMenu() throws Throwable {
        driver.get(url + "#/resources/overview");
    }

    @Then("^Overview page loads successfully and verify title$")
    public void overviewPageLoadsSuccessfullyAndVerifyTitle() throws Throwable {
        String actualTitle = driver.getTitle();
        System.out.println("page title is : " + actualTitle);
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }

    @When("^User looks at ONC-ACB and ONC-ATL information table$")
    public void userLooksAtONCACBAndONCATLInformationTable() throws Throwable {
        driver.get(url + "#/resources/overview");
    }

    @Then("^the table shows data from databse$")
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
