package com.bwf.view;

import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.User;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
/**
 * 普通用户控制界面
 * @author bwfadmin
 *
 */
public class GeneralUserView {
	public static boolean changedPass = false;
	public void generalUserView(){
		RentView rentView = new RentView();
		BookView bookView = new BookView();
		UserView userView = new UserView();
		RechargeView rechargeView = new RechargeView();
		Scanner sc = CentreView.getSc();
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		boolean flag = true;
		changedPass:	//用户密码修改后控制回到登录界面的跳出循环的标签
		while(flag){
			flag = true;
			System.out.println("亲爱的用户<<"+user.getNickname()+">>你好！");
			System.out.println("————[1：图书管理     2：租借管理     3:用户管理    4:积分充值<输入其他数字返回上一级菜单>]————");
			int choose = CtrlUtils.ctrlInt(sc, "请输入你的选择：");
			switch (choose) {
			case 1:
				boolean flag1 = true;
				while(flag1){
					flag1 = true;
					System.out.println("============图书管理============");
					System.out.println("————[1：图书查看    <输入其他数字返回上一级菜单>]————");
					int choose1 = CtrlUtils.ctrlInt(sc, "请输入你的选择：");
					switch (choose1) {
					case 1:
						bookView.lookAllBook();
						break;
					default:
						flag1 = false;
						break;
					}
				}
				break;
			case 2:
				boolean flag2 = true;
				while(flag2){
					flag2 = true;
					System.out.println("============租借管理============");
					System.out.println("————[1：租借信息查看    2：图书借阅     3:图书续借   4：图书归还 <输入其他数字返回上一级菜单>]————");
					int choose2 = CtrlUtils.ctrlInt(sc, "请输入你的选择：");
					switch (choose2) {
					case 1:
						rentView.lookAll();
						break;
					case 2:
						rentView.rentBook();
						break;
					case 3:
						rentView.renew();
						break;
					case 4:
						rentView.returnRent();
						break;
					default:
						flag2 = false;
						break;
					}
				}
				break;
			case 3:
				boolean flag3 = true;
				while(flag3){
					flag3 = true;
					System.out.println("============用户管理============");
					System.out.println("————[1：信息查看      2:密码修改    <输入其他数字返回上一级菜单>]————");
					int choose3 = CtrlUtils.ctrlInt(sc, "请输入你的选择：");
					switch (choose3) {
					case 1:
						userView.lookUser();
						break;
					case 2:
						userView.updateUser();
						if(changedPass){
							break changedPass;
						}
						break;
					default:
						flag3 = false;
						break;
					}
				}
				break;
			case 4:
				rechargeView.rechargeView();
				break;
			default:
				flag = false;
				break;
			}
		}
	}
	
	@Test
	public void test(){
		LoginView lv = new LoginView();
		lv.login();
		generalUserView();
	}
}
