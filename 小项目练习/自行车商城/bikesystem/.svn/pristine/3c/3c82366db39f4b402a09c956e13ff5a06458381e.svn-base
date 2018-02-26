package com.bikesystem.txz.ipml.service;
import com.bikesystem.entity.User;
import com.bikesystem.txz.interfaces.dao.IUserDao;
import com.bikesystem.txz.interfaces.service.IUserService;

public class UserServiceIpml implements IUserService {
	private IUserDao userdao;
	public UserServiceIpml(IUserDao userdao) {
		super();
		this.userdao = userdao;
	}
	@Override
	public User UserLogin(String username, String password) {
		
		if(username==null||password==null)
			return null;
		else if("".equals(username)||"".equals(password))
			return null;
		else return userdao.UserLogin(username, password);
	}
	@Override
	public boolean userRegist(User user) {
		
		if(user==null)
			return false;
		else if(user.getAddress()==null||user.getEmail()==null||user.getIdnumber()==null||
				user.getName()==null||user.getPassword()==null||user.getSex()==null||
				user.getUphone()==null)
			return false;
		else if("".equals(user.getAddress())||"".equals(user.getEmail())||"".equals(user.getIdnumber())
				||"".equals(user.getName())||"".equals(user.getPassword())||"".equals(user.getSex())||
				"".equals(user.getUphone()))
			return false;
		else return userdao.userRegist(user);
	}

	@Override
	public User queryUserInfo(String uphone) {
		
		if(uphone==null||"".equals(uphone))
			return null;
		return userdao.queryUserInfo(uphone);
	}

	@Override
	public boolean updateUserInfo(User user,String name) {
		//修改用户信息
		if(user==null)
			return false;
		else if(user.getAddress()==null||user.getName()==null||user.getSex()==null||
				user.getUphone()==null)
			return false;
		else if("".equals(user.getAddress())||"".equals(user.getName())||"".equals(user.getSex())||
				"".equals(user.getUphone()))
			return false;
		else return userdao.updateUserInfo(user,name);
	}

	@Override
	public boolean deleteUserInfo(String uphone) {
		if(uphone==null||"".equals(uphone))
			return false;
		return userdao.deleteUserInfo(uphone);
	}
	@Override
	public boolean queryUserByPhone(String uphone) {
		if(uphone==null||"".equals(uphone))
			return false;
		else return userdao.queryUserByPhone(uphone);
	}
	@Override
	public boolean queryUserByEmail(String email) {
		if(email==null||"".equals(email))
			return false;
		else return userdao.queryUserByEmail(email);
	}
	@Override
	public boolean updateUserInfoByEmail(String uphone, String email) {
		if(uphone==null||email==null)
			return false;
		else if("".equals(uphone)||"".equals(email))
			return false;
		else return userdao.updateUserInfoByEmail(uphone, email);
	}
	@Override
	public boolean updateUserInfoByPhone(String oldphone, String newphone) {
		if(oldphone==null||newphone==null)
			return false;
		else if("".equals(oldphone)||"".equals(newphone))
			return false;
		else return userdao.updateUserInfoByPhone(oldphone, newphone);
	}
	@Override
	public boolean updateUserInfoByPassword(String uphone, String oldpassword, String newpassword) {
		if(uphone==null||oldpassword==null||newpassword==null)
			return false;
		else if("".equals(uphone)||"".equals(oldpassword)||"".equals(newpassword))
			return false;
		else return userdao.updateUserInfoByPassword(uphone, oldpassword, newpassword);
	}
}
