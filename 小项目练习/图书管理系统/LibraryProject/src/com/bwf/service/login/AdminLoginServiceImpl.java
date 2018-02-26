package com.bwf.service.login;

import java.util.ArrayList;

import com.bwf.dao.admin.AdminInfoManageDaoImpl;
import com.bwf.entry.Info;
import com.bwf.entry.User;

public class AdminLoginServiceImpl implements LoginService {
	private User user ;	//用来存储登陆成功后的用户信息
	private AdminInfoManageDaoImpl adInfoDao = new AdminInfoManageDaoImpl();
	/**
	 * 登录方法(超级Root用户不能直接通过登录进入，需在登录界面使用口令)
	 */
	@Override
	public boolean login(User user) {
		ArrayList<Info> list = adInfoDao.findAll();
		//对所有信息进行筛选匹配，看账号是否能够登录
		for(Info info : list){
			User user1 = (User)info;
			//判断是否能够登录
			if(user1.getUsername().equals(user.getUsername())
					&& user1.getPassword().equals(user.getPassword())
					&& (user1.getAuthority() == 0 || user1.getAuthority() ==1)){
				this.user = user1;
				return true;
			}
		}
		return false;
	}
	/**
	 * 专属Root的账号信息获取方法
	 * @param user
	 * @return
	 */
	public boolean loginForRoot(User user) {
		ArrayList<Info> list = adInfoDao.findAll();
		//对所有信息进行筛选匹配，看账号是否能够登录
		for(Info info : list){
			User user1 = (User)info;
			//判断是否能够登录
			if(user1.getUsername().equals(user.getUsername())
					&& user1.getPassword().equals(user.getPassword())
					&& user1.getAuthority() ==999){
				this.user = user1;
				return true;
			}
		}
		return false;
	}
	/*
	 * 管理员注册方法
	 */
	@Override
	public boolean regist(User user) {
		return adInfoDao.saveInfo(user);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
