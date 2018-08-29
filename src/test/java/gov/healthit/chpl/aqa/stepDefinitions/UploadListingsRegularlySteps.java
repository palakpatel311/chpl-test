package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.DpManagementPage;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;

/**
 * Class UploadListingsRegularlySteps definition.
 */

public class UploadListingsRegularlySteps {
    private WebDriver driver;
    private String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");
    private static final int TIMEOUT = 30;
    private static final int LONG_TIMEOUT = 90;
    private static final DateFormat DATEFORMAT = new SimpleDateFormat("MMdd");
    private static final DateFormat DATEFORMATV = new SimpleDateFormat("dd");

    /**
     * Constructor creates new driver.
     */
    public UploadListingsRegularlySteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
        if (StringUtils.isEmpty(filePath)) {
            String tempDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
            filePath = tempDirectory;
        }
    }

    /**
     * Navigate to Upload Certified Products page.
     */
    @And("^I am on Upload Certified Products page$")
    public void iAmOnUploadCertifiedProductsPage() {
        DpManagementPage.dpManagementLink(driver).click();
    }

    /**
     * Upload a listing.
     * @param edition is listing edition
     */
    @When("^I upload a \"([^\"]*)\" listing$")
    public void iUploadAlisting(final String edition) {
        DpManagementPage.chooseFileButton(driver).sendKeys(filePath + File.separator + edition + "_Test_SLI.csv");
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

    /**
     * Navigate to Confirm Pending Products page.
     */
    @When("^I go to Confirm Pending Products Page$")
    public void loadConfirmPendingProductsPage() {
        DpManagementPage.confirmPendingProductsLink(driver).click();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DpManagementPage.pendingListingsTable(driver)));
    }

    /**
     * Confirm uploaded listing.
     * @param edition is listing edition
     * @param testChplId is chpl id of listing to confirm
     * @throws Exception if there is an exception
     */
    @And("^I confirm \"([^\"]*)\" listing with CHPL ID \"([^\"]*)\"$")
    public void confirmUploadedListing(final String edition, final String testChplId) throws Exception {
       JavascriptExecutor executor = (JavascriptExecutor) driver;
       executor.executeScript("arguments[0].click()", DpManagementPage.inspectButtonForUploadedListing(driver, testChplId));

        System.out.println("Opened inspect");
        try {
        DpManagementPage.nextOnInspectButton(driver).click();

        if (DpManagementPage.isProductNewDivElementPresent(driver)) {
            DpManagementPage.createNewProductOptionOnInspect(driver).click();
        }
        DpManagementPage.nextOnInspectButton(driver).click();

        if (DpManagementPage.isVersionNewDivElementPresent(driver)) {
            DpManagementPage.createNewVersionOptionOnInspect(driver).click();
        }
        DpManagementPage.nextOnInspectButton(driver).click();
        System.out.println("Into Listing");

        DpManagementPage.editOnInspectButton(driver).click();

        Date date = new Date();
        String newpId = DATEFORMAT.format(date);
        DpManagementPage.productIdOnInspect(driver).clear();
        DpManagementPage.productIdOnInspect(driver).sendKeys(newpId);

        Date dateV = new Date();
        String newV = DATEFORMATV.format(dateV);
        DpManagementPage.productVersionOnInspect(driver).clear();
        DpManagementPage.productVersionOnInspect(driver).sendKeys(newV);

        DpManagementPage.saveCpOnInspect(driver).click();
        System.out.println("Done editing");

        DpManagementPage.confirmButtonOnInspect(driver).click();

        WebElement button = DpManagementPage.yesOnConfirm(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        System.out.println("Confirmed");

        WebDriverWait wait = new WebDriverWait(driver, LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(DpManagementPage.updateSuccessfulToastContainer(driver)));
        } catch (Exception e) {
            takeScreenshot();
        }
    }

    /**
     * Take a screenshot.
     * @throws Exception if there is an exception
     */
    public void takeScreenshot() throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath + File.separator + "failed-test.png"));
    }

    /**
     * Load listing details to verify listing was uploaded successfully.
     * @param ed - edition digits in CHPL ID
     */
    @Then("^I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded \"([^\"]*)\" listing$")
    public void verifyUploadWasSuccessful(final String ed) {
        driver.navigate().refresh();

        Date date = new Date();
        String confListingId = ed.substring(2) + ".05.05.1447." + DATEFORMAT.format(date) + "." + DATEFORMATV.format(date) + ".00.1.180707";

        driver.get(url + "/#/product/" + confListingId);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ListingDetailsPage.mainContent(driver)));
        String testListingName = "New product";
        String actualString = ListingDetailsPage.listingName(driver).getText();
        assertEquals(actualString, testListingName);
    }
}
