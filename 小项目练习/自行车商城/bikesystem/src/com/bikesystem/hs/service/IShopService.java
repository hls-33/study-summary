package com.bikesystem.hs.service;

import java.util.List;
import java.util.Map;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;
/**
 * 商店service层，包括对商店主页图片路径、商店信息、商店商品的获取
 */
import com.bikesystem.entity.Shop;
import com.bikesystem.entity.ShopImage;
/**
 * shop服务层：
 * 包含三个功能：
 * 	1：获取商店信息
 * 	2：获取商店商品信息:包括租用和出售的。
 * 	3：获取商店主页图片路径信息（单独提取出来用一个Service来处理）
 * @author bwfadmin
 *
 */
public interface IShopService {
	boolean insertShop(Shop shop);  // 添加商店
	Shop queryShopById(int sid);	//	查看商店信息
	boolean updateShop(Shop shop);	//修改商店信息
	
	
	
	List<BikeRent> queryAllBikeRentByParameter(Map<String,Object> map);//根据动态的参数个数来查询
	List<BikeRent> queryHotBikeRentByShopName(String shopName);//查询最热租的6个车
	List<BikeSell> queryAllBikeSell();	//查看所有店铺的所有出售自行车
	List<BikeSell> queryAllBikeSellByParameter(Map<String,Object> map);//根据动态的参数个数来查询
	List<ShopImage> queryAllShopImage();
	List<BikeRent> queryAllBikeRent();//查看所有可租借自行车信息
}
