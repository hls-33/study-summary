package com.bikesystem.hs.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.bikesystem.entity.BikeSellInfo;
import com.bikesystem.utils.JdbcUtils;

public class BikeSellInfoDaoImpl implements IBikeSellInfoDao{
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	/**
	 * 查询某用户的已购买的自行车信息
	 */
	@Override
	public List<BikeSellInfo> queryUserBikeSellByUsername(String name) {
		String sql="select * from bike_sell_info where name=?";
		try{
			return qr.query(sql, new BeanListHandler<BikeSellInfo>(BikeSellInfo.class),name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询某店铺的已经销售的自行车信息
	 */
	@Override
	public List<BikeSellInfo> queryAdminBikeSellByShopName(String shopname) {
		String sql="select * from bike_sell_info where shopname=?";
		try{
			return qr.query(sql, new BeanListHandler<BikeSellInfo>(BikeSellInfo.class),shopname);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 插入新的已经销售的自行车信息
	 */
	@Override
	public boolean insertBikeSellInfo(BikeSellInfo BikeSellInfo) {
		String sql="insert into bike_kind(shopname,name,bikeprice,selldate)values(?,?,?,?) ";
		try{
			int result = qr.update(sql,BikeSellInfo.getShopName(),BikeSellInfo.getName(),
					BikeSellInfo.getBikePrice(),BikeSellInfo.getSellDate());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Test
	public void test(){
		
	}
}
