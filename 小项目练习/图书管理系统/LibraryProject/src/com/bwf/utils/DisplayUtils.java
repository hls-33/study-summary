package com.bwf.utils;

import org.junit.Test;

public class DisplayUtils {
	
	/**
	 * 动态显示控制！
	 */
	public static void displayCtl(String content , String dynamicSimbol){
		System.out.print(content);
		for(int i =0;i<3;i++){
			try {
				Thread.sleep(400);	//每次停顿符号出现的间隔时间（毫秒为单位）
				System.out.print(dynamicSimbol);
			} catch (InterruptedException e) {
			}
		}
		System.out.println();
	}
	
	@Test
	public void test(){
		displayCtl("充值中",".");
		System.out.println("充值成功！");
	}
}
