package com.bikesystem.txz.interfaces.service;
import com.bikesystem.entity.User;
public interface IUserService {
//	用户
	User UserLogin(String username,String password);//用户登录
	boolean userRegist(User user);//用户注册
	User queryUserInfo(String uphone);//查询用户信息
	boolean updateUserInfo(User user,String name);//修改用户信息
	boolean deleteUserInfo(String uphone);//删除用户信息（选择功能）
	boolean queryUserByPhone(String uphone);//判断是否存在注册的手机
	boolean queryUserByEmail(String email);//判断是否存在注册的邮箱
	boolean updateUserInfoByEmail(String uphone,String email);
	boolean updateUserInfoByPhone(String oldphone,String newphone);
	boolean updateUserInfoByPassword(String uphone,String oldpassword,String newpassword);
}
