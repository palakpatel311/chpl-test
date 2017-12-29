package pageObjects;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.hooks;

public class search_page {
	private WebDriver driver;
	private static WebElement element = null;
	
	public static WebElement search_field(WebDriver driver){
		element = driver.findElement(By.id("searchField"));
		return element;
	}
	public static WebElement search_results_chpl_id(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id='resultsSection']/div[2]/div/table/tbody/tr/td[6]")).getText();
		assertTrue(actualString.contains("14.07.07.1221.FIA1.16.01.1.170608"));
		return element;
	}
	
	public static WebElement details_link(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\'resultsSection\']/div[2]/div/table/tbody/tr/td[8]/div/div[1]/a"));
		element.click();
		return element;
	}
	
	public static WebElement disclosure_url(WebDriver driver){
		String actualString = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/span/div[2]/a")).getText();
		assertTrue(actualString.contains("cehrt-disclosure-information"));
		System.out.println(actualString);
		return element;
	}
	
}
