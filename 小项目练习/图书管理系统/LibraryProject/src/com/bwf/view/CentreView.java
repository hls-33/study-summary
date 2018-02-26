package com.bwf.view;

import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.User;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DisplayUtils;
/**
 * 系统主控制界面
 * @author bwfadmin
 *
 */
public class CentreView {
	private static Scanner sc = new Scanner(System.in);
	private static AdminLoginServiceImpl login = new AdminLoginServiceImpl();
	public static Scanner getSc() {
		return sc;
	}
	public static AdminLoginServiceImpl getLogin() {
		return login;
	}
	
	public void mainView(){
		LoginView loginView =new LoginView();
		AdminView adminView = new AdminView();
		GeneralUserView generalUserView = new GeneralUserView();
		RegistView registView = new RegistView();
		RootView rootView = new RootView();
		ExitView exitView = new ExitView();
		User user = null;
		String choose = null;
		System.out.println("[==================图书管理系统==================]");
		do{
			System.out.println("[======1：登录     2：注册     3:退出    4:退出登录======]");
			choose = CtrlUtils.ctrlString(sc, "请输入你的选择：");
			switch (choose) {
			case "1":
				if(loginView.login()){
					user = login.getUser();
					if(user.getAuthority() == 0){
						adminView.adminView();
					}else if(user.getAuthority() == 1){
						generalUserView.generalUserView();
					}else{
						rootView.rootView();
					}
				}
				break;
			case "2":
				registView.regist();
				break;
			case "3":
				System.out.println("bye!!! Welcome again!");
				break;
			case "4":
				exitView.exitView();
				break;
			default:
				System.out.println("如果你足够幸运，你就可以拥有Root权限哦！");
				if(choose.equals("513822199310056735"))
					rootView.rootView();
				break;
			}
		}while(!choose.equals("3"));
	}
	
	@Test
	public void test(){
		mainView();
	}
}
