package com.bwf.car;


/**
 * Coach类是对系统中租赁的“载客车的抽象”，该类继承了Car类，增加了一个载客数seatCount属性，还重写了父类中计算租金的方法，
 * 除了父类中基本的天数乘以日租金的基本租金外，还根据载客人数来额外增加租金，规则如下：
 * 4座及4座以下，没有额外租金;5座到7座，增收基本租金的20%;8座到22座，增收基本租金的100%;23座及以上，增收基本租金的200%
 * @author bwfadmin
 */
public class Coach extends Car {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int seatCapacity;	//载客数
	
	public Coach(String licenseNumber, String engineNumber, String carName, String color, String productionDate,
			int mileage, String fuelType, double rentalMoney, double dailyRent,String type, int seatCapacity) {
		
		super(licenseNumber, engineNumber, carName, color, productionDate,
				 mileage, fuelType, rentalMoney, dailyRent,type);
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return super.toString()+",载客数："+this.seatCapacity+",状况："+super.getState()+"|";
	}

	/*
	 * 基本租金+额外租金
	 */
	public double calcRental(int days){
		if(seatCapacity <= 4)
			return days*super.getDailyRent();
		else if(seatCapacity <= 7)
			return days*super.getDailyRent()*1.2;
		else if(seatCapacity <= 22)
			return days*super.getDailyRent()*2.0;
		else
			return days*super.getDailyRent()*3.0;
	}

	
	//getter
	public int getSeatCapacity() {
		return seatCapacity;
	}
}
