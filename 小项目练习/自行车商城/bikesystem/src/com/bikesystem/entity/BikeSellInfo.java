package com.bikesystem.entity;
/**
 * ���г����۱�bike_sell_info
 * @author bwfadmin
 *
 */
public class BikeSellInfo {
	private int bsiid;
	private int bsid;
	private String shopName;//shopName������shop��
	private String name;//name������user��
	private double bikePrice;//bikePrice������bike_sell��
	private String sellDate;

	private String bikename;
	private String kindname;

	private String color;
	private String imgpath;

	public BikeSellInfo(String shopName, String name, double bikePrice, String sellDate) {
		super();
		this.shopName = shopName;
		this.name = name;
		this.bikePrice = bikePrice;
		this.sellDate = sellDate;
	}

	public BikeSellInfo(int bsid, String shopName, String name, double bikePrice, String sellDate, String bikename,
			String kindname, String color, String imgpath) {
		super();
		this.bsid = bsid;
		this.shopName = shopName;
		this.name = name;
		this.bikePrice = bikePrice;
		this.sellDate = sellDate;
		this.bikename = bikename;
		this.kindname = kindname;
		this.color = color;
		this.imgpath = imgpath;
	}

	public String getBikename() {
		return bikename;
	}

	public void setBikename(String bikename) {
		this.bikename = bikename;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public BikeSellInfo() {
		super();
	}
	
	public BikeSellInfo(int bsiid,int bsid, String shopName, String name, double bikePrice, String sellDate) {
		super();
		this.bsiid=bsiid;
		this.bsid = bsid;
		this.shopName = shopName;
		this.name = name;
		this.bikePrice = bikePrice;
		this.sellDate = sellDate;
	}
	
	public BikeSellInfo(int bsid, String shopName, String name, double bikePrice, String sellDate) {
		super();
		this.bsid = bsid;
		this.shopName = shopName;
		this.name = name;
		this.bikePrice = bikePrice;
		this.sellDate = sellDate;
	}

	public int getBsiid() {
		return bsiid;
	}

	public void setBsiid(int bsiid) {
		this.bsiid = bsiid;
	}

	public int getBsid() {
		return bsid;
	}
	public void setBsid(int bsid) {
		this.bsid = bsid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBikePrice() {
		return bikePrice;
	}
	public void setBikePrice(double bikePrice) {
		this.bikePrice = bikePrice;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	@Override
	public String toString() {
		return "BikeSellInfo [bsid=" + bsid + ", shopName=" + shopName + ", name=" + name + ", bikePrice=" + bikePrice
				+ ", sellDate=" + sellDate + "]";
	}
	
	
}
