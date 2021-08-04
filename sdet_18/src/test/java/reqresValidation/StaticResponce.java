package reqresValidation;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticResponce {
	@Test
	public void staticResponse() {
			String expectedName="Michael";
			
			Response responce = when()
			.get("https://reqres.in/api/users?page=2");
			
			responce.then()
			  .assertThat()
			  .statusCode(200)
			  .log().all();
			
			String actualName=responce.jsonPath().get("data[0].first_name");
			System.out.println("expected value is:"+expectedName);
			System.out.println("actual value is:"+actualName);
			
			Assert.assertEquals(actualName,expectedName);
			}
}