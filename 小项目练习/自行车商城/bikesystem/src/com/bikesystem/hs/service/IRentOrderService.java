package com.bikesystem.hs.service;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.Shop;
import com.bikesystem.entity.ShopRentSale;
import com.bikesystem.entity.UserRent;

/**
 * 自行车预约功能service层
 * @author bwfadmin
 */
public interface IRentOrderService {
	/**
	 * 根据brid差bikeRent信息
	 * @param brid
	 * @return
	 */
	public BikeRent queryRentByBrid(String brid);
	
	/**
	 * 根据bikenumber查询userRent信息
	 * @param bikenumber
	 * @return
	 */
	public UserRent queryUserRentByBikeNumber(String bikenumber);
	
	/**
	 * 查询shop相关信息
	 * @param shopname
	 * @return
	 */
	public Shop queryShopByShopname(String shopname);
	
	/**
	 * 查询店铺租车优惠信息
	 * @param brid
	 * @return
	 */
	public ShopRentSale queryRentSaleByBrid(int brid);
}
