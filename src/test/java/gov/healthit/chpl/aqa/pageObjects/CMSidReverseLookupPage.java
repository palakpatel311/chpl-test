package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class CMSidReverseLookupPage definition.
 */
public class CMSidReverseLookupPage {
    
    private WebDriver driver;
    private static WebElement element = null;
    
    public static WebElement inputCertificationId(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"certIdsField\"]"));
        return element;
    }
    
    public static WebElement CertIdResultsTable_CHPLIdcolumn(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody"));
        return element;
    }
    
    public static WebElement CertIdResultsTable_CHPLIdcolumnrow1(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody/tr[1]/td[6]"));
        return element;
    }
    public static WebElement CertIdResultsTable_CHPLIdcolumnrow2(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"lookupCertIdResults\"]/tbody/tr[2]/td[6]"));
        return element;
    }
    
    public static WebElement CMSidCreatorWidget(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"widget-dropdown\"]/ai-cms-widget-display/div"));
        return element;
    }
    public static WebElement SearchLookupResults(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div/div/div/span/button/i"));
        return element;
    }
  
    
}
