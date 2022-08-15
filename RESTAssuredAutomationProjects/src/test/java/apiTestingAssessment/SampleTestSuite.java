package apiTestingAssessment;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class SampleTestSuite {
	
	@Test
	public void Test_1() {
		
		//Declaration of API End point
		baseURI = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
		
		int statuscode = 200;
		String name = "Carbon credits";
		boolean canRelist = true;
		String description = "Good position in category";
		
		//This is to test the status code response by the end point and verify if connection succeeded
		given().
			get().
		then().
			statusCode(statuscode);
			System.out.println("Status code " + statuscode + " received, connection to endpoint successful"); 
		
		//This part is to test the acceptance criteria
		given().
			get().
		then().
			body("Name", containsString(name));
			System.out.println("Name element has a value of " + name);
			get().
		then().
			body("CanRelist", equalTo(canRelist));
			System.out.println("CanRelist element has a value of " + canRelist);
			get().
		then().
			body("Promotions[1].Description", containsString(description));
			System.out.println("The Promotions element Gallery has a description of " + description); 
	}

}
