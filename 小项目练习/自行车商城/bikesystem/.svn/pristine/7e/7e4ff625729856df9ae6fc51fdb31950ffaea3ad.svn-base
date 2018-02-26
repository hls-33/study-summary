package com.bikesystem.sh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bikesystem.entity.Comment;

public class CommentDao extends BaseDao implements ICommentDao{
	
	private static final String insertsql="insert into"
			+ " comment(cid,name,shopname,bikename,message,commentdate,commentImgPath,commentStatus)"
			+ " values(?,?,?,?,?,?,?,?)";
	private static final String showsql="select * from comment where commentStatus=?";

	@Override
	public boolean saveComment(int cid, String name, String shopname, String bikename, String message,
								String commentdate, String commentImgPath, String commentStatus) {
		createPreparedStatement(insertsql);
		try {
			pstmt.setString(1, message);
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return false;
	}
	
	@Override
	public boolean showComment(int cid, String name, String shopname, String bikename, String message,
			String commentdate, String commentImgPath, String commentStatus) {
		createPreparedStatement(showsql);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
