package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private String adminUsername = System.getProperty("adminUsername");
    private String adminPassword = System.getProperty("adminPassword");

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
        if (StringUtils.isEmpty(adminUsername)) {
            throw new IllegalArgumentException("Missing value for admin username!");
        }
        if (StringUtils.isEmpty(adminPassword)) {
            throw new IllegalArgumentException("Missing value for admin password!");
        }
    }

    /**
     * Log the user in as an ACB.
     */
    @Given("^I'm logged in as an ACB$")
    public void logInAsAcb() {
        driver.get(url + "#/admin/dpManagement");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.username(driver)));
        LoginPage.username(driver).sendKeys(username);
        LoginPage.password(driver).sendKeys(password);
        LoginPage.loginButton(driver).click();
    }

    /**
     * Verify login attempt was successful.
     * @param role as ACB or Admin
     */
    @Then("^I should be logged in to CHPL as \"([^\"]*)\"$")
    public void verifyLoginWasSuccessful(final String role) {
        String actualString = LoginPage.welcomeText(driver).getText();
        assertTrue(actualString.contains("Welcome"));
    }

    /**
     * Log the user in as an Admin.
     */
    @Given("^I'm logged in as an Admin$")
    public void logInAsAdmin() {
        driver.get(url + "#/admin/dpManagement");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.username(driver)));
        LoginPage.username(driver).sendKeys(adminUsername);
        LoginPage.password(driver).sendKeys(adminPassword);
        LoginPage.loginButton(driver).click();
    }

}

