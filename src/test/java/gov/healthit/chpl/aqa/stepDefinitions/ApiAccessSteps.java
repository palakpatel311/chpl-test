package gov.healthit.chpl.aqa.stepDefinitions;
import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Class ApiAccessSteps definition. Used for Steps related to direct access to the API.
 */
public class ApiAccessSteps {
    private String url = System.getProperty("url");
    private String apikey = System.getProperty("apikey");

    /**
     * Set BaseUrl and other parameters.
     */
    public ApiAccessSteps() {

        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
        if (StringUtils.isEmpty(apikey)) {
            throw new IllegalArgumentException("Missing value for apikey!");
        }
    }

    /**
     * Runs API call requests using given end point to get certified product details and validate CHPL Id in response.
     * @param dbId is the database id of a listing to get listing details
     * @param chplId is expected CHPL ID in response
     */
    @Then("^the certified_product basic and details endpoints for \"([^\"]*)\" have the same CHPL ID: \"([^\"]*)\"$")
    public void validateResponseCP(final String dbId, final String chplId) {

        Response response = given()
                .header("API-KEY", apikey)
                .header("content-type", "application/json")
                .get(url + "rest/certified_products/" + dbId);

        // Get JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluatorC = response.jsonPath();

        // Get chplProductNumber from JSON response
        String chplProductNumberInBasic = jsonPathEvaluatorC.get("chplProductNumber");

        // Validate the response
        Assert.assertEquals(chplProductNumberInBasic, chplId, "CHPL ID is as expected");

        Response responseDetail = given()
                .header("API-KEY", apikey)
                .header("content-type", "application/json")
                .get(url + "rest/certified_products/" + dbId + "/details");

        JsonPath jsonPathEvaluator = responseDetail.jsonPath();

        String chplProductNumberInDetails = jsonPathEvaluator.get("chplProductNumber");

        Assert.assertEquals(chplProductNumberInDetails, chplId, "CHPL ID is as expected");
        Assert.assertEquals(chplProductNumberInBasic, chplProductNumberInDetails, "CHPL IDs match as expected");
    }

    /**
     * Runs API call request using given end point to get cache status in response.
     * @param expStatus is the expected status in response
     */
    @Then("^the cache_status endpoint returns status \"([^\"]*)\" for all caches are populated status$")
    public void validateResponseCacheStatus(final String expStatus) {

        Response response = given()
                .header("API-KEY", apikey)
                .header("content-type", "application/json")
                .get(url + "/rest/cache_status");

        JsonPath jsonPathEvaluator = response.jsonPath();
        String cacheStatus = jsonPathEvaluator.get("status");
System.out.println(cacheStatus);
        Assert.assertTrue(cacheStatus.equalsIgnoreCase(expStatus));
    }

}

