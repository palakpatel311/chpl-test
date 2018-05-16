package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    /**
     * Class ManageDevelopersAndProductsPage definition.
     */
    public final class ManageDevelopersAndProductsPage {

        private ManageDevelopersAndProductsPage() {}
        private static WebElement element = null;

        /**
         * Returns Edit Certified Product link.
         * @param driver WebDriver
         * @return link element
         */
        public static WebElement editCertifiedProductLink(final WebDriver driver) {
            element = driver.findElement(By.linkText("Edit Certified Product"));
            return element;
        }

        /**
         * Returns element that holds date string.
         * @param driver WebDriver
         * @return date element
         */
        public static WebElement sedEndDateOfTesting(final WebDriver driver) {
            element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div/div[3]/div[5]/div/div/div/div[2]/span"));
            return element;
       }


}
