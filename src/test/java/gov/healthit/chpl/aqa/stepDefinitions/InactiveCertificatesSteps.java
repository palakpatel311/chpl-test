package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.InactiveCertificatesPage;

/**
 * Class InactiveCertificatesSteps definition.
 */
public class InactiveCertificatesSteps extends Base {

    @Given("^I am on Inactive Certificates page$")
    public void userLoadsInactiveCertificatesStepsPage() {
        getDriver().get(getUrl() + "/#/collections/inactive");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(InactiveCertificatesPage.mainContent(getDriver())));
    }
}


