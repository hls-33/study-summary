package com.bikesystem.entity;

public class SellAddress {

	private int  said;
	/** 帐号的用户名字*/
	private String name;
	/** 收货的名字*/
	private String username;
	/**省，市，区*/
	private String address ;
	/**详细地址*/
	private String minuteaddress;
	private String phone;
	public SellAddress(String name, String username, String address, String minuteaddress, String phone) {
		super();
		this.name = name;
		this.username = username;
		this.address = address;
		this.minuteaddress = minuteaddress;
		this.phone = phone;
	}
	public SellAddress(int said, String name, String username, String address, String minuteaddress, String phone) {
		super();
		this.said = said;
		this.name = name;
		this.username = username;
		this.address = address;
		this.minuteaddress = minuteaddress;
		this.phone = phone;
	}
	public int getSaid() {
		return said;
	}
	public void setSaid(int said) {
		this.said = said;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMinuteaddress() {
		return minuteaddress;
	}
	public void setMinuteaddress(String minuteaddress) {
		this.minuteaddress = minuteaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**详细地址*/
	
	
}
