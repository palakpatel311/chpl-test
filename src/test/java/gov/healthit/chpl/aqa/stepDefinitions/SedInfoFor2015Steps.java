package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.SedInfoFor2015Page;

/**
 * Class SedInfoFor2015Steps definition.
 */
public class SedInfoFor2015Steps extends Base {

    @Given("^I am on SED Info for 2015 Products page$")
    public void userLoadsSedInfoFor2015Page() {
        getDriver().get(getUrl() + "/#/collections/sed");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(SedInfoFor2015Page.mainContent(getDriver())));
    }
}


