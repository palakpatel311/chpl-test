package gov.healthit.chpl.aqa.api.stepDefinitions;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/** Base class for step definition files. */
public class Base {

    private static String url = System.getProperty("url");
    private static String apikey = System.getProperty("apikey");
    private static String username;
    private static String password;
    /** Default constructor. */
    public Base() {

    }

    public static String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public static  String getApikey() {
        return apikey;
    }

    public void setApikey(final String apikey) {
        this.apikey = apikey;
    }

    public static String getAuth(String role) {
        switch (role) {
        case "ROLE_ADMIN":
            username = System.getProperty("roleAdminUsername");
            password = System.getProperty("roleAdminPassword");
            break;
        case "ROLE_ACB":
            username = System.getProperty("roleAcbUsername");
            password = System.getProperty("roleAcbPassword");
            break;
        case "ROLE_ONC":
            username = System.getProperty("roleOncUsername");
            password = System.getProperty("roleOncPassword");
            break;
        default:
            username = System.getProperty("roleAdminUsername");
            password = System.getProperty("roleAdminPassword");
            break;
        }
        RestAssured.baseURI = Base.getUrl();
        Response res = given()
                .header("API-KEY", Base.getApikey())
                .header("content-type", "application/json")
                .body("{\r\n"
                         + "  \"password\": \"" + password + "\",\r\n"
                        + "  \"userName\": \"" + username + "\"\r\n"
                        + "}")
                .when()
                .post("rest/auth/authenticate")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .extract().response();
        JsonPath js = res.jsonPath();
        String token = js.get("token");
        String auth = "Bearer " + token;
        return auth;
    }
}
