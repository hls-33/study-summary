package com.bwf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/**
	 * 获取给定的字符串日期和当前日期的天数差
	 * @param date1
	 * @return
	 */
	public static int getDayDiff(String date1)  {
		int dayDiff = -1;
		try{
		Date d1 = sdf.parse(date1);
		Date d2 = new Date();
		long diff = d1.getTime()-d2.getTime();
		dayDiff = (int) (diff/1000/60/60/24);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dayDiff;
	}
}
