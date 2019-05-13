package gov.healthit.chpl.aqa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class ProductHistoryEyePage definition.
 */
public final class ListingHistoryEyePage {
    private ListingHistoryEyePage() {
    }

    public static WebElement listingHistoryTable(final WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"product-history-table\"]/tbody"));
    }
}

