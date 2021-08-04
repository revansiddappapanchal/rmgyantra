package reqresValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class DynamicResponce {

	@Test
	public void dynamicResponce() {
		String expectedName="Michael";
		String actualName=null;
	    Response response = when()
	     .get("https://reqres.in/api/users?page=2");
	     
	    List<String> list=response.jsonPath().get("first_name");
	     
	    boolean flag=false;
	    for(String listdata:list) {
	    	if(listdata.equals(expectedName)) {
	    		actualName=listdata;
	    		flag=true;
	    		break;
	    	}
	    }
	    Assert.assertEquals(flag, true);
	    Assert.assertEquals(actualName, expectedName);
	    response.then().statusCode(200).log().all();
	}
}
