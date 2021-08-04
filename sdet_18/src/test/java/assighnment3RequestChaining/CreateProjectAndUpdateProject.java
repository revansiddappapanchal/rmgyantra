package assighnment3RequestChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectAndUpdateProject {

	@Test
	public void createProject() {
		JSONObject jobject1=new JSONObject();
		jobject1.put("createdBy","canvas_team");
		jobject1.put("projectName","canvas");
		jobject1.put("status","Created");
		jobject1.put("teamSize",11);
		
		given()
		        .contentType(ContentType.JSON)
		        .body(jobject1)
		.when()
		        .post("http://localhost:8084/addProject");
		given()
		       .pathParam("projectId", "jobject1");
		JSONObject jObject2=new JSONObject();
		jObject2.put("createdBy","canvas");
		jObject2.put("projectName","zoho");
		jObject2.put("status","Created");
		jObject2.put("teamSize",13);
	   
		 given()
		       .contentType(ContentType.JSON)
		       .body(jObject2)
		 .when()
		      .put("http://localhost:8084/projects/{projectId}")
		  .then()
		       .log().all()
		       .assertThat().statusCode(200)
		       .assertThat().contentType(ContentType.JSON);
	}
}
