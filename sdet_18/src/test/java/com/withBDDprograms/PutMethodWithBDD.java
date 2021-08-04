package com.withBDDprograms;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutMethodWithBDD {

	@Test
	public void putmethod() {
		JSONObject jObject= new JSONObject();
		jObject.put("createdBy", "deepak");
		jObject.put("projectName", "zoho-2");
		jObject.put("status", "Created");
		jObject.put("teamSize", 10);

		
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.put("http://localhost:8084/projects/"+"TY_PROJ_402")
		.then()
		   .log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);

	}
}
