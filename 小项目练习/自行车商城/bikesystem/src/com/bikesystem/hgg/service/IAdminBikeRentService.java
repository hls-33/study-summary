package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.UserRent;

public interface IAdminBikeRentService {

	//查询店铺内自行车被租借的信息
	public List<UserRent> queryUserRentByShopName(String shopName);
}
