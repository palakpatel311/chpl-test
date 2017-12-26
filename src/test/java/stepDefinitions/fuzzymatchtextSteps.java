package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;

public class fuzzymatchtextSteps {

	public WebDriver driver;
	private WebElement element;
	
	public fuzzymatchtextSteps(){
		driver = hooks.driver;
	}

@Given("^I am on listing details page \"([^\"]*)\"$")
public void i_am_on_listing_details_page(String arg1) throws Throwable {
	driver.get("https://chpl.ahrqdev.org/#/product/" + arg1);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	listingDetails_page.load_listings_details_page(driver); 	    
}

@When("^I look at criteria details for criteria g4$")
public void i_look_at_criteria_details_g4() throws Throwable {
	listingDetails_page.certification_criteria_g4_view_details(driver);
}

@Then("^QMS Standard should display updated 'Standard: ISO9001:2015' text$")
public void QMS_standard_displays_correct_text() throws Throwable {
	listingDetails_page.QMS_standard_text(driver);
}

@When("^I look at criteria details for criteria g5$")
public void i_look_at_criteria_details_for_criteria_g5() throws Throwable {
	listingDetails_page.certification_criteria_g5_view_details(driver);
}

@Then("^Accessibility Standard should display updated 'Other - WCAG 2.0' text$")
public void accessibility_Standard_should_display_updated_Other_WCAG() throws Throwable {
    listingDetails_page.Acceessibility_standard_text(driver);
}

@Then("^Accessibility standard 'Section 508 of the Rehabilitation Act' text$")
public void additional_accessibility_standard_options() throws Throwable {
	listingDetails_page.Acceessibility_standard_text2(driver);
}

@When("^I look at SED details$")
public void i_look_at_SED_details() throws Throwable {
   	listingDetails_page.sed_details_accordion_open(driver);
}

@Then("^UCD process should display updated 'NISTIR 7741' text$")
public void ucd_process_should_display_updated_NISTIR_text() throws Throwable {
    listingDetails_page.UCD_process_text(driver);
}
}