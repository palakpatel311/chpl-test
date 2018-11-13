package gov.healthit.chpl.aqa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class UserRegistrationPage definition.
 */
public final class UserRegistrationPage {
    private static WebElement element = null;
    private UserRegistrationPage() {
    }
    /**
     * Returns link of Create New Account.
     * @param driver WebDriver
     * @return button link
     */
    public static WebElement createNewAccount(final WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='btn btn-link']"));
        return element;
    }

    /**
     * Returns the text or URL of Health IT Feedback Form.
     * @param driver Webdriver
     * @return the text or URL element
     */
    public static WebElement healthITFeedbackForm(final WebDriver driver) {
        return driver.findElement(By.xpath("//a[contains(text(),'Health IT Feedback Form')]"));
    }
}
