package com.bikesystem.txz.ipml.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseSystemDao {
	private static String user;
	private static String password;
	private static String driver;
	private static String url;
	
	protected Connection connection;
	protected PreparedStatement prep;
	protected ResultSet res;
	
	static{
		//加载保存数据库文件输入流对象
		InputStream in=BaseSystemDao.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
//			加载驱动
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConnection(){
		if(connection==null){
			try {
				connection=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void getPreparedStatement(String sql){
		getConnection();
		if(sql!=null){
			try {
				prep=connection.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else prep=null;
	}
	public void closeAll(){
		if(res!=null){
			try {
				res.close();
				res=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(prep!=null){
			try {
				prep.close();
				prep=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
