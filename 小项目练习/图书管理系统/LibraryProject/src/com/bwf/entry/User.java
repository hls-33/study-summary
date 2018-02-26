package com.bwf.entry;

public class User extends Info{
	private int loginId;
	private int authority;
	private String username;
	private String password;
	private String nickname;
	private int credits;
	
	public User() {
	}
	public User(int loginId, int authority, String username, String password, String nickname, int credits) {
		this.loginId = loginId;
		this.authority = authority;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.credits = credits;
	}
	
	@Override
	public String toString() {
		if(authority == 1)
			return "注册编号："+loginId+"  权限：普通用户"+"  用户名："+username+
				"  密码："+password+"  昵称："+nickname+"  积分："+credits;
		else if(authority == 0)
			return "注册编号："+loginId+"  权限：管理员"+"  用户名："+username+
					"  密码："+password+"  昵称："+nickname+"  积分："+credits;
		else
			return "注册编号："+loginId+"  权限：最终Boss"+"  用户名："+username+
					"  密码："+password+"  昵称："+nickname+"  积分："+credits;
	}
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
