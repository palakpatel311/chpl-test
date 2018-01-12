package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private static final int DELAY = 20;

    public ChplDownloadSteps() {
        driver = Hooks.getDriver();
    }

    @Given("^user is on CHPL download page$")
    public void userIsOnCHPLHome() throws Throwable {
        driver.get("https://chpl.ahrqdev.org/#/resources/download");
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        assertTrue(driver.getTitle().contains("Download the CHPL"));
    }

    @When("^user is not logged in$")
    public void userIsNotLoggedIn() throws Throwable {
        driver.get("https://chpl.ahrqdev.org/#/resources/download");
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        ChplDownloadPage.loginMenuDropdown(driver).click();
        String actualString = ChplDownloadPage.loginButton(driver).getText();
        assertTrue(actualString.contains("Log In"));
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

    @Given("^user is logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userIsLoggedInWithAnd(final String arg1, final String arg2) throws Throwable {

        driver.get("https://chpl.ahrqdev.org/#/resources/download");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='login-toggle']")).click();

        // This part is currently not logging in user; login button click() is not working
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id='admin']/li/div/form/button[1]")).click();
    }

    @Then("^user sees 8 download files")
    public void userSees8DownloadFiles() throws Throwable {
        int expectedLength = 8;

        WebElement selectElement = ChplDownloadPage.downloadSelectList(driver);
        Select listBox = new Select(selectElement);
        int filecount1 = listBox.getOptions().size();
        Assert.assertEquals(filecount1, expectedLength);
    }
}
