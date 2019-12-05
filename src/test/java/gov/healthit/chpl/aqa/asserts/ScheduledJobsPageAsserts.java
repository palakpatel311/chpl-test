package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ScheduledJobsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;

/**
 * Class ScheduledJobsPageAsserts definition.
 */
public class ScheduledJobsPageAsserts extends Base {
    private static final int JOBNAME_COL = 0;
    private static final int DESCRIPTION_COL = 1;
    private static final int ONCACBSPECIFIC_COL = 2;
    private static final int JOBTYPE_COL = 3;

    /**
     * Assert types of jobs listed in the scheduled jobs page.
     * @param jobNameValue is the expected job name
     * @param descriptionValue is the expected description
     * @param oncAcbSpecificValue is the expected OncAcbSpecific
     * @param jobTypeValue is the expected JobType
     */
    @When("^I see types of jobs with \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
    public void scheduledJobsList(final String jobNameValue, final String descriptionValue, final String oncAcbSpecificValue, final String jobTypeValue) {
        boolean jobFound = false;
        WebElement element = ScheduledJobsPage.typesOfSheduledJobs(getDriver());
        List<List<String>> actualValue = tableElements(element);
        for (List<String> rows : actualValue) {
            if (rows.get(JOBNAME_COL).contains(jobNameValue) && (rows.get(DESCRIPTION_COL).contains(descriptionValue))
                    && (rows.get(ONCACBSPECIFIC_COL).contains(oncAcbSpecificValue)) && (rows.get(JOBTYPE_COL).contains(jobTypeValue))) {
                jobFound = true;
            }
            if (jobFound) {
                break;
            }
        }
        assertTrue(jobFound, "Job not found in the types of jobs list");
    }

    private List<List<String>> tableElements(final WebElement row) {
        List<List<String>> rowValues = new ArrayList<List<String>>();
        List<WebElement> roWebElements = ScheduledJobsPage.getRowElements(row);
        for (WebElement col : roWebElements) {
            List<WebElement> colElts = ScheduledJobsPage.getColElements(col);
            List<String> columns = new ArrayList<>();
            for (WebElement column : colElts) {
                columns.add(column.getText());
            }
            rowValues.add(columns);
        }
        return rowValues;
    }
}
