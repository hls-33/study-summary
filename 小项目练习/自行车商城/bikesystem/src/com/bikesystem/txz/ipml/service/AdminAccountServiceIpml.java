package com.bikesystem.txz.ipml.service;
import com.bikesystem.entity.AdminAccount;
import com.bikesystem.txz.interfaces.dao.IAdminAccountDao;
import com.bikesystem.txz.interfaces.service.IAdminAccountService;
public class AdminAccountServiceIpml implements IAdminAccountService {
	private IAdminAccountDao acd;
	public AdminAccountServiceIpml(IAdminAccountDao acd) {
		super();
		this.acd = acd;
	}
	@Override
	public AdminAccount queryAccountInfo(int aid) {
		// 查询管理员账户信息
		if(aid<0)
			return null;
		return acd.queryAccountInfo(aid);
	}
	@Override
	public Boolean updateAccountInfo(AdminAccount adminAccount) {
		//修改管理员账户信息
		if(adminAccount==null)
			return null;
		else if(adminAccount.getAphone()==null||adminAccount.getAid()<0)
			return null;
		else if("".equals(adminAccount.getAphone()))
			return null;
		else return acd.updateAccountInfo(adminAccount);
	}
}
