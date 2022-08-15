package apiTestingAssessment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TC002_getUserNamebyID {

	@Test
	public void getUserNamebyID() {
		
		int statuscode = 200;
		
		//Verification of Status Code response
		System.out.println("Started Execution of TC002_getUserNamebyID");
		given().
			when().
			get("https://jsonplaceholder.typicode.com/users").
		then().
			assertThat().
			statusCode(statuscode).
			log().status().
			
			//Verification of UserName by ID
			body("name[7]", equalTo("Nicholas Runolfsdottir V"));
			System.out.println("The Name of user for ID # 8 is: Nicholas Runolfsdottir V");
		
		System.out.println("Completed Execution of TC002_getUserNamebyID");
			
	}
}