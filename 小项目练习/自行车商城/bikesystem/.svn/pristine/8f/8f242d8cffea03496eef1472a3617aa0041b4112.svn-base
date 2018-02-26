package com.bikesystem.hs.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.bikesystem.entity.Shop;
import com.bikesystem.utils.JdbcUtils;
/**
 * 商店店铺Dao层实现类
 * @author 祷
 *
 */
public class ShopDaoImpl implements IShopDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	/**
	 * 新增商铺信息
	 */
	@Override
	public boolean insertShop(Shop shop) {
		String sql="insert into shop(aid,shopname,shopaddress,shopbuildtime," +
				"shopinformation)values(?,?,?,?,?) ";
		try{
			int result = qr.update(sql, shop.getAid(),shop.getShopName(),shop.getShopAddress(),
					shop.getShopBuildTime(),shop.getShopInformation());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询商铺信息
	 */
	@Override
	public Shop queryShopById(int sid) {
		String sql="select * from shop where sid=? ";
		try{
			return qr.query(sql, new BeanHandler<Shop>(Shop.class),sid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更新商铺信息
	 */
	@Override
	public boolean updateShop(Shop shop) {
		String sql="update shop set aid=?,shopname=?,shopaddress=?,shopbuildtime=?," +
				"shopinformation=?where sid=? ";
		try{
			int result = qr.update(sql,shop.getAid(),shop.getShopName(),shop.getShopName(),
					shop.getShopBuildTime(),shop.getShopInformation(),shop.getSid());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Shop queryShopByShopname(String shopname) {
		String sql="select * from shop where shopname=? ";
		try{
			return qr.query(sql, new BeanHandler<Shop>(Shop.class),shopname);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;

	}
}
