package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class ComparePage definition.
 */
public final class ComparePage {
    private ComparePage() {}
    private static WebElement element = null;
    /**
     * Toggle for widget display.
     * @param driver WebDriver
     * @return the toggle
     */
    public static WebElement compareWidgetToggle(final WebDriver driver) {
        element = driver.findElement(By.id("compare-widget-toggle"));
        return element;
    }
    /**
     * Get the button that navigates to compare page.
     * @param driver WebDriver
     * @return the button
     */
    public static WebElement generateCmsIdButton(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"compare-widget-dropdown\"]/ai-compare-widget-display/div/div/a[1]"));
        return element;
    }

}
