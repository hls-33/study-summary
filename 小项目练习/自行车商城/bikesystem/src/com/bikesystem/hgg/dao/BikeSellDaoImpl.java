package com.bikesystem.hgg.dao;

import java.sql.SQLException;

import com.bikesystem.entity.BikeSell;

public class BikeSellDaoImpl extends BaseDao implements IBikeSellDao {
	private static final String insertBikeSellSql="insert into bike_sell(bikename,bikecount,color,kindname,shopname,bikeprice,imgpath,bikeheadinfo,bikesubheadinfo) values(?,?,?,?,?,?,?,?,?)";

	@Override
	public boolean insertBikeSell(BikeSell bikesell) {
		if(bikesell==null)
			return false;
		try {
			getDb(insertBikeSellSql);
			ps.setString(1,bikesell.getBikeName());
			ps.setInt(2, bikesell.getBikeCount());
			ps.setString(3, bikesell.getColor());
			ps.setString(4, bikesell.getKindName());
			ps.setString(5, bikesell.getShopName());
			ps.setDouble(6, bikesell.getBikePrice());
			ps.setString(7, bikesell.getImgPath());
			ps.setString(8, bikesell.getBikeheadinfo());
			ps.setString(9, bikesell.getBikesubheadinfo());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return false;
	}

}
