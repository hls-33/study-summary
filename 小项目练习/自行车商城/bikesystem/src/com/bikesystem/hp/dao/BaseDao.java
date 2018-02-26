package com.bikesystem.hp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 封装创建Connection 创建PreparedStatement等数据库连接、操作的对象的API
 * */
public abstract class BaseDao {
	
	protected static String user;
	protected static String password;
	protected static String driver;
	protected static String url;
	

	protected Connection connection;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	static{
		
		InputStream in=BaseDao.class.getClassLoader().getResourceAsStream("hp.properties");
		
		Properties prop=new Properties();
		try {
			prop.load(in);

			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void createConnection(){
		if(connection==null){
			try {
				connection=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void createPreparedStatement(String sql){
		createConnection();
		try {
			pstmt=connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void getResultSet(){
		try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void close(){
		
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null){
			try {
				pstmt.close();
				pstmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection!=null){
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
