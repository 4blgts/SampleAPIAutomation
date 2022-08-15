package apiTestingAssessment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;

public class TC003_verifyUserPostRequest {
	
	@Test
	public void verifyUserPostRequest() {
		
		
		//Start of test
		System.out.println("TC003_verifyUserPostRequest");
		
		//Mapping of Request variables

		JSONObject request = new JSONObject();
		
		request.put("name", "Elon Musk");
		request.put("username", "EMusk");
		request.put("email", "teslaman@email.com");
		
		System.out.println(request);
		
		given().
			header("Content-Type", "application/json; charset=UTF-8").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("https://jsonplaceholder.typicode.com/users").
		then().
			statusCode(201).
			log().all();
		
		//Verify if data was posted
		given().
			when().
			get("https://jsonplaceholder.typicode.com/users").
		then().
			log().all();
		
	}
}