package Base;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.basePath="/student";
		RestAssured.port=8080;
	}

}
