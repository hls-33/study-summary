package com.bikesystem.entity;
/**
 * �û����г����޼�¼��user_rent
 * @author bwfadmin
 *
 */
public class UserRent {
	private int urid;
	private String name;//name������user��
	private String bikeNumber;
	private String bikeName;
	private String shopName;
	private String rentDate;
	private String returnDate;
	private double deposit;	//用户缴纳的租时费用+基本租金
	private String rentType;
	
	public UserRent() {
		super();
	}
	public UserRent(int urid, String name, String bikeNumber, String bikeName, String shopName, String rentDate,
			String returnDate, double deposit ,String rentType) {
		super();
		this.urid = urid;
		this.name = name;
		this.bikeNumber = bikeNumber;
		this.bikeName = bikeName;
		this.shopName = shopName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.deposit = deposit;
		this.rentType=rentType;
	}
	
	public UserRent(int urid, String name, String bikeNumber, String bikeName, String shopName, String rentDate,
			String returnDate, double deposit) {
		super();
		this.urid = urid;
		this.name = name;
		this.bikeNumber = bikeNumber;
		this.bikeName = bikeName;
		this.shopName = shopName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.deposit = deposit;
	}
	public UserRent(String name, String bikeNumber, String bikeName, String shopName, String rentDate,
			String returnDate, double deposit,String rentType) {
		super();
		this.name = name;
		this.bikeNumber = bikeNumber;
		this.bikeName = bikeName;
		this.shopName = shopName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.deposit = deposit;
		this.rentType=rentType;
	}
	
	public int getUrid() {
		return urid;
	}
	public void setUrid(int urid) {
		this.urid = urid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBikeNumber() {
		return bikeNumber;
	}
	public void setBikeNumber(String bikeNumber) {
		this.bikeNumber = bikeNumber;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	@Override
	public String toString() {
		return "UserRent [urid=" + urid + ", name=" + name + ", bikeNumber=" + bikeNumber + ", bikeName=" + bikeName
				+ ", shopName=" + shopName + ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", deposit="
				+ deposit + ", rentType=" + rentType + "]";
	}
	
	
}
