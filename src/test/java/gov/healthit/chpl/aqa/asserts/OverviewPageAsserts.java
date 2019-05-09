package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.OverviewPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class OverviewPageAsserts definition.
 */
public class OverviewPageAsserts extends Base {
    /**
     * Assert that page title is correct.
     * @param title expected page title
     */
    @Then("^Overview page title should be \"([^\"]*)\"$")
    public void overviewPageTitleShouldBe(final String title) {
        assertEquals(OverviewPage.title(getDriver()).getText(), title);
    }

    /**
     * Assert that combination of body/name is found the the table somewhere.
     * @param body expected ONC body
     * @param name expected ONC body's name
     */
    @Then("^ONC-ACB and ONC-ATL information table shows \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theTableShowsDataFromDatabase(final String body, final String name)  {
        boolean isFound = false;

        WebElement table = OverviewPage.acbAtlTable(getDriver());
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

    /**
     * Assert that updated content is found in the webpage.
     * @param expectedText is the expected text
     */
    @Then("^the \"([^\"]+)\" shows as expected$")
    public void updatedContentShowsAsExpected(final String expectedText) {
        String actualText = OverviewPage.pageContent(getDriver()).getText();
        assertTrue(actualText.contains(expectedText), " not found on Overview page : " + actualText);
    }

    /**
     * Verify that link points to correct URL.
     * @param url is URL tied to link text
     * @param linkText text of link
     * @headerNumber is header locator
     */
    @Then("^the link should point to correct url \"([^\"]*)\" for respective section of \"([^\"]*)\" and header \"([^\"]*)\" on the page$")
    public void urlForNavLinksOnOverviewPage(final String url, final String linkText, final String headerNumber) {
      String currentURL = getDriver().getCurrentUrl();
      assertEquals(currentURL, url);
      getDriver().getPageSource().contains(linkText);
      assertTrue(OverviewPage.headerText(getDriver(), headerNumber).isDisplayed());
    }

    /**
     * Asserts that headings are in the correct order on overview page.
     */
    @Then("^I should see the sections in the following order: Announcement, What is the CHPL, Recommended Web Browsers, "
            + "Using the CHPL Website, ONC Certification Program, For EHR Developers, ONC-ACB and ONC-ATL Information$")
    public void verifySectionOrder() {
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(2)")).getText().contains("What is the CHPL?"));
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > span.ng-scope > h2")).getText().contains("Recommended Web Browsers"));
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(9)")).getText().contains("Using the CHPL Website"));
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(25)")).getText().contains("ONC Certification Program"));
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(38)")).getText().contains("For EHR Developers"));
        assertTrue(getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(43)")).getText().contains("ONC-ACB and ONC-ATL Information"));

        Point locWhatIsCHPLHeading = getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(2)")).getLocation();
        int whatIsCHPLLeftX = locWhatIsCHPLHeading.getX();
        int whatIsCHPLTopY = locWhatIsCHPLHeading.getY();

        Point locRecBrowserHeading = getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > span.ng-scope > h2")).getLocation();
        int recBrowserLeftX = locRecBrowserHeading.getX();
        int recBrowserTopY = locRecBrowserHeading.getY();

        Point locUsingTheCHPLHeading = getDriver().findElement(By.cssSelector("#main-content > div.col-md-8 > h2:nth-child(9)")).getLocation();
        int usingTheCHPLLeftX = locUsingTheCHPLHeading.getX();
        int usingTheCHPLTopY = locUsingTheCHPLHeading.getY();

        final boolean headingOrder = (whatIsCHPLLeftX <= recBrowserLeftX) && (whatIsCHPLTopY < recBrowserTopY)
                                     && (usingTheCHPLLeftX >= recBrowserLeftX) && (usingTheCHPLTopY > recBrowserTopY);
        assertTrue(headingOrder);
    }

    @Then("^the link should point to correct url \"([^\"]*)\"$")
    public void urlForNavLinksOnOverviewPage(final String url) {
        String currentURL = getDriver().getCurrentUrl();
        assertEquals(currentURL, url);
    }
}
