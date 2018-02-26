package com.bikesystem.hs.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bikesystem.entity.ShopRentSale;
import com.bikesystem.utils.JdbcUtils;
/**
 * 商家租车折扣Dao层
 * @author bwfadmin
 *
 */
public class ShopRentSellDaoImpl implements IShopRentSaleDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	@Override
	public boolean insertRentSale(ShopRentSale rentSale) {
		String sql="insert into shop_rent_sale(brid,shopname,hoursaleprice,daysaleprice)values(?,?,?,?) ";
		try{
			int result = qr.update(sql,rentSale.getBrid(),rentSale.getShopName(),
					rentSale.getHourSalePrice(),rentSale.getDaySalePrice());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRentSale(ShopRentSale rentSale) {
		String sql="update shop_rent_sale set hoursaleprice=?,daysalprice=? ";
		try{
			int result = qr.update(sql,rentSale.getHourSalePrice(),rentSale.getDaySalePrice());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ShopRentSale> queryAllRentSaleByShopname(String shopname) {
		String sql="select * from shop_rent_sale where shopname=? ";
		try{
			return qr.query(sql, new BeanListHandler<ShopRentSale>(ShopRentSale.class),shopname);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ShopRentSale queryRentSaleByBrid(int brid) {
		String sql="select * from shop_rent_sale where brid=? ";
		try{
			return qr.query(sql, new BeanHandler<ShopRentSale>(ShopRentSale.class),brid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delteRentSaleByBrid(int brid) {
		String sql="delete from shop_rent_sale where brid=? ";
		try{
			int result = qr.update(sql,brid);
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
