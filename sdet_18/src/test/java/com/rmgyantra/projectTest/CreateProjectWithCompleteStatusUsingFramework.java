package com.rmgyantra.projectTest;

import org.seleniumhq.jetty9.io.EndPoint;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rmg.api.project.pojoObjectLib.Project;
import com.rmgyantra.GenericUtils.BaseAPIClasss;
import com.rmgyantra.GenericUtils.DataBaseUtility;
import com.rmgyantra.GenericUtils.Endpoints;
import com.rmgyantra.GenericUtils.JavaUtility;
import com.rmgyantra.GenericUtils.JsonUtility;

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

public class CreateProjectWithCompleteStatusUsingFramework extends BaseAPIClasss {

	@Test
	public void createprojectwithcompletestatususingframework() throws Throwable {
		JavaUtility ju=new JavaUtility();
		JsonUtility jsonUtils = new JsonUtility();
		
		String expectedCreatedBy="chai_modhi";
		String expectedProjectName="TeamIndia"+ju.randomNumber();
		String expectedStatus="completed";
		
		//create a resource inside the server using pojo class
		Project projectlib=new Project(expectedCreatedBy, expectedProjectName, expectedStatus, 15);
		
		//Give precondition and capture the response after doing post operation
		Response response = given()
		   .contentType(ContentType.JSON)
		   .body(projectlib)
		   .when().post("http://localhost:8084/addProject");
		
		//capture projectName and statuscode from the response
		String responseProjectName =jsonUtils.getJsonPathData("projectName", response);
		 String responseStatus=jsonUtils.getJsonPathData("status", response);
		
		 
		 //provide the restassured verification 
		  response.then()
		          .assertThat().statusCode(201)
		          .assertThat().contentType(ContentType.JSON)
		          .log().all();
		  
		  DataBaseUtility dbUtility = new DataBaseUtility();
		  String querry="select * from project";
		  String actualProjectName= dbUtility.executeQuerryAndGetData(querry, 4, expectedProjectName);
		  String actualstatus = dbUtility.executeQuerryAndGetData(querry, 5, expectedStatus);   
		  
		     //assertion for both db and response projectName
		     Assert.assertEquals(actualProjectName, expectedProjectName);
		     Assert.assertEquals(responseProjectName,expectedProjectName);
		     
		     //assertion for both db and response body status
		     Assert.assertEquals(actualstatus, expectedStatus);
		     Assert.assertEquals(responseStatus, expectedStatus);
		}
	} 