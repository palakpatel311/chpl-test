package gov.healthit.chpl.aqa.stepDefinitions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gov.healthit.chpl.aqa.pageObjects.ChplDownloadPage;

/**
 * Class ChplDownloadSteps definition.
 */
public class ChplDownloadSteps {

    private WebDriver driver;
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

    @Given("^user is on CHPL download page$")
    public void userIsOnCHPLdownloadPage() throws Throwable {
        driver.get(url + "#/resources/download");
    }
    
    @Then("^user sees 7 download files")
    public void userSees7DownloadFiles() throws Throwable {
        int expectedLength = 7;
        WebElement selectElement = ChplDownloadPage.downloadSelectList(driver);
        Select listBox = new Select(selectElement);
        int filecount = listBox.getOptions().size();
        Assert.assertEquals(filecount, expectedLength);
    }

    @When("^user selects a file in download file box")
    public void userSelectsAFileInDownloadFileBox() throws Throwable {

        WebElement selectBox = ChplDownloadPage.downloadSelectList(driver);
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText("2015 edition products (xml)");
    }

    @Then("^definition file shows based on download file selection$")
    public void definitionFileShowsBasedOnSelection() throws Throwable {

        String definition = new Select(ChplDownloadPage.definitionSelectList(driver)).getFirstSelectedOption().getText();
        Assert.assertTrue(definition.contains("2015 edition products (xml) Definition File"));
    }

}
