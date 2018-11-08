package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChplResourcesDropdownPage {
	private static WebElement element = null;
	public ChplResourcesDropdownPage() {
	}
	
/**
 * Returns button id of CHPL Resourced Dropdown
 * @param driver WebDriver
 * @return link element
 */
	 public static WebElement CHPLResourcesDropdown(final WebDriver driver) {
	        element = driver.findElement(By.id("resource-toggle"));
	        return element;
	    }
 /**
 * Returns button id of CHPL Resourced Dropdown
 * @param driver WebDriver
 * @return link element
	 */   
	    public static String ContactUsLink(final WebDriver driver) {
	    	element = driver.findElement(By.xpath("//a[@href='https://www.healthit.gov/form/healthit-feedback-form']"));
	    	return element.getText();
	    }
/**
 * Returns button id of CHPL Resourced Dropdown
 * @param driver WebDriver
 * @return link element
	 */   	    
	    public static String ContactUsLinkText(final WebDriver driver) {
	    	element = driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]"));	
	    	return element.getText();
	    } 
}
