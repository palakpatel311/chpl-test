package RESTAssuredTests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.oracle.webservices.internal.api.message.ContentType;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;

public class APICallsTrailingslashUpdate {
	
	
	
	@Test
	public void testAPIcallswithoutlashes()
	{
		
				
		String url = "https://chpl.ahrqstg.org/rest/announcements/";
				
		        given()            
		        .header("API-KEY", "***")
		        .header("content-type", "application/json")
		        .header("Authorization", "Bearer token")
		        .when()
		        .get(url)
		        .then()
		        .log()
		        .all();
		      //  Assert.assertEquals(statusCode, 200, "Correct status code returned");
				
				//get("https://chpl.ahrqstg.org/rest/announcements/").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/certified_products").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/certified_products/").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/corrective_action_plan").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/corrective_action_plan/").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/key/").then().statusCode(200);
				//given().get("https://chpl.ahrqstg.org/rest/key").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/developers").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/developers/").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/products").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/products/").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/atls").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/atls/").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/users").then().statusCode(200).log().all();
				//given().get("https://chpl.ahrqstg.org/rest/users/").then().statusCode(200).log().all();
						
}
}
