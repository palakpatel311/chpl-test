package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ChartsPage definition.
 */
public final class ChartsPage extends BasePage {
    private ChartsPage() {
    }

    /**
     * Returns element that hold Health IT Feedback Form.
     * @param driver WebDriver
     * @return text element or URL
     */
    public static WebElement chartsHealthITFeedback(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(),'Health IT Feedback Form')]"));
    }
}

