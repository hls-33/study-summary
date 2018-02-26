package com.bwf.utils;

import java.util.Scanner;

import org.junit.Test;

public class CtrlUtils {
	public static int ctrlInt(Scanner sc,String title){
		while(true){
			System.out.print(title);
			try{
				int example = sc.nextInt();
				sc.nextLine();
				return example;
			}catch(Exception e){
				System.out.println("输入错误！");
				sc.nextLine();
			}
		}
	}
	
	public static int ctrlIntForRecharge(Scanner sc,String title){
		while(true){
			System.out.print(title);
			try{
				int example = sc.nextInt();
				if(example <= 0)
					throw new RuntimeException();
				sc.nextLine();
				return example;
			}catch(Exception e){
				System.out.println("金额输入错误！");
				sc.nextLine();
			}
		}
	}
	public static String ctrlString(Scanner sc , String title){
		System.out.print(title);
		return sc.nextLine();
	}
	
	public static long ctrlLong(Scanner sc,String title){
		while(true){
			System.out.print(title);
			try{
				long example = sc.nextLong();
				sc.nextLine();
				return example;
			}catch(Exception e){
				System.out.println("输入错误！");
				sc.nextLine();
			}
		}
	}
	
	@Test
	public void test(){
	}
}
