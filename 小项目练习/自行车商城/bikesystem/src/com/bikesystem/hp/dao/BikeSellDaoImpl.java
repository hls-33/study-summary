package com.bikesystem.hp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bikesystem.entity.BikeSell;
import com.bikesystem.entity.SellAddress;
import com.bikesystem.utils.JdbcUtils;

public class BikeSellDaoImpl extends BaseDao implements IBikeSellDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	private static final String InsertSellBike = "insert into sell_address(name,username,address,minuteaddress,phone) values(?,?,?,?,?) ";
	private static final String DeleteSellBike = "delete from sell_address  where said=?";
	private static final String UpdateSellBike = "update sell_address set username=?,address=?,minuteaddress=?,phone=? where said=? ";
	private static final String QuerySellBike = "select  * from bike_sell  where uesrname=?";
	private static final String QueryAllBikeSell = "select  * from sell_address  where name=?";
	private static final String QuerySpecialSellBike = "select  * from bike_sell  where shopname=? and bikename=? ";
/**
 * 添加新地址
 * */
	@Override
	public boolean insertBikeSellAddress(SellAddress sellAddress) {
		createPreparedStatement(InsertSellBike);
		try {
			pstmt.setString(1, sellAddress.getName());
			pstmt.setString(2, sellAddress.getUsername());
			pstmt.setString(3,sellAddress.getAddress());
			pstmt.setString(4, sellAddress.getMinuteaddress());
			pstmt.setString(5, sellAddress.getPhone());
			int rs = pstmt.executeUpdate();
			System.out.println("sellAddress:"+sellAddress);
			if(rs>0){
				System.out.println("添加新地址成功");
				return true;
				
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close();
		}
		return false;
	}

	
	/**
	 * 删除已过期的地址
	 * */
	@Override
	public boolean deleteBikeSellAddressById(int said) {
		createPreparedStatement(DeleteSellBike);
		try {
			pstmt.setInt(1, said);
			int rs = pstmt.executeUpdate();
			if(rs>0){
				return true;
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			close();
		}
		
		
		return false;
	}
	/**
	 * 修改用户收货地址
	 * */
	@Override
	public boolean updateBikeSellAddress(SellAddress sellAddress) {
	
		createPreparedStatement(UpdateSellBike);
		try {
			pstmt.setString(1, sellAddress.getUsername());
			pstmt.setString(2,sellAddress.getAddress());
			pstmt.setString(3, sellAddress.getMinuteaddress());
			pstmt.setString(4, sellAddress.getPhone());
			pstmt.setInt(2,sellAddress.getSaid());
			int rs = pstmt.executeUpdate();
			while(rs>0){
				return true;
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		return false;
	}
	/**
	 * 查看用户自己所有的地址
	 * */
	@Override
	public List<SellAddress> queryAllBikeSellAddress(String name) {
		createPreparedStatement(QueryAllBikeSell);
		List<SellAddress> list = null;
		try {
			list= new ArrayList<SellAddress>();
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new SellAddress(
						rs.getInt("said"),
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("address"),
						rs.getString("minuteaddress"),
						rs.getString("phone")));
			}
			System.out.println("dao:list>>"+list);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close();
		}
		return list;
	}
	/**
	 * 用户自己查看自行车，通过搜索框检索的
	 * */
	@Override
	public List<BikeSell> queryBikeSell(String bikeName) {
		createPreparedStatement(QuerySellBike);
		List<BikeSell> list = null;
		try {
			list= new ArrayList<BikeSell>();
			pstmt.setString(1, bikeName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//显示自行车的基本信息
				list.add(new BikeSell(rs.getString("bikename"),
						rs.getInt("bikecount"),rs.getString("color"),
						rs.getString("kindname"),rs.getString("shopname"),
						rs.getDouble("bikeprice")));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return list;
	}
	/**
	 * 查看特定的的自行车
	 * */
	@Override
	public List<BikeSell> querySpecialBikeSell(String bikeName, String shopName) {
		createPreparedStatement(QuerySpecialSellBike);
		List<BikeSell> list = null;
		try {
			list= new ArrayList<BikeSell>();
			pstmt.setString(1, shopName);
			pstmt.setString(2, bikeName);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				//显示商店的自行车的基本信息
				list.add(new BikeSell(rs.getString("bikename"),
						rs.getInt("bikecount"),rs.getString("color"),
						rs.getString("kindname"),rs.getString("shopname"),
						rs.getDouble("bikeprice"),
						rs.getString("imgpath"),
						rs.getInt("sellcount"),
						rs.getString("bikeheadinfo"),
						rs.getString("bikesubheadinfo")
						));
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return list;
	}


	@Override
	public List<BikeSell> queryAllBikeSellByParameter(Map<String, Object> map) {
		String sql="select * from bike_sell where 1=1 ";
		//查看是否存在bikename参数，有则要用模糊查询
		Set<Entry<String, Object>> entrs = map.entrySet();
		for(Entry<String, Object> entry : entrs){
			String parameter = entry.getKey();
			Object value=entry.getValue();
			
			if("bikename".equals(parameter)){
				sql+=" and "+parameter+" like '%"+value+"%' ";
			}else if("bikeprice".equals(parameter)){
				//如果是传入的日租金范围值，则需要解析
				String[] prices = value.toString().split("~");
				sql+=" and "+parameter+" between "+prices[0]+" and "+prices[1];
			}else {
				sql+=" and "+parameter+" = '"+value+"'";
			}
		}
		System.out.println("sql:"+sql);
		try{
			return qr.query(sql, new BeanListHandler<BikeSell>(BikeSell.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BikeSell> queryHotBikeSellByShopName(String shopName) {
		String sql="select * from bike_sell where shopname=? order by sellcount desc limit 0,8";
		try{
			return qr.query(sql, new BeanListHandler<BikeSell>(BikeSell.class),shopName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public List<BikeSell> getBikeSellByBsid(int bsid) {
		String sql="select *from bike_sell where bsid=?";
		try {
			List<BikeSell> arr=qr.query(sql,new BeanListHandler<BikeSell>(BikeSell.class),bsid);
			
			return arr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<SellAddress> queryAddress(int id){
		String sql ="select *  from sell_address  where said=?";
		createPreparedStatement(sql);
		List<SellAddress> list = null;
		try {
			list= new ArrayList<SellAddress>();
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new SellAddress(
						rs.getInt("said"),
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("address"),
						rs.getString("minuteaddress"),
						rs.getString("phone")));
			}
			System.out.println("dao:list>>"+list);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close();
		}
		return list;
	}
	
	
	
	
}
