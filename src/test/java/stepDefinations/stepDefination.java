package stepDefinations;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import Resources.APIResource;
import Resources.TestDataBuilder;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils{
	
	RequestSpecification Bookreq1;
	Response Bookresp1;
	ResponseSpecification Bookresp;
	Response response;
	TestDataBuilder data=new TestDataBuilder();
	static String id;
	
	@Given("AddBook Payload")
	public void add_book_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Bookreq1=given().spec(requestSpecification()).body(data.AddBookPayload());
		
	}
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String Resources, String method) {
	    // Write code here that turns the phrase above into concrete actions

		APIResource resourceAPI=APIResource.valueOf(Resources);
		System.out.println(resourceAPI.getResource());
		Bookresp= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
			response=Bookreq1.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response=Bookreq1.when().get(resourceAPI.getResource());
				
		}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response boday is {string}")
	public void in_response_boday_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyValue),ExpectedValue);		
	}
	
	@Then("Verify Id created map to {string} using {string}")
	public void verify_id_created_map_to_using(String ExpectedName, String Resources) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   id=getJsonPath(response,"ID");
	   Bookreq1=given().spec(requestSpecification()).queryParam("ID", id);
	   user_calls_with_http_request(Resources,"GET");
	  JsonPath js=new JsonPath(response.asString());
	  String ActualName=js.getString("[0].author");
	   assertEquals(ActualName,ExpectedName);

	}
	
	@Given("DeleteBook details")
	public void delete_book_details() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Bookreq1=given().spec(requestSpecification()).body(data.DeletBookPayload(id));
	}
	
	
}
