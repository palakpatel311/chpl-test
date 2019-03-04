package gov.healthit.chpl.aqa.asserts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.ListingDetailsPage;
import gov.healthit.chpl.aqa.stepDefinitions.Base;
import gov.healthit.chpl.aqa.stepDefinitions.Hooks;

/**
 * Class ListingDetailsAsserts definition.
 */
public class ListingDetailsAsserts extends Base {

    /**
     * Asserts for correct data in Targeted User field.
     * @param targetedUser expected text
     */
    @Then("^Targeted Users should show correct data \"([^\"]*)\"$")
    public void verifyTargetedUserData(final String targetedUser) {
        String actualString = ListingDetailsPage.targetedUser(getDriver()).getText();
        assertTrue(actualString.contains(targetedUser), "Expect " + targetedUser + " to be found in " + actualString);
    }

    /**
     * Asserts for correct data in Accessibility Standard field.
     * @param accessibilityText expected text
     */
    @Then("^Accessibility Standard for criteria \"([^\"]*)\" should display \"([^\"]*)\"$")
    public void accessibilityStandardForCriteriaShouldDisplayUpdatedOtherWCAG(final String criteria, final String accessibilityText) {
        String actualString = ListingDetailsPage.accessibilityStandardByCriteriaText(getDriver(), criteria).getText();
        assertEquals(actualString, accessibilityText);
    }

