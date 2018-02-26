package com.bwf.admin;

import java.util.Scanner;

import com.bwf.car_manage.CarMgr;
import com.bwf.uitools.UiTools;
/**
 * SystemManager类是整个“汽车租赁管理系统的抽象”，该类的实例代表一个“系统对象”，有一个work方法，调用后，整个系统开始工作。
 * @author bwfadmin
 */
public class SystemManager {
	private Scanner sc = new Scanner(System.in);
	private Admin admin; // 代表整个系统中的管理员
	private CarMgr carMgr = new CarMgr(this); // 代表系统中的汽车管理对象
	
	/*
	 * 开始工作的方法，显示系统名称，进入登录环节，
	 * 登录环节可以调用Admin类的静态方法Admin login(String loginId, String loginPsw);
	 */
	public void work() {
		UiTools.printBlack();
		System.out.println("******************************************");
		UiTools.printBlack();
		System.out.println("*                                        *");
		UiTools.printBlack();
		System.out.println("*                                        *");
		UiTools.printBlack();
		System.out.println("****===========汽车租赁系统V1.0============***");
		UiTools.printBlack();
		System.out.println("*                                        *");
		UiTools.printBlack();
		System.out.println("*                                        *");
		UiTools.printBlack();
		System.out.println("******************************************");
		UiTools.printBlack();
		System.out.println("—————————————————请管理员先登录————————————————");
		while(true){
			UiTools.printLine();
			System.out.print("输入用户名：");
			String loginId = sc.nextLine();
			UiTools.printLine();
			System.out.print("输入密码：");
			String loginPsw = sc.nextLine();
			this.admin = Admin.login(loginId, loginPsw);
			if(this.admin != null){
				showMenu();
				break;
			}else{
				UiTools.printBlack();
				System.out.println("用户名或密码错误，请重新输入！");
			}
		}
//		sc.close();
	}
	/*
	 * 登录成功后，进入后台管理主菜单，包括密码修改、汽车管理、租赁管理
	 */
	private void showMenu() {
//		Scanner sc = new Scanner(System.in);
		String choose = null;
		do{
			UiTools.printStar(150);
			System.out.println();
			UiTools.printBlack();
		  System.out.println("---------------------------------------");
		  	UiTools.printBlack();
		  	System.out.println("-          您好  "+this.admin.getName()+",欢迎您进入系统                              -");
			UiTools.printBlack();
		  
		  System.out.println("-         汽车租赁系统>>>>>>后台管理                            -");
		  UiTools.printBlack();
		  System.out.println("-              1-修改密码                                                 -");
		  UiTools.printBlack();
		  System.out.println("-              2-汽车管理                                                 -");
		  UiTools.printBlack();
		  System.out.println("-              3-租赁管理                                                 -");
		  UiTools.printBlack();
		  System.out.println("----------------------------------------");
			UiTools.printLine();
			System.out.print("请输入菜单编号进行选择，输入其他退出系统：");
			choose= sc.nextLine();
			switch (choose) {
			case "1":
				this.admin.modifyPsw();
				break;
			case "2":
				this.carMgr.showCarMenu();
				break;
			case "3":
				this.carMgr.showRentalMenu();
				break;
			default:
				//在退出系统时候保存所有信息到文件中。
				this.admin.save();
				this.carMgr.save();
				this.carMgr.saveRecord();
				System.out.println("退出系统");
				break;
		}
		}while(choose.equals("1") || choose.equals("2") || choose.equals("3"));
//		sc.close();
	}
	
	
	//getter
	public Admin getAdmin() {
		return admin;
	}
	
}
