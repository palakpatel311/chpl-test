package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPISteps definition.
 */
public class ChplAPISteps extends Base {
    /**
     * Click all the controller elements link.
     * @param controllerName as the name of Controller
     */
    @When("^I click on \"([^\"]*)\" link$")
    public void iClickOnLink(final String controllerName) {
        WebElement link = ChplAPIPage.controllerLink(getDriver(), controllerName);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }
}
