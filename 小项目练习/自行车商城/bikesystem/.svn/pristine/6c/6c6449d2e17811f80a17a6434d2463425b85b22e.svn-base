package com.bikesystem.hgg.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class BaseDao {
	
	private static String user;
	private static String password;
	private static String driver;
	private static String url;
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	static{
		InputStream in=BikeDestroyDaoImpl.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//连接数据库
	public boolean getDb(String sql){
		try {
			conn=DriverManager.getConnection(url,user,password);
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//关闭数据库
	public void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
