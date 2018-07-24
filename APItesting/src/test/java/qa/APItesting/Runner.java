package qa.APItesting;

import io.restassured.http.ContentType; 
import io.restassured.response.Response; 
import io.restassured.response.ValidatableResponse; 
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*; 
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Runner{

private Response response;
private ValidatableResponse json;
private RequestSpecification request;

@Given("^a film exists with the Title Guardians of the Galaxy Two$")
public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
request = given().contentType(ContentType.JSON);
}
@Given("^a film exists with the Title IT$")
public void a_film_exists_with_the_Title_IT() {
request = given().contentType(ContentType.JSON);
}

@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
public void a_user_retrieves_the_film_by_title_Guardians_of_the_Galaxy_Two() {
response = request.when().get("http://www.omdbapi.com/?apikey=2917bac2&t=Guardians of the Galaxy Vol. 2");
}

@When("^a user retrieves the film by the title IT$")
public void a_user_retrieves_the_film_by_title_IT() {
response = request.when().get("http://www.omdbapi.com/?apikey=2917bac2&t=IT");
}

@Then("^the status code reads 200$")
public void the_status_code_reads(int statusCode) {
json = response.then().statusCode(200);
}

	
} 
