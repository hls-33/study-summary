package com.bwf.view;

import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.User;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DisplayUtils;
/**
 * 登录管理界面
 * @author bwfadmin
 *
 */
public class LoginView {
	private Scanner sc = CentreView.getSc();
	/**
	 * 登录界面
	 * @return
	 */
	public boolean login(){
		AdminLoginServiceImpl login = CentreView.getLogin();
		if(login.getUser() != null){
			System.out.println("用户已登录！");
			return true;
		}
		System.out.println("============登录界面============");
		String username = CtrlUtils.ctrlString(sc, "请输入登录账号：");
		String password = CtrlUtils.ctrlString(sc, "请输入登录密码：");
		User user = new User(0,0,username,password,null,0);//登录的用户信息
		DisplayUtils.displayCtl("登录中",".");
		if(login.login(user)){
			System.out.println("登陆成功！");
			return true;
		}
		else{
			System.out.println("登录失败！！");
			return false;
		}
	}
	@Test
	public void test(){
		System.out.println(login());
	}
}
