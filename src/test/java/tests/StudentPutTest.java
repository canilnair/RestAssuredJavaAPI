package tests;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import Base.TestBase;
import records.Student;
/*
 * PUT request is used for updating a record if the location is known.
 * Whole message record fields for the update record has to be sent in the message
 * Successful update status code = 200 / Error in message body = 500
 */
public class StudentPutTest extends TestBase{
	
	@Test
	public void updateStudentRecord() {
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java 2EE");
		courses.add("Oracle DBA");
		courses.add("Unix Admin");
		
		
		Student student = new Student();
		student.setFirstName("Anil Chandu");
		student.setLastName("Nair");
		student.setEmail("canilnair@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		RestAssured.given().contentType(ContentType.JSON).when().body(student).put("/101").then().statusCode(200);
		
		System.out.println((RestAssured.given().when().get("/101")).prettyPeek());
	}
	

}
