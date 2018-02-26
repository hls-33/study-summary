package com.bwf.service.admin;

import java.util.ArrayList;

import com.bwf.dao.admin.AdminRentInfoManageDaoImpl;
import com.bwf.entry.Info;

public class AdminRentInfoManageServcieImpl implements InfoManageService {
	private AdminRentInfoManageDaoImpl adRentInfo = new AdminRentInfoManageDaoImpl();
	/*
	 * 管理员查看租借信息
	 */
	@Override
	public ArrayList<Info> findAll() {
		return adRentInfo.findAll();
	}
	/*
	 * 存储租借信息（无此功能）
	 */
	@Override
	public boolean saveInfo(Info info) {
		return false;
	}
	/*
	 * 修改租借信息（无此功能）
	 */
	@Override
	public boolean updateInfo(Info info) {
		return false;
	}
	/*
	 * 删除租借信息（无此功能）
	 */
	@Override
	public boolean removeInfo(Info info) {
		return false;
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		return null;
	}

}
