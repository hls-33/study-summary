package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.BikeRent;

public interface IBikeRentService {

	//查看所有的自行车信息
	public List<BikeRent> queryAllBikeRentNoRented(String shopname);
	
	//根据商店名查看自行车
	public List<BikeRent> queryBikeRentByShopName(String shopName);
	
	//获取总页数
	public int getTotalPage(int pagecount,String shopname);

	//添加租赁自行车
	public boolean insertBikeRent(BikeRent bikeRent);
	
	//根据车牌号查询自行车
	public BikeRent queryBikeRentByBikeNumber(String bikeNumber);
	
	//删除信息
	public boolean deleteBikeRent(BikeRent bikeRent);
	
	//修改车子信息
	public boolean updateBikeRent(String bikeNumber,double hourPrice,double dayPrice,double deposit);
	
	//判断车牌号是否存在
	public boolean queryBikeNumber(String bikenumber);
}
