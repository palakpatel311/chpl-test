package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gov.healthit.chpl.aqa.pageObjects.ChplAPIPage;

/**
 * Class ChplAPISteps definition.
 */
public class ChplAPISteps extends Base {
    private static final String CORR_ACT_PLN_CTRL = "corrective-action-plan-controller";
    private static final String CORR_ACT_PLN = "corrective-action-plan";
    /**
     * Assert that link is correct.
     * @param urlLink expected as Link
     * @param text expected as Content
     */
    @Then("^Verify \"(.*)\" under Certified Health IT Product Listing is followed by \"(.*)\"$")
    public void verifyContentUnderCertifiedHealthITProductListingAndURL(final String text, final String urlLink) {
        WebDriver driver = getDriver();
        String actualText = ChplAPIPage.chplContentText(driver).getText();
        String actualURL = ChplAPIPage.healthITFeedBackFormURL(driver).getAttribute("href");
        assertEquals(actualText, text);
        assertEquals(actualURL, urlLink);
    }

    /**
     * Assert that title should be CHPL API.
     * @param title expected as CHPL API
     */
    @Then("^CHPL API page title should be \"([^\"]*)\"$")
    public void chplApiPageTitleShouldBe(final String title) {
        String chplAPITitle = getDriver().getTitle();
        Assert.assertEquals(chplAPITitle, title);
    }

    /**
     * Click all the controller elements link.
     * @param arg1 as controller elements
     */
    @When("^I click on \"([^\"]*)\" link$")
    public void iClickOnLink(final String arg1) {
        String xPath = "//*[text()='" + arg1 + "']";
        WebElement link = ChplAPIPage.controllerElementName(getDriver(), xPath);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", link);
    }

    /**
     * Assert that contents from webpage matches the contents of excel.
     * @param str as sheet name in the excel
     */
    @Then("^list of \"([^\"]*)\" operations should be displayed without deprecated calls$")
    public void listOfOperationsShouldBeDisplayed(final String str) {
        String sheetName = null;
        WebDriver driver = getDriver();
        // Get element from the webpage into the list
        List<WebElement> listWebElements = ChplAPIPage.controllerElementList(driver);
        if (str.equalsIgnoreCase(CORR_ACT_PLN_CTRL)) {
            sheetName = CORR_ACT_PLN;
        } else {
            sheetName = str;
        }
        ExcelUtil.setExcelFile(sheetName);
        // Creating the list to hold all the API listed on the webpage by swagger
        List<String> apiListFromPage = new ArrayList<>();
        // Get text of the Web Elements list
        for (WebElement wElement : listWebElements) {
            apiListFromPage.add(wElement.getText());
        }
        List<String> apiLstExl = new ArrayList<>();
        // Getting api list from the excel into the list
        apiLstExl = ExcelUtil.getAllCellData();
        // Checking if the api from the webpage present in the excel
        for (String api : apiListFromPage) {
            assertEquals(apiLstExl.contains(api), true);
        }
    }
}
