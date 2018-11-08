package gov.healthit.chpl.aqa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChartsPage {
	private static WebElement element = null;
	public ChartsPage() {
	}

/**
 * Returns the 'href' link on ChartsPage.
 * @param driver WebDriver
 * @return link element
 */
	public static WebElement healthITFeedBackLink(final WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Health IT Feedback Form')]"));
		return element;
	}
	
/**
 * Returns the text for health IT Feedback link.
 * @param driver WebDriver
 * @return returns the element text 
 */
    public static String healthITFeedbackLinkText(final WebDriver driver) {
    	element = driver.findElement(By.xpath("//a[contains(text(),'Health IT Feedback Form')]")); 	
    	return element.getText();
    } 
}

