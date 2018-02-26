package com.bwf.service.user;

import java.util.ArrayList;

import com.bwf.dao.user.UserInfoManageDaoImpl;
import com.bwf.entry.Info;
import com.bwf.entry.User;
import com.bwf.service.admin.InfoManageService;

public class UserInfoManageServcieImpl implements InfoManageService {
	private UserInfoManageDaoImpl userInfo = new UserInfoManageDaoImpl();
	/**
	 * 普通用户之用户信息查询（仅自己的）
	 */
	@Override
	public ArrayList<Info> findAll(Info info) {
		return userInfo.findAll(info);
	}
	/**
	 * 更改用户积分
	 */
	public boolean updateCredits(Info info , int creditDiff){
		ArrayList<Info> userList = findAll(info);
		User user = (User) userList.get(0);
		User newUser = new User(0, 1, user.getUsername(), null,null, (user.getCredits()-creditDiff));
		return userInfo.updateCredits(newUser);
	}
	/**
	 * 无此功能
	 */
	@Override
	public ArrayList<Info> findAll() {
		return null;
	}
	/**
	 * 无此功能
	 */
	@Override
	public boolean saveInfo(Info info) {
		return false;
	}
	/**
	 * 普通用户之修改密码
	 */
	@Override
	public boolean updateInfo(Info info) {
		return userInfo.updateInfo(info);
	}
	/**
	 * 无此功能
	 */
	@Override
	public boolean removeInfo(Info info) {
		return false;
	}
	

}
