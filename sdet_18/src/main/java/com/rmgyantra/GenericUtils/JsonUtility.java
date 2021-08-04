package com.rmgyantra.GenericUtils;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class JsonUtility {

	/*
	 * method will give the data according to the json path passed
	 */
	public String getJsonPathData(String jsonPath,Response response) {
		String result = response.jsonPath() .get(jsonPath);
		return result;
	}
}
