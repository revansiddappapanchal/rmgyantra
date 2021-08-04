package com.rmgyantra.fourWaysToPostRequest;

import java.util.Random;

import org.testng.annotations.Test;

import com.rmg.api.project.pojoObjectLib.Project;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateUsingpojoTest {
    
	@Test
	public void createpojo() {
		Random random=new Random();
		int randomNumber=random.nextInt(2000);
		
	Project pojoObject=new Project("testyantra", "testyantra_onlines"+randomNumber, "on_going", 12);
	given()
	    .contentType(ContentType.JSON)
	     .body(pojoObject)
		.when()
		    .post("http://localhost:8084/addProject")
		 .then()
		      .log().all()
		      .and()
		      .assertThat().statusCode(201);
	}
}
