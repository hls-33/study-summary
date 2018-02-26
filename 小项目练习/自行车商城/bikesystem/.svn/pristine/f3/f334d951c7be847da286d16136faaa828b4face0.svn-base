package com.bikesystem.txz.ipml.dao;

import java.sql.SQLException;

import com.bikesystem.entity.AdminAccount;
import com.bikesystem.txz.interfaces.dao.IAdminAccountDao;

public class AdminAccountDaoIpml extends BaseSystemDao implements IAdminAccountDao {

	@Override
	public AdminAccount queryAccountInfo(int aid) {
		// 查询管理员个人账户信息
		String sql="select * from admin_account where aid=?";
		AdminAccount ac=null;
		getPreparedStatement(sql);
		try {
			prep.setInt(1, aid);
			res=prep.executeQuery();
			if(res.next()){
				ac=new AdminAccount(res.getInt("acid"), res.getInt("aid"),
						res.getString("aphone"), res.getDouble("income"), res.getDouble("spending"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return ac;
	}

	@Override
	public Boolean updateAccountInfo(AdminAccount adminAccount) {
		//修改账户信息 
		String sql="update admin_account set aphone=?,income=?,spending=? where aid=?";
		getPreparedStatement(sql);
		try {
			prep.setString(1, adminAccount.getAphone());
			prep.setDouble(2, adminAccount.getIncome());
			prep.setDouble(3, adminAccount.getSpending());
			prep.setInt(4, adminAccount.getAid());
			int result=prep.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return null;
	}

	@Override
	public Boolean insertAdminAccount(AdminAccount adminAccount) {
		// 管理员注册时，同时申请对应的账户信息
		String sql="insert into admin_account(aid,aphone,income,spending) values(?,?,?,?)";
		getPreparedStatement(sql);
		try {
			prep.setInt(1, adminAccount.getAid());
			prep.setString(2, adminAccount.getAphone());
			prep.setDouble(3, adminAccount.getIncome());
			prep.setDouble(4, adminAccount.getSpending());
			int result=prep.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return false;
	}
}
