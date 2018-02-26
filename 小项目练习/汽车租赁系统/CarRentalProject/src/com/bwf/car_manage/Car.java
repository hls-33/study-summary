package com.bwf.car_manage;

import java.io.Serializable;

/**
 * Car类是对系统中租赁的汽车的抽象，该类是一个抽象类，包含了一系列汽车的属性，还包含一个根据日租金计算租赁费用的方法。
	Car的信息都存储在data\car.txt中
 * @author bwfadmin
 */
public abstract class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TYPE_ZAIKECHE = "载客车";
	public static final String TYPE_ZAIHUOCHE = "载货车";
	public static final String STATE_BAOFEI = "报废";
	public static final String STATE_KONGXIAN = "空闲";
	public static final String STATE_YICHUZU = "已出租";
	private String licenseNumber;	//车牌号
	private String engineNumber; 	//发动机号
	private String carName; 		//车名
	private String color;  			//颜色
	private String productionDate; 	//出厂日期
	private int mileage; 			//里程
	private String fuelType; 		//燃油类型
	private double rentalMoney; 		//租车押金
	private double dailyRent; 			//日租金
	private String state = "空闲";	//状况（空闲，已出租，报废），默认空闲
	private String type;			//汽车类型（载客车/载货车）
	
	
	
	public Car() {
	}

	public Car(String licenseNumber, String engineNumber, String carName, String color, String productionDate,
			int mileage, String fuelType, double rentalMoney, double dailyRent,String type) {
		this.licenseNumber = licenseNumber;
		this.engineNumber = engineNumber;
		this.carName = carName;
		this.color = color;
		this.productionDate = productionDate;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.rentalMoney = rentalMoney;
		this.dailyRent = dailyRent;
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		String info = "|车牌号："+this.licenseNumber+",发动机号："+this.engineNumber+",车名："+this.carName+
				",颜色："+this.color+",出厂日期："+this.productionDate+",行驶里程："+this.mileage+",燃油类型："+
				this.fuelType+",租车押金："+this.rentalMoney+",日租金："+this.dailyRent;
		return info;
	}
	
	/*
	 * 根据日租金以及出租天数来计算基本租金
	 */
	public abstract double calcRental(int days);
	
	//getter
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getCarName() {
		return carName;
	}

	public double getDailyRent() {
		return dailyRent;
	}

	public String getType() {
		return type;
	}

	public double getRentalMoney() {
		return rentalMoney;
	}

	public void setRentalMoney(double rentalMoney) {
		this.rentalMoney = rentalMoney;
	}
	
	
}
