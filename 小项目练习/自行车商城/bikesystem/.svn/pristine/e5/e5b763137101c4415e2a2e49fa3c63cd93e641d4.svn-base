package com.bikesystem.utils;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegexUtil {
	private static Pattern p=null;
	public static boolean getPhoneRegex(String str){//只能输入11位数字
		if(str==null||"".equals(str))
			return false;
		String reg="^\\d{11}$";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getIdnumber(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^[1-9]\\d{17}$";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getEmail(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getName(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^[\u4e00-\u9fa5]{0,}[a-z]{0,}[A-Z]{0,}$";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getPassword(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^[a-zA-Z0-9]{8,16}$";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getAddress(String str){//\u7701  \u5E02
		if(str==null||"".equals(str))
			return false;
		String reg="^[\u4e00-\u9fa5]{0,}\\u7701[\u4e00-\u9fa5]{0,}\\\u5E02[\u4e00-\u9fa5]{0,}";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getCheck(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^[a-zA-Z0-9]{0,5}";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	public static boolean getSex(String str){
		if(str==null||"".equals(str))
			return false;
		String reg="^[\u4e00-\u9fa5]";
		p=Pattern.compile(reg);
		return p.matcher(str).matches();
	}
}
