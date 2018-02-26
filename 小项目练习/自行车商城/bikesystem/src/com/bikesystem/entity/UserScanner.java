package com.bikesystem.entity;
/**
 * 保存用户扫描二维码状态的是实体类
 * @author bwfadmin
 *
 */
public class UserScanner {
	private int usid;
	private int uid;
	private String scannerstate;
	
	
	public UserScanner() {
		super();
	}
	public UserScanner(int usid, int uid, String scannerstate) {
		super();
		this.usid = usid;
		this.uid = uid;
		this.scannerstate = scannerstate;
	}
	
	public UserScanner(int uid, String scannerstate) {
		super();
		this.uid = uid;
		this.scannerstate = scannerstate;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getScannerstate() {
		return scannerstate;
	}
	public void setScannerstate(String scannerstate) {
		this.scannerstate = scannerstate;
	}
	@Override
	public String toString() {
		return "UserScanner [usid=" + usid + ", uid=" + uid + ", scannerstate=" + scannerstate + "]";
	}
	
}
