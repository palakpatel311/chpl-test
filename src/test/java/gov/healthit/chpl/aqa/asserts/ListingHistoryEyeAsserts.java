package gov.healthit.chpl.aqa.asserts;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.model.ListingHistoryData;
import gov.healthit.chpl.aqa.pageObjects.ListingHistoryEyePage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ListingHistoryEyeAsserts definition.
 */
public class ListingHistoryEyeAsserts extends Base {

    /**
     * Assert that expected product edit details is displayed on product history eye.
     * @param expectedEditDetails is "Developer/Product/Version change"
     * @throws Exception of type ParseException or InterruptedException
     */
    @Then("^I see the listing history eye shows a \"([^\"]*)\" on today's date$")
    public void iSeeListingHistory(final String expectedEditDetails) throws Exception {
        Thread.sleep(SLEEP_TIME);
        String actualListingHistoryDetails = ListingHistoryEyePage.listingHistoryTable(getDriver()).getText();
        String[] listingHistoryDetails = actualListingHistoryDetails.split("\n");
        int activityCount = 0;
        ListingHistoryData listingHistoryDataInst = null;
        String date = null;
        for (String activity : listingHistoryDetails) {
            if ((activityCount % 2) == 0) {
                date = activity;
            } else {
                if (activity.startsWith(expectedEditDetails)) {
                    listingHistoryDataInst = new ListingHistoryData();
                    listingHistoryDataInst.setDate(date);
                    listingHistoryDataInst.setActivity(activity);
                    break;
                }
            }
            activityCount++;
        }
        if (listingHistoryDataInst == null) {
            assertFalse("No edit activity recorded for today", true);
        }
        Calendar calInstanceExpectedDate = Calendar.getInstance();
        Calendar calInstanceCurrentDate = Calendar.getInstance();
        Date actualDate = getFormatedDateTimeZone(listingHistoryDataInst.getDate());
        Date currentDate = getFormatedDateTimeZone(null);
        calInstanceExpectedDate.setTime(actualDate);
        calInstanceCurrentDate.setTime(currentDate);
        boolean listingHistoryRecorded = false;
        if ((calInstanceExpectedDate.get(Calendar.YEAR) == calInstanceCurrentDate.get(Calendar.YEAR))
                && ((calInstanceExpectedDate.get(Calendar.MONTH) + 1) == (calInstanceCurrentDate.get(Calendar.MONTH) + 1))
                && (calInstanceExpectedDate.get(Calendar.DAY_OF_MONTH) == calInstanceCurrentDate.get(Calendar.DAY_OF_MONTH))) {
            listingHistoryRecorded = true;
        }
        assertTrue(listingHistoryRecorded, "Listing history is missing for today's date");
    }

}

