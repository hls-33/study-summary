package com.bwf.dao.admin;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import com.bwf.entry.Info;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class AdminRentInfoManageDaoImpl implements InfoManageDao {
	
	/*
	 * 查看所有的租借信息
	 * 返回以个包含信息的ArrayList集合
	 */
	@Override
	public ArrayList<Info> findAll() {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "select * from rent_info ";
			ArrayList<Info> rentList = BeanUtils.queryInfo(con, sql, "Rent");
			return rentList;
		}catch(Exception e){return null;}
		finally{
			DaoUtils.close(con);
		}
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		return null;
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
	@Test
	public void test(){
//		ArrayList<Info> list = findAll();
//		System.out.println(list);
//		for(Info info : list)
//			System.out.println(info);
	}

	
}
