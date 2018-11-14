package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.OverviewPage;

/**
 * Class OverviewSteps definition.
 */
public class OverviewSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public OverviewSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
       }
    }

    /**
     * Get user to the Overview page.
     */
    @Given("^User is on Overview page$")
    public void userLoadsOverviewPage() {
        driver.get(url + "#/resources/overview");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(OverviewPage.mainContent(driver)));
    }

    /**
     * Assert that page title is correct.
     * @param title expected page title
     */
    @Then("^Overview page title should be \"([^\"]*)\"$")
    public void overviewPageTitleShouldBe(final String title) {
        assertEquals(OverviewPage.title(driver).getText(), title);
    }

    /**
     * Assert that combination of body/name is found the the table somewhere.
     * @param body expected ONC body
     * @param name expected ONC body's name
     */
    @Then("^ONC-ACB and ONC-ATL information table shows \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theTableShowsDataFromDatabase(final String body, final String name)  {
        boolean isFound = false;

        WebElement table = OverviewPage.acbAtlTable(driver);
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(0).getText().equals(body) && cols.get(1).getText().equals(name)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "Body: " + body + " / Name: " + name + " not found");
    }
}
