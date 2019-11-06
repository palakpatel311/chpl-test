package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SedInforFor2015Page definition.
 */
public final class SedInfoFor2015Page extends BasePage {
    private SedInfoFor2015Page() {}

    public static WebElement sedInfoFor2015PageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/div[2]/ui-view/div/div[1]/div/h1/ng-transclude"));
    }
}


