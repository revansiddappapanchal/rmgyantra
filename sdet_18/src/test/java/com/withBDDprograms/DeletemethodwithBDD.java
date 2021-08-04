package com.withBDDprograms;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletemethodwithBDD {

	@Test
	public void deletemethod() {
		when()
		.delete("http://localhost:8084/projects/"+"TY_PROJ_204")
		.then()
		    .log().all()
		.assertThat().statusCode(204);

	}
}
