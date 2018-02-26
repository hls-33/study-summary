package com.bikesystem.hs.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.bikesystem.entity.UserRent;
import com.bikesystem.entity.UserScanner;
import com.bikesystem.utils.JdbcUtils;

public class UserScannerDaoImpl implements IUserScannerDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	/**
	 * 查询对应uid的扫描状态 
	 */
	@Override
	public UserScanner queryUserScannerStateByUid(int uid) {
		String sql="select * from user_scanner where uid=? ";
		try{
			return qr.query(sql, new BeanHandler<UserScanner>(UserScanner.class),uid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更新扫描状态
	 */
	@Override
	public boolean updateUserScannerState(UserScanner userScanner) {
		String sql="update user_scanner set scannerstate=? ";
		try{
			if(qr.update(sql, userScanner.getScannerstate())>0)return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 插入初始化状态信息
	 */
	@Override
	public boolean insertInitUserScanner(int uid) {
		String sql="insert into user_scanner(uid) values(?) ";
		try{
			if(qr.update(sql, uid)>0)return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
