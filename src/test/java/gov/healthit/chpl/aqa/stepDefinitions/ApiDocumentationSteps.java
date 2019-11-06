package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.ApiDocumentationPage;

/**
 * Class ApiDocumentationSteps definition.
 */
public class ApiDocumentationSteps extends Base {

    @Given("^I am on API Documetation page$")
    public void userLoadsAPIDocumentaitonPage() {
        getDriver().get(getUrl() + "/#/collections/api-documentation");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ApiDocumentationPage.mainContent(getDriver())));
    }
}


