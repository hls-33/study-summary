package com.bikesystem.hgg.service;

import java.util.List;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.hgg.dao.BaseDao;
import com.bikesystem.hs.dao.IBikeKindDao;

public class BikeKindServiceImpl extends BaseDao implements IBikeKindDao {
	private IBikeKindDao iBikeKindDao;
	
	public BikeKindServiceImpl(IBikeKindDao iBikeKindDao) {
		super();
		this.iBikeKindDao = iBikeKindDao;
	}

	@Override
	public boolean insertBikeKind(BikeKind bikeKind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBikeKindInfo(BikeKind bikeKind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BikeKind> queryAllBikeKind() {
		// TODO Auto-generated method stub
		return iBikeKindDao.queryAllBikeKind();
	}

}
