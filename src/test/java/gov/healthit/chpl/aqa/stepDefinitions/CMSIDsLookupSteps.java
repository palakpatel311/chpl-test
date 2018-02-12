package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.CMSidReverseLookupPage;
import gov.healthit.chpl.aqa.pageObjects.SearchPage;

/**
 * Class CMSIDsLookupSteps definition.
 */
public class CMSIDsLookupSteps {

    private WebDriver driver;
    private static final int DELAY = 40;
        
    public CMSIDsLookupSteps() {
    driver = Hooks.getDriver();
    }
    
    /**
     * To load CMS ID Reverse Lookup page 
     */
    
    @Given("^I am an end-user on CMS ID Reverse Lookup page$")
    public void i_am_an_end_user_on_CMS_ID_Reverse_Lookup_page() {
        driver.get("https://chpl.ahrqstg.org/#/resources/cms_lookup");
        driver.manage().window().maximize();
    }

    /**
     * Lookup one of the 3 unverifiable CMS IDs on reverse lookup page 
     */
    
   @When("^I look up CMS ID \"(.*)\" in the reverse look-up tool$")
    public void I_look_up_CMS_ID_in_the_reverse_lookup_tool(final String cmsId){
        CMSidReverseLookupPage.inputCertificationId(driver).sendKeys(cmsId);
        CMSidReverseLookupPage.SearchLookupResults(driver).click();
    }
    
    /**
     * Asserts that listings returned in result are as expected  
     */

    @Then("^I should see the listings \"(.*)\" that make up the CMS ID$")
    public void i_should_see_the_listings_that_make_up_the_CMS_ID(final String chplId) throws Throwable {
        assertTrue(CMSidReverseLookupPage.CertIdResultsTable_CHPLIdcolumn(driver).getText().contains(chplId));
    }
    
    /**
     * Loads CHPL home/search page  
     */
    
    @Given("^I am an end user on CHPL home page$")
    public void i_am_an_end_user() throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/search");
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        driver.manage().window().maximize();
    }

    /**
     * Loads a listing. First searches for listing, then adds Cert Id to CMS creator.
     * Waits after adding each of the Cert Ids, then generates EHR certification Id.
     */
    
    @When("^I Generate CMS ID using CMS ID widget for same listings as in result of reverse lookup of 0015H8GK6K0ZZB2$")
    public void i_Generate_CMS_ID_using_CMS_ID_widget_for_same_listings_as_in_result_of_reverse_lookup_() throws Throwable{
        SearchPage.searchField(driver).sendKeys("14.07.07.2452.VEI1.01.01.0.161111");
        
        WebDriverWait wait = new WebDriverWait(driver, DELAY);
        SearchPage.certId_Link1(driver).click();
        
        SearchPage.searchField(driver).clear();
        SearchPage.searchField(driver).sendKeys("15.04.04.2891.Sunr.07.01.1.171201");
        
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
        SearchPage.certId_Link2(driver).click();
       
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
        
        SearchPage.getEHR_certId(driver).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
     }

    /**
     * Assert Certification Id generated for listings with unverifiable CMS Id  matches newly generated CMS Id (reverse generation of Id)
     */    
    
    @Then("^the generated CMS ID should be 0015H8GK6K0ZZB2$")
    public void the_generated_CMS_ID_should_be_0015H8GK6K0ZZB2() {
        assertTrue(CMSidReverseLookupPage.CMSidCreatorWidget(driver).getText().contains("0015H8GK6K0ZZB2"));
    }

}
