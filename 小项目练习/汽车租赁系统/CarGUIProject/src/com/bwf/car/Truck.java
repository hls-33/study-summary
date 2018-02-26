package com.bwf.car;

/**
 * Truck类是对系统中租赁的“载货车的抽象”，该类继承了Car类，增加了一个载货数weight属性，
 * 还重写了父类中计算租金的方法，除了父类中基本的天数乘以日租金的基本租金外，还根据载货吨数来额外增加租金，规则如下： 1吨及1吨以下，没有额外租金
 * 1吨以上到3吨以下，增收基本租金的50% 3吨以上到5吨以下，增收基本租金的100%
 * 5吨以上到10吨以下，增收基本租金的200%10吨以上，增收基本租金的400%
 *
 * @author bwfadmin
 */
public class Truck extends Car {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private double weight; // 载货数

    public Truck(String licenseNumber, String engineNumber, String carName, String color, String productionDate,
            int mileage, String fuelType, double rentalMoney, double dailyRent, String type, double weight) {

        super(licenseNumber, engineNumber, carName, color, productionDate,
                mileage, fuelType, rentalMoney, dailyRent, type);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ",载客数：" + this.weight + ",状况：" + super.getState() + "|";
    }

    /*
	 * 基本租金+额外租金
     */
    public double calcRental(int days) {
        if (weight <= 1 && weight >= 0) {
            return days * super.getDailyRent();
        } else if (weight <= 3) {
            return days * super.getDailyRent() * 1.5;
        } else if (weight <= 5) {
            return days * super.getDailyRent() * 2.0;
        } else if (weight < 10) {
            return days * super.getDailyRent() * 3.0;
        } else {
            return days * super.getDailyRent() * 5.0;
        }
    }

    //getter
    public double getWeight() {
        return weight;
    }
}
