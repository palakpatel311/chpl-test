package gov.healthit.chpl.aqa.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplDownloadPage;
/**
 * Class ChplDownloadSteps definition.
 */
public class ChplDownloadSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");
    private String downloadPath = System.getProperty("downloadPath");
    private File dir;
    /**
     * Constructor creates new driver.
     * Create a sub directory under default temp directory to set downloadPath
     */
    public ChplDownloadSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "https://chpl.ahrqdev.org/";
       }
        if (StringUtils.isEmpty(downloadPath)) {
            String tempDirectory;
            try {
              tempDirectory = Files.createTempDirectory("download-files").toString();
              System.out.println(tempDirectory);
            } catch (final IOException e) {
              // Temp dir creation failed - use default
              tempDirectory = null;
            }
           downloadPath = tempDirectory;
        }
        dir = new File(downloadPath);
    }

    /**
     * Get user to the Download CHPL page. Chrome options are necessary to get past
     * keep/discard pop ups for successful download of a file to directory.
     * @throws Throwable throws exception if there is an issue with Chrome options.
     */
    @Given("^I am on download the CHPL resources page$")
    public void iAmOnDownloadTheCHPLResourcesPage() throws Throwable {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        /**
         * Save Chrome Options
         */
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        options.setExperimentalOption("prefs", chromePrefs);
        chromePrefs.put("safebrowsing.enabled", "true");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("disable-popup-blocking");

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(cap);
        driver.get(url + "#/resources/download");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChplDownloadPage.downloadSelectList(driver)));
    }

    /**
     * Activates an item in the download file box.
     */
    @When("^user selects a file in download file box")
    public void userSelectsAFileInDownloadFileBox() {
        WebElement selectBox = ChplDownloadPage.downloadSelectList(driver);
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText("2015 edition products (xml)");
    }

    /**
     * Assert that correct definition file shows.
     */
    @Then("^definition file shows based on download file selection$")
    public void definitionFileShowsBasedOnSelection() {
        String definition = new Select(ChplDownloadPage.definitionSelectList(driver)).getFirstSelectedOption().getText();
        assertTrue(definition.contains("2015 edition products (xml) Definition File"));
    }

    /**
     * Assert that correct number of download files exist.     *
     * @param expectedLength the expected number of files to find
     */
    @Then("^user sees \"([^\"]*)\" download files")
    public void userSeesDownloadFiles(final String expectedLength) {
        WebElement selectElement = ChplDownloadPage.downloadSelectList(driver);
        Select listBox = new Select(selectElement);
        assertEquals(listBox.getOptions().size(), Integer.parseInt(expectedLength));
    }
    /**
     * Select 2015 edition products file from drop down and download .xml file.
     * @throws Exception - to handle IOException with FileUtil
     */

    @When("^I download the 2015 edition products file$")
    public void download2015editionProductsFile() throws Exception {
        /**
         * Clean all files from download directory so each time there is only latest
         * download file to read.
         */
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoption2015editionProductsFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows chpl-2015-currentdate.xml filename$")
    public void verify2015editionProductsFilename() {
        /**
         * Get latest download file in the directory. Keep checking until download is
         * complete then read final filename.
         */

        String dwldFileName = "";
        boolean fileFound = false;

        while (!fileFound) {
            File[] filenames = dir.listFiles();

            for (File file : filenames) {
                dwldFileName = file.getName();
            }
            String finalName = dwldFileName.replaceAll("(^....).{2,30}(....$)", "$1" + "-" + "$2");

            if (finalName.equalsIgnoreCase("chpl-.xml")) {
                fileFound = true;
            }
        }
        /**
         * Replace ddmmhh part to construct a filename to match with expected.
         * Use of DateFormat to get current system date.
         */
        String downloadfileName = dwldFileName.replaceAll("(^chpl-2015-........_).{2,10}(.xml)",
                "$1" + "xxxxxx" + "$2");

        String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
        String currentfile = "chpl-2015-" + sysfilename + "xxxxxx.xml";

        assertEquals(downloadfileName, currentfile, "File is not current");
    }
    /**
     * Select 2014 edition products file from drop down and download .xml file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the 2014 edition products file$")
    public void download2014editionProductsFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoption2014editionProductsFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows chpl-2014-currentdate.xml filename$")
    public void verify2014editionProductsFilename() {

        /**
         * Get latest download file in the directory. Keep checking until download is
         * complete then read final filename.
         */
        String dwldFileName = "";
        boolean fileFound = false;

        while (!fileFound) {
            File[] filenames = dir.listFiles();

            for (File file : filenames) {
                dwldFileName = file.getName();
            }
            String finalName = dwldFileName.replaceAll("(^....).{2,30}(....$)", "$1" + "-" + "$2");

            if (finalName.equalsIgnoreCase("chpl-.xml")) {
                fileFound = true;
            }
        }
        /**
         * Replace ddmmhh part to construct a filename to match with expected.
         * Use of DateFormat to get current system date.
         */
        String downloadfileName = dwldFileName.replaceAll("(^chpl-2014-........_).{2,10}(.xml)",
                "$1" + "xxxxxx" + "$2");
        String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
        String currentfile = "chpl-2014-" + sysfilename + "xxxxxx.xml";

        assertEquals(downloadfileName, currentfile, "File is not current");
    }
    /**
     * Select 2011 edition products file from drop down and download .xml file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the 2011 edition products file$")
    public void download2011editionProductsFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoption2011editionProductsFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows 2011-chpl-lastrun.xml filename$")
    public void verify2011editionProductsFilename() {

        /**
         * Get latest download file in the directory. Keep checking until download is
         * complete then read final filename.
         */
        String dwldFileName = "";
        boolean fileFound = false;

        while (!fileFound) {
            File[] filenames = dir.listFiles();

            for (File file : filenames) {
                dwldFileName = file.getName();
            }
            String finalName = dwldFileName.replaceAll("(^....).{2,30}(....$)", "$1" + "-" + "$2");

            if (finalName.equalsIgnoreCase("chpl-.xml")) {
                fileFound = true;
            }
        }
        /**
         * Replace ddmmhh part to construct a filename to match with expected.
         * Use of DateFormat to get current system date.
         */
        String downloadfileName = dwldFileName.replaceAll("(^chpl-2011-........_).{2,10}(.xml)",
                "$1" + "xxxxxx" + "$2");

        String sysMonth = new SimpleDateFormat("MM").format(new Date());
        String sysYear = new SimpleDateFormat("yyyy").format(new Date());
        /**
         * Construct filename for each quarter to validate download filename. 2011
         * product xml file is generated on first day of a quarter. Compare filenames
         * generated within a quarter against constructed filename.
         */

        String sysfilenameQ1 = "chpl-2011-" + sysYear + "0101_xxxxxx.xml";
        String sysfilenameQ2 = "chpl-2011-" + sysYear + "0401_xxxxxx.xml";
        String sysfilenameQ3 = "chpl-2011-" + sysYear + "0701_xxxxxx.xml";
        String sysfilenameQ4 = "chpl-2011-" + sysYear + "1001_xxxxxx.xml";

        if (sysMonth.equalsIgnoreCase("01") || sysMonth.equalsIgnoreCase("02")
                || sysMonth.equalsIgnoreCase("03") && downloadfileName.equals(sysfilenameQ1)) {
            assertEquals(downloadfileName, sysfilenameQ1, "File is not current");
        } else if (sysMonth.equalsIgnoreCase("04") || sysMonth.equalsIgnoreCase("05")
                || sysMonth.equalsIgnoreCase("06") && downloadfileName.equals(sysfilenameQ2)) {
            assertEquals(downloadfileName, sysfilenameQ2, "File is not current");
        } else if (sysMonth.equalsIgnoreCase("07") || sysMonth.equalsIgnoreCase("08")
                || sysMonth.equalsIgnoreCase("09") && downloadfileName.equals(sysfilenameQ3)) {
            assertEquals(downloadfileName, sysfilenameQ3, "File is not current");
        } else if (sysMonth.equalsIgnoreCase("10") || sysMonth.equalsIgnoreCase("11")
                || sysMonth.equalsIgnoreCase("12") && downloadfileName.equals(sysfilenameQ4)) {
            assertEquals(downloadfileName, sysfilenameQ4, "File is not current");
        }

    }
    /**
     * Select 2015 edition summary file from drop down and download .csv file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the 2015 edition summary file$")
    public void download2015editionSummaryFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoption2015summaryFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows chpl-2015-currentdate.csv filename$")
    public void verify2015editionSummaryFilename() {
        /**
         * Get latest download file in the directory. Keep checking until download is
         * complete then read final filename.
         */
        String dwldFileName = "";
        boolean fileFound = false;

        while (!fileFound) {
            File[] filenames = dir.listFiles();

            for (File file : filenames) {
                dwldFileName = file.getName();
            }
            String finalName = dwldFileName.replaceAll("(^....).{2,30}(....$)", "$1" + "-" + "$2");

            if (finalName.equalsIgnoreCase("chpl-.csv")) {
                fileFound = true;
            }
        }
        /**
         * Replace ddmmhh part to construct a filename to match with expected.
         * Use of DateFormat to get current system date.
         */
        String downloadfileName = dwldFileName.replaceAll("(^chpl-2015-........_).{2,10}(.csv)",
                "$1" + "xxxxxx" + "$2");
        String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
        String currentfile = "chpl-2015-" + sysfilename + "xxxxxx.csv";

        assertEquals(downloadfileName, currentfile, "File is not current");
    }
    /**
     * Select 2014 edition summary file from drop down and Download .csv file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the 2014 edition summary file$")
    public void download2014editionSummaryFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoption2014summaryFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows chpl-2014-currentdate.csv filename$")
    public void verify2014editionSummaryFilename() {
        /**
         * Get latest download file in the directory. Keep checking until download is
         * complete then read final filename.
         */
        String dwldFileName = "";
        boolean fileFound = false;

        while (!fileFound) {
            File[] filenames = dir.listFiles();

            for (File file : filenames) {
                dwldFileName = file.getName();
            }
            String finalName = dwldFileName.replaceAll("(^....).{2,30}(....$)", "$1" + "-" + "$2");

            if (finalName.equalsIgnoreCase("chpl-.csv")) {
                fileFound = true;
            }
        }
        /**
         * Replace ddmmhh part to construct a filename to match with expected.
         * Use of DateFormat to get current system date.
         */
        String downloadfileName = dwldFileName.replaceAll("(^chpl-2014-........_).{2,10}(.csv)",
                "$1" + "xxxxxx" + "$2");
        String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
        String currentfile = "chpl-2014-" + sysfilename + "xxxxxx.csv";

        assertEquals(downloadfileName, currentfile, "File is not current");
    }
    /**
     * Select Surveillance Activity file from drop down and download .csv file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the Surveillance Activity file$")
    public void downloadSurveillanceActivityFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoptionSurveillanceFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows surveillance-all.csv filename$")
    public void verifySurveillanceActivityFilename() {

        File[] filenames = dir.listFiles();

        for (File file : filenames) {
            String dwldFileName = file.getName();
            String currentfile = "surveillance-all.csv";
            assertEquals(dwldFileName, currentfile, "File is not current");
        }
    }
    /**
     * Select surveillance-with-nonconformities file from drop down and download .csv file.
     * @throws Exception - to handle IOException with FileUtil
     */
    @When("^I download the Non-Conformities file$")
    public void downloadNonConformitiesFile() throws Exception {
        //FileUtils.cleanDirectory(dir);
        ChplDownloadPage.downloadoptionNonconformitiesFile(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }
    /**
     * Assert filename of download file.
     */
    @Then("^the downloaded file shows surveillance-with-nonconformities.csv filename$")
    public void verifyNonConformitiesFilename() {

        File[] filenames = dir.listFiles();

        for (File file : filenames) {
            String dwldFileName = file.getName();
            String currentfile = "surveillance-with-nonconformities.csv";
            assertEquals(dwldFileName, currentfile, "File is not current");
        }

    }
    /**
     * Print filenames if directory is not empty.
     * Assert that download directory is empty
     */
    @And("^the download directory is empty$")
    public void checkifDownloadDirectoryisEmpty() {
        for (String fileName : dir.list()) {
            System.out.println(fileName);
}
        assertFalse("directry is not empty", dir.list().length > 0);

    }

}
