package com.withBDDprograms;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Post {

	@Test
	public void createProject() {
		JSONObject j= new JSONObject();
		j.put("createdBy", "siddu");
		j.put("projectName", "pojo");
		j.put("status", "Created");
		j.put("teamSize", 101);
		
		given()
		.contentType(ContentType.JSON)
		.body(j)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		   .log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);

	}

}
