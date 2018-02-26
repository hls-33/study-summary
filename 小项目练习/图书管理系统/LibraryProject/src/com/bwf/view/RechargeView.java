package com.bwf.view;

import java.util.Scanner;

import com.bwf.entry.User;
import com.bwf.service.admin.AdminInfoManageServcieImpl;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DisplayUtils;

/**
 * 充值界面
 * @author bwfadmin
 */
public class RechargeView {
	private Scanner sc = CentreView.getSc();
	
	public boolean rechargeView(){
		System.out.println("============充值界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		if(user.getAuthority() == 1){	//仅只普通用户才需要充值
			AdminInfoManageServcieImpl adminInfo = new AdminInfoManageServcieImpl();//由管理员来负责修改积分
			System.out.println("您的积分余额为："+user.getCredits());
			int addCredits = CtrlUtils.ctrlIntForRecharge(sc, "请问你需要充值的积分为（1RMB为1积分）：");
			String choose = CtrlUtils.ctrlString(sc, "确认充值（y）/其他键取消充值：");
			if(choose.equals("y")){
				DisplayUtils.displayCtl("充值中，请稍后", ".");
				User rechargeUser = new User(user.getLoginId(),user.getAuthority(),user.getUsername(),
						user.getPassword(),user.getNickname(),user.getCredits()+addCredits);
				login.setUser(rechargeUser);//修改登录状态中的user信息（数据库中的信息已经修改完毕）
				boolean flag = adminInfo.updateInfo(rechargeUser);
				if(flag)
					System.out.println("充值成功！");
				else
					System.out.println("充值失败！");
				return flag;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
