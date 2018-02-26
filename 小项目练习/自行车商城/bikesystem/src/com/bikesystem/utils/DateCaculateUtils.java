package com.bikesystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 租用的日期计算工具类
 * @author bwfadmin
 *
 */
public class DateCaculateUtils {
	private static final SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static String dateAdd(String orderDate,String rentType,int rentTimes){
		try{
			if("hourmodel".equals(rentType)){
				Date date = simple.parse(orderDate);
				long dateLong = date.getTime();
				long newDateLong = rentTimes*60*60*1000+dateLong;
				Date returnDate = new Date(newDateLong);
				return simple.format(returnDate);
			}else if("daymodel".equals(rentType)){
				Date date = simple.parse(orderDate);
				long dateLong = date.getTime();
				long newDateLong = rentTimes*24*60*60*1000+dateLong;
				Date returnDate = new Date(newDateLong);
				return simple.format(returnDate);
			}else{
				return null;
			}
		}catch(Exception e){
		}
		return null;
	}
	
}
