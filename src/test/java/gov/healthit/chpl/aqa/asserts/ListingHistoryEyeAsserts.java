package gov.healthit.chpl.aqa.asserts;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ListingHistoryEyePage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ListingHistoryEyeAsserts definition.
 */
public class ListingHistoryEyeAsserts extends Base {

    private static final int TIME_DURATION = 60000;

    /**
     * Assert that expected Developer/Product/Version edit details is displayed on listing history eye.
     * @param expectedEditDetails is "Developer/Product/Version change"
     * @throws Exception of type ParseException or InterruptedException
     */
    @Then("^I see the listing history eye shows a \"([^\"]*)\" on today's date$")
    public void iSeeListingHistory(final String expectedEditDetails) throws Exception {
        Thread.sleep(SLEEP_TIME);
        String actualListingHistoryDetails = ListingHistoryEyePage.listingHistoryTable(getDriver()).getText();
        String[] listingHistoryDetails = actualListingHistoryDetails.split("\n");
        int activityCount = 0;
        List<String> activityDateList = new ArrayList<>();
        String date = null;
        for (String histDetails : listingHistoryDetails) {
            if ((activityCount % 2) == 0) {
                date = histDetails;
            } else {
                if (histDetails.startsWith(expectedEditDetails)) {
                    activityDateList.add(date);
                }
            }
            activityCount++;
        }
        String latestDate = activityDateList.get(0);
        for (String activityDate : activityDateList) {
            long time = getFormatedDateTimeZone(activityDate).getTime();
            if (time > getFormatedDateTimeZone(latestDate).getTime()) {
                latestDate = activityDate;
            }
        }
        if (latestDate == null) {
            fail("No edit activity recorded for today");
        }
        Date actualDate = getFormatedDateTimeZone(latestDate);
        Date currentDate = new Date();
        assertTrue(((currentDate.getTime() - actualDate.getTime()) < TIME_DURATION),
                "Listing history is missing for today's date");
    }

}

