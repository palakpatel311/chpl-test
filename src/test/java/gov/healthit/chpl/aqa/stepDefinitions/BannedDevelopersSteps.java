package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.BannedDevelopersPage;

/**
 * Class BannedDevelopersSteps definition.
 */
public class BannedDevelopersSteps extends Base {

    @Given("^I am on Banned Developers page$")
    public void userLoadsBannedDeveloperPage() {
        getDriver().get(getUrl() + "/#/collections/developers");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(BannedDevelopersPage.mainContent(getDriver())));
    }
}


