package com.rmgyantra.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	static Connection conection=null;
	static ResultSet result;
	public void connectToDB() {
		/**
		 * @author siddu
		 * this mehtod will perform mysql database connection
		 */
		try {
			 Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * @Author siddu
	 * this method will perform database close action
	 */
        public  void closeDB() throws SQLException {
		conection.close();
		
	}
        public void executeQuerry(String querry) throws SQLException {
        	conection.createStatement().executeQuery(querry);
        }
        /*
         * @Author siddu
         * this method will verify whether data is present in databse or not
         */
        public String executeQuerryAndGetData(String querry,int columnNumber,String expectedData) throws Throwable {
        	boolean flag=true;
        	 result=conection.createStatement().executeQuery(querry);
            while(result.next()) {
            	if(result.getString(columnNumber).equals(expectedData)) {
            		flag=true;
            		break;
            	}
            }
            if(flag) {
            	System.out.println(expectedData+"==>data is verified in the database");
            	return expectedData;
            }else {
            	System.out.println(expectedData+"===> Data is not verified");
                 return expectedData;           
            }
        }
}
