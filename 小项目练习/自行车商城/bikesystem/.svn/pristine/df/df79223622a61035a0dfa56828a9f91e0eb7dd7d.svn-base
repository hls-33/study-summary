package com.bikesystem.hgg.dao;

import java.util.List;

import com.bikesystem.entity.BikeDestroy;

public interface IBikeDestroyDao {
	//添加自行车报废信息
	public boolean insertBikeDestory(BikeDestroy bikeDestory);
	
	//删除已经报废的自行车信息
	public boolean deleteBikeByBikeNumber(String bikeNumber);
	
	//根据商店名查询店内所有自行车报废信息
	public List<BikeDestroy > queryBikeDestroy(String shopName);
	
	
}
