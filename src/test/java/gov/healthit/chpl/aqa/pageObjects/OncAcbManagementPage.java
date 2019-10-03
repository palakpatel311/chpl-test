package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class OncAcbManagementPage definition.
 */
public final class OncAcbManagementPage extends BasePage {
    private OncAcbManagementPage() {}

    public static WebElement oncACBManagementPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[contains(text(),'ONC-ACB Management')]"));
    }

    public static WebElement oncACBName(final WebDriver driver, final String oncAcbName) {
        return driver.findElement(By.partialLinkText(oncAcbName));
    }

    public static WebElement editONCACB(final WebDriver driver) {
        return driver.findElement(By.id("edit-organization"));
    }

    public static WebElement markRetirementStatus(final WebDriver driver) {
        return driver.findElement(By.id("organization-retired"));
    }

    public static WebElement retirementDate(final WebDriver driver) {
        return driver.findElement(By.id("retirement-date"));
    }

    public static WebElement saveONCACB(final WebDriver driver) {
        return driver.findElement(By.id("chpl-organization-save"));
    }

    public static WebElement retirementStatus(final WebDriver driver, final String retirementStatus) {
        return driver.findElement(By.xpath("//span[contains(text(),'Retired: " + retirementStatus + "')]"));
    }

    public static WebElement retirementDateIs(final WebDriver driver, final String retirementDate) {
        return driver.findElement(By.xpath("//span[contains(text(),'Retirement Date:" + retirementDate + "')]"));
    }

    public static WebElement errorMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/p"));
    }

    public static WebElement addressFirstLine(final WebDriver driver) {
        return driver.findElement(By.id("address-line-1"));
    }

    public static WebElement addressCity(final WebDriver driver) {
        return driver.findElement(By.id("address-city"));
    }

    public static WebElement addressState(final WebDriver driver) {
        return driver.findElement(By.id("address-state"));
    }

    public static WebElement addressZipCode(final WebDriver driver) {
        return driver.findElement(By.id("address-zipcode"));
    }

    public static WebElement addressCountry(final WebDriver driver) {
        return driver.findElement(By.id("address-country"));
    }

    public static WebElement fieldWebsite(final WebDriver driver) {
        return driver.findElement(By.id("organization-website"));
    }

    public static WebElement oncACBNameOnEditForm(final WebDriver driver) {
        return driver.findElement(By.id("organization-name"));
    }

    public static WebElement organizationsToggleNavLink(final WebDriver driver) {
        return driver.findElement(By.id("organizations-toggle"));
    }

    public static WebElement organizationsDropdownLinkToLoadACBManagementPage(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"organizations-dropdown-menu\"]/li[4]/a"));
    }
}
