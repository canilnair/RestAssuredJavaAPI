package tests;

import org.junit.Test;

import com.jayway.restassured.RestAssured;

import Base.TestBase;

public class StudentDeleteTest extends TestBase{
	
	@Test
	public void deleteRecord() {
		RestAssured.given().when().delete("/101").then().statusCode(204);
		
		System.out.println((RestAssured.given().when().get("/list").prettyPeek()));
	}

}
