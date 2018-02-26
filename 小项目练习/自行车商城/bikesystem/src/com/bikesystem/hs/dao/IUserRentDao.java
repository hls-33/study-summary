package com.bikesystem.hs.dao;

import java.util.List;

import com.bikesystem.entity.UserRent;

/**
 * 用户租赁自行车信息Dao层
 * @author 祷
 *
 */
public interface IUserRentDao {
	List<UserRent> queryUserBikeRentByUsername(String  name);//查询用户租借信息
	List<UserRent> queryAdminBikeRentByShopName(String  shopname);//查询店铺自行车被租借信息
	UserRent queryUserBikeRentByBikeNumber(String bikenumber);
	
	boolean insertUserRent(UserRent userRent);		//插入用户租赁记录
	boolean updateUserRent(UserRent userRent);		//修改租车归还时间
	boolean deleteUserRent(int urid);				//	还车删除记录
	
	
}
