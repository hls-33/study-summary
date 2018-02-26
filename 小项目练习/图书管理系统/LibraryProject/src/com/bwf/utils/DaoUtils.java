package com.bwf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DaoUtils {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {}
	}
	// 创建连接
		public static Connection getConn(){
			Properties pro = new Properties();	//获取配置文件的类
			try{
				pro.load(new FileInputStream("."+File.separator+"connection.properties"));
				String url = pro.getProperty("url");
				String user = pro.getProperty("user");
				String pass = pro.getProperty("pass");
				Connection conn = DriverManager.getConnection(url,user,pass);
				return conn;
			}catch(Exception e){e.printStackTrace();return null;}
		}
		// 释放连接
		public static void close(Connection conn){
			if(null == conn)
				return;
			try{
				conn.close();
			}catch(Exception e){e.printStackTrace();}
		}
}
