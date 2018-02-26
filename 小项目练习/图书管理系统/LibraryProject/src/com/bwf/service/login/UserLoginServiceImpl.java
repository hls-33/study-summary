package com.bwf.service.login;

import java.util.ArrayList;

import com.bwf.dao.admin.AdminInfoManageDaoImpl;
import com.bwf.entry.Info;
import com.bwf.entry.User;

public class UserLoginServiceImpl implements LoginService {
	private User user;
	private AdminInfoManageDaoImpl adInfoDao = new AdminInfoManageDaoImpl();
	/*
	 * 用户登录方法
	 */
	@Override
	public boolean login(User user) {
		ArrayList<Info> list = adInfoDao.findAll();
		//对所有信息进行筛选匹配，看账号是否能够登录
		for(Info info : list){
			User user1 = (User)info;
			//判断是否能够登录
			if(user1.getAuthority() == 1 && user1.getUsername().equals(user.getUsername())
					&& user1.getPassword().equals(user.getPassword())){
				this.user = user1;
				return true;
			}
		}
		return false;
	}
	/*
	 * 用户注册方法
	 */
	@Override
	public boolean regist(User user) {
		user.setAuthority(1);
		return adInfoDao.saveInfo(user);
	}
	public User getUser() {
		return user;
	}

}
