package com.Requestchaining;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ChainingTest {

	@Test
	public void chain() {
		Response response = when()
		.get("http://localhost:8084/projects");
		String proid = response.jsonPath().get("[0].projectId");
		System.out.println(proid);
		
		given()
		       .pathParam("projectId", "proid")
		.when()
		      .delete("http://localhost:8084/projects/{projectId}")
	
		     .then()
		              .log().all()
		               .assertThat().statusCode(204);
	}
}
