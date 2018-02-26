package com.bikesystem.sh.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BaseDao {
	
	private static String user;
	private static String password;
	private static String driver;
	private static String url;
	
	//����˼����Ϊʲô���������Ƿ�static��?
	protected Connection connection;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	/*
	 * ΪʲôҪ�ھ�̬���ж�ȡproperties�ļ�?
	 * ��̬����������ص�ʱ��ͻᱻִ��,��ֻ�ᱻִ��һ�Ρ�
	 * ��ȡproperties�ļ�ֻ��Ҫ��ȡһ�Σ���ˣ����Է���static���С�
	 * */
	static{
		//���ǰ����ݿ����ӵ���Ϣ��ŵ�properties�еĺô��Ǳ�����Щ����Ϣ�����ά��
		//Ϊ�˶�ȡproperties�ļ����������Ȼ�ȡ���ļ���Ӧ��������
		InputStream in=BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
		//Ϊ�˷����ȡproperties�ļ�,���ǰ�properties�ļ���Ӧ�����������󽻸�Properties����
		Properties prop=new Properties();
		try {
			prop.load(in);
			
			//��ȡָ����key��Ӧ��value
			//��ȡuser��Ӧ��ֵ
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			
			//������ص�ʱ�򣬾�ͬʱ�������ݿ�������com.mysql.jdbc.Driver
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//����Connection
	protected void createConnection(){
		if(connection==null){
			try {
				connection=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//�ڴ���PreparedStatement  һ����Ҫһ��sql����
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
	
	/*
	 * �÷������ڹر�ResultSet��PreparedStatement��Connection��
	 * ֮����������,����Ϊ��
	 * 1����������ĵ���
	 * 2���������ǵ����ݲ�����û�в���ResultSet�������PreparedStatement����
	 *   ��������������п��жϣ�����Ӱ��--���йرգ�û�оͲ��ܡ�
	 * */
	//�ر�connection pstmt rs
	protected void close(){
		
		if(rs!=null){
			try {
				rs.close();
				//�ڹرն����ʱ��һ��Ҫ�Ѹö��������ÿ�,���øö����ܹ���GC(����������)������
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
