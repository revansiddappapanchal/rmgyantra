package com.parameters;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class QuarryParameterTest {

	@Test
	public void parameter() {
		given()
		     .queryParam("page", "2")
		.when()
		    .get("https://reqres.in/api/users?page=2")
		.then()
		     .log().all();
	}
}
