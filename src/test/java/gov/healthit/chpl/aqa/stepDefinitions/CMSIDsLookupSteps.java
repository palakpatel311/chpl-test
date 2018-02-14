package gov.healthit.chpl.aqa.stepDefinitions;
import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;
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
    private static final int TIMEOUT = 30;
    private String url = System.getProperty("url");
    
    /**
     * Constructor creates new driver.
     */
    
    public CMSIDsLookupSteps() {
    driver = Hooks.getDriver();
    if (StringUtils.isEmpty(url)) {
       url = "http://localhost:3000/";
      }
    }
    
    /**
     * To load CMS ID Reverse Lookup page 
     */
    
    @Given("^I am an end-user on CMS ID Reverse Lookup page$")
    public void i_am_an_end_user_on_CMS_ID_Reverse_Lookup_page() {
        driver.get(url + "#/resources/cms_lookup");
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
        driver.get(url + "#/search");
     }

    /**
     * Loads a listing. First searches for listing, then adds Cert Id to CMS creator.
     * Waits after adding each of the Cert Ids, then generates EHR certification Id.
     */
    
    @When("^I Generate CMS ID using CMS ID widget for same listings \"([^\"]*)\" and \"([^\"]*)\" as in result of reverse lookup$")
    public void i_Generate_CMS_ID_using_CMS_ID_widget_for_same_listings_and_as_in_result_of_reverse_lookup(String chplId1, String chplId2) {
             
        SearchPage.searchField(driver).sendKeys(chplId1);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        SearchPage.certId_Link1(driver).click();
              
        SearchPage.searchField(driver).clear();
        
        SearchPage.searchField(driver).sendKeys(chplId2);
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
        SearchPage.certId_Link2(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
      
        SearchPage.getEHR_certId(driver).click();
        wait.until(ExpectedConditions.elementToBeClickable(SearchPage.detailsLink(driver)));
      
     }

    /**
     * Assert Certification Id generated for listings with unverifiable CMS Id  matches newly generated CMS Id (reverse generation of Id)
     */    
    
    @Then("^the generated CMS ID should be \"(.*)\"$")
    public void the_generated_CMS_ID_should_be_given_cmsId(final String cmsId) {
        assertTrue(CMSidReverseLookupPage.CMSidCreatorWidget(driver).getText().contains(cmsId));
    }

}
