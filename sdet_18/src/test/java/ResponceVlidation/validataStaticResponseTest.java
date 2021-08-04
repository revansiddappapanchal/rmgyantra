package ResponceVlidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class validataStaticResponseTest {
    
	@Test
	public void staticResponse() {
			String expectedProjectName="adarsha sir";
			
			Response responce = when()
			.get("http://localhost:8084/projects");
			
			responce.then()
			  .assertThat()
			  .statusCode(200)
			  .log().all();
			
			String actualProjectName=responce.jsonPath().get("[0].createdBy");
			System.out.println("expected value is:"+expectedProjectName);
			System.out.println("actual value is:"+actualProjectName);
			
			Assert.assertEquals(actualProjectName,expectedProjectName);
			}
}
