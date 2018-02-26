package com.bwf.uitools;

public class UiTools {
	private static final String BLANK =" " ;
	private static final String STAR ="*" ;
	private static final String LINE ="—" ;
	private static final String SOLID ="-" ;
	
	public static void printBlack(){
		for(int i =0;i<5;i++)
			System.out.print("\t");
	}
	public static void printBlack(int count){
		for(int i =0;i<count;i++)
			System.out.print(BLANK);
	}
	
	public static void printStar(){
		for(int i =0;i<40;i++)
			System.out.print(STAR);
	}
	public static void printStar(int count){
		for(int i =0;i<count;i++)
			System.out.print(STAR);
	}
	
	public static void printLine(){
		for(int i =0;i<39;i++)
			System.out.print(LINE);
		System.out.print(">");
	}
	public static void printLine(int count){
		for(int i =0;i<count;i++)
			System.out.print(LINE);
	}
	
	public static void printSolid(){
		for(int i =0;i<39;i++)
			System.out.print(SOLID);
		System.out.print(">");
	}
	public static void printSolid(int count){
		for(int i =0;i<count;i++)
			System.out.print(SOLID);
	}
}
