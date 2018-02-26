package com.bikesystem.entity;
/**
 * 自行车种类表：bike_kind
 * @author bwfadmin
 *
 */
public class BikeKind {
	private int bkid;
	private String kindName;
	private String bkInformation;
	
	
	
	public BikeKind() {
		super();
	}
	public BikeKind(int bkid, String kindName, String bkInformation) {
		super();
		this.bkid = bkid;
		this.kindName = kindName;
		this.bkInformation = bkInformation;
	}
	
	public BikeKind(String kindName, String bkInformation) {
		super();
		this.kindName = kindName;
		this.bkInformation = bkInformation;
	}
	
	public int getBkid() {
		return bkid;
	}
	public void setBkid(int bkid) {
		this.bkid = bkid;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getBkInformation() {
		return bkInformation;
	}
	public void setBkInformation(String bkInformation) {
		this.bkInformation = bkInformation;
	}
	@Override
	public String toString() {
		return "Comment [bkid=" + bkid + ", kindName=" + kindName + ", bkInformation=" + bkInformation + "]";
	}
	
}
