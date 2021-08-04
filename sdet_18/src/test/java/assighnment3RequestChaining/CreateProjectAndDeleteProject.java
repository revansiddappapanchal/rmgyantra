package assighnment3RequestChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectAndDeleteProject {

	@Test
	public void deleteProject() {
		JSONObject jobject=new JSONObject();
		jobject.put("createdBy","lead_team");
		jobject.put("projectName","canvas");
		jobject.put("status","Created");
		jobject.put("teamSize",100);
		
		given()
		        .contentType(ContentType.JSON)
		        .body(jobject)
		 .when()
		        .post("http://localhost:8084/addProject");
		given()
	       .pathParam("projectId", jobject)
	.when()
	      .delete("http://localhost:8084/projects/{projectId}")

	     .then()
	              .log().all()
	               .assertThat().statusCode(200);
	}
}
