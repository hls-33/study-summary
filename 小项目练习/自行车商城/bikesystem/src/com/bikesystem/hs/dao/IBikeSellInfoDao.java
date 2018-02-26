package com.bikesystem.hs.dao;

import java.util.List;

import com.bikesystem.entity.BikeSellInfo;

/**
 * 自行车销售信息Dao层
 * @author 祷
 *
 */
public interface IBikeSellInfoDao {
	List<BikeSellInfo> queryUserBikeSellByUsername(String  name);//查询用户销售信息
	List<BikeSellInfo> queryAdminBikeSellByShopName(String  shopname);//查询店铺自行车被销售信息
	boolean insertBikeSellInfo(BikeSellInfo BikeSellInfo);//插入自行车销售记录

}
