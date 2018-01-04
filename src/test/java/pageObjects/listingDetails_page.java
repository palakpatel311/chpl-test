package pageObjects;

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
	
		public static void sed_details_accordion_open(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("details-sed")));
		
		// to close certification criteria accordion that's open by default
		listingDetails_page.certification_criteria_accordion(driver);
		
		//to open SED accordion			
		listingDetails_page.SED_accordion(driver).click();
	}
	
	public static WebElement edit_certified_product_link(WebDriver driver){
		element = driver.findElement(By.linkText("Edit Certified Product"));
		element.click();
		return element;
	}
	
	public static WebElement SED_criteria_table(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]"));
		return element;
	} 
	
	public static WebElement certification_criteria_a1_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[1]/div/div/span[2]/a"));
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
		return element;
	}
	
	public static WebElement QMS_standard_text(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[53]/div/div/div/table/tbody/tr[3]/td[2]/ul/li"));
		return element;
	}
	
	public static WebElement certification_criteria_g5_view_details(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/span[2]/a"));
		return element;
	}
	
	public static WebElement Acceessibility_standard_text(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-certification-criteria\"]/div[54]/div/div/div/table/tbody/tr[3]/td[2]/ul/li[1]"));
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
		return element;
	}
	
	public static WebElement SED_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-sed"));
		return element;
	}
	
	public static WebElement UCD_process_text(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr/td[2]"));
		return element;
	}
	
	public static WebElement usability_report_title(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[1]/h4"));
		return element;
	}
	
	public static WebElement intended_user_description_title(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[2]/h4"));
		return element;
	}
	
	public static WebElement SED_testing_complete_date_title(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"panel-sed\"]/div/span/span[3]/h4"));
		return element;
	}
	
	public static WebElement download_SED_details_button(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-tasks-table\"]/tfoot/tr/td/button"));
		return element;
	}
	
	public static WebElement SED_certification_Criteria(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[1]"));
		return element;
	}
	
	public static WebElement SED_certification_Criteria2(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[2]"));
		return element;
	}
	
	public static WebElement SED_certification_Criteria3(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[3]"));
		return element;
	}
	public static WebElement SED_certification_Criteria4(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[4]"));
		return element;
	}
	
	public static WebElement SED_certification_Criteria5(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[5]"));
		return element;
	}
	public static WebElement SED_certification_Criteria6(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[6]"));
		return element;
	}
	public static WebElement SED_certification_Criteria7(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[7]"));
		return element;
	}
	public static WebElement SED_certification_Criteria8(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[8]"));
		return element;
	}
	public static WebElement SED_certification_Criteria9(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"sed-ucd-processes-table\"]/tbody/tr[1]/td[1]/ul/li[9]"));
		return element;
	}
	
	public static WebElement g1_g2_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-g1g2"));
		return element;
	}
	
	public static WebElement surveillance_Activities_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-surveillance-activities"));
		return element;
	}
	
	public static WebElement additional_info_accordion(WebDriver driver){
		element = driver.findElement(By.id("details-additional-information"));
		return element;
	}
}