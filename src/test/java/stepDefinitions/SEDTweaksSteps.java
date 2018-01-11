package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;
import static org.testng.Assert.assertTrue;


public class SEDTweaksSteps {

	public WebDriver driver;
	
	public SEDTweaksSteps()
	{
		driver = hooks.driver;
	}

	@Given("^I am on the Details page of Listing \"([^\"]*)\"$")
	public void i_am_on_a_listing_s_details_pages(String arg1) throws Throwable {
		driver.get("https://chpl.ahrqstg.org/#/product/" + arg1);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Assert.assertTrue(driver.getTitle().contains("CHPL Product Details")); 
	}

	
	@Then("^I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
	public void i_should_see_the_accordions_exist_on_details_page() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("details-certification-criteria")));
		assertTrue(driver.findElement(By.id("details-certification-criteria")).getText().contains("Certification Criteria"));
		assertTrue(driver.findElement(By.id("details-cqm")).getText().contains("Clinical Quality Measures"));
		assertTrue(driver.findElement(By.id("details-sed")).getText().contains("Safety Enhanced Design (SED)"));
		assertTrue(driver.findElement(By.id("details-g1g2")).getText().contains("Successfully Tested G1/G2 Measures"));
		assertTrue(driver.findElement(By.id("details-surveillance-activities")).getText().contains("Surveillance Activities"));
		assertTrue(driver.findElement(By.id("details-additional-information")).getText().contains("Additional Information"));
		
	}
	
	@Then("^I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
	public void i_should_see_the_accordions_in_the_following_order_Criteria_CQMs_SED_G1_G2_Surveillance_Additional_Info() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));
		
	}

	@When("^I open SED details accordion$")
	public void i_open_SED_accordion() throws Throwable {
		listingDetails_page.sed_details_accordion_open(driver);
	}
	
	@Then("^usability report text should read as 'Full Usability Report'$")
	public void usability_report_title_reads_as_Full_Usability_Report() throws Throwable {
		
		assertTrue(listingDetails_page.usability_report_title(driver).getText().contains("Full Usability Report"));	
	}

	@Then("^intended user description header should show as 'Description of Intended Users'$")
	public void the_header_should_be_named_Description_of_Intended_Users() throws Throwable {
	    
		assertTrue(listingDetails_page.intended_user_description_title(driver).getText().contains("Description of Intended Users"));
	}

	@Then("^the header name should read as 'Date SED Testing was Completed'$")
	public void the_header_should_be_named_as_Date_SED_Testing_was_Completed() throws Throwable {
		
	assertTrue(listingDetails_page.SED_testing_complete_date_title(driver).getText().contains("Date SED Testing was Completed"));
	}

	@Then("^the download button title should read as 'Download SED Details'$")
	public void the_download_button_title_should_read_as_Download_SED_Details() throws Throwable {
		
	assertTrue(listingDetails_page.download_SED_details_button(driver).getText().contains("Download SED Details"));
	}
	
	@Then("^the criteria number should also include the criteria title$")
	public void the_criteria_number_should_also_include_the_criteria_title() throws Throwable {
		assertTrue(listingDetails_page.SED_certification_Criteria(driver).getText().contains("170.315 (a)(1): Computerized Provider Order Entry (CPOE) - Medications"));
		assertTrue(listingDetails_page.SED_certification_Criteria2(driver).getText().contains("170.315 (a)(2): CPOE - Laboratory"));
		assertTrue(listingDetails_page.SED_certification_Criteria3(driver).getText().contains("170.315 (a)(3): CPOE - Diagnostic Imaging"));
		assertTrue(listingDetails_page.SED_certification_Criteria4(driver).getText().contains("170.315 (a)(4): Drug-Drug, Drug-Allergy Interaction Checks for CPOE"));
		assertTrue(listingDetails_page.SED_certification_Criteria5(driver).getText().contains("170.315 (a)(5): Demographics"));
		assertTrue(listingDetails_page.SED_certification_Criteria6(driver).getText().contains("170.315 (a)(6): Problem List"));
		assertTrue(listingDetails_page.SED_certification_Criteria7(driver).getText().contains("170.315 (a)(8): Medication Allergy List"));
		assertTrue(listingDetails_page.SED_certification_Criteria8(driver).getText().contains("170.315 (a)(14): Implantable Device List"));
		assertTrue(listingDetails_page.SED_certification_Criteria9(driver).getText().contains("170.315 (b)(3): Electronic Prescribing"));
	}
		
	@Then("^there should be text 'No Certification Criteria were tested for SED'$")
	public void there_should_be_text_No_Certification_Criteria_were_tested_for_SED() throws Throwable {
			
		assertTrue(driver.getPageSource().contains("No Certification Criteria were tested for SED."));
	}

}

