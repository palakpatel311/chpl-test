package gov.healthit.chpl.aqa.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import gov.healthit.chpl.aqa.pageObjects.ChplDownloadPage;

/**
 * Class ChplDownloadSteps definition.
 */
public class ChplDownloadSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");

    /**
     * Constructor creates new driver.
     */
    public ChplDownloadSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
    }

    /**
     * Loads the CHPL Download page.
     */
    @Given("^user is on CHPL download page$")
    public void userIsOnCHPLdownloadPage() {
        driver.get(url + "#/resources/download");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(ChplDownloadPage.mainContent(driver)));
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
     * Assert that correct number of download files exist.
     *
     * @param expectedLength the expected number of files to find
     */
    @Then("^user sees \"([^\"]*)\" download files")
    public void userSeesDownloadFiles(final String expectedLength) {
        WebElement selectElement = ChplDownloadPage.downloadSelectList(driver);
        Select listBox = new Select(selectElement);
        assertEquals(listBox.getOptions().size(), Integer.parseInt(expectedLength));
    }
}
