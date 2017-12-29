package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.listingDetails_page;
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
		search_page.search_field(driver).sendKeys(CHPL_ID);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		search_page.details_link(driver);
		search_page.disclosure_url(driver);		  
	}
	
	@When("^I look at Mandatory Disclosure URL$")
	public void i_look_at_Mandatory_Disclosure_URL() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/span/div[2]/h2"));		   
	}

	@Then("^it should show updated url$")
	public void it_should_show_updated_url() throws Throwable {
		search_page.disclosure_url(driver);
	}



}
