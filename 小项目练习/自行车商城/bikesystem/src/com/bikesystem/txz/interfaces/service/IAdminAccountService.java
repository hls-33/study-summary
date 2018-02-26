package com.bikesystem.txz.interfaces.service;

import com.bikesystem.entity.AdminAccount;

public interface IAdminAccountService {
	AdminAccount queryAccountInfo(int acid);//查询管理员账户信息
	Boolean updateAccountInfo(AdminAccount adminAccount);//收入/支出修改
}
