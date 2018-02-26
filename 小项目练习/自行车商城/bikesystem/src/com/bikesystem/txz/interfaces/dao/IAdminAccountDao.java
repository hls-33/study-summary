package com.bikesystem.txz.interfaces.dao;
import com.bikesystem.entity.AdminAccount;
public interface IAdminAccountDao {
	AdminAccount queryAccountInfo(int acid);//查询管理员账户信息
	Boolean updateAccountInfo(AdminAccount adminAccount);//收入/支出修改
	Boolean insertAdminAccount(AdminAccount adminAccount);//管理员注册时添加对应账目信息
}
