package com.bwf.view;

import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.User;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
/**
 * 注册界面
 * @author bwfadmin
 *
 */
public class RegistView {
	private Scanner sc = CentreView.getSc();
	public boolean regist(){
		System.out.println("============注册界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null){	//若未登录，则只能进行普通账号的注册
			System.out.println("亲爱的用户<<游客>>你好！");
			String username = CtrlUtils.ctrlString(sc, "请输入注册账号：");
			String password = CtrlUtils.ctrlString(sc, "请输入注册密码：");
			String nickname = CtrlUtils.ctrlString(sc, "请输入注册账号昵称：");
			String ensure = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
			if(!ensure.equals("y"))
				return false;
			User registUser = new User(0, 1, username,
					password, nickname, 0);
			boolean flag = login.regist(registUser);
			if(flag)
				System.out.println("恭喜你<<"+nickname+">>注册成功，"
						+ "你注册的账号："+username+"  密码为："+password+
						"  昵称为："+nickname+"  权限为：普通用户权限");
			else
				System.out.println("sorry，mission failed ,please try again!!");
			return flag;
		}else{
			if(user.getAuthority() == 0 || user.getAuthority() == 999){	//若已登录，则为管理员才可进行管理员账号的注册
				if(user.getAuthority() == 0)
					System.out.println("亲爱的管理员<<"+user.getNickname()+">>你好！");
				else
					System.out.println("亲爱的Root兄<<"+user.getNickname()+">>你好！");
				String username = CtrlUtils.ctrlString(sc, "请输入注册账号：");
				String password = CtrlUtils.ctrlString(sc, "请输入注册密码：");
				String nickname = CtrlUtils.ctrlString(sc, "请输入注册账号昵称：");
				int authority = CtrlUtils.ctrlInt(sc, "请输入注册账号的权限(0:管理员权限/1：普通用户权限)：");
				String ensure = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
				if(!ensure.equals("y"))
					return false;
				User registUser = new User(0, authority, username,
						password, nickname, 0);
				boolean flag = login.regist(registUser);
				if(flag)
					System.out.println("恭喜你<<"+user.getNickname()+">>，"
							+ "你注册的账号："+username+"  密码为："+password+
							"  昵称为："+nickname+"  权限为：管理员权限");
				else
					System.out.println("sorry，mission failed");
				return flag;
			}else{
				System.out.println("亲爱的用户<<"+user.getNickname()+">>你好！");
				String username = CtrlUtils.ctrlString(sc, "请输入注册账号：");
				String password = CtrlUtils.ctrlString(sc, "请输入注册密码：");
				String nickname = CtrlUtils.ctrlString(sc, "请输入注册账号昵称：");
				String ensure = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
				if(!ensure.equals("y"))
					return false;
				User registUser = new User(0, 1, username,
						password, nickname, 0);
				boolean flag = login.regist(registUser);
				if(flag)
					System.out.println("恭喜你<<"+user.getNickname()+">>,您的新注册已成功，"
							+ "你注册的账号："+username+"  密码为："+password+
							"  昵称为："+nickname+"  权限为：普通用户权限");
				else
					System.out.println("sorry，mission failed ,please try again!!");
				return flag;
			}
		}
	}
	@Test
	public void test(){
		LoginView lv = new LoginView();
		lv.login();
		System.out.println(regist());
	}
}
