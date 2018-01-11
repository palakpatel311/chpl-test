package stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;

public class tptdSteps {

	public WebDriver driver;
	private WebElement element;
	
	public tptdSteps(){
		driver = hooks.driver;
	}

@Given("^I am on Details page of Listing \"([^\"]*)\"$")
public void i_am_on_a_listing_details_page(String arg1) throws Throwable {
	driver.get("https://chpl.ahrqdev.org/#/product/" + arg1);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	assertTrue(driver.getTitle().contains("CHPL Product details")); 	    
}

@When("^I look at criteria details for criteria c2$")
public void i_look_at_criteria_details_C2() throws Throwable {
	listingDetails_page.certification_criteria_c2_view_details(driver);
}

@Then("^Test Procedure field should display 'Name: ONC Test Method' text$")
public void test_Procedure_field_should_display_Name_ONC_Test_Method_text() throws Throwable {
	assertTrue(driver.getPageSource().contains("Name: ONC Test Method"));
}

@When("^I look at criteria details for criteria c3$")
public void i_look_at_criteria_details_C3() throws Throwable {
	listingDetails_page.certification_criteria_c3_view_details(driver);
}

@When("^I look at criteria details for criteria f1$")
public void i_look_at_criteria_details_f1() throws Throwable {
	listingDetails_page.certification_criteria_f1_view_details(driver);
}
}