package com.bikesystem.hgg.dao;

import java.sql.SQLException;

public class ShopDaoImpl extends BaseDao implements IShopDao {
	private static final String queryShopNameSql="select shopname from shop where aid=?";
	
	@Override
	public String queryShopNameByAid(int aid) {
		getDb(queryShopNameSql);
		try {
			ps.setInt(1,aid);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getString("shopname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
