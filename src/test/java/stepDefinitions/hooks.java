package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	
	public static WebDriver driver;
	
	 @Before
	  public void openbrowser() {
		
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver_win32\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	 
	  @After
	  public void afterMethod() {
		 // Close the driver
		  driver.quit();
	  }

	

}
