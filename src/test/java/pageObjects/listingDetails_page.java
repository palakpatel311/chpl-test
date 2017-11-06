package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.hooks;


public class listingDetails_page {
	
	private WebDriver driver;
	private static WebElement element = null;
	
	
	public static void load_listings_details_page(WebDriver driver) {
			driver = hooks.driver;
			driver.manage().window().maximize();
			String actualTitle = driver.getTitle();
			System.out.println("page title is : "+actualTitle);
		
	}
	
	public static void sed_details_accordion_open(WebDriver driver){
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")));
		
		// to close certification criteria accordion that's open by default
		WebElement expanded = driver.findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
		expanded.click();
		//to open SED accordion			
		WebElement expanded1 = driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)"));
		expanded1.click();
	}
	
	
	public static WebElement SED_criteria_table(WebDriver driver){

		element = driver.findElement(By.xpath("//*[@id='mainContent']/div[2]/div[2]/div/div/div[3]/div[2]/div/span/span[4]/table/thead/tr/th[1]"));
		return element;
	} 
	
	
}
	
	
	
	
	
	

