package com.bikesystem.entity;
/**
 * ���ų���Ʒ������Ϣ��bike_sell
 * @author bwfadmin
 *
 */
public class BikeSell {
	private int bsid;
	private String bikeName;
	private int bikeCount;
	private String color;
	private String kindName;
	private String shopName;
	private double bikePrice;
	private String imgPath;
	private int sellCount;
	private String  bikeheadinfo;
	private String bikesubheadinfo;
	public BikeSell() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public BikeSell(String bikeName, int bikeCount, String color, String kindName, String shopName, double bikePrice,
			String imgPath, int sellCount, String bikeheadinfo, String bikesubheadinfo) {
		super();
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
		this.imgPath = imgPath;
		this.sellCount = sellCount;
		this.bikeheadinfo = bikeheadinfo;
		this.bikesubheadinfo = bikesubheadinfo;
	}




	public BikeSell(int bsid, String bikeName, int bikeCount, String color, String kindName, String shopName,
			double bikePrice, String imgPath, int sellCount, String bikeheadinfo, String bikesubheadinfo) {
		super();
		this.bsid = bsid;
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
		this.imgPath = imgPath;
		this.sellCount = sellCount;
		this.bikeheadinfo = bikeheadinfo;
		this.bikesubheadinfo = bikesubheadinfo;
	}




	public BikeSell(int bsid, String bikeName, int bikeCount, String color, String kindName, String shopName,
			double bikePrice, String imgPath,int sellCount) {
		super();
		this.bsid = bsid;
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
		this.imgPath = imgPath;
	}

	public BikeSell(String bikeName, int bikeCount, String color, String kindName, String shopName, double bikePrice,
			String imgPath,int sellCount) {
		super();
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
		this.imgPath = imgPath;
		this.sellCount = sellCount;
	}
	
	public BikeSell(String bikeName, int bikeCount, String color, String kindName, String shopName, double bikePrice,
			String imgPath) {
		super();
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
		this.imgPath = imgPath;
	}
	


	
	public BikeSell(String bikeName, int bikeCount, String color, String kindName, String shopName, double bikePrice) {
		super();
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.shopName = shopName;
		this.bikePrice = bikePrice;
	}
	
	

	public BikeSell(String bikeName, int bikeCount, String color, String kindName, double bikePrice) {
		super();
		this.bikeName = bikeName;
		this.bikeCount = bikeCount;
		this.color = color;
		this.kindName = kindName;
		this.bikePrice = bikePrice;
	}



	public BikeSell(String imgPath) {
		super();
		this.imgPath = imgPath;
	}




	public int getSellCount() {
		return sellCount;
	}


	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}


	public int getBsid() {
		return bsid;
	}
	public void setBsid(int bsid) {
		this.bsid = bsid;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public int getBikeCount() {
		return bikeCount;
	}
	public void setBikeCount(int bikeCount) {
		this.bikeCount = bikeCount;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public double getBikePrice() {
		return bikePrice;
	}
	public void setBikePrice(double bikePrice) {
		this.bikePrice = bikePrice;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	public String getBikeheadinfo() {
		return bikeheadinfo;
	}




	public void setBikeheadinfo(String bikeheadinfo) {
		this.bikeheadinfo = bikeheadinfo;
	}




	public String getBikesubheadinfo() {
		return bikesubheadinfo;
	}




	public void setBikesubheadinfo(String bikesubheadinfo) {
		this.bikesubheadinfo = bikesubheadinfo;
	}




	@Override
	public String toString() {
		return "BikeSell [bsid=" + bsid + ", bikeName=" + bikeName + ", bikeCount=" + bikeCount + ", color=" + color
				+ ", kindName=" + kindName + ", shopName=" + shopName + ", bikePrice=" + bikePrice + ", imgPath="
				+ imgPath + ", sellCount=" + sellCount + ",bikeheadinfo"+bikeheadinfo+",bikesubheadinfo"+bikesubheadinfo+"]";
	}
	
	
}
