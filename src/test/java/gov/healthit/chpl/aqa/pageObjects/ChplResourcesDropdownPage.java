package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class ChplResourcesDropDown definition.
 */
public final class ChplResourcesDropdownPage {
    private ChplResourcesDropdownPage() {
    }

    /**
     * Returns button id of CHPL Resources Dropdown.
     * @param driver WebDriver
     * @return id element
     */
    public static WebElement chplResourcesDropdown(final WebDriver driver) {
        return driver.findElement(By.id("resource-toggle"));
    }

    /**
     * Returns URL of Contact Us Link.
     * @param driver WebDriver
     * @return URL element
     * */
    public static WebElement contactUsURL(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]"));
    }
}
