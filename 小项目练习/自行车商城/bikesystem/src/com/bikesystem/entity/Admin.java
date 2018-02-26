package com.bikesystem.entity;
/**
 * ������Ϣ�� admin��Ӧ��bean��
 * @author bwfadmin
 *
 */
public class Admin {
	private int aid;
	private String aphone;
	private String password;
	private String name;
	private String idnumber;
	private String imagepath;
	
	public Admin() {
		super();
	}
	public Admin(int aid, String aphone, String password, String name, String idnumber,String imagepath) {
		super();
		this.aid = aid;
		this.aphone = aphone;
		this.password = password;
		this.name = name;
		this.idnumber = idnumber;
		this.imagepath=imagepath;
	}
	public Admin(int aid,String aphone, String password, String name) {
		super();
		this.aid=aid;
		this.aphone = aphone;
		this.password = password;
		this.name = name;
	}
	public Admin(String aphone, String password, String name, String idnumber) {
		super();
		this.aphone = aphone;
		this.password = password;
		this.name = name;
		this.idnumber = idnumber;
	}
	@Override
	public String toString() {
		return aid+":"+aphone+":"+password+":"+name+":"+idnumber+":"+imagepath;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
}
