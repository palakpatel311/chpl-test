package pageObjects;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import stepDefinitions.hooks;

public class chpldownload_page {
	
	private WebDriver driver;
	private static WebElement element = null;
	
	public static WebElement downloadselect_list(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='downloadSelect']"));
		return element;
	}
	
	public static WebElement definitionselect_list(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"definitionSelect\"]"));
		return element;
	}
	
	public static WebElement login_menu_dropdown(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"login-toggle\"]/span[1]"));
		return element;
	}
	
	public static WebElement login_button(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"admin\"]/li/div/form/button[1]"));
		return element;
	}
	
}
