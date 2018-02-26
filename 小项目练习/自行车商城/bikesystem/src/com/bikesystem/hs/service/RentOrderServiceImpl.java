package com.bikesystem.hs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.Shop;
import com.bikesystem.entity.ShopRentSale;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.IBikeRentDao;
import com.bikesystem.hs.dao.IShopDao;
import com.bikesystem.hs.dao.IShopRentSaleDao;
import com.bikesystem.hs.dao.IUserRentDao;

public class RentOrderServiceImpl implements IRentOrderService {
	private IBikeRentDao bikeRentDao;
	private IUserRentDao userRentDao;
	private IShopDao shopDao;
	private IShopRentSaleDao rentSaleDao;
	
	public RentOrderServiceImpl(IBikeRentDao bikeRentDao, 
			IUserRentDao userRentDao,IShopDao shopDao,IShopRentSaleDao rentSaleDao) {
		super();
		this.bikeRentDao = bikeRentDao;
		this.userRentDao = userRentDao;
		this.shopDao = shopDao;
		this.rentSaleDao = rentSaleDao;
	}
	
	@Override
	public BikeRent queryRentByBrid(String brid) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("brid",brid);
		List<BikeRent> list=bikeRentDao.queryAllBikeRentByParameter(map);
		if(list!=null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserRent queryUserRentByBikeNumber(String bikenumber) {
		return userRentDao.queryUserBikeRentByBikeNumber(bikenumber);
	}

	@Override
	public Shop queryShopByShopname(String shopname) {
		return shopDao.queryShopByShopname(shopname);
	}

	@Override
	public ShopRentSale queryRentSaleByBrid(int brid) {
		return rentSaleDao.queryRentSaleByBrid(brid);
	}
	
	
}
