package com.bikesystem.txz.ipml.service;
import com.bikesystem.entity.Admin;
import com.bikesystem.txz.interfaces.dao.IAdminDao;
import com.bikesystem.txz.interfaces.service.IAdminService;
public class AdminServiceIpml implements IAdminService {
	private IAdminDao admindao;
	public AdminServiceIpml(IAdminDao admindao) {
		super();
		this.admindao = admindao;
	}
	@Override
	public Admin adminLogin(String aphone, String password) {
//		管理员登陆
		if(aphone==null||password==null)
			return null;
		else if("".equals(aphone)||"".equals(password))
			return null;
		else return admindao.adminLogin(aphone, password);
	}

	@Override
	public boolean adminRegist(Admin admin) {
//		管理员注册
		if(admin==null)
			return false;
		else if(admin.getAphone()==null||admin.getName()==null||admin.getPassword()==null
				||admin.getIdnumber()==null)
			return false;
		else if("".equals(admin.getAphone())||"".equals(admin.getName())||"".equals(admin.getPassword())
				||"".equals(admin.getIdnumber()))
			return false;
		else return admindao.adminRegist(admin);
	}

	@Override
	public Admin queryAdminInfo(String aphone) {
		// 查询管理员个人信息
		if(aphone==null||"".equals(aphone))
			return null;
		return admindao.queryAdminInfo(aphone);
	}

	@Override
	public boolean updateAdminInfo(Admin admin) {
		// 修改管理员信息
		if(admin==null)
			return false;
		else if(admin.getAphone()==null||admin.getName()==null||admin.getPassword()==null
				||admin.getIdnumber()==null)
			return false;
		else if("".equals(admin.getAphone())||"".equals(admin.getName())||"".equals(admin.getPassword())
				||"".equals(admin.getIdnumber()))
			return false;
		else return admindao.updateAdminInfo(admin);
	}

	@Override
	public boolean deleteAdminInfo(int aid) {
		if(aid<0)
			return false;
		return admindao.deleteAdminInfo(aid);
	}
	@Override
	public boolean queryByAphone(String aphone) {
		if(aphone==null||"".equals(aphone))
			return false;
		else return admindao.queryByAphone(aphone);
	}
}
