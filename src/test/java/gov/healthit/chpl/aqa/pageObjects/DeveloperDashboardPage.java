package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class DeveloperDashboardPage definition.
 */
public final class DeveloperDashboardPage extends BasePage {
    private DeveloperDashboardPage() {
    }

    public static WebElement editDeveloperInformation(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='developer-component-edit']"));
    }

    public static WebElement editDeveloperWebsite(final WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='developer-website']"));
    }

    public static WebElement saveDeveloperInformation(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='developer-component-save']"));
    }

    public static WebElement changeRequestStatus(final WebDriver driver, final String requestStatus) {
        return driver.findElement(By.xpath("//td[contains(text(),'" + requestStatus + "')]"));
    }

    public static WebElement changeRequestSubmittedWebsite(final WebDriver driver) {
        return driver.findElement(By.xpath("//chpl-change-requests[@class='ng-scope ng-isolate-scope']//div[@class='panel-body']"));
    }

    public static WebElement changeRequestAction(final WebDriver driver, final String changeRequestAction) {
        return driver.findElement(By.xpath("//button[contains(text(),'" + changeRequestAction + "')]"));
    }

    public static WebElement goBackToChangeRequest(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[contains(text(),'Back to Change Request')]"));
    }

    public static WebElement withdrawChangeRequestReasonForChange(final WebDriver driver) {
        return driver.findElement(By.xpath("//textarea[@id='comment']"));
    }

    public static WebElement submitWithdrawChangeRequest(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class='btn btn-default']"));
    }

    public static WebElement withdrawChangeRequestMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("//p[@class='ng-binding']"));
    }

    public static WebElement withdrawChangeRequestTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[@class='panel-title ng-binding']"));
    }

    public static WebElement statusLogMetadata(final WebDriver driver) {
        return driver.findElement(By.xpath("//table[@class='table']//thead"));
    }

    public static WebElement editChangeRequestSubmittedWebsite(final WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='submitted-website']"));
    }

    public static WebElement saveEditedChangeRequest(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class='btn btn-default']"));
    }

    public static WebElement editChangeRequest(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[@class='panel-title ng-binding']"));
    }

    public static WebElement statusLog(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class='btn btn-default']"));
    }

    public static WebElement trackingTitle(final WebDriver driver, final String title) {
        return driver.findElement(By.xpath("//h2[@class='panel-title ng-binding'][contains(text(),'" + title + "')]"));
    }

    public static WebElement trackingMetadata(final WebDriver driver) {
        return driver.findElement(By.xpath("//table[@class='table table-vertical-align']//thead"));
    }

    public static WebElement changeStatusMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("//p[@class='ng-scope']"));
    }
}
