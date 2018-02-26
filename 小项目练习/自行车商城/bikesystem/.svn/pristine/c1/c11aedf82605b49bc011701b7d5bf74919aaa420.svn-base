package com.bikesystem.hs.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.utils.JdbcUtils;
/**
 * 完成与BikeKind数据库表的数据交互
 * @author 祷
 *
 */
public class BikeKindDaoImpl implements IBikeKindDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	@Override
	public boolean insertBikeKind(BikeKind bikeKind) {
		String sql="insert into bike_kind(kindname,bkinformation)values(?,?) ";
		try{
			int result = qr.update(sql, bikeKind.getKindName(),bikeKind.getBkInformation());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBikeKindInfo(BikeKind bikeKind) {
		String sql="update bike_kind set kindname=?,bkinformation=? where bkid=? ";
		try{
			int result = qr.update(sql, bikeKind.getKindName(),bikeKind.getBkInformation(),bikeKind.getBkid());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BikeKind> queryAllBikeKind() {
		String sql="select * from bike_kind ";
		try{
			return qr.query(sql, new BeanListHandler<BikeKind>(BikeKind.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void test(){
		BikeKind bikeKind = new BikeKind("越野车","专为野马而生！");
		System.out.println(insertBikeKind(bikeKind));
		BikeKind bikeKind2 = new BikeKind(1,"公路车","专为公路稳行而生！");
		System.out.println(updateBikeKindInfo(bikeKind2));
		System.out.println(queryAllBikeKind());
	}
}
