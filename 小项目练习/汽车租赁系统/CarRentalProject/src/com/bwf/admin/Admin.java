package com.bwf.admin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.bwf.uitools.UiTools;
/**
 * Admin类是对系统使用者管理员角色的抽象，该类的实例代表一个“成功登录的管理员对象”，包含了账号、密码、管理员姓名等属性，
 * 还包含登录的静态方法，成功登录后返回当前的管理员对象，该对象拥有修改密码的方法。
 * （无论登录也好还是修改密码也好，都基于隐藏在Admin类私有的，静态的load和save方法，来读取配置文件中管理员的信息）
 * Admin的信息都存储在data\admin.txt中
 
 * @author bwfadmin
 */
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Admin> adminList;
	private String loginId;
	private String loginPsw;
	private String name;
	
	public Admin(){}
	
	public Admin(String loginId, String loginPsw, String name) {
		super();
		this.loginId = loginId;
		this.loginPsw = loginPsw;
		this.name = name;
	}
	/*
	 * 静态的登录方法，根据账号和密码查询管理员信息对象，没有查找到返回null
	 */
	public static Admin login(String loginId, String loginPsw) {
		boolean isFind = load();
		if(isFind){
			for(Admin ad : adminList){
				if(ad.getLoginId().trim().equals(loginId) && ad.getLoginPsw().trim().equals(loginPsw)){
					return ad;
				}
			}
			return null;
		}else{
			return null;
		}
	}
	/*
	 * 管理员对象的修改密码的方法
	 */
	public void modifyPsw() {
		Scanner sc = new Scanner(System.in);
		UiTools.printStar(150);
		System.out.println();
		UiTools.printBlack();
		UiTools.printSolid(39);
		System.out.println();
		UiTools.printBlack();
		System.out.println("-   汽车租赁系统>>>>>>后台管理>>>>>>修改密码     -");
		UiTools.printBlack();
		UiTools.printSolid(39);
		System.out.println();
		while(true){	//通过循环来控制判断是否输入的是正确的旧密码
			UiTools.printLine();
			System.out.print("请输入旧密码：");
			String oldPsw = sc.nextLine();
			if(oldPsw.trim().equals(this.loginPsw)){
				UiTools.printLine();
				System.out.print("请输入新密码:");
				this.loginPsw = sc.nextLine();
//				boolean isSave = save();
//				if(isSave){
				UiTools.printLine();
				System.out.print("密码修改成功！按任意非空格键返回上一级菜单：");
				sc.nextLine();
//				}else{
//					System.out.println("修改密码失败！");
//				}
				break;
			}else{
				System.out.println("旧密码输入错误！");
			}
		}
//		sc.close();
	}
	/*
	 * 读取admin.txt文件，加载所有的Admin对象信息
	 */
	@SuppressWarnings("unchecked")
	private static boolean load() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data"+File.separator+"admin.txt"));
			adminList = (ArrayList<Admin>) ois.readObject();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载Admin对象信息异常");
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
			}
		} 
		return false;
	}
	/*
	 *存储adminList中的所有Admin对象信息 
	 */
	public boolean save() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data"+File.separator+"admin.txt"));
			oos.writeObject(adminList);
			oos.flush();
			oos.close();
			return true;
		}catch (Exception e) {
			System.out.println("加载Admin对象信息异常");
		} 
		return false;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getLoginPsw() {
		return loginPsw;
	}
	
}
