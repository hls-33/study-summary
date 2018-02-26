package com.bikesystem.hs.dao;

import com.bikesystem.entity.UserScanner;

/**
 * 保存用户扫描二维码状态的Dao层
 * @author bwfadmin
 *
 */
public interface IUserScannerDao {
	/**
	 * 查询扫描状态
	 * @param uid
	 * @return
	 */
	public UserScanner queryUserScannerStateByUid(int uid);
	
	/**
	 * 修改扫描状态
	 * @param userScanner
	 * @return
	 */
	public boolean updateUserScannerState(UserScanner userScanner);
	
	/**
	 * 插入初始化的userscanner扫描信息（仅需要uid，state默认为false）
	 * @param uid
	 * @return
	 */
	public boolean insertInitUserScanner(int uid);
	
}
