package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class UserManagementPage definition.
 */
public final class UserManagementPage extends BasePage {
    private UserManagementPage() {
    }

    public static WebElement impersonateRole(final WebDriver driver, final String impersonateRoleName) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + impersonateRoleName + "')]"));
    }
}
