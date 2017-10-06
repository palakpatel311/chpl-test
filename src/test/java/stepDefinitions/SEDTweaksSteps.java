package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SEDTweaksSteps {
	public WebDriver driver;
	
	public SEDTweaksSteps()
	{
		driver = hooks.driver;
		
	}
	
	@Given("^I am on a listing's details pages$")
	public void i_am_on_a_listing_s_details_pages() throws Throwable {
	    driver.get("https://chpl.ahrqstg.org/#/product/8481");
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		String actualTitle = driver.getTitle();
		System.out.println("page title is : "+actualTitle);
	    
	}

	@When("^I look at the accordions$")
	public void i_look_at_the_accordions() throws Throwable {
		driver.get("https://chpl.ahrqstg.org/#/product/8481");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
		String a1 = driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a1);
	    String a2 = driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a2);
	    String a3 = driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a3);
	    String a4 = driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a4);
	    String a5 = driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a5);
	    String a6 = driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText();
	    System.out.println("Accordion title:" +a6);
	    
	    
	}

	@Then("^I should see them in the following order: Criteria, CQMs, SED, G(\\d+)/G(\\d+), Surveillance, Additional Info$")
	public void i_should_see_them_in_the_following_order_Criteria_CQMs_SED_G_G_Surveillance_Additional_Info(int arg1, int arg2) throws Throwable {
		
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
		assertTrue(driver.findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));
		
	}

	@Given("^I am looking at a listing's SED details$")
	public void i_am_looking_at_a_listing_s_SED_details() throws Throwable {
		driver.get("https://chpl.ahrqstg.org/#/product/8481");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")));
		
	}

	@When("^I look at the SED Intended User Description$")
	public void i_look_at_the_SED_INtended_User_Description() throws Throwable {
		
	
		Thread.sleep(5000);
		WebElement expanded = driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
		expanded.click();
					
		WebElement expanded1 = driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)"));
		expanded1.click();
		
		if(driver.getPageSource().contains("No Certification Criteria were tested for SED."))
		    System.out.println("No Certification Criteria were tested for SED.");
		else
			driver.getPageSource().contains("Description of Intended Users");
	}

	@Then("^the header should be named Description of Intended Users$")
	public void the_header_should_be_named_Description_of_Intended_Users() throws Throwable {
	    
		assertTrue(
				driver.getPageSource().contains("Description of Intended Users"));
			
	}

	@When("^I look at the 'SED Testing Completion Date'$")
	public void i_look_at_the_SED_Testing_Completion_Date() throws Throwable {
		if(driver.getPageSource().contains("No Certification Criteria were tested for SED."))
		    System.out.println("No Certification Criteria were tested for SED.");
		else
			driver.getPageSource().contains("Date SED Testing was Completed");
	
	}

	@Then("^the header should be named 'Date SED Testing was Completed'$")
	public void the_header_should_be_named_Date_SED_Testing_was_Completed() throws Throwable {
	    assertTrue(
				driver.getPageSource().contains("Date SED Testing was Completed"));
	}

	@When("^I look at the download button$")
	public void i_look_at_the_download_button() throws Throwable {
	   driver.findElement(By.cssSelector(".panel-body > div:nth-child(1) > span:nth-child(1) > span:nth-child(5) > table:nth-child(2) > tfoot:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > button:nth-child(1)")).getTagName();
	
	}

	@Then("^the button should be named 'Download SED Details'$")
	public void the_button_should_be_named_Download_SED_Details() throws Throwable {
		assertTrue(
				driver.getPageSource().contains("Download SED Details"));
	}

	@When("^I look at the associated criteria$")
	public void i_look_at_the_associated_criteria() throws Throwable {
		driver.get("https://chpl.ahrqstg.org/#/product/8481");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")));
		
	}

	@Then("^the criteria number should also include the criteria title$")
	public void the_criteria_number_should_also_include_the_criteria_title() throws Throwable {
		Thread.sleep(5000);
		WebElement expanded = driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
		expanded.click();
					
		WebElement expanded1 = driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)"));
		expanded1.click();
		
		 WebElement Table_1 = driver.findElement(By.xpath("//*[@id='mainContent']/div[2]/div[2]/div/div/div[3]/div[2]/div/span/span[4]/table/thead/tr/th[1]"));
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
		
	

	@Given("^I am looking at listing's SED details$")
	public void i_am_looking_at_listing_s_SED_details() throws Throwable {
	    driver.get("https://chpl.ahrqstg.org/#/product/8482");
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")));
		
	}

	@Given("^present listing doesn't have SED$")
	public void present_listing_doesn_t_have_SED() throws Throwable {
		Thread.sleep(5000);
		WebElement expanded = driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
		expanded.click();
					
		WebElement expanded1 = driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)"));
		expanded1.click();
		
		driver.getPageSource().contains("No Certification Criteria were tested for SED.");
		    System.out.println("No Certification Criteria were tested for SED.");
		
	}

	@Then("^there should be text No Certification Criteria were tested for SED$")
	public void there_should_be_text_No_Certification_Criteria_were_tested_for_SED() throws Throwable {
		assertTrue(
				driver.getPageSource().contains("No Certification Criteria were tested for SED."));
	}

}

