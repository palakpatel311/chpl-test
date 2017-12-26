package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("details-sed")));
		
		// to close certification criteria accordion that's open by default
		listingDetails_page.certification_criteria_accordion(driver);
		
		//to open SED accordion			
		listingDetails_page.SED_accordion(driver);
	}
	
	public static WebElement edit_certified_product_link(WebDriver driver){
		element = driver.findElement(By.linkText("Return to search results"));
		element.click();
		return element;
	}
	
	public static WebElement SED_criteria_table(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='mainContent']/div[2]/div[2]/div/div/div[3]/div[2]/div/span/span[4]/table/thead/tr/th[1]"));
		return element;
	} 
	
	public static WebElement certification_criteria_a1_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div/div/span[2]/a"));
		element.click();
		
		return element;
	} 
	public static WebElement certification_criteria_c2_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[26]/div/div/span[2]/a"));
		element.click();
		return element;
	} 
	
	public static WebElement certification_criteria_c3_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[27]/div/div/span[2]/a"));
		element.click();
		return element;
	} 
	public static WebElement certification_criteria_c4_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[28]/div/div/span[2]/a"));
		element.click();
		return element;
	}
	
	public static WebElement certification_criteria_g4_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[53]/div/div/span[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		return element;
	}
	
	public static WebElement QMS_standard_text(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[53]/div/div/div/table/tbody/tr[3]/td[2]/ul/li")).getText();
		assertTrue(actualString.contains("Standard: ISO9001:2015"));
		return element;
	}
	
	public static WebElement certification_criteria_g5_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/span[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		return element;
	}
	
	public static WebElement Acceessibility_standard_text(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/div/table/tbody/tr[3]/td[2]/ul/li[1]")).getText();
		assertTrue(actualString.contains("Other - WCAG 2.0"));
		return element;
	}
	public static WebElement Acceessibility_standard_text2(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/div/table/tbody/tr[3]/td[2]/ul/li[2]")).getText();
		assertTrue(actualString.contains("Section 508 of the Rehabilitation Act"));
		return element;
	}
	public static WebElement certification_criteria_f1_view_details(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[53]/div/div/span[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		return element;
	}

	public static WebElement certification_criteria_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-certification-criteria"));
		element.click();
		return element;
	}
	
	public static WebElement CQM_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-cqm"));
		element.click();
		return element;
	}
	
	public static WebElement SED_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-sed"));
		element.click();
		return element;
	}
	
	public static WebElement UCD_process_text(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr/td[2]")).getText();
		assertTrue(actualString.contains("NISTIR 7741"));
		return element;
	}
	
	public static WebElement g1_g2_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-g1g2"));
		element.click();
		return element;
	}
	
	public static WebElement surveillance_Activities_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-surveillance-activities"));
		element.click();
		return element;
	}
	
	public static WebElement additional_info_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-additional-information"));
		element.click();
		return element;
	}
}