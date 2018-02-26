package com.bikesystem.hs.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bikesystem.entity.ShopImage;
import com.bikesystem.txz.ipml.dao.BaseSystemDao;
import com.bikesystem.utils.JdbcUtils;
/**
 * 商店主页图片路径Dao层
 * @author bwfadmin
 *
 */
public class ShopImageDaoImpl extends BaseSystemDao implements IShopImageDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public List<ShopImage> queryShopImage(String shopname,String imagename) {
		String sql="select * from shop_image where shopname=? and imagename=?";
		try{
			return qr.query(sql, new BeanListHandler<ShopImage>(ShopImage.class),shopname,imagename);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertShopImage(ShopImage shopImage) {
		String sql="insert into shop_image(sid,imagename,imagepath)values(?,?,?) ";
		try{
			int result = qr.update(sql,shopImage.getSiid(),shopImage.getImageName(),
					shopImage.getImagePath());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateShopImage(ShopImage shopImage) {
		String sql="update shop_image set imagename=?,imagepath=? ";
		try{
			int result = qr.update(sql,shopImage.getImageName(),shopImage.getImagePath());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ShopImage> queryAllShopImage() {
		String sql="select * from shop_image left join shop on shop.shopname=shop_image.shopname group by shop.shopname limit ?,?";
		try{
			return qr.query(sql, new BeanListHandler<ShopImage>(ShopImage.class),0,10);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
