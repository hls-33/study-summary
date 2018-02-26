package com.bikesystem.hp.service;

import java.util.List;

import com.bikesystem.entity.BikeSellInfo;
import com.bikesystem.hp.dao.IBikeSellInfoDao;

public class BikeSellInfoServicImpl implements IBikeSellInfoService,IBikeSellInfoDao{

		private IBikeSellInfoDao ibsid;
		
	public BikeSellInfoServicImpl(IBikeSellInfoDao ibsid) {
			super();
			this.ibsid = ibsid;
		}

	@Override
	public List<BikeSellInfo> queryUserBikeRent(String name) {
	
		if(name.equals(null) || name.equals("")){
			return null;
		}
		return ibsid.queryUserBikeRent(name);
	}

	@Override
	public List<BikeSellInfo> queryAdminBikeRent(String shopname) {
		if(shopname.equals(null) || shopname.equals("")){
			return null;
		}
		return ibsid.queryAdminBikeRent(shopname);
	}

	@Override
	public boolean insertBikeSellInfo(BikeSellInfo BikeSellInfo) {
	
		if(BikeSellInfo.equals(null)){
			return false;
		}
		return ibsid.insertBikeSellInfo(BikeSellInfo);
	}

}
