package sis;

import java.sql.*;

public class CreateJDBCConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost";
	
	private String USER = "root";
	private String PASS = "";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public Statement getStatement(){
		return stmt;
	}
	
	public CreateJDBCConnection(String user,String pass){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,user,pass);
			stmt = conn.createStatement();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("SQL Error");
		}
	}
	
	public CreateJDBCConnection(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("SQL Error");
		}
	}
}
