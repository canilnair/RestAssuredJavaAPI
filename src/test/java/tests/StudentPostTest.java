package tests;

import java.util.ArrayList;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import Base.TestBase;
import records.Student;
/*
 * POST is to insert a whole new record
 * Message body has to have all mandatory fields entered and sent as a message body.
 * Successful message response status code = 201 /  Error status code = 500
 */
public class StudentPostTest extends TestBase{
	
	@Test
	public void createStudentRecord() {
		ArrayList<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("C#");
		
		Student student = new Student();
		
		student.setFirstName("Anil");
		student.setLastName("Nair");
		student.setEmail("canilnair@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(course);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
		Response response = RestAssured.given().when().get("/101");
		System.out.println(response.prettyPeek());
		
	}

}
