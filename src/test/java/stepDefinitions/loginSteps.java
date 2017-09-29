package stepDefinitions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginSteps {
	public WebDriver driver;
	
	public loginSteps()
	{
		driver = hooks.driver;
	
	}
	
	@Given("^User is on CHPL home page$")
	public void user_is_on_CHPL_home_page() throws Throwable {
	      
	    driver.get("https://chpl.ahrqdev.org/#/search");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^User clicks on Administrator Login button$")
	public void user_clicks_on_Administrator_Login_button() throws Throwable {
	    
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Administrator Login")).click();
	   
	}

	@Then("^login form shows in dropdown$")
	public void login_form_shows_in_dropdown() throws Throwable {
	   System.out.println("Login form open");
	   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	

	@Given("^User enters valid username and password$")
	public void User_enters_valid_username_and_password() throws Throwable {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("");
	   driver.findElement(By.id("password")).sendKeys("");
	  
	}

	@When("^User clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//button[contains(.,'Log In')]")).click();
	}
	
	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id=\"admin\"]/li[3]/a")).click();
	}
}
	





















	


	      









	   















  







	





	
	


