package com.bwf.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.Info;
import com.bwf.entry.User;
import com.bwf.service.admin.AdminInfoManageServcieImpl;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.service.user.UserInfoManageServcieImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DisplayUtils;
/**
 * 用户控制界面中间功能层
 * @author bwfadmin
 *
 */
public class UserView {
	private Scanner sc = CentreView.getSc();
	/**
	 * 用户信息值查询（管理员可查看所有普通用户，普通用户仅能查看自己的信息）
	 */
	public boolean lookUser(){
		System.out.println("======用户信息查询界面======");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null )
			return false;
		if(user.getAuthority() == 0){//管理员查看所普通用户信息
			AdminInfoManageServcieImpl adminUser = new AdminInfoManageServcieImpl();
			ArrayList<Info> userList = adminUser.findAll();
			if(userList == null)
				return false;
			DisplayUtils.displayCtl("用户信息检索中", ".");
			if(userList.size() == 0)
				System.out.println("暂无任何普通用户信息！！");
			else{
				for(Info info : userList){
					System.out.println("<<"+info+">>");
				}
			}
			return true;
		}else if(user.getAuthority() == 999){	//超级Root管理
			AdminInfoManageServcieImpl adminUser = new AdminInfoManageServcieImpl();
			ArrayList<Info> userList = adminUser.findAllForRoot();
			if(userList == null)
				return false;
			DisplayUtils.displayCtl("用户信息检索中", ".");
			if(userList.size() == 0)
				System.out.println("暂无任何用户信息！！");
			else{
				for(Info info : userList){
					System.out.println("<<"+info+">>");
				}
			}
			return true;
		}else{
			UserInfoManageServcieImpl generalUser = new UserInfoManageServcieImpl();
			ArrayList<Info> userList = generalUser.findAll(user);
			if(userList == null)
				return false;
			DisplayUtils.displayCtl("用户信息检索中", ".");
			System.out.println("<<"+userList.get(0)+">>");
			return true;
		}
	}
	/**
	 * 用户信息增加（即注册）(管理员和普通用户均可注册)
	 */
	public boolean addUser(){
		RegistView rv = new RegistView();
		return rv.regist();
	}
	
	/**
	 * 普通用户信息更改（管理员可改所有普通用户，普通用户只能修改自己的密码）
	 */
	public boolean updateUser(){
		System.out.println("======用户信息修改界面======");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		if(user.getAuthority() == 0 || user.getAuthority() == 999){//管理员可修改所普通用户信息，Root可改所有
			AdminInfoManageServcieImpl adminUser = new AdminInfoManageServcieImpl();
			int loginId = CtrlUtils.ctrlInt(sc, "请输入你要修改的用户ID：");
			User user1 = null;
			if(user.getAuthority() == 0)
				user1 = adminUser.getUserById(loginId);
			else
				user1 = adminUser.getUserByIdForRoot(loginId);
			if(user1 == null){
				System.out.println("都没有的用户编号ID，你改啥啊！！");
				return false;
			}
			System.out.print("你要修改的用户信息如下：\n"+user1+"\n");
			int authority = 0;
			if(user.getAuthority() == 0)
				authority= CtrlUtils.ctrlInt(sc, "请输入你要修改的用户权限（0：管理员/1：普通用户）：");
			else
				authority = 999;
			String username = CtrlUtils.ctrlString(sc, "请输入你要修改的用户登录名：");
			String password = CtrlUtils.ctrlString(sc, "请输入你要修改的用户登录密码：");
			String nickname = CtrlUtils.ctrlString(sc, "请输入你要修改的用户昵称：");
			int credits = CtrlUtils.ctrlInt(sc, "请输入你要修改的用户积分：");
			User newUser = new User(loginId, authority, username, 
					password, nickname, credits);
			boolean flag = adminUser.updateInfo(newUser);
			DisplayUtils.displayCtl("用户信息更新中", ".");
			if(flag){
				System.out.println("用户信息更改成功！！");
			}else{
				System.out.println("mission failed , try again please!!");
			}
			return flag;
		}else{		//普通用户只能更改自己的密码
			System.out.println(user);
			UserInfoManageServcieImpl generalUser = new UserInfoManageServcieImpl();
			String password = CtrlUtils.ctrlString(sc, "请用户输入旧密码：");
			if(!password.equals(user.getPassword())){
				System.out.println("密码错误！");
				return false;
			}
			String newPass = null;
			while(true){
				newPass = CtrlUtils.ctrlString(sc, "请输入您的新密码：");
				String confirm = CtrlUtils.ctrlString(sc, "请确认您的新密码：");
				if(newPass.equals(confirm))
					break;
				else
					System.out.println("两次输入不匹配！");
			}
			User newUser = new User(0, 1, user.getUsername(), newPass, null, 0);
			boolean flag = generalUser.updateInfo(newUser);
			DisplayUtils.displayCtl("密码修改中", ".");
			if(flag){
				DisplayUtils.displayCtl("用户密码更改成功！即将回到登录界面，请用新账号重新登录！", ".");
				GeneralUserView.changedPass=true;
				login.setUser(null);
			}else{
				System.out.println("mission failed , try again please!!");
			}
			return flag;
		}
	}
	
	/**
	 * 普通用户信息删除（仅管理员可操作）
	 */
	public boolean removeUser(){
		System.out.println("======用户信息删除界面======");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null || user.getAuthority() ==1)
			return false;
		AdminInfoManageServcieImpl adminUser = new AdminInfoManageServcieImpl();
		int loginId = CtrlUtils.ctrlInt(sc, "请输入你需要删除的用户Id:");
		User user1 = null;
		if(user.getAuthority() == 0)
			user1 = adminUser.getUserById(loginId);
		else
			user1 = adminUser.getUserByIdForRoot(loginId);
		if(user1 == null){
			System.out.println("用户不存在或您的权限不够！");
			return false;
		}
		if(user1.getAuthority() == 999){
			System.out.print("超级Root不可删除！");
			DisplayUtils.displayCtl("系统受保护中", ".");
			System.out.println("再见！");
			System.exit(0);
		}
		System.out.print("你要删除的的用户信息如下：\n"+user1+"\n");
		String choose = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
		boolean flag = false;
		if(choose.equals("y")){
			User removeUser = new User(loginId, 1, null, null, null, 0);
			flag = adminUser.removeInfoForRoot(removeUser);
			DisplayUtils.displayCtl("删除中", ".");
			if(flag){
				System.out.println("用户信息删除成功！！");
			}else{
				System.out.println("mission failed , try again please!!");
			}
		}else{
			System.out.println("用户删除取消！！");
		}
		return flag;
	}
	
	@Test
	public void test(){
		LoginView lv = new LoginView();
		lv.login();
		System.out.println(addUser());
		System.out.println(updateUser());
		System.out.println(removeUser());
		lookUser();
	}
}
