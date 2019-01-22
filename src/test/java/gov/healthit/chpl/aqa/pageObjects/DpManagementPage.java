package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class DpManagementPage definition.
 */
public final class DpManagementPage {

    private DpManagementPage() {}

    /**
     * Returns choose file button for new listing upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement chooseFileButton(final WebDriver driver) {
        return driver.findElement(By.id("listing-file-upload"));
    }

    /**
     * Returns choose file button for bulk surveillance upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement chooseFileForSurveillanceUploadButton(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-file-upload"));
    }

    /**
     * Get the CHPL Product Number value in surveillance search results.
     * @param driver WebDriver
     * @return the CHPL Product Number element
     */
    public static WebElement chplProductNumber(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"surveillance-search-single-result\"]/tbody/tr[1]/td"));
    }

    /**
     * Return the table containing surveillance details for a single Listing.
     * @param driver WebDriver
     * @return the table
     */
    public static WebElement surveillanceSearchSingleResultTable(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-search-single-result"));
    }
    /**
     * Returns Confirm Pending Products link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement confirmPendingProductsLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"admin-nav.dpManagement.confirm\"]/a"));
    }

    /**
     * Find inspect button for uploaded listing to confirm.
     * @param driver WebDriver
     * @param testChplId is chpl id of listing to confirm
     * @return the inspect button element
     */
    public static WebElement inspectButtonForUploadedListing(final WebDriver driver, final String testChplId) {
        return driver.findElement(By.id("pending-listing-inspect-" + testChplId));
    }

    /**
     * Label of the inspect modal dialog work flow.
     * @param driver WebDriver
     * @return the label element
     */
    public static WebElement inspectModalLabel(final WebDriver driver) {
        return driver.findElement(By.id("inspect-label"));
    }

    /**
     * Returns true iff "Developer New" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isDeveloperNewDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("developer-new")).size() > 0;
    }

    /**
     * Returns true iff "Developer System" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isDeveloperSystemDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("developer-system")).size() > 0;
    }

    /**
     * Returns true iff "Developer Uploaded" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isDeveloperUploadedDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("developer-uploaded")).size() > 0;
    }

    /**
     * Returns true iff "Product New" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isProductNewDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("product-new")).size() > 0;
    }

    /**
     * Returns true iff "Product System" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isProductSystemDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("product-system")).size() > 0;
    }

    /**
     * Returns true iff "Product Uploaded" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isProductUploadedDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("product-uploaded")).size() > 0;
    }

    /**
     * Returns true iff "Version New" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isVersionNewDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("version-new")).size() > 0;
    }

    /**
     * Returns true iff "Version System" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isVersionSystemDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("version-system")).size() > 0;
    }

    /**
     * Returns true iff "Version Uploaded" DIV exists on the Inspect screen.
     * @param driver WebDriver
     * @return true iff element exists
     */
    public static boolean isVersionUploadedDivElementPresent(final WebDriver driver) {
        return driver.findElements(By.id("version-uploaded")).size() > 0;
    }

    /**
     * Returns 'Create new product' radio button element on Inspect screen.
     * @param driver WebDriver
     * @return radio button element
     */
    public static WebElement createNewProductOptionOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("create-product"));
    }

    /**
     * Returns 'Create new version' radio button element on Inspect screen.
     * @param driver WebDriver
     * @return radio button element
     */
    public static WebElement createNewVersionOptionOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("create-version"));
    }

    /**
     * Returns Developer and Product Management link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement dpManagementLink(final WebDriver driver) {
        return driver.findElement(By.linkText("Developer & Product Management"));
    }

    /**
     * Returns Products and Surveillance Upload link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement dpManagementUploadProductsSurveillance(final WebDriver driver) {
        return driver.findElement(By.linkText("Upload Products & Surveillance"));
    }

   /**
     * Returns element holding main content.
     * @param driver WebDriver
     * @return element holding main content
     */
    public static WebElement mainContent(final WebDriver driver) {
        return driver.findElement(By.id("main-content"));
    }

    /**
     * Returns Manage Surveillance Activity link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement manageSurveillanceActivityLink(final WebDriver driver) {
        return driver.findElement(By.linkText("Manage Surveillance Activity"));
    }

    /**
     * Returns Pending Listings table in Confirm Pending Listings section.
     * @param driver WebDriver
     * @return table element
     */
    public static WebElement pendingListingsTable(final WebDriver driver) {
        return driver.findElement(By.id("pending-listings-table"));
    }

    /**
     * Returns 'previous' button on Inspect screen to navigate to previous screen.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement previousButtonOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("inspect-previous"));
    }

    /**
     * Returns surveillanceSearch input box.
     * @param driver WebDriver
     * @return surveillanceSearch element
     */
    public static WebElement surveillanceSearch(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-search"));
    }

    /**
     * Returns Surveillance search button.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement survSearchButton(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-search-button"));
    }

    /**
     * Returns element that holds post upload success text.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement updateSuccessfulToastContainer(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));
    }

    /**
     * Returns upload listing file button element.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement uploadFileButton(final WebDriver driver) {
        return driver.findElement(By.id("listing-file-confirm-0"));
    }

    /**
     * Returns upload surveillance file button element for bulk surveillance upload.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement uploadSurveillanceFileButton(final WebDriver driver) {
        return driver.findElement(By.id("surveillance-file-confirm-0"));
    }

    /**
     * Returns element that holds text message displayed after successful listing upload.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement uploadSuccessfulText(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[1]/div"));
    }

    /**
     * Returns Upload Products and Surveillance link.
     * @param driver WebDriver
     * @return link element
     */
    public static WebElement uploadProductsAndSurveillanceLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"admin-nav.dpManagement.upload\"]/a"));
    }

    /**
     * Returns 'next' button on Inspect screen to navigate to next screen.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement nextOnInspectButton(final WebDriver driver) {
        return driver.findElement(By.id("inspect-next"));
    }

    /**
     * Returns 'confirm' button on Inspect screen.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement confirmButtonOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("inspect-confirm"));
    }

    /**
     * Returns edit certified product button on Inspect screen.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement editOnInspectButton(final WebDriver driver) {
        return driver.findElement(By.id("inspect-edit"));
    }

    /**
     * Returns product Id in CHPL ID on inspect form.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement productIdOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("id-prod"));
    }

    /**
     * Returns product version in CHPL ID on inspect form.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement productVersionOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("id-ver"));
    }

    /**
     * Returns save certified product button on inspect form.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement saveCpOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("edit-save"));
    }

    /**
     * Returns 'Yes' button on Confirm alert.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement yesOnConfirm(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

    /**
     * Returns element that holds error and warning text.
     * @param driver WebDriver
     * @return text element
     */
    public static WebElement warningErrorTextOnInspect(final WebDriver driver) {
        return driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div[3]/div/div/div/ul"));
   }

    /**
     * Returns reject product button on Inspect screen.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement rejectButtonOnInspect(final WebDriver driver) {
        return driver.findElement(By.id("inspect-reject"));
    }

    /**
     * Returns error text on upload failure message.
     */
    public static WebElement uploadFailureErrorMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div/div[1]/div"));
    }
}
