package com.parameters;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import io.restassured.http.ContentType;

public class FromParameterTest {

	@Test
	public void parameter() {
		given()
		      .contentType(ContentType.JSON)
		      .formParam("createdBy", "MS_Dhoni")
		      .formParam("projectName", "CSK")
		      .formParam("status", "Completed")
		      .formParam("teamSize", "100")
		.when()
		         .post("http://localhost:8084/addProject")
		 .then()
		        .log().all();
		         
	}
}
