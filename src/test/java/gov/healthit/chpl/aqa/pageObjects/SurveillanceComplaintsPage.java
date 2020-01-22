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

    public static WebElement addNewComplaintButton(final WebDriver driver) {
        return driver.findElement(By.id("add-new-complaint"));
    }

    public static WebElement addComplaintFormTitle(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[1]/h2"));
    }

    public static WebElement associatedCriteriaValue(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[9]/div[1]/span"));
    }

    public static WebElement associatedListingValue(final WebDriver driver) {
        return driver.findElement(By.id("remove-listing-9360"));
    }

    public static WebElement associatedSurveillanceValue(final WebDriver driver) {
        return driver.findElement(By.id("remove-listing-831"));
    }

    public static WebElement certifiedProductField(final WebDriver driver) {
        return driver.findElement(By.id("listings"));
    }

    public static WebElement complainantContactedCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("complainant-contacted"));
    }

    public static WebElement complaintsTable(final WebDriver driver) {
        return driver.findElement(By.id("complaints-table"));
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
        return driver.findElement(By.cssSelector("a[title='Delete Complaint']"));
    }

     public static WebElement developerContactedCheckbox(final WebDriver driver) {
        return driver.findElement(By.id("developer-contacted"));
    }

    public static WebElement editComplaintButton(final WebDriver driver) {
        return driver.findElement(By.cssSelector("a[title='Edit Complaint']"));
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
        return driver.findElement(By.id("save-complaint"));
    }

    public static WebElement saveButtonOnEditComplaintForm(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"chpl-complaint\"]/div[18]/button[1]"));
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
