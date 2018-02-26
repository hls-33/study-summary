package com.bwf.dao.admin;

import java.sql.Connection;
import java.util.ArrayList;


import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class AdminBookInfoManageDaoImpl implements InfoManageDao {
	/*
	 * 管理员书籍管理之查询
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
	 * 管理员书籍管理之添加新书籍（插入book_id无效）
	 */
	@Override
	public boolean saveInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "insert into book_info(book_name,book_author) values(?,?) ";
			Book book = (Book)info;
			Object[] params = {book.getBookName(),book.getBookAuthor()};
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
	 * 管理员书籍管理之修改书籍信息（根据书籍id）
	 */
	@Override
	public boolean updateInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update book_info set book_name=?,book_author=? where book_id=? ";
			Book book = (Book)info;
			Object[] params = {book.getBookName(),book.getBookAuthor(),book.getBookId()};
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
	 * 管理员书籍管理之删除书籍信息（根据书籍id）
	 */
	@Override
	public boolean removeInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "delete from book_info where book_id=? ";
			Book book = (Book)info;
			Object[] params = {book.getBookId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Test
//	public void test(){
//		Book book = new Book(2,"斗破苍穹","天蚕番茄");
//		removeInfo(book);
//		ArrayList<Info> list = findAll();
//		for(Info info : list)
//			System.out.println(info);
//	}
}
