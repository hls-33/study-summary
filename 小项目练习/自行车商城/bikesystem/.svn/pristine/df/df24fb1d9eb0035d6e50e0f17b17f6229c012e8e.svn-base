package com.bikesystem.hs.dao;

import com.bikesystem.entity.Shop;

/**
 * 商店Dao层接口
 * @author 祷
 *
 */
public interface IShopDao {
	boolean insertShop(Shop shop);  // 添加商店
	Shop queryShopById(int sid);	//	查看商店信息
	boolean updateShop(Shop shop);	//修改商店信息
	/**
	 * 根据商店名（必须验证以确保是唯一的）来查询shop信息
	 * @param shopname
	 * @return
	 */
	Shop queryShopByShopname(String shopname);
}
