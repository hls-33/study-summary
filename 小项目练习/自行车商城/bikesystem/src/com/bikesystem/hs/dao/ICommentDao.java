package com.bikesystem.hs.dao;

import java.util.List;

import com.bikesystem.entity.Comment;

/**
 * 评论信息Dao层
 * @author 祷
 *
 */
public interface ICommentDao {
	List<Comment> queryComment(String bikeName,String shopName);//查询对应店铺-自行车的评论
	Boolean insertComment(Comment comment);//插入对应店铺-自行车的评论

}
