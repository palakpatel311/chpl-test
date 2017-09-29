package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class chpldownloadSteps {

	public WebDriver driver;
	
	public chpldownloadSteps()
	{
		driver = hooks.driver;
		
	}
	
	@Given("^User is on CHPL home$")
	public void user_is_on_CHPL_home() throws Throwable {
		driver.get("https://chpl.ahrqdev.org/#/search");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		     
	}
	
	@When ("^User clicks on CHPL Resources button$")
	public void user_clicks_on_CHPL_Resources_button() throws Throwable {
		
		//driver.findElement(By.xpath("//*[@id='resource-toggle']")).click();
		//driver.findElement(By.xpath("//*[@id='resource-dropdown-menu']/li[4]/a")).click();
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().window().maximize();
	}
	
	
	@Then("^Download the CHPL page loads successfully and page title shows correct$")
	public void download_the_CHPL_page_loads_successfully_and_page_title_shows_correct() throws Throwable {
	    
		String actualTitle = driver.getTitle();
		System.out.println("page title is : "+actualTitle);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

<<<<<<< HEAD
=======
	
>>>>>>> dcf5c39dbbdf1f150438590c352a08580d7453e4
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
	
	WebElement selectBox = driver.findElement(By.xpath("//*[@id='downloadSelect']"));
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
		
		WebElement element=driver.findElement(By.name("downloadSelect"));
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
		
		WebElement selectBox = driver.findElement(By.xpath("//*[@id='downloadSelect']"));
		Select dropdown = new Select(selectBox);
		dropdown.selectByVisibleText("2015 edition products (xml)");
	}
	
	@Then("^definition file shows based on download file selection$")
	public void definitio_file_shows_based_on_selection () throws Throwable{
	
		WebElement selectBox2 = driver.findElement(By.xpath("//*[@id='definitionSelect']"));
		Select definition = new Select(selectBox2);
		List<WebElement> definitionOptions = definition.getOptions();
		System.out.println("Number of definition files: " +definitionOptions.size());
		for(int i=0;i<definitionOptions.size();i++)          
	    {
	        System.out.println(definitionOptions.get(i).getText());
	    }
		
	}
	
	@Given("^user is logged in$")
	public void user_is_logged_in() throws Throwable {
	    
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='login-toggle']")).click();
		Thread.sleep(100);
		// This part is currently not logging in user; login button click() is not working
		driver.findElement(By.id("username")).sendKeys("****");
		driver.findElement(By.id("password")).sendKeys("****");
		driver.findElement(By.xpath("//*[@id='admin']/li/div/form/button[1]")).click();
			
	  
	}

	
	@Then("^user sees 8 download files$")
	public void user_sees_download_files(int arg1) throws Throwable {
		driver.get("https://chpl.ahrqdev.org/#/resources/download");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement element=driver.findElement(By.name("downloadSelect"));
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		System.out.println("Number of download files: " +list.size());
		for(int i=0;i<list.size();i++)          
		    {
		        System.out.println(list.get(i).getText());
		    }

	}

	
	
}
