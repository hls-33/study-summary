package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.BikeKind;

public interface BikeKindService {
	
	//查看所有自行车种类
	public List<BikeKind> queryAllBikeKind();
}
