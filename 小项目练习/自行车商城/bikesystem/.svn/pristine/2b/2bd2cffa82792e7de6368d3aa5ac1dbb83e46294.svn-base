package com.bikesystem.hs.dao;

import java.util.List;
import java.util.Map;

import com.bikesystem.entity.BikeRent;

/**
 * 自行车出租Dao层
 * @author 祷
 *
 */
public interface IBikeRentDao {
	boolean insertBikeRent(BikeRent bikeRent);		//添加自行车
	boolean deleteBikeRentById(int brid);	         //删除出售的自行车
	boolean updateBikeRent(BikeRent bikeRent);		 //  修改自行车信息
	
	/**
	 * 根据brid查询对应bikeRent
	 * @param shopName
	 * @return
	 */
	BikeRent queryBikeRentByBrid(int brid);
	List<BikeRent> queryAllBikeRentByShopName(String shopName);	//查看所有租借自行车
	List<BikeRent> queryAllBikeRentByBikeName(String bikeName);// 查看相关自行车信息
	List<BikeRent> queryAllBikeRent(String bikeName,String shopName);//查看相关自行车信息
	List<BikeRent> queryAllBikeRentByParameter(Map<String,Object> map);//根据动态的参数个数来查询
	List<BikeRent> queryAllBikeRent();//查看所有可租借自行车信息
	List<BikeRent> queryHotBikeRentByShopName(String shopName);//查询最热租的6个车
	
	List<BikeRent> queryAllBikeRentOrderByRentCount(String shopName);
	List<BikeRent> queryAllBikeRentOrderByDayPrice(String shopName);//查看相关自行车信息
	
	/**
	 * 查询租车中最热的12个车供搜索页面的初始
	 * @return
	 */
	List<BikeRent> queryHotBikeRent();
}
