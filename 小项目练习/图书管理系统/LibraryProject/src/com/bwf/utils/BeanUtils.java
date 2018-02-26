package com.bwf.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.entry.Rent;
import com.bwf.entry.User;

public class BeanUtils {
	
	/*
	 * 根据 查询sql语句返回对应的查询对应的arrayList集合对象
	 */
	public static ArrayList<Info> queryInfo(Connection con , String querySql , String className , Object...infoMessage){
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<Info> arrList = new ArrayList<>();
		if(!querySql.startsWith("select"))
			return arrList;
		try{
			pstmt = con.prepareStatement(querySql);
			for(int i=0;i<infoMessage.length;i++){
				pstmt.setObject(i+1,infoMessage[i]);
			}
			rs = pstmt.executeQuery();
			if(className.equalsIgnoreCase("Book")){
				while(rs.next()){
					arrList.add(new Book(rs.getInt("book_id"),rs.getString("book_name"),
							rs.getString("book_author"),rs.getString("book_state")));
				}
				return arrList;
			}else if(className.equalsIgnoreCase("Rent")){
				while(rs.next()){
					arrList.add(new Rent(rs.getInt("rent_id"),rs.getInt("book_id"),rs.getString("rent_book"),
							rs.getString("rent_user"),rs.getInt("rent_credit"),rs.getString("rent_date"),
							rs.getString("return_date"),rs.getInt("rent_daydiff")));
				}
				return arrList;
			}else if(className.equalsIgnoreCase("User")){
				while(rs.next()){
					arrList.add(new User(rs.getInt("login_id"),rs.getInt("authority"),rs.getString("username"),
							rs.getString("password"),rs.getString("nickname"),rs.getInt("credits")));
				}
				return arrList;
			}else{
				return arrList;
			}
			//只有在出异常的情况下才会返回null
		}catch(Exception e){return null;}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 包装的更新数据的方法：增删改
	 */
	public static int updateInfo(Connection con , String sql , Object...infoMessage){
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			for(int i=0;i<infoMessage.length;i++){
				pstmt.setObject(i+1,infoMessage[i]);
			}
			return pstmt.executeUpdate();
		}catch(Exception e){return 0;}
		finally{
			try {
				pstmt.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	@Test
	public void test(){
		Connection con = DaoUtils.getConn();
		String sql = "insert into book_info(book_name,book_author) values(?,?) ";
		Object[] params = {"史上最强轮回","那一抹绯红"};
		updateInfo(con,sql,params);
		String querySql = "select * from book_info ";
		ArrayList<Info> list = queryInfo(con, querySql, "Book");
		for(Info info : list)
			System.out.println(info);
	}
}
