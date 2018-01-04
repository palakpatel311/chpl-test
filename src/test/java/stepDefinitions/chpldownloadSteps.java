package stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.chpldownload_page;
import pageObjects.listingDetails_page;
public class chpldownloadSteps {

	public WebDriver driver;
	
	public chpldownloadSteps()
	{
		driver = hooks.driver;
	}
	
	@Given("^user is on CHPL download page$")
	public void user_is_on_CHPL_home() throws Throwable {
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		assertTrue(driver.getTitle().contains("Download the CHPL"));
	}
	
	@When("^user is not logged in$")
	public void user_is_not_logged_in() throws Throwable {
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		chpldownload_page.login_menu_dropdown(driver).click();
		String actualString = chpldownload_page.login_button(driver).getText();
		assertTrue(actualString.contains("Log In"));
	}
	
	@Then("^user sees 7 download files")
	public void user_sees_7_download_files() throws Throwable {

	WebElement selectElement = chpldownload_page.downloadselect_list(driver);
	Select listBox = new Select(selectElement);
	int filecount = listBox.getOptions().size();
	Assert.assertEquals(filecount, 7);
	}
	
	@When("^user selects a file in download file box")
	public void user_selects_a_file_in_download_file_box() throws Throwable{
			
		WebElement selectBox = chpldownload_page.downloadselect_list(driver);
		Select dropdown = new Select(selectBox);
		dropdown.selectByVisibleText("2015 edition products (xml)");
	}
	
	@Then("^definition file shows based on download file selection$")
	public void definitio_file_shows_based_on_selection () throws Throwable{
		
		String definition = new Select(chpldownload_page.definitionselect_list(driver)).getFirstSelectedOption().getText();
		Assert.assertTrue(definition.contains("2015 edition products (xml) Definition File"));
	}
	
	@Given("^user is logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_is_logged_in_with_and(String arg1, String arg2) throws Throwable {
	    
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='login-toggle']")).click();
		
		// This part is currently not logging in user; login button click() is not working
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='admin']/li/div/form/button[1]")).click();
	}

		
	@Then("^user sees 8 download files")
	public void user_sees_8_download_files() throws Throwable {
		WebElement selectElement = chpldownload_page.downloadselect_list(driver);
		Select listBox = new Select(selectElement);
		int filecount1 = listBox.getOptions().size();
		Assert.assertEquals(filecount1, 8);
	}
}