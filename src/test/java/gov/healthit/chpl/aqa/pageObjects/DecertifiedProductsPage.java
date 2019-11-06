package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class DecertifiedProductsPage definition.
 */
public final class DecertifiedProductsPage extends BasePage {
    private DecertifiedProductsPage() {}

    public static WebElement decertifiedProductsPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/div[2]/ui-view/div/div[1]/div/h1/ng-transclude"));
    }
}


