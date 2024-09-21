package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import Pojo.payload;
import Pojo.payloadFields;
import Pojo.payloadIssueType;
import Pojo.payloadProject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JiraIssue extends Utils{
ResponseSpecification resSpec;
RequestSpecification res;
Response response;

TestDataBuild databuild = new TestDataBuild();


// Instantiate the POJO class with test data
@Given("User Create Issue Payload")
public void user_create_issue_payload() throws IOException {
	 res = given().spec(RequestSpecification()).body(databuild.paylaodData());
}


@When("User calls CreateIssue API with Post http request")
public void user_calls_create_issue_api_with_post_http_request() throws FileNotFoundException {
	response = res.when().post("/rest/api/2/issue").then().spec(ResponseSpecification()).extract().response();
	System.out.println(response);
}

@Then("the API call should get success message with Status Code {int}")
public void the_api_call_should_get_success_message_with_status_code(Integer int1) {
    assertEquals(response.getStatusCode(), 201);
	
}

@Given("User Create Issue Payload with {string} and {string}")
public void user_create_issue_payload_with_and(String description, String summary) throws IOException {
	 res = given().spec(RequestSpecification()).body(databuild.paylaodData(description, summary));
}


@When("User calls {string} API with {string} http request")
public void user_calls_api_with_http_request(String string1, String string2) throws IOException {
	APIResources k = APIResources.valueOf(string1);
	System.out.println(k.getResource());
	String getResource = k.getResource();
	if(string2.equals("Post")){
		response = res.when().post(getResource).then().spec(ResponseSpecification()).extract().response();
	}
	else if(string2 .equals("Get")) {
		response = res.when().get(getResource).then().spec(ResponseSpecification()).extract().response();
	}

}





}
