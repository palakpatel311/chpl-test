package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplDownloadPage;

/**
 * Class MonitorDownloadFiles definition.
 */

public class MonitorDownloadFilesSteps {
    private WebDriver driver;
    private String url = System.getProperty("url");

    private static String downloadPath = "\\filepath";
    private static File dir = new File("\\filepath");

    /**
     * Constructor creates new driver.
     */
    public MonitorDownloadFilesSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Get user to the Download CHPL page. Chrome options are necessary to get past
     * keep/discard pop ups for successful download of a file to directory.
     */
    @Given("^I am on download the CHPL resources page$")
    public void i_am_on_download_the_CHPL_resources_page() throws Throwable {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        /**
         * Save Chrome Opions
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

    }

    @When("^I download the 2015 edition products file$")
    public void i_download_the_2015ed_products_file() {
        ChplDownloadPage.downloadFile_2015products(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows chpl-2015-currentdate.xml filename$")
    public void the_downloaded_file_shows_chpl_2015_currentdate_xml_filename() {
        /**
         * Get a list of all files in the directory and sort it by last modified date to
         * get latest download file in the directory. This can be improved by deleting
         * each file in the directory after validation (file.delete() was not working).
         */
        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        /**
         * Get latest download file and replace ddmmhh part to construct a filename to
         * match with expected Use of DateFormat to get current system date
         */
        for (File file : files) {
            String matchFile = file.getName();
            String downloadfileName = matchFile.replaceAll("(^chpl-2015-........_).{2,10}(.xml)",
                    "$1" + "xxxxxx" + "$2");
            String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
            String currentfile = "chpl-2015-" + sysfilename + "xxxxxx.xml";

            assertEquals(downloadfileName, currentfile, "File is not current");

        }
    }

    @When("^I download the 2014 edition products file$")
    public void i_download_the_2014ed_xml_file() {
        ChplDownloadPage.downloadFile_2014products(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows chpl-2014-currentdate.xml filename$")
    public void the_downloaded_file_shows_chpl_2014_currentdate_xml_filename() {

        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String matchFile = file.getName();
            String downloadfileName = matchFile.replaceAll("(^chpl-2014-........_).{2,10}(.xml)",
                    "$1" + "xxxxxx" + "$2");
            String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
            String currentfile = "chpl-2014-" + sysfilename + "xxxxxx.xml";

            assertEquals(downloadfileName, currentfile, "File is not current");

        }
    }

    @When("^I download the 2011 edition products file$")
    public void i_download_the_2011ed_products_file() {
        ChplDownloadPage.downloadFile_2011products(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows 2011-chpl-lastrun.xml filename$")
    public void the_downloaded_file_shows_chpl_2011_lastrun_xml_filename() {

        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String matchFile = file.getName();

            String downloadfileName = matchFile.replaceAll("(^chpl-2011-........_).{2,10}(.xml)",
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
            }

            else if (sysMonth.equalsIgnoreCase("07") || sysMonth.equalsIgnoreCase("08")
                    || sysMonth.equalsIgnoreCase("09") && downloadfileName.equals(sysfilenameQ3)) {
                assertEquals(downloadfileName, sysfilenameQ3, "File is not current");
            } else if (sysMonth.equalsIgnoreCase("10") || sysMonth.equalsIgnoreCase("11")
                    || sysMonth.equalsIgnoreCase("12") && downloadfileName.equals(sysfilenameQ4)) {
                assertEquals(downloadfileName, sysfilenameQ4, "File is not current");
            }
        }
    }

    @When("^I download the 2015 edition summary file$")
    public void i_download_the_2015ed_summary_file() {
        ChplDownloadPage.downloadFile_2015summary(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows chpl-2015-currentdate.csv filename$")
    public void the_downloaded_file_shows_chpl_2015_currentdate_csv_filename() {
        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String matchFile = file.getName();
            String downloadfileName = matchFile.replaceAll("(^chpl-2015-........_).{2,10}(.csv)",
                    "$1" + "xxxxxx" + "$2");
            String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
            String currentfile = "chpl-2015-" + sysfilename + "xxxxxx.csv";

            assertEquals(downloadfileName, currentfile, "File is not current");
        }

    }

    @When("^I download the 2014 edition summary file$")
    public void i_download_the_2014ed_summary_file() {
        ChplDownloadPage.downloadFile_2014summary(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows chpl-2014-currentdate.csv filename$")
    public void the_downloaded_file_shows_chpl_2014_currentdate_csv_filename() {
        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String matchFile = file.getName();
            String downloadfileName = matchFile.replaceAll("(^chpl-2014-........_).{2,10}(.csv)",
                    "$1" + "xxxxxx" + "$2");
            String sysfilename = new SimpleDateFormat("yyyyMMdd_").format(new Date());
            String currentfile = "chpl-2014-" + sysfilename + "xxxxxx.csv";

            assertEquals(downloadfileName, currentfile, "File is not current");

        }

    }

    @When("^I download the Surveillance Activity file$")
    public void i_download_the_Surveillance_Activity_file() {
        ChplDownloadPage.downloadFile_surveillanceall(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows surveillance-all.csv filename$")
    public void the_downloaded_file_shows_surveillance_all_csv_filename() {
        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String downloadfileName = file.getName();
            String currentfile = "surveillance-all.csv";

            assertEquals(downloadfileName, currentfile, "File is not current");
        }

    }

    @When("^I download the Non-Conformities file$")
    public void i_download_the_Non_Conformities_file() {
        ChplDownloadPage.downloadFile_nonconformity(driver).click();
        ChplDownloadPage.downloadFileButton(driver).click();
    }

    @Then("^the downloaded file shows surveillance-with-nonconformities.csv filename$")
    public void the_downloaded_file_shows_surveillance_with_nonconformities_csv_filename() {
        File[] files = dir.listFiles();
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

        for (File file : files) {
            String downloadfileName = file.getName();
            String currentfile = "surveillance-with-nonconformities.csv";

            assertEquals(downloadfileName, currentfile, "File is not current");
        }

    }

}
