package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.DecertifiedProductsPage;
/**
 * Class DecertifiedProductsSteps definition.
 */
public class DecertifiedProductsSteps extends Base {

    @Given("^I am on Decertified Products page$")
    public void userLoadsDecertifiedProductsPage() {
        getDriver().get(getUrl() + "/#/collections/products");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DecertifiedProductsPage.mainContent(getDriver())));
    }
}

