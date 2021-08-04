package com.parameters;

import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest {

	@Test
	public void parameter() {
	  given()
	    .contentType(ContentType.JSON)
	          .pathParam("projectId", "TY_PROJ_204")
	  .when()
	           .get("http://localhost:8084//projects/{projectId}")
	  .then()
	       .log().all()
	       .assertThat().statusCode(200);
	}
}
