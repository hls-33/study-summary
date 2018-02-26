package com.bwf.rental_manage;

import java.io.Serializable;

/**
 * RentalRecord类是对系统中“汽车租、还记录的抽象”，
 * 该类包含了租车人的信息、租车的押金、租车日期、还车日期、租车的实际天数、租车等办理人、租车的收入等属性。
 * RentalRecord的信息都存储在data\record.txt中
 * @author bwfadmin
 */
public class RentalRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customer;			//租车人
	private String pid; 				//租车人身份证号码
	private String tel;					//租车人联系电话
	private double yj;						//实缴押金
	private int ts;						//预计租车天数
	private String rentDate;			//租车日期
	private String returnDate = "未归还";	//还车日期
	private int sjts = 0;				//实际租车天数
	private double sr = 0;				//收入
	private String carCph;				//租用的汽车车牌号
	private String adminName;			//办理租车手续的管理员姓名
	
	public RentalRecord(String customer, String pid, String tel, double yj, int ts, 
			String rentDate, String returnDate,int sjts, double sr, String carCph, String adminName) {
		this.customer = customer;
		this.pid = pid;
		this.tel = tel;
		this.yj = yj;
		this.ts = ts;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.sjts = sjts;
		this.sr = sr;
		this.carCph = carCph;
		this.adminName = adminName;
	}
	public RentalRecord(String carCph,String adminName,String customer,String pid,String tel,double yj,int ts){
		this.carCph = carCph;
		this.adminName = adminName;
		this.customer = customer;
		this.pid = pid;
		this.tel = tel;
		this.yj = yj;
		this.ts = ts;
	}
	@Override
	public String toString() {
		String info = "租出汽车车牌号："+carCph+",管理员："+adminName+",租车人："+customer+",身份证号码："+pid+
				",联系电话："+tel+",实缴押金："+yj+",预计天数："+ts+",租车日期："+rentDate+",还车日期："+returnDate+
				",实际租车天数："+sjts+",收入："+sr;
		return info;
	}
	
	
	//getter
	public String getCarCph() {
		return carCph;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getCustomer() {
		return customer;
	}
	public double getYj() {
		return yj;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getSjts() {
		return sjts;
	}
	public void setSjts(int sjts) {
		this.sjts = sjts;
	}
	public double getSr() {
		return sr;
	}
	public void setSr(double sr) {
		this.sr = sr;
	}
	
}
