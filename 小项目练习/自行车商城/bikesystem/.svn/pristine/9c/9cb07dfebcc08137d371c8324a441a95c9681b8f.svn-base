package com.bikesystem.entity;
/**
 * 包含了预约中的一系列需要保存在session中的属性，用一个实体类来包装起来。
 * @author bwfadmin
 *
 */
public class RentOrderInfo {
	private int sid;
	private int brid;
	private User user ;	//保存已经登录的user对象
	private String rentType;
	private int rentTimes;
	private double totalTimePrice;	//租时计费
	private double allPayPrice;		//租金+租时计费
	private String orderDate;
	
	public RentOrderInfo() {
		super();
	}
	
	public RentOrderInfo(int sid, int brid,  String rentType, int rentTimes, double totalTimePrice,
			double allPayPrice) {
		super();
		this.sid = sid;
		this.brid = brid;
		this.rentType = rentType;
		this.rentTimes = rentTimes;
		this.totalTimePrice = totalTimePrice;
		this.allPayPrice = allPayPrice;
	}


	public RentOrderInfo(int sid, int brid) {
		super();
		this.sid = sid;
		this.brid = brid;
	}
	public RentOrderInfo(String rentType, int rentTimes, double totalTimePrice, double allPayPrice) {
		super();
		this.rentType = rentType;
		this.rentTimes = rentTimes;
		this.totalTimePrice = totalTimePrice;
		this.allPayPrice = allPayPrice;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public int getRentTimes() {
		return rentTimes;
	}
	public void setRentTimes(int rentTimes) {
		this.rentTimes = rentTimes;
	}
	public double getTotalTimePrice() {
		return totalTimePrice;
	}
	public void setTotalTimePrice(double totalTimePrice) {
		this.totalTimePrice = totalTimePrice;
	}
	public double getAllPayPrice() {
		return allPayPrice;
	}
	public void setAllPayPrice(double allPayPrice) {
		this.allPayPrice = allPayPrice;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "RentOrderInfo [sid=" + sid + ", brid=" + brid + ", user=" + user + ", rentType=" + rentType
				+ ", rentTimes=" + rentTimes + ", totalTimePrice=" + totalTimePrice + ", allPayPrice=" + allPayPrice
				+ ", orderDate=" + orderDate + "]";
	}

	
}
