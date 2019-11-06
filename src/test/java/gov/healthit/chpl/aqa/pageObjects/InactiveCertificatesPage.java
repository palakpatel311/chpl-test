package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class InactiveCertificatesPage definition.
 */
public final class InactiveCertificatesPage extends BasePage {
    private InactiveCertificatesPage() {}

    public static WebElement inactiveCertificatesPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/div[2]/ui-view/div/div[1]/div/h1/ng-transclude/ai-title"));
    }
}


