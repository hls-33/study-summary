package com.bikesystem.hgg.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bikesystem.entity.UserRent;

public class AdminUserRentDaoImpl extends BaseDao implements IAdminUserRentDao {
	
	private List<UserRent> list;
	private static final String queryBikeRentByShopNameSql="select * from bike_rent where shopname=?";
	
	//查看商店自行车被租借的信息
	@Override
	public List<UserRent> queryBikeRentByShopName(String shopName) {
		if(shopName==null)
			return null;
		list=new ArrayList<UserRent>();
		try {
			getDb(queryBikeRentByShopNameSql);
			ps.setString(1,shopName);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new UserRent(rs.getInt("urid"),rs.getString("name"),rs.getString("bikenumber"),
						rs.getString("bikename"),rs.getString("shopname"),rs.getString("rentdate"),
						rs.getString("returndate"),rs.getDouble("deposit"),rs.getString("rentType")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close();
		}
		return null;
	}

}
