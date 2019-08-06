package gov.healthit.chpl.aqa.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import gov.healthit.chpl.aqa.pageObjects.AnnouncementsPage;

/**
 * Class AnnouncementsSteps definition.
 */
public class AnnouncementsSteps extends Base {

    /**
     * Get user to the Announcements Page.
     **/
    @Given("^I navigate to the Announcements Management page$")
    public void navigateToAnnouncementsPage() {
        getDriver().get(getUrl() + "#/administration/announcements");
    }

    /**
     * Click Add Announcements on the Announcements page.
     **/
    @And("^I add an Announcement$")
    public void addAnnouncement() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", AnnouncementsPage.addAnnouncementsButton(getDriver()));
        AnnouncementsPage.addAnnouncementsButton(getDriver()).click();
    }

    /**
     * Clear the "Title/Announcement-Text/StartDate/EndDate" field and enter a value.
     * @param value to be entered
     * @param fieldName is the id of the field in the Add Announcements section
     **/
    @And("^I set the \"(.*)\" field to \"(.*)\"$")
    public void setField(final String fieldName, final String value) {
        AnnouncementsPage.announcementField(getDriver(), fieldName).clear();
        AnnouncementsPage.announcementField(getDriver(), fieldName).sendKeys(value);
        AnnouncementsPage.announcementField(getDriver(), fieldName).sendKeys(Keys.TAB);
    }

    /**
     * Click Cancel button in the Announcement section.
     **/
    @And("^I click cancel button in the Announcement section$")
    public void clickCancelButtonInAnnouncementSection() {
        WebElement link = AnnouncementsPage.cancelButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
    }

    /**
     * Click Save button in the Announcement section.
     **/
    @And("^I click save button in the Announcement section$")
    public void clickSaveButtonInAnnouncementSection() {
        WebElement link = AnnouncementsPage.saveButton(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        AnnouncementsPage.saveButton(getDriver()).click();
    }

    /**
     * Set the Announcement Text field.
     * @param fieldName is the name of the field in the Add Announcements section
     **/
    @And("^I set the \"(.*)\" field to today's date$")
    public void setAnnouncementTitleField(final String fieldName) {
        AnnouncementsPage.announcementField(getDriver(), fieldName).sendKeys(getCurrentDate());
    }

    /**
     * Get user to the Announcements Reports Page.
     **/
    @Given("^I navigate to the Announcements Reports page$")
    public void announcementsReportsPage() {
        getDriver().get(getUrl() + "/#/reports/announcements");
    }

    /**
     * Edit an existing announcement.
     **/
    @And("^I edit an existing Announcement$")
    public void editExistingAnnouncement() {
        AnnouncementsPage.editExistingAnnouncement(getDriver()).click();
    }

    /**
     * Delete an announcement.
     **/
    @And("^I delete an Announcement$")
    public void deleteAnnouncement() {
        WebElement link = AnnouncementsPage.deleteAnnouncement(getDriver());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", link);
        AnnouncementsPage.deleteAnnouncement(getDriver()).click();
    }

}

