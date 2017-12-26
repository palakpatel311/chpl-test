package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.chpldownload_page;
public class chpldownloadSteps {

	public WebDriver driver;
	
	public chpldownloadSteps()
	{
		driver = hooks.driver;
		
	}
	
	@Given("^User is on CHPL home$")
	public void user_is_on_CHPL_home() throws Throwable {
		driver.get("https://chpl.ahrqdev.org/#/search");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		chpldownload_page.print_page_title(driver);
	}
	
	@When ("^User clicks on CHPL Resources button$")
	public void user_clicks_on_CHPL_Resources_button() throws Throwable {
		
		//driver.findElement(By.xpath("//*[@id='resource-toggle']")).click();
		//driver.findElement(By.xpath("//*[@id='resource-dropdown-menu']/li[4]/a")).click();
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
	}
	
	@Then("^Download the CHPL page loads successfully and page title shows correct$")
	public void download_the_CHPL_page_loads_successfully_and_page_title_shows_correct() throws Throwable {
	    
		chpldownload_page.print_page_title(driver);
	}

	@Given("^user is not logged in$")
	public void user_is_not_logged_in() throws Throwable {
	System.out.println("user is not logged in");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@When("^user clicks on download file box$")
	public void user_clicks_on_download_file_box() throws Throwable {
		try {
	driver.get("https://chpl.ahrqdev.org/#/resources/download");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	WebElement selectBox = chpldownload_page.downloadselect_list(driver);
	Select dropdown = new Select(selectBox);
    List<WebElement> options = dropdown.getOptions();
    for(int i=0;i<options.size();i++)
    {
       System.out.println("Display Text : " + options.get(i).getText());
    }   

}catch(Exception e){e.printStackTrace();}
}
		
	
	@Then("^user sees 7 download files")
	public void user_sees_7_download_files() throws Throwable {
		
		WebElement element=chpldownload_page.downloadselect_list(driver);
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		System.out.println("Number of download files: " +list.size());
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
	}
	
	@When("^user selects a file in download file box")
	public void user_selects_a_file_in_download_file_box() throws Throwable{
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement selectBox = chpldownload_page.downloadselect_list(driver);
		Select dropdown = new Select(selectBox);
		dropdown.selectByVisibleText("2015 edition products (xml)");
	}
	
	@Then("^definition file shows based on download file selection$")
	public void definitio_file_shows_based_on_selection () throws Throwable{
	
		WebElement selectBox2 = chpldownload_page.downloadselect_list(driver);
		Select definition = new Select(selectBox2);
		List<WebElement> definitionOptions = definition.getOptions();
		System.out.println("Number of definition files: " +definitionOptions.size());
		for(int i=0;i<definitionOptions.size();i++)          
	    {
	        System.out.println(definitionOptions.get(i).getText());
	    }
		
	}
	
	@Given("^user is logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_is_logged_in_with_and(String arg1, String arg2) throws Throwable {
	    
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='login-toggle']")).click();
		Thread.sleep(100);
		// This part is currently not logging in user; login button click() is not working
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='admin']/li/div/form/button[1]")).click();
		  
	}

	@When("^User checks download file box$")
	public void user_checks_download_file_box() throws Throwable {
		
}
	
	@Then("^user sees 8 download files")
	public void user_sees_8_download_files() throws Throwable {
		
		WebElement element=chpldownload_page.downloadselect_list(driver);
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		System.out.println("Number of download files: " +list.size());
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }
	
	}

	
	
}
