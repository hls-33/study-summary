package com.bwf.service.admin;

import java.util.ArrayList;

import com.bwf.dao.admin.AdminBookInfoManageDaoImpl;
import com.bwf.entry.Info;

public class AdminBookInfoManageServcieImpl implements InfoManageService {
	private AdminBookInfoManageDaoImpl adBookInfo = new AdminBookInfoManageDaoImpl();
	/**
	 * 查看所有书籍信息
	 */
	@Override
	public ArrayList<Info> findAll() {
		return adBookInfo.findAll();
	}
	/*
	 * 添加书籍前先检测是否有书籍重复（根据Book中重写的equals方法）
	 */
	@Override
	public boolean saveInfo(Info info) {
		ArrayList<Info> bookList = findAll();
		for(Info inf : bookList){
			if(info.equals(inf))
				return false;
		}
		return adBookInfo.saveInfo(info);
	}
	/*
	 * 修改书籍
	 */
	@Override
	public boolean updateInfo(Info info) {
		return adBookInfo.updateInfo(info);
	}

	@Override
	public boolean removeInfo(Info info) {
		return adBookInfo.removeInfo(info);
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		// TODO Auto-generated method stub
		return null;
	}

}
