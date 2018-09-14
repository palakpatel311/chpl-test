package gov.healthit.chpl.aqa.RESTAssuredTests;
import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Class VerifyEndpointHasCorrectData definition.
 */
public class VerifyEndpointHasCorrectData {
    private String url = System.getProperty("url");
    private String apikey = System.getProperty("apikey");

    /**
     * Set BaseUrl and other parameters.
     */
    public VerifyEndpointHasCorrectData() {

        if (StringUtils.isEmpty(url)) {
            url = "http://localhost:3000/";
        }
        if (StringUtils.isEmpty(apikey)) {
            throw new IllegalArgumentException("Missing value for apikey!");
        }
    }

    /**
     * Runs API call requests using given endpoint to get certified product details and validate chpl Id in response.
     * @param dbId is the database id of a listing to get listing details
     * @param chplId is expected CHPL ID in response
     */
    @Given("^I send request for product details using basic information product endpoint with \"([^\"]*)\" then I should get correct \"([^\"]*)\" in response$")
    public void validateResponseCP(final String dbId, final String chplId) {

        Response response = given()
        .header("API-KEY", apikey)
        .header("content-type", "application/json")
        .get(url + "/rest/certified_products/" + dbId);

        // Get JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluatorC = response.jsonPath();

        // Get chplProductNumber from JSON response
        String chplProductNumberInBasic = jsonPathEvaluatorC.get("chplProductNumber");

        // Validate the response
        Assert.assertEquals(chplProductNumberInBasic, chplId, "CHPL ID is as expected");

        Response responseDetail = given()
                .header("API-KEY", apikey)
                .header("content-type", "application/json")
                .get(url + "/rest/certified_products/" + dbId + "/details");

                JsonPath jsonPathEvaluator = responseDetail.jsonPath();

                String chplProductNumberInDetails = jsonPathEvaluator.get("chplProductNumber");

                Assert.assertEquals(chplProductNumberInDetails, chplId, "CHPL ID is as expected");
                Assert.assertEquals(chplProductNumberInBasic, chplProductNumberInDetails, "CHPL IDs match as expected");
    }
}
