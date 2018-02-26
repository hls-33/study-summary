package com.bikesystem.utils;
/**
 * 用来将double、int等数字类型的字符串转换成对应基本类型的工具类
 * @author bwfadmin
 *
 */
public class ParseNumberUtils {
	/**
	 * 转换int
	 * @param id
	 * @return
	 */
	public static int parseIntId(String id){
		try{
			return Integer.parseInt(id);
		}catch(Exception e){return -1;}
	}
	/**
	 * 转换double
	 * @param id
	 * @return
	 */
	public static double parseDoubleId(String id){
		try{
			return Double.parseDouble(id);
		}catch(Exception e){return -1;}
	}
}
