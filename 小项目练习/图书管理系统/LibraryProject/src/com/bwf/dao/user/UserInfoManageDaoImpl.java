package com.bwf.dao.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.bwf.dao.admin.InfoManageDao;
import com.bwf.entry.Info;
import com.bwf.entry.User;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class UserInfoManageDaoImpl implements InfoManageDao {
	/*
	 * 普通用户之用户信息查询（仅自己的）
	 */
	@Override
	public ArrayList<Info> findAll(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "select * from login_info where username=?";
			User user = (User)info;
			Object[] params = {user.getUsername()};
			ArrayList<Info> userList = BeanUtils.queryInfo(con, sql, "User",params);
			return userList;
		}catch(Exception e){return null;}
		finally{
			DaoUtils.close(con);
		}
	}
	/*
	 * 普通用户之用户密码修改（User信息中仅有密码和账号为有效项）
	 */
	public boolean updateCredits(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update login_info set credits=? where username=? and authority=1 ";
			User user = (User)info;
			Object[] params = {user.getCredits(),user.getUsername()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	@Override
	public ArrayList<Info> findAll() {
		return null;
	}
	/*
	 * 无此功能
	 */
	@Override
	public boolean saveInfo(Info info) {
		return false;
	}
	/*
	 * 普通用户之用户密码修改（User信息中仅有密码和账号为有效项）
	 */
	@Override
	public boolean updateInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update login_info set password=? where username=? and authority=1 ";
			User user = (User)info;
			Object[] params = {user.getPassword(),user.getUsername()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/*
	 * 无此功能
	 */
	@Override
	public boolean removeInfo(Info info) {
		return false;
	}
	
//	@Test
//	public void test(){
//		User user = new User(1,1,"mrhu","mrhu123","小胡先生",100);
////		updateInfo(user);
//		ArrayList<Info> list = findAll(user);
//		for(Info info : list)
//			System.out.println(info);
//	}
}
