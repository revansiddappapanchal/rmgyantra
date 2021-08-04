package ResponceVlidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmg.api.project.pojoObjectLib.Project;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingMultipleDataTest {
    
	@Test(dataProvider="provideData")
	public void CreateProject(String createdBy,String projectname,String status,int teamSize) {
		Project pojoObject=new Project(createdBy, projectname, status, teamSize);
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
	@DataProvider
	public Object[][] provideData() {
		Object[][] objArray = new Object[3][4];
		objArray[0][0]="testyantra123";
		objArray[0][1]="testyantra123_project";
		objArray[0][2]="completed";
		objArray[0][3]="101";
		
		objArray[1][0]="testyantra456";
		objArray[1][1]="testyantra1456_project";
		objArray[1][2]="completed";
		objArray[1][3]="102";

		objArray[2][0]="testyantra123";
		objArray[2][1]="testyantra123_project";
		objArray[2][2]="completed";
		objArray[2][3]="103";
		
		return objArray;
		
		
		
	}
}
