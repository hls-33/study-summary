package com.bwf.dao.admin;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import com.bwf.entry.Info;
import com.bwf.entry.User;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class AdminInfoManageDaoImpl implements InfoManageDao {

	@Override
	public ArrayList<Info> findAll() {
		Connection con = DaoUtils.getConn();
		try{
			//查看所有的信息，以便之后登录遍历账号使用！
			String sql = "select * from login_info";
			ArrayList<Info> userList = BeanUtils.queryInfo(con, sql, "User");
			return userList;
		}catch(Exception e){return null;}
		finally{
			DaoUtils.close(con);
		}

	}
	/**
	 * 管理员注册账号（管理员权限账号账号 && 普通用户权限账号）
	 */
	@Override
	public boolean saveInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "insert into login_info(authority,username,password,nickname) "
					+ "values(?,?,?,?) ";
			User user = (User)info;
			Object[] params = {user.getAuthority(),user.getUsername(),user.getPassword(),
					user.getNickname()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/**
	 * 管理员修改用户信息
	 */
	@Override
	public boolean updateInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update login_info set authority=?,username=?,password=?,"
					+ "nickname=?,credits=? where login_id=? ";
			User user = (User)info;
			Object[] params = {user.getAuthority(),user.getUsername(),user.getPassword(),
					user.getNickname(),user.getCredits(),user.getLoginId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/**
	 * 管理员删除用户信息(只需要login_id信息，且管理员只能删除普通用户)
	 */
	@Override
	public boolean removeInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			//
			String sql = "delete from login_info where login_id=? and authority=1 ";
			User user = (User)info;
			Object[] params = {user.getLoginId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/**
	 * Root可删所有
	 * @param info
	 * @return
	 */
	public boolean removeInfoForRoot(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			//
			String sql = "delete from login_info where login_id=? ";
			User user = (User)info;
			Object[] params = {user.getLoginId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	@Test
	public void test(){
		User user = new User(1,1,"mrhu","mrhu123","小胡先生",100);
		saveInfo(user);
		ArrayList<Info> list = findAll();
		for(Info info : list)
			System.out.println(info);
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		// TODO Auto-generated method stub
		return null;
	}
}
