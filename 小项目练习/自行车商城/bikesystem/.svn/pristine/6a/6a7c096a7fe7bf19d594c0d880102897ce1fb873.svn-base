package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.UserRent;
import com.bikesystem.hgg.dao.IAdminUserRentDao;

public class AdminUserRentServiceImpl implements IAdminBikeRentService {
	private IAdminUserRentDao iAdminUserRentDao;

	public AdminUserRentServiceImpl(IAdminUserRentDao iAdminUserRentDao) {
		super();
		this.iAdminUserRentDao = iAdminUserRentDao;
	}

	//查询商店内自行车被租借的信息
	@Override
	public List<UserRent> queryUserRentByShopName(String shopName) {
		// TODO Auto-generated method stub
		return iAdminUserRentDao.queryBikeRentByShopName(shopName);
	}

}
