package crudOperation_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;

public class GetAllProject {

	@Test
	public void getallProjet()
	{
	  RestAssured.get("http://localhost:8084/projects");
	}
}
