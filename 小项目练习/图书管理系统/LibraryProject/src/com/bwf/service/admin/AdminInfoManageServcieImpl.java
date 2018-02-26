package com.bwf.service.admin;

import java.util.ArrayList;

import com.bwf.dao.admin.AdminInfoManageDaoImpl;
import com.bwf.entry.Info;
import com.bwf.entry.User;

public class AdminInfoManageServcieImpl implements InfoManageService {
	private AdminInfoManageDaoImpl adInfo = new AdminInfoManageDaoImpl();
	/**
	 * 管理员查看普通用户信息
	 */
	@Override
	public ArrayList<Info> findAll() {
		ArrayList<Info> list =  adInfo.findAll();
		ArrayList<Info> userList = new ArrayList<>();
		//对所有信息进行筛选，只留下普通用户信息供管理员查看
		for(Info info : list){
			User user1 = (User)info;
			if(user1.getAuthority() == 1)
				userList.add(info);
		}
		return userList;
	}
	/**
	 * Root查看所有用户
	 */
	public ArrayList<Info> findAllForRoot(){
		return adInfo.findAll();
	}
	/**
	 * 通过loginId获取普通用户User对象
	 */
	public User getUserById(int loginId){
		ArrayList<Info> userInfo = findAll();
		if(userInfo == null || userInfo.size() == 0)
			return null;
		for(Info info : userInfo){
			User user = (User)info;
			if(user.getLoginId() == loginId ){
				return user;
			}
		}
		return null;
	}
	/**
	 * Root可获取所有用户对象
	 */
	public User getUserByIdForRoot(int loginId){
		ArrayList<Info> userInfo = findAllForRoot();
		for(Info info : userInfo){
			User user = (User)info;
			if(user.getLoginId() == loginId ){
				return user;
			}
		}
		return null;
	}
	
	/**
	 * 管理员注册用户信息
	 */
	@Override
	public boolean saveInfo(Info info) {
		User user = (User)info;
		//必须权限值是0或1才能注册
		if(user.getAuthority() !=0 && user.getAuthority()!=1)
			return false;
		return adInfo.saveInfo(info);
	}
	/**
	 * 管理员修改普通用户信息
	 */
	@Override
	public boolean updateInfo(Info info) {
		return adInfo.updateInfo(info);
	}
	/**
	 * 管理员删除普通用户信息
	 */
	@Override
	public boolean removeInfo(Info info) {
		return adInfo.removeInfo(info);
	}
	/**
	 * Root账户
	 * @param info
	 * @return
	 */
	public boolean removeInfoForRoot(Info info) {
		return adInfo.removeInfoForRoot(info);
	}
	/**
	 * 无此功能
	 */
	@Override
	public ArrayList<Info> findAll(Info info) {
		return null;
	}

}
