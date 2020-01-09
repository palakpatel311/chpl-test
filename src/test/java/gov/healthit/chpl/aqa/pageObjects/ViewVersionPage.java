package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ViewVersionPage definition.
 */
public final class ViewVersionPage extends BasePage {
    private ViewVersionPage() {
    }

    public static WebElement editVersionLink(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"version-component-edit-" + versionId + "\"]/i"));
    }

    public static WebElement editVersionField(final WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='version-name']"));
    }

    public static WebElement editVersionSaveButton(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"version-component-save-" + versionId + "\"]/i"));
    }

    public static WebElement lastModifiedDateOnVersionEdit(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-version-" + versionId + "\"]/span/span[2]/em"));
    }

    public static WebElement viewVersionPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//span[contains(text(),'View Version')]"));
    }

    public static WebElement viewSavedVersion(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-version-" + versionId + "\"]"));
    }

    public static WebElement mergeVersionLink(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"version-component-merge-" + versionId + "\"]/i"));
    }

    public static WebElement versionsToMergeMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]"
                + "/div/div/ui-view/chpl-developers/div/chpl-products/div/chpl-versions/div/div[2]/div[4]/div[1]"));
    }

    public static WebElement versionMissingErrorMessage(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-version-" + versionId + "\"]/span/div/div/div"));
    }

    public static WebElement splitVersionLink(final WebDriver driver, final String versionId) {
        return driver.findElement(By.xpath("//*[@id=\"version-component-split-" + versionId + "\"]/i"));
    }

    public static WebElement listingsMovingToNewVersionMessage(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]"
                + "/div/div/ui-view/chpl-developers/div/chpl-products/div/chpl-versions/div/div[2]/div[4]/div"));
    }
}

