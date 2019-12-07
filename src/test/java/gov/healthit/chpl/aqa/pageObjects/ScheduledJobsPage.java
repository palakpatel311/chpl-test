package gov.healthit.chpl.aqa.pageObjects;

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

    public static WebElement typesOfSheduledJobsRoleAcb(final WebDriver driver) {
        WebElement webelement  = driver.findElement(By.xpath("//chpl-jobs-scheduled-jobs[@class='ng-isolate-scope']"));
        return webelement;
    }
}
