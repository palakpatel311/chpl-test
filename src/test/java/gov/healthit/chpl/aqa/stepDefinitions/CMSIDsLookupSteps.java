package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
/**
 * Class CMSIDsLookupSteps definition.
 */
public class CMSIDsLookupSteps {

    private WebDriver driver;
    private static final int DELAY = 40;
    
    public CMSIDsLookupSteps() {
    driver = Hooks.getDriver();
    }
    @Given("^I am an end-user on CMS ID Reverse Lookup page$")
    public void i_am_an_end_user_on_CMS_ID_Reverse_Lookup_page() {
        driver.get("https://chpl.ahrqstg.org/#/resources/cms_lookup");
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        Assert.assertTrue(driver.getTitle().contains("CMS ID Reverse Lookup"));
    }

    @When("^I look up '0015H8GK6K0ZZB2' CMS ID in the reverse look-up tool$")
    public void I_look_up_a_CMS_ID_in_the_reverse_lookup_tool() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"certIdsField\"]")).sendKeys("0015H8GK6K0ZZB2");
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div/div/div/span/button/i")).click();
    }

    @Then("^I should see the listings that make up the CMS ID$")
    public void i_should_see_the_listings_that_make_up_the_CMS_ID() throws Throwable {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody/tr[1]/td[6]")).getText().contains("14.07.07.2452.VEI1.01.01.0.161111")); 
    }

    @Given("^I am an end user$")
    public void i_am_an_end_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        
    }

    @When("^I Generate CMS ID using CMS ID widget for same listings as in result of reverse lookup of (\\d+)H(\\d+)GK(\\d+)K(\\d+)ZZB(\\d+)$")
    public void i_Generate_CMS_ID_using_CMS_ID_widget_for_same_listings_as_in_result_of_reverse_lookup_of_H_GK_K_ZZB(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       
    }

    @Then("^the generated CMS ID should be '(\\d+)H(\\d+)GK(\\d+)K(\\d+)ZZB(\\d+)'$")
    public void the_generated_CMS_ID_should_be_H_GK_K_ZZB(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        
    }

    
    
    
    
    
}
