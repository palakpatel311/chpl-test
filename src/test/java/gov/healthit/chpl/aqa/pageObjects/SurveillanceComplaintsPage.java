package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class SurveillanceComplaintsPage definition.
 */
public final class SurveillanceComplaintsPage extends BasePage {
    private SurveillanceComplaintsPage() {}

    public static WebElement actions(final WebDriver driver) {
        return driver.findElement(By.id("actions"));
    }

    public static WebElement addNewComplaintLink(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/button"));
    }

    public static WebElement addComplaintFormTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/h2"));
    }

    public static WebElement associatedCriteriaValue(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[12]/div[1]/span"));
    }

    public static WebElement associatedListingValue(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[10]/div/span"));
    }

    public static WebElement associatedSurveillanceValue(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[11]/div/span"));
    }

    public static WebElement certifiedProductField(final WebDriver driver) {
        return driver.findElement(By.id("listings"));
    }

    public static WebElement complainantContactedCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("complainant-contacted"));
    }

    public static WebElement complaintsTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table"));
    }

    public static WebElement complainantType(final WebDriver driver) {
        return driver.findElement(By.id("complainant-type"));
    }

    public static WebElement closedDate(final WebDriver driver) {
        return driver.findElement(By.id("closed-date"));
    }

    public static WebElement criteriaField(final WebDriver driver) {
        return driver.findElement(By.id("criteria"));
    }

    public static WebElement deleteComplaintButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[17]/button[3]"));
    }

     public static WebElement developerContactedCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("developer-contacted"));
    }

    public static WebElement editComplaintButton(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/div/table/tbody/tr[63]/td[7]/button"));
    }

    public static WebElement flagForONCReviewCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("flag-for-onc-review"));
    }

    public static WebElement oncACBField(final WebDriver driver) {
        return driver.findElement(By.id("certification-body"));
    }

    public static WebElement oncACBComplaintId(final WebDriver driver) {
        return driver.findElement(By.id("acb-complaint-id"));
    }

    public static WebElement oncComplaintId(final WebDriver driver) {
        return driver.findElement(By.id("onc-complaint-id"));
    }

     public static WebElement oncATLContactedCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("onc-atl-contacted"));
    }

     public static WebElement saveButtonOnNewComplaintForm(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[16]/button[1]/i"));
    }

    public static WebElement saveButtonOnEditComplaintForm(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[17]/button[1]/i"));
    }

    public static WebElement surveillanceField(final WebDriver driver) {
        return driver.findElement(By.id("surveilances"));
    }

    public static WebElement summary(final WebDriver driver) {
        return driver.findElement(By.id("summary"));
    }

    public static WebElement receivedDate(final WebDriver driver) {
       return driver.findElement(By.id("received-date"));
   }

    public static WebElement yesToConfirmDelete(final WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
    }

}
