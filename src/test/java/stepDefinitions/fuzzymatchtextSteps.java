package stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;

public class fuzzymatchtextSteps {

	public WebDriver driver;
	
	
	public fuzzymatchtextSteps(){
		driver = hooks.driver;
	}

@Given("^I am on listing details page \"([^\"]*)\"$")
public void i_am_on_listing_details_page(String arg1) throws Throwable {
	driver.get("https://chpl.ahrqstg.org/#/product/" + arg1);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Assert.assertTrue(driver.getTitle().contains("CHPL Product Details"));	    
}

@When("^I look at criteria details for criteria g4$")
public void i_look_at_criteria_details_g4() throws Throwable {
	listingDetails_page.certification_criteria_g4_view_details(driver).click();
}

@Then("^QMS Standard should display updated 'Standard: 21 CFR 820' text$")
public void QMS_standard_displays_correct_text() throws Throwable {
	String actualString = listingDetails_page.QMS_standard_text(driver).getText();
	assertTrue(actualString.contains("Standard: 21 CFR 820"));
}

@When("^I look at criteria details for criteria g5$")
public void i_look_at_criteria_details_for_criteria_g5() throws Throwable {
	Actions action = new Actions(driver);
	action.moveToElement(listingDetails_page.certification_criteria_g5_view_details(driver)).click().perform();
	}

@Then("^Accessibility Standard should display updated 'Other - WCAG Level' text$")
public void accessibility_Standard_should_display_updated_Other_WCAG() throws Throwable {
	String actualString = listingDetails_page.Acceessibility_standard_text(driver).getText();
	assertTrue(actualString.contains("Other - WCAG Level"));
}

@When("^I look at SED details$")
public void i_look_at_SED_details() throws Throwable {
   	listingDetails_page.sed_details_accordion_open(driver);
}

@Then("^UCD process should display updated 'ISO 9241-210' text$")
public void ucd_process_should_display_updated_NISTIR_text() throws Throwable {
	String actualString = listingDetails_page.UCD_process_text(driver).getText();
	assertTrue(actualString.contains("ISO 9241-210"));
}
}