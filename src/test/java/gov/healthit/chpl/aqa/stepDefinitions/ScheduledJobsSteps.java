package gov.healthit.chpl.aqa.stepDefinitions;

import cucumber.api.java.en.Given;

/**
 * Class ScheduledJobsSteps definition.
 */
public class ScheduledJobsSteps extends Base {

    @Given("^I'm on Scheduled Jobs page$")
    public void scheduledJobsPage() {
        getDriver().get(getUrl() + "#/administration/jobs/scheduled");
    }
}
