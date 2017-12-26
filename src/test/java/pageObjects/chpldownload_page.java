package pageObjects;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import stepDefinitions.hooks;

public class chpldownload_page {
	
	private WebDriver driver;
	private static WebElement element = null;
	
	public static void print_page_title(WebDriver driver) {
		driver = hooks.driver;
		driver.manage().window().maximize();
		String actualTitle = driver.getTitle();
		System.out.println("page title is : "+actualTitle);
	}

	
	public static WebElement downloadselect_list(WebDriver driver){

		element = driver.findElement(By.xpath("//*[@id='downloadSelect']"));
		element.click();
		return element;
	}
	
}
