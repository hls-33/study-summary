package com.bwf.service.user;

import java.util.ArrayList;

import com.bwf.dao.user.UserBookInfoManageDaoImpl;
import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.service.admin.InfoManageService;

public class UserBookInfoManageServcieImpl implements InfoManageService {
	private UserBookInfoManageDaoImpl userBook = new UserBookInfoManageDaoImpl();
	/*
	 * 查看书籍
	 */
	@Override
	public ArrayList<Info> findAll() {
		return userBook.findAll();
	}
	/**
	 * 根据bookId获取Book对象
	 */
	public Book getBook(int bookId ){
		ArrayList<Info> bookInfo = findAll();
		if(bookInfo == null || bookInfo.size() == 0)
			return null;
		for(Info info : bookInfo){
			Book book = (Book)info;
			if(book.getBookId() == bookId ){
				return book;
			}
		}
		return null;
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
		return userBook.updateInfo(info);
	}
	/*
	 * 无此功能
	 */
	@Override
	public boolean removeInfo(Info info) {
		return false;
	}
	@Override
	public ArrayList<Info> findAll(Info info) {
		return null;
	}

}
