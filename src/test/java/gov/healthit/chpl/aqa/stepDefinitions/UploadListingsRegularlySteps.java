package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;

/**
 * Class UploadListingsRegularlySteps definition.
 */

public class UploadListingsRegularlySteps {
    private WebDriver driver;
    private String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");

    /**
     * Constructor creates new driver.
     */
    public UploadListingsRegularlySteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
       }
        if (StringUtils.isEmpty(filePath)) {
            String tempDirectory = System.getProperty("user.dir") + File.separator + "target" + File.separator + "upload-files";
            filePath = tempDirectory;
       }
    }

    /**
     * Get user to upload certified products page.
     */
    @And("^I am on Upload Certified Products page$")
    public void iAmOnUploadCertifiedProductsPage() {
        DpManagementPage.dpManagementLink(driver).click();
    }

    /**
     * Upload a 2014 listing.
     */
    @When("^I upload a 2014 listing$")
    public void listingUpload2014() {
        DpManagementPage.chooseFileButton(driver).sendKeys(filePath + File.separator + "2014_V11_hasGAP.csv");
        DpManagementPage.uploadFileButton(driver).click();
    }

    /**
     * Upload a 2015 listing.
     */
    @When("^I upload a 2015 listing$")
    public void listingUpload2015() {
        DpManagementPage.chooseFileButton(driver).sendKeys(filePath + File.separator + "2015_v12_Test.csv");
        DpManagementPage.uploadFileButton(driver).click();
    }

    /**
     * Assert upload success message.
     */
    @Then("^I see upload successful message$")
    public void uploadSuccessText() {
        String successText = DpManagementPage.uploadSuccessfulText(driver).getText();
        assertTrue(successText.contains("was uploaded successfully"));
    }
}
