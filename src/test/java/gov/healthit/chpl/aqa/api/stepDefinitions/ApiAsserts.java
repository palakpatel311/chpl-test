package gov.healthit.chpl.aqa.api.stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;

/**
 * Class ApiAsserts definition.
 */
public class ApiAsserts extends Base {
    /**
     * Validates the status code for given endpoint.
     * @param apiEndpoint is the CHPL API
     * @param expStatus is the expected status in response
     */
    @Then("^the \"([^\"]*)\" endpoint returns correct \"([^\"]*)\"$")
    public void apiReturnsCorrectStatusCode(final String apiEndpoint, final int expStatus) {

        Response response = given()
                .header("API-KEY", Base.getApikey())
                .header("content-type", "application/json")
                .get(getUrl() + "rest" + apiEndpoint);

        Assert.assertEquals(response.getStatusCode(), expStatus);
    }
}
