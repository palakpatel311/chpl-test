package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class AnnouncementsPage definition.
 */
public final class AnnouncementsPage extends BasePage {
    private AnnouncementsPage() {}

    public static WebElement annoouncementsPageTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//h2[contains(text(),'Announcements')]"));
    }

    public static WebElement annoouncementsColumnName(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/ui-view/chpl-announcements/div/div"));
    }

    public static WebElement addAnnouncementsButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
    }

    public static WebElement announcementField(final WebDriver driver, final String fieldName) {
        return driver.findElement(By.xpath("//input[@id='" + fieldName + "']"));
    }

    public static WebElement errorMessage(final WebDriver driver, final String errorMessage) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + errorMessage + "')]"));
    }

    public static WebElement cancelButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='announcement-cancel']"));
    }

    public static WebElement saveButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='announcement-create']"));
    }

    public static WebElement savedAnnouncementInformatoin(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/ui-view/chpl-announcements/div/div"));
    }

    public static WebElement announcementReportDetails(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/ui-view/chpl-reports-announcements/div"));
    }

    public static WebElement editExistingAnnouncement(final WebDriver driver) {
        return driver.findElement(By.xpath("//tr[2]//td[6]//button[1]"));
    }

    public static WebElement deleteAnnouncement(final WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id='announcement-delete']"));
    }

}

