package com.bwf.view;

import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.DisplayUtils;

/**
 * 退出登录
 * @author bwfadmin
 */
public class ExitView {
	public void exitView(){
		AdminLoginServiceImpl login = CentreView.getLogin();
		if(login.getUser()!=null){
			login.setUser(null);
			DisplayUtils.displayCtl("用户信息退出中", ".");
			System.out.println("登录信息退出成功！");
		}else{
			System.out.println("还没登录呢，你退出个啥！！");
		}
			
	}
}
