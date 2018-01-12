package stepDefinitions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginSteps {
    public WebDriver driver;

    public loginSteps()
    {
        driver = hooks.driver;

    }

    @Given("^User is on CHPL home page$")
    public void user_is_on_CHPL_home_page() throws Throwable {

        driver.get("https://chpl.ahrqdev.org/#/search");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @When("^User clicks on Administrator Login button$")
    public void user_clicks_on_Administrator_Login_button() throws Throwable {
        driver.get("https://chpl.ahrqdev.org/#/resources/download");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='login-toggle']")).click();
        Thread.sleep(100);
    }

    @Then("^login form shows in dropdown$")
    public void login_form_shows_in_dropdown() throws Throwable {
        System.out.println("Login form open");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }


    @Given("^User enters valid \"(.*)\" and \"(.*)\"$")
    public void User_enters_valid_username_and_password(String username, String password) throws Throwable {
        driver.get("https://chpl.ahrqdev.org/#/resources/download");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='login-toggle']")).click();
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");

    }

    @And("^User clicks login button$")
    public void user_clicks_login_button() throws Throwable {

        driver.findElement(By.xpath("//*[@id='admin']/li/div/form/button[1]")).click();
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() throws Throwable {
        System.out.println("login successfull");
    }
}
