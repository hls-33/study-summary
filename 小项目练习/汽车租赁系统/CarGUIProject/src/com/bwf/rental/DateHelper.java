package com.bwf.rental;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * DateHelper类是一个关于日期时间的帮助类，主要是为了简化日期时间java.util.Date类的简化和计算日期天数差，提供了几个静态的方法。
 * @author bwfadmin
 */
public class DateHelper {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 指定模板的日期格式化类对象
	/*
	 * 获取当前日期的格式化字符串形式
	 */

	public static String getDate() {
		return sdf.format(new Date());
	}

	/*
	 * 获取指定日期的格式化字符串形式
	 */
	public static String getDate(Date date) {
		return sdf.format(date);
	}

	/*
	 * 获取两个字符串格式日期的天数差,失败返回-1
	 */
	public static int getDayDiff(String date1, String date2)  {
		int dayDiff = -1;
		try{
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long diff = Math.abs(d1.getTime()-d2.getTime());
		dayDiff = (int) (diff/1000/60/60/24);
		}catch(Exception e){
			System.out.println("日期字符串格式错误！");
		}
		return dayDiff;
	}

}
