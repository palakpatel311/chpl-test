package gov.healthit.chpl.aqa.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    /**
     * Class ManageDevelopersAndProductsPage definition.
     */
    public final class ManageDevelopersAndProductsPage extends BasePage {

        private ManageDevelopersAndProductsPage() {}

        /**
         * Returns Edit Certified Product link.
         * @param driver WebDriver
         * @return link element
         */
        public static WebElement editCertifiedProductLink(final WebDriver driver) {
            return driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div[3]/div[5]/div/div/div/div[1]/span[2]/span/a"));
        }

        /**
         * Returns element that holds date string.
         * @param driver WebDriver
         * @return date element
         */
        public static WebElement sedEndDateOfTesting(final WebDriver driver) {
            return driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div[3]/div[5]/div/div/div/div[2]/span"));
       }

        /**
         * Returns the element that holds version number for CQM.
         * @param driver WebDriver
         * @param cqm is CQM Name
         * @return version element
         * return null if version was not found in version list
         */
        public static WebElement cmsVersion(final WebDriver driver, final String cqm) {
            WebElement table = driver.findElement(By.xpath("//*[@id=\"panel-cqm\"]/table/tbody"));
            ArrayList<WebElement> rows = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                ArrayList<WebElement> cols = (ArrayList<WebElement>) row.findElements(By.tagName("td"));
                if (cols.get(1).getText().equalsIgnoreCase(cqm)) {
                    return cols.get(0);
                }
            }
            return null;
        }
}
