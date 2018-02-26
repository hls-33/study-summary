package com.bikesystem.txz.ipml.service;

import java.util.List;

import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.IUserRentDao;
import com.bikesystem.txz.interfaces.service.IUserRentQueryService;

public class UserRentQueryServletIpml implements IUserRentQueryService {
	private IUserRentDao userdao;
	public UserRentQueryServletIpml(IUserRentDao userdao) {
		super();
		this.userdao = userdao;
	}
	@Override
	public List<UserRent> getUserRentByName(String name) {
		if(name==null||"".equals(name))
			return null;
		else return userdao.queryUserBikeRentByUsername(name);
	}

}
