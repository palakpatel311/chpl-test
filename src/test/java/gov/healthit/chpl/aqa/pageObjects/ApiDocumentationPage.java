package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ApiDocumentationPage definition.
 */
public final class ApiDocumentationPage extends BasePage {
    private ApiDocumentationPage() {}

    public static WebElement apiDocumentationPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/ai-compare-widget/div[2]/ui-view/div/div[1]/div/h1/ng-transclude/ai-title"));
    }
}


