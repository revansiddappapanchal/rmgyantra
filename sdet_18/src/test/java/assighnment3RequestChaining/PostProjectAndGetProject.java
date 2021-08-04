package assighnment3RequestChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostProjectAndGetProject {

	@Test
	public void createProject() {
		JSONObject jobject=new JSONObject();
		jobject.put("createdBy","siddu");
		jobject.put("projectName","SDET-18");
		jobject.put("status","Created");
		jobject.put("teamSize",10);
		
		given()
		        .contentType(ContentType.JSON)
		        .body(jobject)
		  .when()
		        .post("http://localhost:8084/addProject");
          given()
              .pathParam("projectId", "jobject")
          .when()
                .get("http://localhost:8084/projects/{projectId}")
          .then()
		        .log().all()
		        .assertThat().statusCode(201)
		        .assertThat().contentType(ContentType.JSON);
	             
	}
}
