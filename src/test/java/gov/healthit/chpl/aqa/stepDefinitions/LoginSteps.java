package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.LoginPage;

/**
 * Class LoginSteps definition.
 */
public class LoginSteps {

    private WebDriver driver;
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");

    /**
     * Constructor creates new driver.
     */
    public LoginSteps() {
        driver = Hooks.getDriver();
        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
           }

        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("Missing value for username!");
           }
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Missing value for password!");
           }
    }

    /**
     * Loads CHPL admin page to show login form.
     */
    @Given("^I am on CHPL admin page$")
    public void iAmOnChplAdminPage() {
        driver.get(url + "#/admin/");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.username(driver)));
    }

    /**
     * Enter username in Username field.
     */
    @And("^I fill in username$")
    public void enterUsername() {
        LoginPage.username(driver).sendKeys(username);
    }

    /**
     * Enter password in Password field.
     */
    @And("^I fill in Password$")
    public void enterPassword() {
        LoginPage.password(driver).sendKeys(password);
    }

    /**
     * Click login button.
     */
    @And("^I click Log in button$")
    public void clickLoginButton() {
        LoginPage.loginButton(driver).click();
    }

    /**
     * Verify login attempt was successful.
     */
    @Then("^I should be logged in to CHPL as ACB Admin$")
    public void verifyLoginWasSuccessful() {
        String actualString = LoginPage.welcomeText(driver).getText();
        assertTrue(actualString.contains("Welcome"));
    }

}
