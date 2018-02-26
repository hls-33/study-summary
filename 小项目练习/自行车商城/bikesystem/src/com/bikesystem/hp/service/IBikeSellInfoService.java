package com.bikesystem.hp.service;

import java.util.List;

import com.bikesystem.entity.BikeSellInfo;

public interface IBikeSellInfoService {

	/**查询用户销售信息*/
	List<BikeSellInfo> queryUserBikeRent(String  name);
	/**查询店铺自行车被销售信息*/
	List<BikeSellInfo> queryAdminBikeRent(String  shopname);
	/**插入自行车销售记录*/	
	boolean insertBikeSellInfo(BikeSellInfo BikeSellInfo);
	
}
