package com.bikesystem.hs.dao;
/**
 * c3p0获取数据库实体信息
 */
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.utils.JdbcUtils;

public class TestDao {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void test(){
		String sql="select * from bike_kind ";
		try{
			//查询很多结果封装到一个list集合当中
			ArrayList<BikeKind> list = (ArrayList<BikeKind>) qr.query(sql, new BeanListHandler<BikeKind>(BikeKind.class));
			//查询一行记录封装到BikeKind对象当中
			String sql2="select * from bike_kind where bkid=? ";
			BikeKind bikeKind = qr.query(sql2, new BeanHandler<BikeKind>(BikeKind.class), 1);
			System.out.println(list);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		test();
	}
}
