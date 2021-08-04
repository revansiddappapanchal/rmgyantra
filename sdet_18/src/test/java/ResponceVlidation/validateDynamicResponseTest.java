package ResponceVlidation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.response.Response;
import junit.framework.Assert;

public class validateDynamicResponseTest {
 
	@Test
	public void dynamicResponce() {
		String expectedData="canvas.com";
		String actualData=null;
	    Response response = when()
	     .get("http://localhost:8084/projects");
	     
	    List<String> list=response.jsonPath().get("projectName");
	     
	    boolean flag=false;
	    for(String listdata:list) {
	    	if(listdata.equals(expectedData)) {
	    		actualData=listdata;
	    		flag=true;
	    		break;
	    	}
	    }
	    Assert.assertEquals(flag, true);
	    Assert.assertEquals(actualData, expectedData);
	    response.then().statusCode(200).log().all();
	}
	
}
