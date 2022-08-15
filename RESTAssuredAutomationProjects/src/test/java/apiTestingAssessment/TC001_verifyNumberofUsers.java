package apiTestingAssessment;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC001_verifyNumberofUsers {
	
	@Test
	public void verifyNumberofUsers() {
		
		int statuscode = 200;
		
		//Verification of Status Code response
		System.out.println("Started Execution of TC001_verifyNumberofUsers");
		given().
			when().
			get("https://jsonplaceholder.typicode.com/users").
		then().
			assertThat().
			statusCode(statuscode).
			log().status();
		
			//Verification of number of users
			Response res = given().when().get("https://jsonplaceholder.typicode.com/users");
			JsonPath js = new JsonPath(res.asString());
			int size = js.getInt("data.size()");
			assertEquals(size, 10);
			System.out.println("The total number of user is equal to: "+size);
        
        System.out.println("Completed Execution of TC001_verifyNumberofUsers");
		
	}
	

}
