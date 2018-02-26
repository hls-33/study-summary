package com.bikesystem.hs.dao;

import java.util.List;
import java.util.Map;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;

/**
 * 自行车销售Dao层
 * @author 祷
 *
 */
public interface IBikeSellDao {
	boolean insertBikeSell(BikeSell bikeSell);		//添加自行	车
	boolean deleteBikeSellById(int bsid);	//删除出售的自行													
	boolean updateBikeSell(BikeSell bike);		//修改自行车信息
	List<BikeSell> queryAllBikeSellByShopName(String shopName);	//查看所有出售自行车
	List<BikeSell> queryAllBikeSellByBikeName(String bikeName);//查看相关自行车信息
	List<BikeSell> queryAllBikeSell(String bikeName,String shopName);//查看相关自行车信息
	List<BikeSell> queryAllBikeSell();	//查看所有店铺的所有出售自行车
	
	List<BikeSell> queryAllBikeSellOrderBySellCount(String shopName);//查看相关自行车信息根据rentCount顺序查询
	List<BikeSell> queryAllBikeSellOrderByBikeprice(String shopName);//查看相关自行车信息
	List<BikeSell> queryAllBikeSellByParameter(Map<String,Object> map);//根据动态的参数个数来查询
}
