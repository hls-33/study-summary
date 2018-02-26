package com.bikesystem.hp.service;

import java.util.List;

import com.bikesystem.entity.BikeSell;
import com.bikesystem.entity.SellAddress;

public interface IBikeSellService {


	/**添加地址*/
	boolean insertBikeSellAddress(SellAddress sellAddress);
	/**删除出地址*/
	boolean deleteBikeSellAddressById(int said);	
	/**修改地址*/
	boolean updateBikeSellAddress(SellAddress sellAddress);		
	/**查看所有地址*/
	List<SellAddress> queryAllBikeSellAddress(String name);	
	/**查看相关自行车信息*/
	List<BikeSell> queryBikeSell(String bikeName);
	/**查看特定自行车信息*/
	List<BikeSell> querySpecialBikeSell(String bikeName,String shopName);
	List<BikeSell> getBikeSellByBsid(int bsid);
}
