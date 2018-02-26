package com.bikesystem.txz.ipml.service;

import java.util.List;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.hs.dao.IBikeKindDao;
import com.bikesystem.txz.interfaces.service.IBikeKindService;

public class BikeKindServiceIpml implements IBikeKindService {
	private IBikeKindDao bikekinddao;
	public BikeKindServiceIpml(IBikeKindDao bikekinddao) {
		super();
		this.bikekinddao = bikekinddao;
	}

	@Override
	public boolean insertBikeKind(BikeKind bikeKind) {
		if(bikeKind==null)
			return false;
		return bikekinddao.insertBikeKind(bikeKind);
	}

	@Override
	public Boolean updateBikeKindInfo(BikeKind bikeKind) {
		if(bikeKind==null)
			return null;
		else return bikekinddao.updateBikeKindInfo(bikeKind);
	}

	@Override
	public List<BikeKind> queryAllBikeKind() {
		return bikekinddao.queryAllBikeKind();
	}

}
