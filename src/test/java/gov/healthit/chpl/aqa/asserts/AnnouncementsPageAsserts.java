package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.AnnouncementsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class AnnouncementsPageAsserts definition.
 */
public class AnnouncementsPageAsserts extends Base {

    /**
     * Assert that Announcements is expected text.
     * @param expectedPageTitle is Announcements
     */
    @Then("^I see \"([^\"]*)\" as the page title for the Announcements management page$")
    public void iSeePageTitle(final String expectedPageTitle) {
        String actualPageTitle = AnnouncementsPage.annoouncementsPageTitle(getDriver()).getText();
        assertEquals(expectedPageTitle, actualPageTitle);
    }

    /**
     * Assert that columns are displayed in the Announcements Page.
     * @param expectedColumnNames are "Title, Announcement, StartDate & EndDate"
     **/
    @Then("^I see \"([^\"]*)\" columns in the Announcements page$")
    public void seeColumnsInAnnouncementsPage(final String expectedColumnNames) {
        String actualColumnNames = AnnouncementsPage.annoouncementsColumnName(getDriver()).getText();
        assertTrue(actualColumnNames.contains(expectedColumnNames));
    }

    /**
     * Assert that error message is displayed for Title/StartDate/EndDate.
     * @param expectedErrorMessage is Title/StartDate/EndDate is required
     */
    @Then("^I see \"(.*)\" error message$")
    public void iSeeErrorMessage(final String expectedErrorMessage) {
        String actualErrorMessage = AnnouncementsPage.errorMessage(getDriver(), expectedErrorMessage).getText();
        assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    /**
     * Assert that Announcement information is recorded on Announcements page.
     */
    @Then("^I see the Announcement information is saved and recorded on Announcements page$")
    public void announcementInfoRecordedOnAnnouncementsPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(AnnouncementsPage.savedAnnouncementInformatoin(getDriver())));
        String actualAnnouncementInformation = AnnouncementsPage.savedAnnouncementInformatoin(getDriver()).getText();
        assertTrue((actualAnnouncementInformation.contains(getCurrentDate())));
    }

    /**
     * Assert that Announcement information is correct in Announcements Reports.
     * @param announcementActivity is Created/Deleted announcement
     */
    @Then("^I see \"(.*)\" activity is recorded in Announcements Reports$")
    public void announcementInfoRecordedInAnnouncementsReports(final String announcementActivity) {
        String actualAnnouncementInformation = AnnouncementsPage.announcementReportDetails(getDriver()).getText();
        assertTrue(actualAnnouncementInformation.contains(announcementActivity + getCurrentDate()));

    }
}
