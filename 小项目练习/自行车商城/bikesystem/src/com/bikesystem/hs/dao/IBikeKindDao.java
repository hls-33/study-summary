package com.bikesystem.hs.dao;

import java.util.List;

import com.bikesystem.entity.BikeKind;

/**
 * 自行车中了你Dao层
 * @author 祷
 *
 */
public interface IBikeKindDao {
	boolean insertBikeKind(BikeKind bikeKind);	//添加自行车种类
	boolean updateBikeKindInfo(BikeKind bikeKind);  //修改自行车种类信息
	List<BikeKind> queryAllBikeKind();		//查看种类

}
