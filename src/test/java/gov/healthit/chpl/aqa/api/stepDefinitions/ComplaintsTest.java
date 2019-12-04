package gov.healthit.chpl.aqa.api.stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.stepDefinitions.Base;
import gov.healthit.chpl.aqa.stepDefinitions.Hooks;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ComplaintsTest {

	private Response response;
	private RequestSpecification request;
	
	@Given("^I set base URL$")
	public void setURL()  {
		RestAssured.baseURI=Base.getUrl() ;
	}

	@When("^I set Headers with API key and (.+)$")
	public void setHeaders(String authorization) {
    if (authorization.contentEquals("Valid")){
    	authorization=Hooks.getAuth();
    	request= given()
                .header("API-KEY", Base.getApikey())
                .header("content-type", "application/json")
                .header("Authorization", authorization);
    }
    else if (authorization.contentEquals("Invalid")){
    	request= given()
                .header("API-KEY", Base.getApikey())
                .header("content-type", "application/json");
    }
	}

	@And("^I send GET request to complaints resource \"([^\"]*)\"$")
    public void sendGetRequest(String resource) {
		response =request
	            .get(resource);
    }	

	@Then("^I verify the (.+)$")
	public void apiReturnsCorrectStatusCode(int statuscode) throws Throwable {
	    Assert.assertEquals(response.getStatusCode(), statuscode);
	}
	
}



