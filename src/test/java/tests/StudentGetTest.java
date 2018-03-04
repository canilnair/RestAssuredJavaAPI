package tests;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import Base.TestBase;


/*
 * GET request is used for reading a / all records.
 * Whole message record fields for the retrieved as record in the response message
 * Successful read status code = 200 / Error in message body = 500
 */

public class StudentGetTest extends TestBase{
	
	protected Response response;

	@Test
	public void getAllStudentInformation() {
		/*
		 * given()
		 * set cookies, add auth, adding parameters, setting header info
		 * .when()
		 * GET, POST, PUT, DELETE, PATCH, CONTENTS, etc..
		 * .then()
		 * Validate status code, extract response, extract headers, extract cookies, extract the response body
		 */
		
		response = RestAssured.given()
		.when()
		.get("/list");
		
		System.out.println(response.body().prettyPrint());
		
		// Validate response code = 200
		RestAssured.given().when().get("/list").then().statusCode(200);				
	}
	
	@Test
	public void getSingleStudentInformation() {
		response = RestAssured.given().when().get("/10");
		
		System.out.println(response.getBody().prettyPrint());
		
		//Validating response code = 200	
		RestAssured.given().when().get("/1").then().statusCode(200);
	}
	
	@Test
	public void getStudentsFromFinancialAnalysis() {
		response = RestAssured.given().param("programme", "Financial Analysis").param("limit", 3).when().get("/list");
		System.out.println(response.prettyPeek());
	}

}
