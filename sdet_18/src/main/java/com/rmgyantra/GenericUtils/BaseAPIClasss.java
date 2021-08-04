package com.rmgyantra.GenericUtils;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseAPIClasss {
	DataBaseUtility db = new DataBaseUtility();
	
   @BeforeSuite
   public void configBeforeSuite() {
	     
	     System.out.println("==========start=======");
	     db.connectToDB();
	     System.out.println("=========connect to database==========");
	     baseURI="htttp://localhost";
	     port=8084;
	     
   }
    public void configAfterSuite() throws Throwable {
    	db.closeDB();
    	System.out.println("=======databse is closed=====");
    }
}
