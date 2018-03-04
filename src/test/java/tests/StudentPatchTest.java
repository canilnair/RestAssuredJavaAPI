package tests;

import java.util.ArrayList;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import Base.TestBase;
import records.Student;
/*
 * PATCH request is used for updating a record.
 * A single Value within a record can be used using PATCH
 * Successful update status code = 200 / Error in message body = 500
 */ 

public class StudentPatchTest extends TestBase {
	
	@Test
	public void patchStudentDetails() {
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java 2EE");
		courses.add("Oracle DBA");
		courses.add("Unix Admin");
		
		
		Student student = new Student();
		student.setFirstName("Panchikkal Chandu");
		student.setLastName("Nair");
		student.setEmail("canilnair@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		RestAssured.given().contentType(ContentType.JSON).when().body(student).patch("/101").then().statusCode(200);
		
		System.out.println((RestAssured.given().when().get("/101")).prettyPeek());
		
	}
	
	
	

}
