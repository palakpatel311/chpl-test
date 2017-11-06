package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;

import static org.junit.Assert.assertTrue;

public class SEDTweaksSteps {

	public WebDriver driver;
	
	public SEDTweaksSteps()
	{
		driver = hooks.driver;
		
	}

 	
	@Given("^I am on a listing's details pages$")
	public void i_am_on_a_listing_s_details_pages() throws Throwable {
		listingDetails_page.load_listings_details_page(driver); 	    
	}

	
	@Then("^I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
	public void i_should_see_the_accordions_in_the_following_order_Criteria_CQMs_SED_G1_G2_Surveillance_Additional_Info() throws Throwable {
		driver.get("https://chpl.ahrqstg.org/#/product/8481");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
		
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));
		
	}

	

	@When("^I click open SED accordion$")
	public void i_click_open_SED_accordion() throws Throwable {
		listingDetails_page.sed_details_accordion_open(driver);
		
		if(driver.getPageSource().contains("No Certification Criteria were tested for SED."))
		    System.out.println("No Certification Criteria were tested for SED.");
		else
			driver.getPageSource().contains("Description of Intended Users");
	}

	@Then("^intended user description header should show as Description of Intended Users$")
	public void the_header_should_be_named_Description_of_Intended_Users() throws Throwable {
	    
	assertTrue(driver.getPageSource().contains("Description of Intended Users"));
			
	}

	@Then("^the header name should read as 'Date SED Testing was Completed'$")
	public void the_header_should_be_named_as_Date_SED_Testing_was_Completed() throws Throwable {
		
	listingDetails_page.sed_details_accordion_open(driver);
	assertTrue(driver.getPageSource().contains("Date SED Testing was Completed"));
	}

	@Then("^the download button title should read as 'Download SED Details'$")
	public void the_download_button_title_should_read_as_Download_SED_Details() throws Throwable {
		
	listingDetails_page.sed_details_accordion_open(driver);
	assertTrue(driver.getPageSource().contains("Download SED Details"));
	}
	
	@Then("^usability report text should read as 'Full Usability Report'$")
	public void usability_report_title_reads_as_Full_Usability_Report() throws Throwable {
		listingDetails_page.sed_details_accordion_open(driver);
		assertTrue(driver.getPageSource().contains("Full Usability Report"));
	}
	
	@Then("^the criteria number should also include the criteria title$")
	public void the_criteria_number_should_also_include_the_criteria_title() throws Throwable {
		listingDetails_page.sed_details_accordion_open(driver);
		
		WebElement Table_1 = listingDetails_page.SED_criteria_table(driver);
		List<WebElement> Rows = Table_1.findElements(By.tagName("tr"));
		System.out.println("No. of rows: "+Rows.size());
				  
		 //to print all the values inside the table
		 for(WebElement Row : Rows)
		 {
		  List<WebElement> Cols = Row.findElements(By.tagName("li"));
		  for (WebElement col : Cols) {
              System.out.print(col.getText() + "\t");
		  }
		  System.out.println();
		 }
	}
		
	@Then("^there should be text 'No Certification Criteria were tested for SED'$")
	public void there_should_be_text_No_Certification_Criteria_were_tested_for_SED() throws Throwable {
		listingDetails_page.sed_details_no_sed_data(driver);
		driver.getPageSource().contains("No Certification Criteria were tested for SED.");
		    System.out.println("No Certification Criteria were tested for SED.");
		    
		assertTrue(driver.getPageSource().contains("No Certification Criteria were tested for SED."));
	}

}

