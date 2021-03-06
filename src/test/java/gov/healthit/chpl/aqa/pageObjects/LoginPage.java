package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class LoginPage definition.
 */
public final class LoginPage extends BasePage {
    private LoginPage() {}
    private static WebElement element = null;

    /**
     * Returns log in button.
     * @param driver WebDriver
     * @return log in button element
     */
    public static WebElement loginButton(final WebDriver driver) {
        element = driver.findElement(By.cssSelector("[id^='login_']"));
        return element;
    }
    /**
     * Returns password text box element.
     * @param driver WebDriver
     * @return password input element
     */
    public static WebElement password(final WebDriver driver) {
        element = driver.findElement(By.name("password"));
        return element;
    }
    /**
     * Returns username text box element.
     * @param driver WebDriver
     * @return username input element
     */
    public static WebElement username(final WebDriver driver) {
        element = driver.findElement(By.name("username"));
        return element;
    }
    /**
     * Returns Welcome text that shows after successful login.
     * @param driver WebDriver
     * @return returns element that holds welcome text
     */
    public static WebElement loggedinUserName(final WebDriver driver) {
        element = driver.findElement(By.id("login-toggle"));
        return element;
    }
    /**
     * Returns admin login/logout pop up button.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement loginLogoutPopUp(final WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"login-toggle\"]"));
        return element;
    }

    public static WebElement adminLoginDropdown(final WebDriver driver) {
        element = driver.findElement(By.id("admin"));
        return element;
    }

    /**
     * Returns logout button on admin login pop up.
     * @param driver WebDriver
     * @return button element
     */
    public static WebElement logoutButton(final WebDriver driver) {
        element = driver.findElement(By.cssSelector("[id^='logout_']"));
        return element;
    }

}
