package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.UserRent;
import com.bikesystem.hgg.dao.UserRentDaoImpl;

public class UserRentServiceImpl implements IUserRentService {
	
	private UserRentDaoImpl userRentDaoImpl;

	public UserRentServiceImpl(UserRentDaoImpl userRentDaoImpl) {
		super();
		this.userRentDaoImpl = userRentDaoImpl;
	}

	@Override
	public List<UserRent> queryAllUserRent() {
		// TODO Auto-generated method stub
		return userRentDaoImpl.queryAllUserRent();
	}

	@Override
	public List<UserRent> queryBikeRentByShopName(String shopName) {
		// TODO Auto-generated method stub
		return userRentDaoImpl.queryBikeRentByShopName(shopName);
	}

	


}
