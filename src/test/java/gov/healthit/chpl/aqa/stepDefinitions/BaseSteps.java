package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.BasePage;
/**
 * Class BaseSteps definition.
 */
public class BaseSteps extends Base {
    /**
     * Click CHPL Resources Top Navigation.
     */
    @When("^I click CHPL Resources Top Navigation Link$")
    public void iclickCHPLResourcesTopNavigationLink() {
        WebDriver driver =  getDriver();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(BasePage.chplResourcesDropdown(driver))).click();
    }
}
