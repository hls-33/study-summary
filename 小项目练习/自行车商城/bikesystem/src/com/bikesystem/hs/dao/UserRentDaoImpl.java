package com.bikesystem.hs.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bikesystem.entity.UserRent;
import com.bikesystem.utils.JdbcUtils;
/**
 * 用户租用自行车信息
 * @author 祷
 *
 */
public class UserRentDaoImpl implements IUserRentDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	/**
	 * 查询某用户的租用的自行车信息
	 */
	@Override
	public List<UserRent> queryUserBikeRentByUsername(String name) {
		String sql="select * from user_rent where name=? ";
		try{
			return qr.query(sql, new BeanListHandler<UserRent>(UserRent.class),name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询某店铺已经被租用的用户租借自信车的信息
	 */
	@Override
	public List<UserRent> queryAdminBikeRentByShopName(String shopname) {
		String sql="select * from user_rent where shopname=? ";
		try{
			return qr.query(sql, new BeanListHandler<UserRent>(UserRent.class),shopname);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 新增的用户租借信息
	 */
	@Override
	public boolean insertUserRent(UserRent userRent) {
		String sql="insert into user_rent(name,bikenumber,bikename,shopname,rentdate," +
				"returndate,deposit,rentType)values(?,?,?,?,?,?,?,?) ";
		try{
			int result = qr.update(sql,userRent.getName(),userRent.getBikeNumber(),
					userRent.getBikeName(),userRent.getShopName(),userRent.getRentDate(),
					userRent.getReturnDate(),userRent.getDeposit(),userRent.getRentType());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新用户租借信息(仅供修改还车日期和压金)
	 */
	@Override
	public boolean updateUserRent(UserRent userRent) {
		String sql="update user_rent set returndate=?,deposit=?,rentType=? where urid=? ";
		try{
			int result = qr.update(sql,userRent.getReturnDate(),userRent.getDeposit(),
					userRent.getRentType(),userRent.getUrid());
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除用户租借信息
	 */
	@Override
	public boolean deleteUserRent(int urid) {
		String sql="delete from user_rent where urid=? ";
		try{
			int result = qr.update(sql,urid);
			if(result>0){return true;}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public UserRent queryUserBikeRentByBikeNumber(String bikenumber) {
		String sql="select * from user_rent where bikenumber=? ";
		try{
			return qr.query(sql, new BeanHandler<UserRent>(UserRent.class),bikenumber);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
