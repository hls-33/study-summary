package com.bikesystem.txz.ipml.dao;
import java.sql.SQLException;
import com.bikesystem.entity.Admin;
import com.bikesystem.entity.AdminAccount;
import com.bikesystem.txz.interfaces.dao.IAdminDao;
public class AdminDaoIpml extends BaseSystemDao implements IAdminDao {
	@Override
	public Admin adminLogin(String aphone,String password) {
//		管理员登陆
		Admin admin=null;
		String sql="select * from admin where aphone=? && password=?";
		getPreparedStatement(sql);
		try {
			prep.setString(1, aphone);
			prep.setString(2, password);
			res=prep.executeQuery();
			if(res.next()){
				admin=new Admin(res.getInt("aid"), res.getString("aphone"), res.getString("password"),
						res.getString("name"), res.getString("idnumber"), res.getString("imagepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return admin;
	}
	//管理员注册时账户的添加
	private boolean adminRegistAccount(Admin admin){
		AdminAccountDaoIpml acd=new AdminAccountDaoIpml();
		boolean flag=false;
		String sqlid="select aid from admin where aphone=?";
		int aid=0;
		getPreparedStatement(sqlid);
		try {
			prep.setString(1, admin.getAphone());
			res=prep.executeQuery();
			if(res.next())
				aid=res.getInt("aid");
			return acd.insertAdminAccount(new AdminAccount(aid, admin.getAphone(), 0, 0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return flag;
	}
	@Override
	public boolean adminRegist(Admin admin) {
		// 管理员注册
		String sql="insert into admin(aphone,password,name,idnumber) values(?,?,?,?)";
		getPreparedStatement(sql);
		try {
			prep.setString(1, admin.getAphone());
			prep.setString(2, admin.getPassword());
			prep.setString(3, admin.getName());
			prep.setString(4, admin.getIdnumber());
			int result=prep.executeUpdate();
			if(result>0)
				return adminRegistAccount(admin);
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return false;
	}
	@Override
	public Admin queryAdminInfo(String aphone) {
		// 查询管理员个人信息
		String sql="select * from admin where aphone=?";
		Admin admin=null;
		getPreparedStatement(sql);
		try {
			prep.setString(1, aphone);
			res=prep.executeQuery();
			if(res.next()){
				admin=new Admin(res.getInt("aid"), res.getString("aphone"),
						res.getString("password"), res.getString("name"), 
						res.getString("idnumber"),res.getString("imagepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{closeAll();}
		return admin;
	}
	@Override
	public boolean updateAdminInfo(Admin admin) {
		// 修改管理员个人信息
		String sql="update admin set aphone=?,password=?,name=?,idnumber=?,imagepath=?";
		getPreparedStatement(sql);
		try {
			prep.setString(1, admin.getAphone());
			prep.setString(2, admin.getPassword());
			prep.setString(3, admin.getName());
			prep.setString(4, admin.getIdnumber());
			prep.setString(5, admin.getImagepath());
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
	@Override
	public boolean deleteAdminInfo(int aid) {
		// 删除管理员个人信息
		String sql="delete from admin where aid=?";
		getPreparedStatement(sql);
		try {
			prep.setInt(1, aid);
			int result=prep.executeUpdate();
			if(result>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean queryByAphone(String aphone) {
		String sql="select * from admin where aphone=?";
		getPreparedStatement(sql);
		try {
			prep.setString(1, aphone);
			res=prep.executeQuery();
			if(res.next())
				return false;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
