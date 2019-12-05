package gov.healthit.chpl.aqa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ScheduledJobsPage definition.
 */
public final class ScheduledJobsPage extends BasePage {
    private ScheduledJobsPage() {
    }

    public static WebElement typesOfSheduledJobs(final WebDriver driver) {
        WebElement webelement  = driver.findElement(By.xpath("//table[@class='table table-condensed']//tbody"));
        return webelement;
    }

    public static List<WebElement> getRowElements(final WebElement row) {
        List<WebElement> roWebElements = row.findElements(By.tagName("tr"));
        return roWebElements;
    }

    public static List<WebElement> getColElements(final WebElement col) {
        List<WebElement> colElts = col.findElements(By.tagName("td"));
        return colElts;
    }
}
