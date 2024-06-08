package com.vTiger.crm.generic.dataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/** contains Database resuable methods 
 * @author Pavan Kalyan
 */
public class DataBaseUtility {
	
	Connection con=null;
	public void getDbConnection(String url,String userName,String password) throws Throwable{
	try {
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	 con = DriverManager.getConnection(url, userName, password);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	public void closeConnection() throws Throwable {
		try {
		con.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
			Statement stat = con.createStatement();
			 result = stat.executeQuery(query);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}
		return result;
	}
	
	public int executeNonSelectQuery(String query) throws Throwable {
		int result=0;
		try {
			Statement stat = con.createStatement();
			 result = stat.executeUpdate(query);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}
		return result;
	}
	public void getDbConnection() throws Throwable{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		 con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	}
	
	
	
	
	}
