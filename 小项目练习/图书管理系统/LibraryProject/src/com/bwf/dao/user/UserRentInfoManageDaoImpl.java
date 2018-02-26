package com.bwf.dao.user;

import java.sql.Connection;
import java.util.ArrayList;


import com.bwf.dao.admin.InfoManageDao;
import com.bwf.entry.Info;
import com.bwf.entry.Rent;
import com.bwf.entry.User;
import com.bwf.utils.BeanUtils;
import com.bwf.utils.DaoUtils;

public class UserRentInfoManageDaoImpl implements InfoManageDao {
	/*
	 * 用户查询之查询自己的租借信息（以username为准）
	 */
	@Override
	public ArrayList<Info> findAll(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "select * from rent_info where rent_user=?";
			User user = (User)info;
			Object[] params = {user.getUsername()};
			ArrayList<Info> rentList = BeanUtils.queryInfo(con, sql, "Rent",params);
			return rentList;
		}catch(Exception e){return null;}
		finally{
			DaoUtils.close(con);
		}

	}
	/*
	 * 查询所有借阅信息，（无此权限）
	 */
	@Override
	public ArrayList<Info> findAll() {
		return null;
	}
	/*
	 * 用户借书
	 */
	@Override
	public boolean saveInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "insert into rent_info(book_id,rent_book,rent_user,rent_credit,rent_date,return_date) "
					+ "values(?,?,?,?,now(),date_add(rent_date,interval 30 day))";
			Rent rent = (Rent)info;
			Object[] params = {rent.getBookId(),rent.getRentBook(),rent.getRentUser(),rent.getRentCredit()};
			int result = BeanUtils.updateInfo(con, sql,params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}
	/*
	 * 用户续借
	 */
	@Override
	public boolean updateInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "update rent_info set return_date=date_add(return_date,interval ? day),"
					+ "rent_daydiff=(rent_daydiff+?) where rent_user=? and book_id=?";
			Rent rent = (Rent)info;
			Object[] params = {rent.getDayDiff(),rent.getDayDiff(),rent.getRentUser(),rent.getBookId()};
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
	 * 用户还书(依据rent_id编号来还书)
	 */
	@Override
	public boolean removeInfo(Info info) {
		Connection con = DaoUtils.getConn();
		try{
			String sql = "delete from rent_info where rent_id=? ";
			Rent rent = (Rent)info;
			Object[] params = {rent.getRentId()};
			int result = BeanUtils.updateInfo(con, sql, params);
			if(result == 0)
				return false;
			return true;
		}catch(Exception e){return false;}
		finally{
			DaoUtils.close(con);
		}
	}

//	@Test
//	public void test(){
//		Rent rent = new Rent(3,1,"斗qwq苍穹","user",4,null,null,20);
//		System.out.println(removeInfo(rent));
//		ArrayList<Info> list = findAll(rent);
//		for(Info info : list)
//			System.out.println(info);
//	}

	
}
