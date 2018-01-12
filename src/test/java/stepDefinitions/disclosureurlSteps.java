package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.search_page;

public class disclosureurlSteps {
    public WebDriver driver;
    private WebElement element;
    public disclosureurlSteps(){
        driver = hooks.driver;
    }

    @Given("^I am on listing details page of listing with CHPL ID \"(.*)\"$")
    public void i_am_on_listing_details_page_of_listing_with_CHPL_ID(String CHPL_ID) throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/search");
        //driver.get("https://chpl.healthit.gov/#/search");
        search_page.search_field(driver).sendKeys(CHPL_ID);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        search_page.details_link(driver).click();
    }

    @Then("^it should show updated url$")
    public void it_should_show_updated_url() throws Throwable {
        String actualString = search_page.disclosure_url(driver).getText();
        Assert.assertTrue(actualString.contains("cehrt-disclosure-information"));
    }

}
