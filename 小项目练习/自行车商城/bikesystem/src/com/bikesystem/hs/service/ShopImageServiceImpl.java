package com.bikesystem.hs.service;

import java.util.List;

import com.bikesystem.entity.ShopImage;
import com.bikesystem.hs.dao.IShopImageDao;

public class ShopImageServiceImpl implements IShopImageService {
	private IShopImageDao shopImageDao;
	
	public ShopImageServiceImpl(IShopImageDao shopImageDao) {
		super();
		this.shopImageDao = shopImageDao;
	}

	@Override
	public List<ShopImage> queryShopImage(String shopname, String imagename) {
		return shopImageDao.queryShopImage(shopname,imagename);
	}

	@Override
	public boolean insertShopImage(ShopImage shopImage) {
		return shopImageDao.insertShopImage(shopImage);
	}

	@Override
	public boolean updateShopImage(ShopImage shopImage) {
		return shopImageDao.updateShopImage(shopImage);
	}

}
