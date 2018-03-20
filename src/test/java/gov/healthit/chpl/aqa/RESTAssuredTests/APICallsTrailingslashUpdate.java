package gov.healthit.chpl.aqa.RESTAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

/**
 * APICallsTrailingslashUpdate Class.
 */
public class APICallsTrailingslashUpdate {
    /**
     * Send Header values Content-Type, API-KEY and Authentication token.
     * Test response for API calls.
     */
    @Test
    public void testAPIcallswithoutslashes() {
        final int goodResponse = 200;
        given()
            .header("API-KEY", "***")
            .header("content-type", "application/json")
            .header("Authorization", "Bearer token")
            .when()
            .get("https://chpl.ahrqstg.org/rest/announcements/")
            .then()
            .log()
            .all();
        //Assert.assertEquals(statusCode, 200, "Correct status code returned");
        given().get("https://chpl.ahrqstg.org/rest/announcements").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/certified_products").then().statusCode(goodResponse);
        given().get("https://chpl.ahrqstg.org/rest/certified_products/").then().statusCode(goodResponse);
        given().get("https://chpl.ahrqstg.org/rest/corrective_action_plan").then().statusCode(goodResponse);
        given().get("https://chpl.ahrqstg.org/rest/corrective_action_plan/").then().statusCode(goodResponse);
        given().get("https://chpl.ahrqstg.org/rest/key/").then().statusCode(goodResponse);
        given().get("https://chpl.ahrqstg.org/rest/key").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/developers").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/developers/").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/products").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/products/").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/atls").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/atls/").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/users").then().statusCode(goodResponse).log().all();
        given().get("https://chpl.ahrqstg.org/rest/users/").then().statusCode(goodResponse).log().all();
    }
}
