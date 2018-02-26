package com.bikesystem.hgg.dao;

import java.util.List;

import com.bikesystem.entity.BikeRent;

public interface IBikeRentDao {

	//查看所有的自行车信息
	public List<BikeRent> queryAllBikeRentNoRented(String shopname);
	
	//根据商店名查询记录
	public List<BikeRent> queryBikeRentByShopName(String shopName);
	
	//获取总页数
	public int getTotalPage(int pagecount,String shopname);
	
	//根据车牌号查看自行车信息
	public BikeRent queryBikeRentByBikeNumber(String bikeNumber);
	
	//添加出租的自行车信息
	public boolean insertBikeRent(BikeRent bikeRent);
	
	//删除信息
	public boolean deleteBikeRent(BikeRent bikeRent);
	
	//修改自行车信息
	public boolean updateBikeRent(String bikeNumber,double hourPrice,double dayPrice,double deposit);
	
	//判断车牌号是否存在
	public boolean queryBikeNumber(String bikenumber);
	
}
