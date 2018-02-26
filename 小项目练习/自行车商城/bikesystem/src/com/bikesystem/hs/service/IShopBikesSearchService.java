package com.bikesystem.hs.service;

import java.util.List;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;

public interface IShopBikesSearchService {
	//sell相关查询
	List<BikeSell> queryAllBikeSellByShopName(String shopName);	//查看所有出售自行车
	List<BikeSell> queryAllBikeSellOrderBySellCount(String shopName);//查看相关自行车信息
	List<BikeSell> queryAllBikeSellOrderByBikeprice(String shopName);//查看相关自行车信息
	List<BikeSell> queryAllBikeSellByShopName(String shopName,String kindName);	//查看所有出售自行车
	
	//rent相关查询
	List<BikeRent> queryAllBikeRentByShopName(String shopName);	//查看所有租借自行车
	List<BikeRent> queryAllBikeRentOrderByRentCount(String shopName);//查看相关自行车信息
	List<BikeRent> queryAllBikeRentOrderByDayPrice(String shopName);//查看相关自行车信息
	List<BikeRent> queryAllBikeRentByShopName(String shopName,String kindName);	//查看所有租借自行车
	
}