    /**
     * Asserts that elements exist on the accordion.
     */
    @Then("^I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsExistOnDetailsPage() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("details-certification-criteria")));
        assertTrue(getDriver().findElement(By.id("details-certification-criteria")).getText().contains("Certification Criteria"));
        assertTrue(getDriver().findElement(By.id("details-cqm")).getText().contains("Clinical Quality Measures"));
        assertTrue(getDriver().findElement(By.id("details-sed")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(getDriver().findElement(By.id("details-g1g2")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(getDriver().findElement(By.id("details-surveillance-activities")).getText().contains("Surveillance Activities"));
        assertTrue(getDriver().findElement(By.id("details-additional-information")).getText().contains("Additional Information"));
    }

    /**
     * Asserts that elements are in the correct order on the accordion.
     */
    @Then("^I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info$")
    public void iShouldSeeTheAccordionsInTheFollowingOrderCriteriaCQMsSEDG1G2SurveillanceAdditionalInfo() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(2) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Certification Criteria"));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(3) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Clinical Quality Measures"));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Safety Enhanced Design (SED)"));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Successfully Tested G1/G2 Measures"));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Surveillance Activities"));
        assertTrue(getDriver().findElement(By.cssSelector("div.panel:nth-child(7) > div:nth-child(1) > a:nth-child(1)")).getText().contains("Additional Information"));
    }

    /**
     * Assert that the QMS Standard section has the passed in value.
     * @param qmsText expected text
     * @param number certification criteria
     */
    @Then("^QMS Standard should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void qmsStandardDisplaysCorrectText(final String qmsText, final String number) {
        String actualString = ListingDetailsPage.qmsStandardText(getDriver(), number).getText();
        assertTrue(actualString.contains(qmsText), "Expect " + qmsText + " to be found in " + actualString);
    }

    /**
     * Asserts that criteria should also have the title.
     */
    @Then("^the criteria number should also include the criteria title$")
    public void theCriteriaNumberShouldAlsoIncludeTheCriteriaTitle() {
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "1").getText(), "170.315 (a)(1): Computerized Provider Order Entry (CPOE) - Medications");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "2").getText(), "170.315 (a)(2): CPOE - Laboratory");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "3").getText(), "170.315 (a)(3): CPOE - Diagnostic Imaging");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "4").getText(), "170.315 (a)(4): Drug-Drug, Drug-Allergy Interaction Checks for CPOE");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "5").getText(), "170.315 (a)(5): Demographics");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "6").getText(), "170.315 (a)(6): Problem List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "7").getText(), "170.315 (a)(7): Medication List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "8").getText(), "170.315 (a)(8): Medication Allergy List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "9").getText(), "170.315 (a)(14): Implantable Device List");
        assertEquals(ListingDetailsPage.sedCertificationCriteria(getDriver(), "10").getText(), "170.315 (b)(3): Electronic Prescribing");
    }

    /**
     * Assert that Mandatory Disclosures URL exists and is correct.
     * @param targetUrl the URL value to assert
     */
    @Then("^the Mandatory Disclosures URL should be: \"(.*)\"$")
    public void theMandatoryDisclosuresUrlShouldBe(final String targetUrl) {
        String actualText = ListingDetailsPage.disclosureUrl(getDriver()).getText();
        assertTrue(actualText.contains(targetUrl), "Expect " + targetUrl + " to be found in " + actualText);
    }

    /**
     * Assert that Test Results Summary URL exists and is correct.
     * @param targetUrl the URL value to assert
     */
    @Then("^the Test Results Summary URL should be: \"(.*)\"$")
    public void theTestResultsSummaryUrlShouldBe(final String targetUrl) {
        String actualText = ListingDetailsPage.testResultsSummaryUrl(getDriver()).getText();
        assertTrue(actualText.contains(targetUrl), "Expect " + targetUrl + " to be found in " + actualText);
    }

    /**
     * Assert that UCD URL exists and is correct.
     * @param targetUrl the URL value to assert
     */
    @Then("^the UCD URL should be: \"(.*)\"$")
    public void ucdUrlShouldBe(final String targetUrl) {
        String actualText = ListingDetailsPage.ucdUrl(getDriver()).getText();
        assertTrue(actualText.contains(targetUrl), "Expect " + targetUrl + " to be found in " + actualText);
    }

    /**
     * Assert message when listing is not found.
     * @param notfoundText the text message to assert
     */
    @Then("^the page shows \"(.*)\" message$")
    public void verifyMessageonPage(final String notfoundText) {
        String actualString = ListingDetailsPage.mainContent(getDriver()).getText();
        assertTrue(actualString.contains(notfoundText), "Expect " + notfoundText + " to be found in " + actualString);
    }

    /**
     * Assert that Test Procedure text is as expected.
     * @param tpText expected text
     * @param number criteria to look in
     * @throws Exception if screenshot unable to be taken
     */
    @Then("^Test Procedure should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void testProcedureFieldShouldDisplay(final String tpText, final String number) throws Exception {
        try {
            String actualString = ListingDetailsPage.testProcedure(getDriver(), number).getText();
            assertTrue(actualString.contains(tpText), "Expect \"" + tpText + "\" to be found in \"" + actualString + "\"");
        } catch (NullPointerException npe) {
            Hooks.takeScreenshot(tpText + "_" + number);
            assertTrue(false, tpText + "_" + number + ": " + npe.getMessage());
        }
    }

    /**
     * Assert that Test tool text is as expected.
     * @param testToolName expected text
     * @param number criteria to look in
     * @param testToolVersion expected test tool version
     * @throws Exception if screenshot unable to be taken
     */
    @Then("^Test Tool should display \"([^\"]*)\" and \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void testToolFieldShouldDisplay(final String testToolName, final String testToolVersion, final String number) throws Exception {
        try {
            String actualString = ListingDetailsPage.testTool(getDriver(), number).getText();
            assertTrue(actualString.contains(testToolName), "Expect \"" + testToolName + "\" to be found in \"" + actualString + "\"");
            assertTrue(actualString.contains(testToolVersion), "Expect \"" + testToolVersion + "\" to be found in \"" + actualString + "\"");
        } catch (NullPointerException npe) {
            Hooks.takeScreenshot(testToolName + "_" + number);
            assertTrue(false, testToolName + "_" + number + ": " + npe.getMessage());
        }
    }

    /**
     * Assert that Functionality Tested is as expected.
     * @param functTested is expected text
     * @param number criteria to look in
     * @throws Exception if screenshot unable to be taken
     */
    @Then("^Functionality Tested should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void verifyFunctionalityTestedValue(final String functTested, final String number) throws Exception {
        try {
            String actualString = ListingDetailsPage.functionalityTested(getDriver(), number).getText();
            assertTrue(actualString.contains(functTested), "Expect \"" + functTested + "\" to be found in \"" + actualString + "\"");
        } catch (NullPointerException npe) {
            Hooks.takeScreenshot(functTested + "_" + number);
            assertTrue(false, functTested + "_" + number + ": " + npe.getMessage());
        }
    }

    /**
     * Assert that Privacy and Security Framework is as expected.
     * @param privacySecurity expected text
     * @param number criteria to look in
     * @throws Exception if screenshot unable to be taken
     */
    @Then("^Privacy and security Framework should display \"([^\"]*)\" for criteria \"([^\"]*)\"$")
    public void verifyPrivacySecurityFrameworkValue(final String privacySecurity, final String number) throws Exception {
        try {
            String actualString = ListingDetailsPage.privacySecurityFramework(getDriver(), number).getText();
            assertTrue(actualString.contains(privacySecurity), "Expect \"" + privacySecurity + "\" to be found in \"" + actualString + "\"");
        } catch (NullPointerException npe) {
            Hooks.takeScreenshot(privacySecurity + "_" + number);
            assertTrue(false, privacySecurity + "_" + number + ": " + npe.getMessage());
        }
    }

    /**
     * Assert that Listing Name is as expected.
     * @param lname expected text
     */
    @Then("^the listing name shows as \"([^\"]*)\"$")
    public void verifyListingName(final String lname) {
        String actualString = ListingDetailsPage.listingName(getDriver()).getText();
        assertEquals(actualString, lname);
    }

    /**
     * Assert that the UCD Process equals the passed in value.
     * @param ucdText expected text
     */
    @Then("^UCD process should display \"([^\"]*)\"$")
    public void ucdProcessShouldDisplayUpdatedUcdText(final String ucdText) {
        String actualString = ListingDetailsPage.ucdProcessText(getDriver()).getText();
        assertEquals(actualString, ucdText);
    }

    /**
     * Asserts correct text in SED section.
     * @param reportTitle expected text
     */
    @Then("^usability report text should read as \"([^\"]*)\"$")
    public void usabilityReportTitleReadsAsFullUsabilityReport(final String reportTitle) {
        String actualString = ListingDetailsPage.usabilityReportTitle(getDriver()).getText();
        assertTrue(actualString.contains(reportTitle), "Expect " + reportTitle + " to be found in " + actualString);
    }

    /**
     * Asserts for correct text in SED section.
     * @param userDescTitle expected text
     */
    @Then("^intended user description header should show as \"([^\"]*)\"$")
    public void theHeaderShouldBeNamedDescriptionOfIntendedUsers(final String userDescTitle) {
        String actualString = ListingDetailsPage.intendedUserDescriptionTitle(getDriver()).getText();
        assertTrue(actualString.contains(userDescTitle), "Expect " + userDescTitle + " to be found in " + actualString);
    }

    /**
     * Asserts correct text for download button.
     * @param downloadbtnTitle expected text for download button
     */
    @Then("^download button title should read as \"([^\"]*)\"$")
    public void theDownloadButtonTitleShouldReadAsDownloadSEDDetails(final String downloadbtnTitle) {
        String actualString = ListingDetailsPage.downloadSEDDetailsButton(getDriver()).getText();
        assertTrue(actualString.contains(downloadbtnTitle), "Expect " + downloadbtnTitle + " to be found in " + actualString);
    }

    /**
     * Asserts that this listing has no criteria tested for SED.
     * @param nodataText expected text
     */
    @Then("^there should be text \"([^\"]*)\"$")
    public void thereShouldBeTextNoCertificationCriteriaWereTestedForSED(final String nodataText) {
        String actualString = ListingDetailsPage.nosedData(getDriver()).getText();
        assertTrue(actualString.contains(nodataText), "Expect " + nodataText + " to be found in " + actualString);
    }

    /**
     * Asserts Measure Name for input value for G1/G2.
     * @param measureName expected text
     * @param number is criteria number
     * @param gOption for G1/G2 Measure selection
     */
    @Then("^Measure Successfully Tested for \"([^\"]*)\" should display \"([^\"]*)\" for \"([^\"]*)\"$")
    public void assertMeasureName(final String gOption, final String measureName, final String number) {

        if (gOption.equals("G1")) {
            String actualString = ListingDetailsPage.gMeasureName(getDriver(), number, "G1").getText();
            assertTrue(actualString.contains(measureName), "Expect " + measureName + " to be found in " + actualString);
        } else {
            String actualString = ListingDetailsPage.gMeasureName(getDriver(), number, "G2").getText();
            assertTrue(actualString.contains(measureName), "Expect " + measureName + " to be found in " + actualString);
        }
    }

    /**
     * Asserts Measure required text and associated criteria show correct.
     * @param mName expected text
     * @param reqTest is expected toggle tip text
     * @param criteria is criteria number
     */
    @Then("^the Required Test shows as \"([^\"]*)\" for \"([^\"]*)\" and associated criteria \"([^\"]*)\"$")
    public void requiredTestValidationBasedOnMeasureName(final String reqTest, final String mName, final String criteria) {
        String actualString = ListingDetailsPage.measureNameForReqTest(getDriver(), reqTest).getText();
        assertTrue(actualString.contains(mName), "Expect \"" + mName + "\" to be found in \"" + actualString + "\"");
        String associatedCriteria = ListingDetailsPage.associatedCriteria(getDriver(), mName).getText();
        assertTrue(associatedCriteria.contains(criteria), "Expect " + criteria + " to be found in " + associatedCriteria);
    }

    /**
     * Asserts text on product history pop up.
     */
    @Then("^I click the 'Eye'$")
    public void iClickEye() {
        ListingDetailsPage.productHistoryEye(getDriver()).click();
    }

    /**
     * Asserts text on product history pop up.
     * @param historyText is expected text on pop up
     */
    @Then("^the 'Eye' pop-up opens to show Product History \"(.*)\"$")
    public void eyePopupShowsText(final String historyText) {
        boolean isFound = false;

        WebElement table = ListingDetailsPage.productHistoryTable(getDriver());
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(1).getText().equals(historyText)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "Text: " + historyText + " not found");
    }

    /**
     * Asserts text on product history pop up.
     * @param htext is expected text on pop up
     */
    @Then("^the 'Eye' pop-up opens to show appropriate text \"(.*)\"$")
    public void eyeShowsExpectedText(final String htext) {
        String expectedText = ListingDetailsPage.productHistoryText(getDriver()).getText();
        assertTrue(expectedText.contains(htext), "Expect " + htext + " to be found in " + expectedText);
    }

    /**
     * Assert text in CQM panel.
     * @param cqm is CMS number
     */
    @Then("^I see newly added CQMs \"([^\"]*)\"$")
    public void opencqmPanel(final String cqm) {
        boolean isFound = false;

        WebElement table = ListingDetailsPage.cqmDataTable(getDriver());
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            if (cols.get(1).getText().equals(cqm)) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "Text: " + cqm + " not found");
    }

    /**
     * Assert CHPL Product number is correct.
     * @param expectedProductNumber is CHPL Expected Product number
     */
    @Then("^the correct CHPL Product number \"([^\"]*)\" is displayed$")
    public void correctCHPLProductNumber(final String expectedProductNumber) {
        String productNumber = ListingDetailsPage.productNumber(getDriver()).getText();
        assertTrue(productNumber.contains(expectedProductNumber), "Expected product number [ " + expectedProductNumber + " ] but found [ " + productNumber + " ]");
    }

}
