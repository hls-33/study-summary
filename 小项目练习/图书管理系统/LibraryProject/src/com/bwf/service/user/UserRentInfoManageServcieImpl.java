package com.bwf.service.user;

import java.util.ArrayList;

import com.bwf.dao.user.UserRentInfoManageDaoImpl;
import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.entry.Rent;
import com.bwf.entry.User;
import com.bwf.service.admin.InfoManageService;

public class UserRentInfoManageServcieImpl implements InfoManageService {
	private UserRentInfoManageDaoImpl userRentInfo = new UserRentInfoManageDaoImpl();
	private UserBookInfoManageServcieImpl userBookInfo = new UserBookInfoManageServcieImpl();
	/*
	 * 用户查询之查询自己的租借信息（以username为准）
	 */
	@Override
	public ArrayList<Info> findAll(Info info) {
		return userRentInfo.findAll(info);
	}
	
	@Override
	public ArrayList<Info> findAll() {
		return null;
	}
	/**
	 * 用户借书
	 */
	@Override
	public boolean saveInfo(Info info) {
		Rent rent = (Rent)info;
		Book book = new Book(rent.getBookId(),null,null,"已借");
		userBookInfo.updateInfo(book);	//修改被借书籍的状态为已借
		return userRentInfo.saveInfo(info);
	}
	/*
	 * 用户续借
	 */
	@Override
	public boolean updateInfo(Info info) {
		return userRentInfo.updateInfo(info);
	}
	/**
	 * 用户还书(依据rent_id编号来还书)
	 * 并将被还的书状态修改为未借
	 */
	@Override
	public boolean removeInfo(Info info) {
		Rent rent = (Rent)info;
		Book book = new Book(rent.getBookId(),null,null,"未借");
		userBookInfo.updateInfo(book);	//修改被还书籍的状态为未借
		return userRentInfo.removeInfo(info);
	}
	/**
	 * 根据rent_id和登录的user返回对应的借阅rent对象
	 * @param user
	 * @param rentId
	 * @return
	 */
	public Rent getRentById(User user , int rentId){
		ArrayList<Info> infoList = findAll(user);
		for(Info info : infoList){
			Rent rent1 = (Rent)info;
			if(rent1.getRentId() == rentId)
				return rent1;
		}
		return null;
	}
	
	/**
	 * 根据book_id和登录的user返回对应的借阅rent对象
	 * @param user
	 * @param rentId
	 * @return
	 */
	public Rent getRentByBookId(User user , int bookId){
		ArrayList<Info> infoList = findAll(user);
		for(Info info : infoList){
			Rent rent1 = (Rent)info;
			if(rent1.getBookId() == bookId)
				return rent1;
		}
		return null;
	}

}
