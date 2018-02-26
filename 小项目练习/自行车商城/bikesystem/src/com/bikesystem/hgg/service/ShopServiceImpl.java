package com.bikesystem.hgg.service;

import com.bikesystem.hgg.dao.IShopDao;

public class ShopServiceImpl implements IShopService {
	private IShopDao iShopDao;
	
	public ShopServiceImpl(IShopDao iShopDao) {
		super();
		this.iShopDao = iShopDao;
	}

	@Override
	public String queryShopNameByAid(int aid) {
		// TODO Auto-generated method stub
		return iShopDao.queryShopNameByAid(aid);
	}

}
