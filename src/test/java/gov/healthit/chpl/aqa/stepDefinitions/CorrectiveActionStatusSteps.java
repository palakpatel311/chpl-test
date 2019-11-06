package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.CorrectiveActionStatusPage;

/**
 * Class CorrectiveActionStatusSteps definition.
 */
public class CorrectiveActionStatusSteps extends Base {

    @Given("^I am on Corrective Action Status page$")
    public void userLoadsCorrectiveActionStatusPage() {
        getDriver().get(getUrl() + "/#/collections/corrective-action");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(CorrectiveActionStatusPage.mainContent(getDriver())));
    }
}


