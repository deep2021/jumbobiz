package com.striker.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection123 {
	
	public static Connection gettingConnection(){
		Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/jumboproject","root","123456"); 
     	}
		catch (Exception e) {
		  e.printStackTrace();
		}
		return con;
}
}


