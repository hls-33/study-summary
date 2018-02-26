package com.bikesystem.utils;
/**
 * C3p0连接池配置工具类
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static ComboPooledDataSource ds = null;
	static{
		//配置文件在定义为位置的做法
		ds=new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:mysql://hsadmin:3306/bicyclesystem");
		ds.setUser("root");
		ds.setPassword("123");
	}
	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static DataSource getDataSource() {
		return ds;
	}
}
