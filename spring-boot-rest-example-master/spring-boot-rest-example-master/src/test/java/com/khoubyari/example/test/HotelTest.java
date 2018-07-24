package com.khoubyari.example.test;

import static io.restassured.RestAssured.given;


import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class HotelTest {
	
	private RequestSpecification request; 
	private Response response;


@Test
	public void postSwagger() {

		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		//RequestSpecification request = RestAssured.given();
		request = given().contentType(ContentType.JSON);
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "Manchester Salford");
		requestParams.put("description", "This is a test 5");
		requestParams.put("name", "ANTHIA b");
		requestParams.put("rating", 5);
		System.out.println(request.body(requestParams.toString()));
		
		Response response = request.post("/");
		System.out.println(response.getStatusCode());
		



		}

	
	@Test
	public void deleteSwagger() {
		request = given().when().contentType(ContentType.JSON);
		Response response = request.delete("http://localhost:8090/example/v1/hotels/7");
		
	}
	
	
	
	@Test
	public void getSwagger() {
		request = given().when().contentType(ContentType.JSON);
		Response response = request.get("http://localhost:8090/example/v1/hotels");
		response.prettyPrint();
	}
	
	@Test
	public void putSwagger() {
		request = given().when().contentType(ContentType.JSON);
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "Manchester Salford");
		requestParams.put("description", "This is a test 5556665");
		requestParams.put("id", 1);
		requestParams.put("name", "ANTHIA c");
		requestParams.put("rating", 5);
		request.body(requestParams.toString());
		
		response = request.put("http://localhost:8090/example/v1/hotels/1");
		response = request.get("http://localhost:8090/example/v1/hotels/1");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	



}
