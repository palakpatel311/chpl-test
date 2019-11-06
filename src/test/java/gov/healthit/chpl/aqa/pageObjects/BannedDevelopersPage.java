package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class BannedDevelopersPage definition.
 */
public final class BannedDevelopersPage extends BasePage {
    private BannedDevelopersPage() {}

    public static WebElement bannedDevelopersPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/div[2]/ui-view/div/div[1]/div/h1/ng-transclude"));
    }
}


