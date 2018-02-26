package com.bikesystem.hs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;
import com.bikesystem.hs.dao.IBikeRentDao;
import com.bikesystem.hs.dao.IBikeSellDao;

public class ShopBikesSearchServiceImpl implements IShopBikesSearchService {
	private IBikeRentDao bikeRentDao;
	private IBikeSellDao bikeSellDao;
	
	
	public ShopBikesSearchServiceImpl(IBikeRentDao bikeRentDao, IBikeSellDao bikeSellDao) {
		super();
		this.bikeRentDao = bikeRentDao;
		this.bikeSellDao = bikeSellDao;
	}


	@Override
	public List<BikeSell> queryAllBikeSellByShopName(String shopName) {
		return bikeSellDao.queryAllBikeSellByShopName(shopName);
	}

	@Override
	public List<BikeSell> queryAllBikeSellOrderBySellCount(String shopName) {
		return bikeSellDao.queryAllBikeSellOrderBySellCount(shopName);
	}

	@Override
	public List<BikeSell> queryAllBikeSellOrderByBikeprice(String shopName) {
		return bikeSellDao.queryAllBikeSellOrderByBikeprice(shopName);
	}

	@Override
	public List<BikeSell> queryAllBikeSellByShopName(String shopName, String kindName) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("shopname", shopName);
		map.put("kindname", kindName);
		return bikeSellDao.queryAllBikeSellByParameter(map);
	}

	@Override
	public List<BikeRent> queryAllBikeRentByShopName(String shopName) {
		return bikeRentDao.queryAllBikeRentByShopName(shopName);
	}

	@Override
	public List<BikeRent> queryAllBikeRentOrderByRentCount(String shopName) {
		return bikeRentDao.queryAllBikeRentOrderByRentCount(shopName);
	}

	@Override
	public List<BikeRent> queryAllBikeRentOrderByDayPrice(String shopName) {
		return bikeRentDao.queryAllBikeRentOrderByDayPrice(shopName);
	}

	@Override
	public List<BikeRent> queryAllBikeRentByShopName(String shopName, String kindName) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("shopname", shopName);
		map.put("kindname", kindName);
		return bikeRentDao.queryAllBikeRentByParameter(map);
	}

}
