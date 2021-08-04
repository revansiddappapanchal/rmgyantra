package com.rmgyantra.projectTest;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rmg.api.project.pojoObjectLib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCompletedStatusTest {

	@Test
	public void CreateProjectWithCompletedStatus() throws SQLException {
	Random random=new Random();
	int randomnumber = random.nextInt(1000);
	
	String expectedCreatedBy="chai_modhi";
	String expectedProjectName="TeamIndia"+randomnumber;
	String expectedStatus="completed";
	
	//create a resource inside the server using pojo class
	Project projectlib=new Project(expectedCreatedBy, expectedProjectName, expectedStatus, 15);
	
	//Give precondition and capture the response after doing post operation
	Response response = given()
	   .contentType(ContentType.JSON)
	   .body(projectlib)
	   .when().post("http://localhost:8084/addProject");
	
	//capture projectName and statuscode from the response
	String responseProjectName = response.jsonPath().get("projectName");
	 String responseStatus=response.jsonPath().get("status");
	 
	 //provide the restassured verification 
	  response.then()
	          .assertThat().statusCode(201)
	          .assertThat().contentType(ContentType.JSON)
	          .log().all();
	  
	      //Register the database
	      Driver driver = new Driver();
	      DriverManager.registerDriver(driver);
	      
	      //connect to mysql database
	      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	      
	      //create the statement
	      Statement statement = connection.createStatement();
	      
	      //execute querry and get the values from  database
	      String actualProjectName=null;
	      String actualStatus=null;
	      boolean flag=false;
	      ResultSet result = statement.executeQuery("select * from project");
	      while(result.next())
	      {
	    	  if(result.getString(4).equals(expectedProjectName)) {
	    		  actualProjectName=result.getString(4);
	    		  System.out.println("actualProjectName:"+actualProjectName);
	    		  actualStatus=result.getString(5);
	    		  System.out.println("actualStatus:"+actualStatus);
	    		  flag=true;
	    		  break;
	    	  }
	      }
	      connection.close();
	      //assertion using flag btween expected and actual from database
	      Assert.assertEquals(flag, true);
	      //verification between expected and actual database
	      Assert.assertEquals(actualProjectName, expectedProjectName);
          //verification between expected and from response	  
	      Assert.assertEquals(responseProjectName, expectedProjectName);
	      
	      //assertion for status
	      Assert.assertEquals(actualStatus, expectedStatus);
	      Assert.assertEquals(responseStatus, expectedStatus);
	}
}
