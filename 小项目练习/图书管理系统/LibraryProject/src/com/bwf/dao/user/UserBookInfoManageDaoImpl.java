package com.bwf.dao.user;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import com.bwf.dao.admin.InfoManageDao;
import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class UserBookInfoManageDaoImpl implements InfoManageDao {
	/*
	 * 普通用户之书籍信息查询（所有的）
	 */
	@Override
	public ArrayList<Info> findAll() {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "select * from book_info ";
			ArrayList<Info> bookList = BeanUtils.queryInfo(con, sql, "Book");
			return bookList;
		}catch(Exception e){return null;}
		finally{
			DaoUtils.close(con);
		}
	}
	/*
	 * 无此功能
	 */
	@Override
	public boolean saveInfo(Info info) {
		return false;
	}
	/**
	 * 用户借书后则将对应的书籍的state改为已借
	 */
	@Override
	public boolean updateInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update book_info set book_state=? where book_id=? ";
			Book book = (Book)info;
			Object[] params = {book.getBookState(),book.getBookId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/*
	 * 无此功能
	 */
	@Override
	public boolean removeInfo(Info info) {
		return false;
	}
	@Test
	public void test(){
//		ArrayList<Info> list = findAll();
//		for(Info info : list)
//			System.out.println(info);
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		return null;
	}
}
